package com.yaesta.app.persistence.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.yaesta.app.util.Constants;
import com.yaesta.app.util.SupplierUtil;
import com.yaesta.integration.sellercenter.json.bean.UserBean;
import com.yaesta.integration.sellercenter.json.bean.UserResponseContainer;
import com.yaesta.integration.sellercenter.service.SellerCenterService;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.yaesta.app.mail.MailInfo;
import com.yaesta.app.mail.MailParticipant;
import com.yaesta.app.mail.MailService;
import com.yaesta.app.persistence.entity.Address;
import com.yaesta.app.persistence.entity.Proveedor;
import com.yaesta.app.persistence.entity.Supplier;
import com.yaesta.app.persistence.entity.SupplierContact;
import com.yaesta.app.persistence.entity.SupplierDeliveryCalendar;
import com.yaesta.app.persistence.entity.TramacoSupplier;
import com.yaesta.app.persistence.entity.TramacoZone;
import com.yaesta.app.persistence.entity.YaEstaLog;
import com.yaesta.app.persistence.repository.AddressRepository;
import com.yaesta.app.persistence.repository.ProveedorRepository;
import com.yaesta.app.persistence.repository.SupplierContactRepository;
import com.yaesta.app.persistence.repository.SupplierDeliveryCalendarRepository;
import com.yaesta.app.persistence.repository.SupplierRepository;
import com.yaesta.app.persistence.repository.TramacoSupplierRepository;
import com.yaesta.app.persistence.repository.TramacoZoneRepository;
import com.yaesta.app.persistence.util.ContactInfoUtil;
import com.yaesta.app.persistence.vo.ContactContainerVO;
import com.yaesta.app.persistence.vo.ContactInfoVO;
import com.yaesta.app.persistence.vo.ContactVO;
import com.yaesta.app.persistence.vo.EmailContainerVO;
import com.yaesta.app.persistence.vo.EmailVO;
import com.yaesta.app.persistence.vo.PhoneContainerVO;
import com.yaesta.app.persistence.vo.PhoneVO;
import com.yaesta.app.persistence.vo.SupplierBeanVO;
import com.yaesta.app.persistence.vo.SupplierResponseVO;
import com.yaesta.app.persistence.vo.SupplierVO;
import com.yaesta.app.service.SystemOutService;


@Service
public class SupplierService implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -4542692183723268416L;

	@Autowired
	private SupplierRepository supplierRepository;
	
	@Autowired
	private MailService mailService;
	
	@Autowired
	private SupplierContactRepository supplierContactRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private SupplierDeliveryCalendarRepository supplierDeliveryCalendarRepository;
	
	@Autowired
	private TramacoSupplierRepository tramacoSupplierRepository;
	
	@Autowired
	private TramacoZoneRepository tramacoZoneRepository;
	
	@Autowired
	private ProveedorRepository proveedorRepository;
	
	@Autowired
	TableSequenceService tableSequenceService;
	
	@Autowired
	SellerCenterService sellerCenterService;
	
	@Autowired
	YaEstaLogService logService;
	
	@Autowired
	SystemOutService systemOut;
	
	private @Value("${mail.smtp.from}") String mailFrom;
	private @Value("${mail.smtp.supplier.to}") String mailTo;
	private @Value("${mail.smtp.supplier.to.name}") String mailToName;
	private @Value("${mail.smtp.supplier.contacts}") String mailSmtpSupplierContacts;
	private @Value("${mail.smtp.supplier.contacts.names}") String mailSmtpSupplierContactsNames;
	private @Value("${sellercenter.url}") String sellerCenterUrl;
	
	@Transactional
	public Supplier save(Supplier entity, List<SupplierDeliveryCalendar> deliveryCalendar, List<SupplierContact> contactList, List<SupplierContact> removeContactList){
		
		Boolean isNew = Boolean.FALSE;
		
		if(entity.getId()==null){
			entity.setId(tableSequenceService.getNextValue("SEQ_SUPPLIER"));
			isNew = Boolean.TRUE;
		}
		
		String postalCode = entity.getPostalCode();
		if(postalCode!=null && !postalCode.equals("")){
			try{
				TramacoZone zone = tramacoZoneRepository.findOne(new Long(postalCode));
				entity.setZone(zone);
			}catch(Exception e){
				systemOut.println("Error asignando codigo de zona a proveedor");
			}
		}
		
		//if(entity.getStreetMain()==null){
			entity.setStreetMain(entity.getAddress());
		//}
		
		if(entity.getStreetSecundary()==null){
			entity.setStreetSecundary("");
		}
		
		supplierRepository.save(entity);
		supplierRepository.flush();
		
		if(deliveryCalendar!=null && !deliveryCalendar.isEmpty()){
			for(SupplierDeliveryCalendar sdc:deliveryCalendar){
				sdc.setSupplier(entity);
			}
			
			supplierDeliveryCalendarRepository.save(deliveryCalendar);
		}
		
		if(contactList!=null && !contactList.isEmpty()){
			for(SupplierContact sc:contactList){
				sc.setSupplier(entity);
				saveContact(sc);
			}
		}
		
		if(removeContactList!=null && !removeContactList.isEmpty()){
			for(SupplierContact sc:removeContactList){
				removeContact(sc);
			}
		}
		
		sendNewSupplierMail(entity);
		
		if(isNew){
			UserBean su = new UserBean();
			su.setNombre(entity.getName());
			su.setPerfil("seller");
			su.setUsuario(entity.getSellerUser());
			su.setEmail(entity.getContactEmail());
			su.setId("(-"+entity.getId()+"-)");
			
			UserResponseContainer resp = sellerCenterService.createUser(su);
			
			if(!resp.getEstado().equals("error")){
				entity.setPassword(resp.getUsuario().getPassword());
				supplierRepository.save(entity);
				//enviar notificacion de acceso al proveedor
				sendNewSellerMail(entity,resp);
			}else{
				YaEstaLog yaestalog = new YaEstaLog();
				yaestalog.setLogDate(new Date());
				yaestalog.setProcessName("SELLERCENTER-CREATE");
				yaestalog.setTextinfo(entity.getName()+ " ==> "+resp.getMsg());
				logService.save(yaestalog);
			}
		}
		
		return entity;
	}
	
	@Transactional
	public SupplierContact saveContact(SupplierContact contact){
		
		if(contact.getId().intValue()==-1){
			contact.setId(null);
		}
		supplierContactRepository.save(contact);
		return contact;
	}
	@Transactional
	public void removeContact(SupplierContact contact){
		
		SupplierContact found = supplierContactRepository.findOne(contact.getId());
		
		if(found!=null){
			supplierContactRepository.delete(found);
		}
	}
	
	@Transactional
	public void removeAllContact(List<SupplierContact> contactList){
		supplierContactRepository.delete(contactList);
	}
	
	public List<SupplierContact> getContacts(Supplier supplier){
		return supplierContactRepository.findBySupplier(supplier);
	}
	
	public Supplier findByVitexId(String vitexId){
		return supplierRepository.findByVitexId(vitexId);
	}
	
	public Supplier findById(Long id){
		return supplierRepository.getOne(id);
	}
	
	public List<Supplier> getSuppliers(){
		List<Supplier>  found = supplierRepository.findAll();
		
		/*
		for(Supplier s:found){
			Hibernate.initialize(s.getCategory());
			Hibernate.initialize(s.getAccountType());
			Hibernate.initialize(s.getBank());
			Hibernate.initialize(s.getCountry());
			Hibernate.initialize(s.getPriority());
			Hibernate.initialize(s.getProductListStatus());
			Hibernate.initialize(s.getSupplierStatus());
			Hibernate.initialize(s.getSupplierType());
		}
		*/
		
		return found;
	}
	
	public List<SupplierBeanVO> getSuppliersVO(){
		List<SupplierBeanVO> result = new ArrayList<SupplierBeanVO>();
		List<Supplier> found = getSuppliers();
		if(found!=null && !found.isEmpty()){
			for(Supplier s:found){
				SupplierBeanVO sb = SupplierUtil.fromSupplierToSupplierBean(s);
				result.add(sb);
			}
		}
		
		return result;
	}
	
	public Supplier findOne(Long id){
		return supplierRepository.findOne(id);
	}
	
	
	
	@Transactional
	public String updateSupplier(){
		String response = "OK";
		
		try{
			List<Proveedor> proveedores = proveedorRepository.findAll();
			int count = 0;
			
			for(Proveedor proveedor:proveedores){
				Boolean found = false;
				Supplier updSupplier = supplierRepository.findOne(proveedor.getCodigo());
				
				
				
				ContactInfoVO contactInfo = ContactInfoUtil.extractContactInfoFromSupplier(proveedor);
				
				if(updSupplier==null){
				
					updSupplier = new Supplier();
					
					systemOut.println("NO Encuentra "+proveedor.getNombreProveedor() +" "+ proveedor.getCodigo());
				}else{
					count++;
					found=true;
					systemOut.println("Encuentra "+updSupplier.getName() +" "+ updSupplier.getId());
				}
				
				updSupplier.setName(proveedor.getNombreProveedor());
				updSupplier.setAddress(proveedor.getDireccion());
				updSupplier.setStreetMain(proveedor.getDireccion());
				updSupplier.setProvince(proveedor.getProvincia());
				updSupplier.setCanton(proveedor.getCanton());
				updSupplier.setDeliveryManager(proveedor.getGestorEntrega());
				updSupplier.setOfficeHours(proveedor.getHorarioAtencion());
				updSupplier.setZone(proveedor.getZona());
				updSupplier.setPostalCode(proveedor.getZona().getCodigo()+"");
				updSupplier.setFound(found);
				if(contactInfo.getPrincipalEmail()!=null){
				updSupplier.setContactEmail(contactInfo.getPrincipalEmail().getEmail());
				}
				updSupplier.setContactName(contactInfo.getPrincipalContact().getFirstName());
				updSupplier.setContactLastName(contactInfo.getPrincipalContact().getLastName());
				if(contactInfo.getPrincipalPhone()!=null){
				updSupplier.setPhone(contactInfo.getPrincipalPhone().getPhone());
				}
				Gson gson = new Gson();
				if(!contactInfo.getPhoneList().isEmpty()){
					String phoneList = gson.toJson(contactInfo.getPhoneList());
					updSupplier.setPhoneList(phoneList);
				}
				if(!contactInfo.getContactList().isEmpty()){
					String contactList = gson.toJson(contactInfo.getContactList());
					updSupplier.setContactList(contactList);
				}
				if(!contactInfo.getEmailList().isEmpty()){
					String emailList = gson.toJson(contactInfo.getEmailList());
					updSupplier.setEmailList(emailList);
				}
				
				supplierRepository.save(updSupplier);
			}
			
			
			systemOut.println("Encontrados "+count);
			
		}catch(Exception e){
			systemOut.println("Error en "+e.getMessage());
			e.printStackTrace();
		}
		
		return response;
	}
	
	
	public String updateContacts(){
		String response = "OK";
		
		try{
			
			List<Supplier> supplierList = supplierRepository.findAll();
			
			for(Supplier supplier:supplierList){
				Gson gson =  new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
				ContactContainerVO contactContainer = new ContactContainerVO();
				EmailContainerVO emailContainer = new EmailContainerVO();
				PhoneContainerVO phoneContainer = new PhoneContainerVO();
				if(supplier.getContactList()!=null){
					String strContactList = "{ contact_list:"+supplier.getContactList()+"}";
					strContactList = strContactList.replace("\"name\"", "name");
					systemOut.println("contact_list "+strContactList);
					contactContainer = gson.fromJson(strContactList, ContactContainerVO.class);
					systemOut.println("contactContainer "+contactContainer.getContactList().size());
				}
				if(supplier.getEmailList()!=null){
					String strEmailList = "{ email_list:"+supplier.getEmailList()+"}";
					strEmailList = strEmailList.replace("\"email\"", "email");
					emailContainer = gson.fromJson(strEmailList, EmailContainerVO.class);
				}
				if(supplier.getPhoneList()!=null){
					String strPhoneList = "{ phone_list: "+ supplier.getPhoneList() + " }";
					strPhoneList = strPhoneList.replace("\"phone\"", "phone");
					strPhoneList = strPhoneList.replace("\"ext\"", "ext");
					phoneContainer = gson.fromJson(strPhoneList, PhoneContainerVO.class);
				}
				
				if(!contactContainer.getContactList().isEmpty()){
				   int i,j;
				   i=0; j=0;
				   for(ContactVO cvo:contactContainer.getContactList()){
					   SupplierContact sc = new SupplierContact();
					   sc.setName(cvo.getName());
					   if(!emailContainer.getEmailList().isEmpty() && i<emailContainer.getEmailList().size()){
						   sc.setEmail(emailContainer.getEmailList().get(i).getEmail());
						   i++;
					   }
					   if(!phoneContainer.getPhoneList().isEmpty() && j<phoneContainer.getPhoneList().size()){
						   sc.setPhone(phoneContainer.getPhoneList().get(j).getPhone());
						   /*if(phoneContainer.getPhoneList().get(j).getExt()!=null){
								sc.setExt(phoneContainer.getPhoneList().get(j).getExt().get(0));
							}*/
						   j++;
					   }
					   sc.setSupplier(supplier);
					   systemOut.println("==>>1");
					   supplierContactRepository.save(sc);
					   systemOut.println("==>>"+sc.getId());
				   }	
				}//
				else{
					if(!emailContainer.getEmailList().isEmpty()){
						int i;
						   i=0;
						   for(EmailVO evo:emailContainer.getEmailList()){
							   SupplierContact sc = new SupplierContact();
							   sc.setEmail(evo.getEmail());
							   if(!phoneContainer.getPhoneList().isEmpty() && i<phoneContainer.getPhoneList().size()){
								   sc.setPhone(phoneContainer.getPhoneList().get(i).getPhone());
								   /*if(phoneContainer.getPhoneList().get(i).getExt()!=null){
										sc.setExt(phoneContainer.getPhoneList().get(i).getExt().get(0));
									}*/
								   i++;
							   }
							   sc.setSupplier(supplier);
							   systemOut.println("==>>2");
							   supplierContactRepository.save(sc);
							   systemOut.println("==>>"+sc.getId());
						   }
					}else{
						if(!phoneContainer.getPhoneList().isEmpty()){
							for(PhoneVO pvo:phoneContainer.getPhoneList()){
								SupplierContact sc = new SupplierContact();
								sc.setPhone(pvo.getPhone());
								/*if(pvo.getExt()!=null){
									sc.setExt(pvo.getExt().get(0));
								}*/
								systemOut.println("==>>3");
								sc.setSupplier(supplier);
								supplierContactRepository.save(sc);
								systemOut.println("==>>"+sc.getId());
							}
						}
					}
				}
			}
			
		}catch(JsonSyntaxException e){
			systemOut.println("Error actualizando contactos formatException");
			e.printStackTrace();
		}catch(Exception e){
			systemOut.println("Error actualizando contactos");
			e.printStackTrace();
		}
		
		return response;
	}
	
	
	@Transactional
	public String updateSupplierFromAddress(){
		
		String response = "OK";
		
		try{
		List<Supplier> allSuppliers = supplierRepository.findAll();
		
		if(allSuppliers!=null && !allSuppliers.isEmpty()){
			for(Supplier supplier:allSuppliers){
				List<Address> addressList = addressRepository.findBySupplier(supplier);
				if(addressList!=null && !addressList.isEmpty()){
					
					for(Address address:addressList){
						Boolean update = false;
						if(supplier.getContactEmail()==null && address.getEmail()!=null){
							supplier.setContactEmail(address.getEmail());
							update = true;
						}
						//if(supplier.getContactDocument()==null && address.getDni()!=null)
						if(address.getDni()!=null){
							supplier.setContactDocument(address.getDni());
							update = true;
						}
						//if(supplier.getContactName()==null && address.getFirstname()!=null && !address.getFirstname().equals(Constants.supplierFlag))
						if(address.getFirstname()!=null && !address.getFirstname().equals(Constants.supplierFlag)){
							supplier.setContactName(address.getFirstname());
							update = true;
						}
						//if(supplier.getContactLastName()==null && address.getLastname()!=null && !address.getLastname().equals(Constants.supplierFlag))
						if(address.getLastname()!=null && !address.getLastname().equals(Constants.supplierFlag)){
							supplier.setContactLastName(address.getLastname());
							update = true;
						}
						//if(supplier.getName()==null && address.getAlias()!=null && !address.getAlias().equals(Constants.supplierFlag))
						if(address.getAlias()!=null && !address.getAlias().equals(Constants.supplierFlag)){
							supplier.setName(address.getAlias());
							update = true;
						}
						if(supplier.getStreetMain()==null && address.getAddress1()!=null){
							supplier.setStreetMain(address.getAddress1());
							update = true;
						}
						if(supplier.getStreetSecundary()==null && address.getAddress2()!=null){
							supplier.setStreetSecundary(address.getAddress2());
							update=true;
						}
						
						if(update){
							supplierRepository.saveAndFlush(supplier);
						}
					}//fin for address
				
				}//fin if address
					
				
				List<TramacoSupplier> tramacoSupplierList = tramacoSupplierRepository.findAll();
				
				if(tramacoSupplierList!=null && !tramacoSupplierList.isEmpty()){
					for(TramacoSupplier tramacoSupplier:tramacoSupplierList){
						
						if(tramacoSupplier.getProveedor().trim().toUpperCase().equals(supplier.getName().trim().toUpperCase())){
							tramacoSupplier.setSupplier(supplier);
							tramacoSupplierRepository.saveAndFlush(tramacoSupplier);
							
							List<TramacoZone> zones = tramacoZoneRepository.findByProvinciaAndCanton(tramacoSupplier.getProvincia(), tramacoSupplier.getGestorEntrega());
							if(zones!=null && !zones.isEmpty()){
								supplier.setPostalCode(zones.get(0).getCodigo()+"");
							}
							//completar informacion en proveedores
							String personContacts =  tramacoSupplier.getPersonaContacto();
							
							String[] persons = personContacts.split("%");
						
							if(persons!=null){
								int size = persons.length;
								for(int i=0;i<size;i++){
									SupplierContact sc = new SupplierContact();
									sc.setName(persons[i]);
									sc.setSupplier(supplier);
									supplierContactRepository.saveAndFlush(sc);
								}
								
								supplier.setContactName(persons[0]);
								supplier.setContactLastName(persons[0]);
							}
							else{
							   supplier.setContactName(personContacts);
							   supplier.setContactLastName(personContacts);
							}
							
							String contactInfo = tramacoSupplier.getContactosProveedor();
							
							String[] contacts = contactInfo.split("%");
							
							if(contacts!=null){
								int siz = contacts.length;
								for(int i=0;i<siz;i++){
									SupplierContact sc = new SupplierContact();
									sc.setSupplier(supplier);
									if(contacts[i].contains("@")){
										sc.setEmail(contacts[i].trim());
									}else if(contacts[i].trim().toUpperCase().contains("EXT")){
										String[] exts = contacts[i].split("EXT");
										sc.setPhone(exts[0]);
										sc.setExt(exts[1]);
									}
									supplierContactRepository.saveAndFlush(sc);
								}
							}
							
							supplierRepository.saveAndFlush(supplier);
						}
						
					}// fin for tramaco SupplierList
				}//fin if de tramacoSupplierList
				
			}// fin for de suppliers
		}
		}catch(Exception e){
			response = "Error:"+e.getMessage();
		}
		return response;
	}
	
   private void sendNewSupplierMail(Supplier supplier){
	   if(supplier.getIsNew()){
		   systemOut.println("Inicio notificacion");
		   MailInfo mailInfo = new MailInfo();
		   MailParticipant sender = new MailParticipant();
		   sender.setName("YaEsta.com");
		   sender.setEmail(mailFrom);
		   mailInfo.setMailSender(sender);
		   MailParticipant receiver = new MailParticipant();
		   receiver.setName(mailToName);
		   receiver.setEmail(mailTo);
		   mailInfo.setMailReceiver(receiver);
		   List<MailParticipant> ccList = new ArrayList<MailParticipant>();
		   String[] contactsNames = mailSmtpSupplierContactsNames.split("%");
		   String[] contactsEmails = mailSmtpSupplierContacts.split("%");
		
			for(int j=0;j<contactsNames.length;j++){
				MailParticipant cc = new MailParticipant();
				cc.setEmail(contactsEmails[j]);
				cc.setName(contactsNames[j]);
				ccList.add(cc);
			}
			
			mailInfo.setReceivers(ccList);
			
			String subject="Notificación de nuevo proveedor " + supplier.getName();
			
			mailInfo.setSubject(subject);
			
			String generalText = "Se informa de la creación en el sistema del proveedor " + supplier.getName() 
								 + " identificado en el sistema con el ID " + supplier.getId();
			
			mailInfo.setGeneralText(generalText);
			
			mailService.sendMailTemplate(mailInfo, "newSellerNotification.vm");	
			systemOut.println("Fin notificacion");
	   }
   }
   
   private void sendNewSellerMail(Supplier supplier, UserResponseContainer urc){
	   if(supplier.getIsNew()){
		   systemOut.println("Inicio notificacion");
		   MailInfo mailInfo = new MailInfo();
		   MailParticipant sender = new MailParticipant();
		   sender.setName("YaEsta.com");
		   sender.setEmail(mailFrom);
		   mailInfo.setMailSender(sender);
		   MailParticipant receiver = new MailParticipant();
		   receiver.setName(supplier.getName());
		   receiver.setEmail(supplier.getContactEmail());
		   mailInfo.setMailReceiver(receiver);
		   /*
		   List<MailParticipant> ccList = new ArrayList<MailParticipant>();
		   String[] contactsNames = mailSmtpSupplierContactsNames.split("%");
		   String[] contactsEmails = mailSmtpSupplierContacts.split("%");
		
			for(int j=0;j<contactsNames.length;j++){
				MailParticipant cc = new MailParticipant();
				cc.setEmail(contactsEmails[j]);
				cc.setName(contactsNames[j]);
				ccList.add(cc);
			}
			
			mailInfo.setReceivers(ccList);
			*/
			
			String subject="Notificación de clave de nuevo proveedor " + supplier.getName();
			
			mailInfo.setSubject(subject);
			
			String generalText = "Se informa de la creación en el sistema del proveedor " + supplier.getName() 
								 + " identificado en el sistema con el ID " + supplier.getId() + ".<br></br>"
								 + "Usted podra ingresar al sistema de SELLERS de YAESTA con las credenciales usuario <b>" + urc.getUsuario().getUsuario() + "</b> y clave <b>" + urc.getUsuario().getPassword() + "</b><br></br>"
								 +"Para ingresar utilice el siguiente url " + sellerCenterUrl;	
			
			mailInfo.setGeneralText(generalText);
			
			mailService.sendMailTemplate(mailInfo, "newSellertoSellerNotification.vm");	
			systemOut.println("Fin notificacion");
	   }
   }
   
   @Transactional
   public SupplierResponseVO deleteSupplier(SupplierVO supplierVO){
	   SupplierResponseVO response = new SupplierResponseVO();
	   String result = "OK";
	   
	   try{
	   
		   Supplier supplier;
		   
		   if(supplierVO.getSupplierId()!=null){
			   supplier = supplierRepository.findOne(supplierVO.getSupplierId());
		   }else{
			  
			   supplier = supplierVO.getSupplier();
		   }
		   
		   if(supplier!=null){
			   //Eliminar lista de contactos
			   List<SupplierContact> contacts = getContacts(supplier);
		   
			   if(contacts!=null && !contacts.isEmpty()){
				   supplierContactRepository.delete(contacts);
			   }
			   
			   //Eliminar lista de direcciones
			   List<Address> addressList = addressRepository.findBySupplier(supplier);
		   
			   if(addressList!=null && !addressList.isEmpty()){
				   addressRepository.delete(addressList);
			   }
			   
			   supplierRepository.delete(supplier);
		   }
	   }catch(Exception e){
		   result = "Error eliminando proveedor";
	   }
	   
	   response.setResponse(result);
	   return response;
   }
}
