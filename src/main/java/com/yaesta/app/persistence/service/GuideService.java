package com.yaesta.app.persistence.service;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.io.FileUtils;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.yaesta.app.mail.ItemInfoGuide;
import com.yaesta.app.mail.ItemInfoSupplier;
import com.yaesta.app.mail.MailInfo;
import com.yaesta.app.mail.MailParticipant;
import com.yaesta.app.mail.MailService;
import com.yaesta.app.persistence.entity.Catalog;
import com.yaesta.app.persistence.entity.Guide;
import com.yaesta.app.persistence.entity.GuideDetail;
import com.yaesta.app.persistence.entity.GuideMigrate;
import com.yaesta.app.persistence.entity.Order;
import com.yaesta.app.persistence.entity.Supplier;
import com.yaesta.app.persistence.entity.SupplierContact;
import com.yaesta.app.persistence.entity.YaEstaLog;
import com.yaesta.app.persistence.repository.GuideDetailRepository;
import com.yaesta.app.persistence.repository.GuideMigrateRepository;
import com.yaesta.app.persistence.repository.GuideRepository;
import com.yaesta.app.persistence.vo.DateRangeVO;
import com.yaesta.app.persistence.vo.GuideDeliveryNotificationVO;
import com.yaesta.app.persistence.vo.GuideSearchVO;
import com.yaesta.app.persistence.vo.GuideVO;
import com.yaesta.app.persistence.vo.TrackingContainerVO;
import com.yaesta.app.persistence.vo.TrackingVO;
import com.yaesta.app.service.SystemOutService;
import com.yaesta.app.util.GuideUtil;
import com.yaesta.app.util.TrackingUtil;
import com.yaesta.app.util.UtilDate;
import com.yaesta.integration.tramaco.dto.GuideBeanDTO;
import com.yaesta.integration.tramaco.dto.GuideDTO;
import com.yaesta.integration.tramaco.service.TramacoService;
import com.yaesta.integration.vitex.json.bean.OrderComplete;
import com.yaesta.integration.vitex.service.OrderVitexService;

import dmz.comercial.servicio.cliente.dto.SalidaTrackGuiaWs;

@Service
public class GuideService {

	@Autowired
	private GuideRepository guideRepository;

	@Autowired
	private GuideDetailRepository guideDetailRepository;

	@Autowired
	private GuideMigrateRepository guideMigrateRepository;

	@Autowired
	private TramacoService tramacoService;

	@Autowired
	private OrderVitexService orderVitexService;

	@Autowired
	private SupplierService supplierService;

	@Autowired
	protected PropertySourcesPlaceholderConfigurer propertyConfigurer;

	@Autowired
	private MailService mailService;

	@Autowired
	private YaEstaLogService logService;
	
	@Autowired
	private CatalogService catalogService;
	
	@Autowired
	private OrderService orderService;

	@Autowired
	SystemOutService systemOut;

	private @Value("${mail.smtp.from}") String mailFrom;
	private @Value("${mail.smtp.to}") String mailTo;
	private @Value("${mail.smtp.to.name}") String mailToName;
	private @Value("${mail.smtp.cc}") String mailCc;
	private @Value("${mail.smtp.cc.name}") String mailCcName;
	private @Value("${mail.path.logo.image}") String logoPath;
	private @Value("${mail.text.delivery}") String mailTextDelivery;
	private @Value("${tramaco.contacts}") String tramacoContacts;
	private @Value("${tramaco.contacts.names}") String tramacoContactsNames;
	private @Value("${datil.carrier.motoexpress.email}") String motoExpressEmail1;
	private @Value("${datil.carrier.motoexpress.email2}") String motoExpressEmail2;
	private @Value("${datil.carrier.internal.email}") String despachoInternoEmail1;
	private @Value("${datil.carrier.internal.email2}") String despachoInternoEmail2;
	private @Value("${datil.carrier.cyclist.email}") String ciclistaEmail1;
	private @Value("${datil.carrier.cyclist.email2}") String ciclistaEmail2;
	private @Value("${yaesta.log.path}") String yaestaLogPath;

	public List<Guide> findByOrder(Order order) {
		List<Guide> result = new ArrayList<Guide>();
		List<Guide> founds = guideRepository.findByOrder(order);

		if (founds != null && !founds.isEmpty()) {
			for (Guide g : founds) {
				List<GuideDetail> gdList = guideDetailRepository.findByGuide(g);
				g.setDetails(gdList);
				result.add(g);
			}
		}

		return result;
	}

	public Guide saveGuide(Guide guide) {

		if (guide.getGuideStatus() != null) {
			guide.setStatus(guide.getGuideStatus().getNemonic());
		}

		if (guide.getDeliveryDate() != null) {
			guide.setStrDeliveryDate(UtilDate.fromDateToString(guide.getDeliveryDate(), "yyyy-MM-dd"));
			guide.setPeriode(UtilDate.fromDateToString(guide.getDeliveryDate(), "yyyy-MM"));
		}

		guideRepository.save(guide);
		return guide;
	}

	public List<Guide> getAll() {
		return guideRepository.findAll();
	}

	public List<GuideVO> getAllVO() {
		List<GuideVO> resultList = new ArrayList<GuideVO>();
		List<Guide> found = guideRepository.findAll();

		if (found != null && !found.isEmpty()) {
			for (Guide g : found) {
				GuideVO gvo = GuideUtil.fromGuideToGuideVO(g);
				resultList.add(gvo);
			}
		}

		return resultList;
	}

	public List<GuideVO> findByCreateDateRangeVO(DateRangeVO dateRange) {
		List<Guide> found = guideRepository.findByCreateDateBetween(dateRange.getStartDate(),
				dateRange.getFinishDate());
		List<GuideVO> resultList = new ArrayList<GuideVO>();
		if (found != null && !found.isEmpty()) {
			for (Guide g : found) {
				GuideVO gvo = GuideUtil.fromGuideToGuideVO(g);
				resultList.add(gvo);
			}
		}
		return resultList;
	}

	public List<GuideVO> findByOrderDateRangeVO(DateRangeVO dateRange) {
		List<Guide> found = guideRepository.findByOrderDateBetween(dateRange.getStartDate(), dateRange.getFinishDate());
		List<GuideVO> resultList = new ArrayList<GuideVO>();
		if (found != null && !found.isEmpty()) {
			for (Guide g : found) {
				GuideVO gvo = GuideUtil.fromGuideToGuideVO(g);
				resultList.add(gvo);
			}
		}
		return resultList;
	}

	public List<Guide> findByDeliveryName(String deliveryName) {
		return guideRepository.findByDeliveryName(deliveryName);
	}

	public List<Guide> findByOrderId(String orderId) {
		return guideRepository.findByOrderVitexId(orderId);
	}

	@Transactional
	public Guide saveGuideDetail(Guide guide, List<GuideDetail> details) {

		if (details != null && !details.isEmpty()) {
			for (GuideDetail gd : details) {
				gd.setGuide(guide);
				guideDetailRepository.save(gd);
			}
		}

		return guide;
	}

	public Guide findById(Long id) {
		return guideRepository.findOne(id);
	}

	@Transactional
	public List<TrackingVO> getTrackingInfo(String guideId, String deliveryId) {
		List<TrackingVO> trackingList = new ArrayList<TrackingVO>();

		Long idGuide = new Long(guideId);

		Guide guide = guideRepository.getOne(idGuide);
		if (guide != null) {
			systemOut.println("Guide " + guide.getId());

			if (deliveryId.equals("TRAMACO")) {
				GuideDTO guideInfo = new GuideDTO();

				GuideBeanDTO gbd = new GuideBeanDTO();
				gbd.setGuide(guide);
				gbd.setGuideDeliveryId(guide.getGuideId());
				guideInfo.setGuideBean(gbd);
				GuideDTO response = tramacoService.trackingService(guideInfo);

				if (response.getGuideBean().equals("OK") && response.getGuideBean().getGuideTrackResponse() != null
						&& response.getGuideBean().getGuideTrackResponse().getLstSalidaTrackGuiaWs() != null
						&& !response.getGuideBean().getGuideTrackResponse().getLstSalidaTrackGuiaWs().isEmpty()) {
					for (SalidaTrackGuiaWs st : response.getGuideBean().getGuideTrackResponse()
							.getLstSalidaTrackGuiaWs()) {
						TrackingVO tvo = TrackingUtil.fromSalidaTrackGuiaWsToTrackingVO(st);
						trackingList.add(tvo);
					}

					guide.setLatitude(response.getLatitude());
					guide.setLongitude(response.getLongitude());

					guideRepository.save(guide);
				}
			}
		}

		return trackingList;
	}

	public Guide findByVitexDispatcherId(String vitexDispatcherId) {
		Guide found = null;

		List<Guide> list = guideRepository.findByVitexDispatcherId(vitexDispatcherId);

		if (list != null && !list.isEmpty()) {
			found = list.get(0);
		}
		return found;
	}

	public String updateGuides() {
		String result = "OK";

		List<Guide> guides = guideRepository.findAll();

		for (Guide guide : guides) {

			if (guide.getOrderVitexId() != null) {
				OrderComplete oc = orderVitexService.getOrderComplete(guide.getOrderVitexId());
				try {
					guide.setOrderDate(UtilDate.fromIsoToDateTime(oc.getCreationDate()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				guide.setCustomerName(oc.getCustomerName());
				guide.setOrderStatus(oc.getStatus());
				guideRepository.save(guide);
			}

		}

		return result;
	}

	public List<GuideVO> findByStatus(GuideSearchVO guideSearch) {
		List<GuideVO> resultList = new ArrayList<GuideVO>();

		List<Guide> found = guideRepository.findByStatus(guideSearch.getStatus());

		if (found != null && !found.isEmpty()) {
			for (Guide g : found) {
				GuideVO gvo = GuideUtil.fromGuideToGuideVO(g);
				List<GuideDetail> details = this.getGuideDetails(g);
				gvo.setDetails(details);
				resultList.add(gvo);
			}
		}

		return resultList;
	}

	public List<GuideVO> findByStatusAndDeliveryDate(GuideSearchVO guideSearch) {
		List<GuideVO> resultList = new ArrayList<GuideVO>();

		List<Guide> found = guideRepository.findByStatusAndStrDeliveryDate(guideSearch.getStatus(),
				UtilDate.fromDateToString(guideSearch.getDeliveryDate(), "yyyy-MM-dd"));

		if (found != null && !found.isEmpty()) {
			for (Guide g : found) {
				GuideVO gvo = GuideUtil.fromGuideToGuideVO(g);
				resultList.add(gvo);
			}
		}

		return resultList;
	}

	public List<GuideVO> findByStatusAndDeliveryDateAndDeliveryName(String status, Date deliveryDate,
			String deliveryName) {

		GuideSearchVO guideSearch = new GuideSearchVO();
		guideSearch.setStatus(status);
		guideSearch.setDeliveryDate(deliveryDate);
		guideSearch.setDeliveryName(deliveryName);
		return findByStatusAndDeliveryDateAndDeliveryName(guideSearch);
	}

	public List<GuideVO> findByStatusAndDeliveryDateAndDeliveryName(GuideSearchVO guideSearch) {
		List<GuideVO> resultList = new ArrayList<GuideVO>();

		List<Guide> found = guideRepository.findByStatusAndStrDeliveryDateAndDeliveryName(guideSearch.getStatus(),
				UtilDate.fromDateToString(guideSearch.getDeliveryDate(), "yyyy-MM-dd"), guideSearch.getDeliveryName());

		if (found != null && !found.isEmpty()) {
			for (Guide g : found) {
				GuideVO gvo = GuideUtil.fromGuideToGuideVO(g);
				resultList.add(gvo);
			}
		}

		return resultList;
	}

	public List<GuideVO> findByOrderDateBetweenAndStatus(GuideSearchVO guideSearch) {
		List<GuideVO> resultList = new ArrayList<GuideVO>();

		List<Guide> found = guideRepository.findByOrderDateBetweenAndStatus(guideSearch.getStartDate(),
				guideSearch.getStartDate(), guideSearch.getStatus());

		if (found != null && !found.isEmpty()) {
			for (Guide g : found) {
				GuideVO gvo = GuideUtil.fromGuideToGuideVO(g);
				resultList.add(gvo);
			}
		}

		return resultList;
	}

	public GuideDeliveryNotificationVO sendProgrammedGuides(GuideSearchVO guideSearch) {

		GuideDeliveryNotificationVO result = new GuideDeliveryNotificationVO();
		result.setResponse("OK");

		MailInfo mailTramaco = new MailInfo();
		guideSearch.setDeliveryName("TRAMACO");
		mailTramaco = preparedMailInfo(guideSearch);
		mailTramaco = completeMailForCourier(mailTramaco, "TRAMACO",
				UtilDate.fromDateToString(guideSearch.getDeliveryDate(), "yyyy-MM-dd"));
		if (mailTramaco.getSendMail()) {
			mailService.sendMailTemplate(mailTramaco, "deliveryNotification.vm");
			result.getCourierList().add("TRAMACO");
		}
		MailInfo mailMotoExpress = new MailInfo();
		guideSearch.setDeliveryName("MOTO_EXPRESS");
		mailMotoExpress = preparedMailInfo(guideSearch);
		mailMotoExpress = completeMailForCourier(mailMotoExpress, "MOTO_EXPRESS",
				UtilDate.fromDateToString(guideSearch.getDeliveryDate(), "yyyy-MM-dd"));
		if (mailMotoExpress.getSendMail()) {
			mailService.sendMailTemplate(mailMotoExpress, "deliveryNotification.vm");
			result.getCourierList().add("MOTO_EXPRESS");
		}
		MailInfo mailCiclista = new MailInfo();
		guideSearch.setDeliveryName("CICLISTA");
		mailCiclista = preparedMailInfo(guideSearch);
		mailCiclista = completeMailForCourier(mailCiclista, "CICLISTA",
				UtilDate.fromDateToString(guideSearch.getDeliveryDate(), "yyyy-MM-dd"));
		if (mailCiclista.getSendMail()) {
			mailService.sendMailTemplate(mailCiclista, "deliveryNotification.vm");
			result.getCourierList().add("CICLISTA");
		}
		MailInfo mailDespachoInterno = new MailInfo();
		guideSearch.setDeliveryName("DESPACHO_INTERNO");
		mailDespachoInterno = preparedMailInfo(guideSearch);
		mailDespachoInterno = completeMailForCourier(mailDespachoInterno, "DESPACHO_INTERNO",
				UtilDate.fromDateToString(guideSearch.getDeliveryDate(), "yyyy-MM-dd"));
		if (mailDespachoInterno.getSendMail()) {
			mailService.sendMailTemplate(mailDespachoInterno, "deliveryNotification.vm");
			result.getCourierList().add("DESPACHO_INTERNO");
		}
		MailInfo mailTCC = new MailInfo();
		guideSearch.setDeliveryName("TCC");
		mailTCC = preparedMailInfo(guideSearch);
		mailTCC = completeMailForCourier(mailTCC, "TCC",
				UtilDate.fromDateToString(guideSearch.getDeliveryDate(), "yyyy-MM-dd"));
		if (mailTCC.getSendMail()) {
			mailService.sendMailTemplate(mailTCC, "deliveryNotification.vm");
			result.getCourierList().add("TCC");
		}
		MailInfo mailLAAR = new MailInfo();
		guideSearch.setDeliveryName("LAAR");
		mailLAAR = preparedMailInfo(guideSearch);
		mailLAAR = completeMailForCourier(mailLAAR, "LAAR",
				UtilDate.fromDateToString(guideSearch.getDeliveryDate(), "yyyy-MM-dd"));
		if (mailLAAR.getSendMail()) {
			mailService.sendMailTemplate(mailLAAR, "deliveryNotification.vm");
			result.getCourierList().add("LAAR");
		}

		return result;
	}

	private MailInfo preparedMailInfo(GuideSearchVO guideSearch) {
		MailInfo mailInfo = new MailInfo();

		List<Guide> foundGuide = guideRepository.findByStatusAndStrDeliveryDateAndDeliveryName(guideSearch.getStatus(),
				UtilDate.fromDateToString(guideSearch.getDeliveryDate(), "yyyy-MM-dd"), guideSearch.getDeliveryName());
		List<ItemInfoGuide> infoGuideList = new ArrayList<ItemInfoGuide>();
		List<ItemInfoSupplier> infoSupplierList = new ArrayList<ItemInfoSupplier>();
		List<Supplier> supplierList = new ArrayList<Supplier>();

		if (foundGuide != null && !foundGuide.isEmpty()) {
			for (Guide g : foundGuide) {
				ItemInfoGuide iig = new ItemInfoGuide();
				iig.setSupplierName(g.getSupplier().getName());
				iig.setCustomerName(g.getCustomerName());
				if (!supplierList.contains(g.getSupplier())) {
					supplierList.add(g.getSupplier());
				}
				iig.setCustomerPhone(g.getCustomerPhone());
				iig.setGuideNumber(g.getGuideNumber());
				iig.setOrderSequence(g.getSerial());
				iig.setOrderId(g.getOrderVitexId());
				infoGuideList.add(iig);
			}

			if (!supplierList.isEmpty()) {
				for (Supplier s : supplierList) {
					ItemInfoSupplier iis = new ItemInfoSupplier();
					iis.setSupplierName(s.getName());
					String principalContact = s.getContactName() + " " + s.getContactLastName();
					iis.setPrincipalContact(principalContact);
					iis.setPhone(s.getPhone());
					String contacts = principalContact + "<br></br>";

					List<SupplierContact> scList = supplierService.getContacts(s);
					if (scList != null && !scList.isEmpty()) {
						for (SupplierContact sc : scList) {
							contacts = contacts + sc.getName() + "<br></br>";
						}
					}
					iis.setContactNames(contacts);
					iis.setSupplierAddress(s.getAddress());
					iis.setCity(s.getCity());
					infoSupplierList.add(iis);
				}
			}
			mailInfo.setSendMail(Boolean.TRUE);
		}

		mailInfo.setItemInfoGuideList(infoGuideList);
		mailInfo.setItemInfoSupplierList(infoSupplierList);

		return mailInfo;
	}

	private MailInfo completeMailForCourier(MailInfo mailInfo, String courier, String date) {

		mailInfo.setGeneralText(mailTextDelivery);

		MailParticipant sender = new MailParticipant();
		sender.setName("YaEsta.com");
		sender.setEmail(mailFrom);
		mailInfo.setMailSender(sender);

		MailParticipant receiver = new MailParticipant();
		receiver.setName(mailToName);
		receiver.setEmail(mailTo);
		mailInfo.setMailReceiver(receiver);

		mailInfo.setSubject("Retiros Programados para el día de hoy " + date);
		List<MailParticipant> receiverTotal = new ArrayList<MailParticipant>();
		if (courier.equals("TRAMACO")) {
			String[] contactsCourierNames = tramacoContactsNames.split("%");
			String[] contactsCourierEmails = tramacoContacts.split("%");

			for (int j = 0; j < contactsCourierNames.length; j++) {
				MailParticipant mpCourier = new MailParticipant();
				mpCourier.setEmail(contactsCourierEmails[j]);
				mpCourier.setName(contactsCourierNames[j]);
				receiverTotal.add(mpCourier);
			}
		} else if (courier.equals("MOTO_EXPRESS")) {
			MailParticipant mp1 = new MailParticipant();
			mp1.setEmail(motoExpressEmail1);
			mp1.setName("Contacto MotoExpress");
			receiverTotal.add(mp1);
			MailParticipant mp2 = new MailParticipant();
			mp2.setEmail(motoExpressEmail2);
			mp2.setName("Contacto MotoExpress");
			receiverTotal.add(mp2);

		} else if (courier.equals("DESPACHO_INTERNO")) {
			MailParticipant mp1 = new MailParticipant();
			mp1.setEmail(despachoInternoEmail1);
			mp1.setName("Contacto Yaesta");
			receiverTotal.add(mp1);
			MailParticipant mp2 = new MailParticipant();
			mp2.setEmail(despachoInternoEmail2);
			mp2.setName("Contacto Yaesta");
			receiverTotal.add(mp2);
		} else if (courier.equals("CICLISTA")) {
			MailParticipant mp1 = new MailParticipant();
			mp1.setEmail(ciclistaEmail1);
			mp1.setName("Contacto Ciclista");
			receiverTotal.add(mp1);
			MailParticipant mp2 = new MailParticipant();
			mp2.setEmail(ciclistaEmail2);
			mp2.setName("Contacto Ciclista");
			receiverTotal.add(mp2);
		} else if (courier.equals("TCC")) {
			// TODO.
		} else if (courier.equals("LAAR")) {
			// TODO.
		}

		return mailInfo;
	}

	public void processGuideTracking() {

		List<Guide> guides = guideRepository.findAll();

		if (guides != null && !guides.isEmpty()) {
			for (Guide guide : guides) {
				try {

					List<TrackingVO> trackList = this.getTrackingInfo(guide.getId() + "", guide.getDeliveryName());

					TrackingContainerVO tcv = new TrackingContainerVO();
					tcv.setTrackingList(trackList);

					try {

						ObjectMapper mapper = new ObjectMapper();

						String json = new Gson().toJson(tcv);

						mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
						Object oJson = mapper.readValue(json, TrackingContainerVO.class);
						String indented = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(oJson);
						String fileName = yaestaLogPath + "GUIDETRACKING" + (new Date()).getTime() + ".txt";
						FileUtils.writeStringToFile(new File(fileName), indented);

					} catch (IOException e) {

						YaEstaLog yaestalog = new YaEstaLog();
						yaestalog.setLogDate(new Date());
						yaestalog.setProcessName("GUIDETRACKING" + guide.getGuideId());
						yaestalog.setTextinfo("Error consulta VTEX ordenes");
						// yaestalog.setXmlInfo(json);
						logService.save(yaestalog);

						e.printStackTrace();
					}

				} catch (Exception e) {

					YaEstaLog yaestalog = new YaEstaLog();
					yaestalog.setLogDate(new Date());
					yaestalog.setProcessName("Guide Tracking");
					yaestalog.setTextinfo("Error al obtener tracking de Guia" + guide.getGuideNumber());
					// yaestalog.setXmlInfo(json);
					logService.save(yaestalog);

					e.printStackTrace();
				}
			}
		}
	}

	@Transactional
	public void saveGuideDetails(Guide guide, List<GuideDetail> details) {
		if (guide != null) {

			if (details != null && !details.isEmpty()) {
				for (GuideDetail gd : details) {
					gd.setGuide(guide);
					guideDetailRepository.save(gd);
				}
			}
		}
	}

	public List<GuideDetail> getGuideDetails(Guide guide) {
		return guideDetailRepository.findByGuide(guide);
	}

	@Transactional
	public String processMigrate() {

		String result = "OK";
		try {
			
			Catalog catDelivery = catalogService.findById(174L);
			Catalog catDeliveryProcess = catalogService.findById(179L);
			Catalog catCancel = catalogService.findById(175L);

			List<GuideMigrate> migrateList = guideMigrateRepository.findAll();

			if (migrateList != null && !migrateList.isEmpty()) {
				for (GuideMigrate gm : migrateList) {
					List<Guide> guideList = guideRepository.findByGuideNumber(gm.getGuideNumber());
					if(guideList!=null && !guideList.isEmpty()){
						for(Guide g:guideList){
							if(gm.getPod().equals("ENTREGADO")){
								g.setGuideStatus(catDelivery);
								g.setStatus(catDelivery.getNemonic());
							}else if(gm.getPod().equals("RETIRADO")){
								g.setGuideStatus(catDeliveryProcess);
								g.setStatus(catDeliveryProcess.getNemonic());
							}else if(gm.getPod().equals("DEVUELTO")){
								g.setGuideStatus(catCancel);
								g.setStatus(catCancel.getNemonic());
							}
							guideRepository.save(g);
							
							Order order = g.getOrder();
							
							if(order!=null && gm.getPaymentAcepted()!=null && gm.getPaymentAcepted().equals("SI")){
								order.setStatus("invoiced");
								order.setPendingInvoice(Boolean.FALSE);
								orderService.saveOrder(order);
							}else{
								order =orderService.findByVitexId(gm.getOrderId());
								if(order!=null && gm.getPaymentAcepted()!=null && gm.getPaymentAcepted().equals("SI")){
									order.setStatus("invoiced");
									order.setPendingInvoice(Boolean.FALSE);
									orderService.saveOrder(order);
								}
							}
						}//fin for de guias
					}
				}
			}

		} catch (Exception e) {
			result = "ERROR";
			YaEstaLog yaestalog = new YaEstaLog();
			yaestalog.setLogDate(new Date());
			yaestalog.setProcessName("Guide Migrate");
			yaestalog.setTextinfo("Error al procesar migracion de guias" + e.getMessage());
			// yaestalog.setXmlInfo(json);
			logService.save(yaestalog);
			e.printStackTrace();
		}
		
		return result;
	}
}
