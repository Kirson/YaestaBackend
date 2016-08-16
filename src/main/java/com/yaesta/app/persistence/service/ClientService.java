package com.yaesta.app.persistence.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaesta.app.persistence.entity.Client;
import com.yaesta.app.persistence.entity.ClienteBodega;
import com.yaesta.app.persistence.entity.TramacoZone;
import com.yaesta.app.persistence.repository.ClientRepository;
import com.yaesta.app.persistence.repository.ClienteBodegaRepository;
import com.yaesta.integration.vitex.json.bean.OrderBean;
import com.yaesta.integration.vitex.json.bean.OrderComplete;
import com.yaesta.integration.vitex.json.bean.OrderSchema;
import com.yaesta.integration.vitex.json.bean.Payment;
import com.yaesta.integration.vitex.json.bean.Transaction;
import com.yaesta.integration.vitex.json.bean.enums.PaymentEnum;
import com.yaesta.integration.vitex.service.OrderVitexService;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private ClienteBodegaRepository clienteBodegaRepository;
	
	@Autowired
	private OrderVitexService orderVitexService;
	
	@Autowired
	private TramacoZoneService tramacoZoneService;
	
	public List<Client> getClients(){
		return clientRepository.findAll();
	}
	
	
	@Transactional
	public String updateInfo(){
		String response="OK";
		
		
		//Obtener todas las ordenes
		OrderSchema os = orderVitexService.getOrdersRest(null);
		List<OrderComplete> ocList = new ArrayList<OrderComplete>();
		List<OrderBean> obList = os.getList();
		for(OrderBean ob:obList){
			OrderComplete oc = orderVitexService.getOrderComplete(ob.getOrderId());
			ocList.add(oc);
		}
		
		//Iterar todas las ordenes
		for(OrderComplete oc:ocList){
			Client found = clientRepository.findByDocument(oc.getClientProfileData().getDocument());
			Client client = new Client();
			if(found!=null){
				 client = found;
			}else{
				client.setCreateDate(new Date());
			}
				
			client.setDocument(oc.getClientProfileData().getDocument());
			client.setEmail(oc.getClientProfileData().getEmail());
			client.setFirstName(oc.getClientProfileData().getFirstName());
			client.setLastName(oc.getClientProfileData().getLastName());
			client.setVitexId(oc.getClientProfileData().getUserProfileId());
			client.setHomePhone(oc.getClientProfileData().getPhone());
			client.setCellPhone(oc.getClientProfileData().getPhone());
			
			String province =oc.getShippingData().getAddress().getState();
			String canton = oc.getShippingData().getAddress().getCity();
				
				
			TramacoZone tz = tramacoZoneService.getByProvinciaCantonParroquia(province, canton, canton);
				
			if(tz!=null){
				client.setGeoZone(tz.getCodigo()+"");
			}
				
			client.setProvince(province);
			client.setCanton(canton);
				
			client.setClientName(oc.getCustomerName());
			
			String address=oc.getShippingData().getAddress().getCountry() + " " +oc.getShippingData().getAddress().getState() + " " + oc.getShippingData().getAddress().getCity() + " - " + oc.getShippingData().getAddress().getStreet() + " " + oc.getShippingData().getAddress().getNumber() + " " + oc.getShippingData().getAddress().getComplement() + " POSTALCODE: " +  oc.getShippingData().getAddress().getPostalCode(); 
			client.setAddress(address);
			client.setPostalCode(oc.getShippingData().getAddress().getPostalCode());
			client.setWarehouseCode("COD"+client.getDocument());
			client.setCreateDate(new Date());
			client.setIsNew("S");
				
				
			if(oc.getPaymentData().getTransactions()!=null && !oc.getPaymentData().getTransactions().isEmpty()){
				for(Transaction tr:oc.getPaymentData().getTransactions()){
					if(tr.getPayments()!=null && !tr.getPayments().isEmpty()){
						for(Payment py:tr.getPayments()){
							client.setLastPaymentMethod(py.getPaymentSystemName());
							System.out.println("SystemPaymentname "+py.getPaymentSystemName());
							if(py.getPaymentSystemName().equals(PaymentEnum.PAGO_CONTRA_ENTREGA.getPaymentSystemName())){
								client.setUseCreditCard(Boolean.FALSE);
							}else if(py.getPaymentSystemName().equals(PaymentEnum.SAFETYPAY.getPaymentSystemName())){
									client.setUseCreditCard(Boolean.FALSE);
								}else if(py.getPaymentSystemName().equals(PaymentEnum.TRANSFERENCIA_BANCARIA_OTRAS_ENTIDADES.getPaymentSystemName())){
									client.setUseCreditCard(Boolean.FALSE);
								}
								else if(py.getPaymentSystemName().equals(PaymentEnum.PAYCLUB.getPaymentSystemName())){
									client.setUseCreditCard(Boolean.TRUE);
								}else if(py.getPaymentSystemName().equals(PaymentEnum.TARJETA_ALIA.getPaymentSystemName())){
									client.setUseCreditCard(Boolean.TRUE);
								}else if(py.getPaymentSystemName().equals(PaymentEnum.TARJETA_CREDITO.getPaymentSystemName())){
									client.setUseCreditCard(Boolean.TRUE);
								}
								else if(py.getPaymentSystemName().equals(PaymentEnum.PAYPAL.getPaymentSystemName())){
									client.setUseCreditCard(Boolean.TRUE);
								}
								
								
							}//fin for
							
							
						}//
					}
				
				
				clientRepository.save(client);
			}
		}
		
		
		List<Client> clientList = clientRepository.findAll();
		
		for(Client cl:clientList){
			String code = "COD"+cl.getDocument();
			ClienteBodega found = clienteBodegaRepository.findOne(code);
			if(found==null){
				ClienteBodega nCb = new ClienteBodega();
				nCb.setCodigo(code);
				nCb.setRazonSocial(cl.getClientName());
				nCb.setDireccionEntrega(cl.getAddress());
				nCb.setNombreVia(cl.getAddress());
				nCb.setUbicacionGeografia(cl.getGeoZone());
				nCb.setNuevo("S");
				nCb.setFechaCreacion(new Date());
				clienteBodegaRepository.save(nCb);
			}else{
			found.setNuevo("N");
			clienteBodegaRepository.save(found);
			}
		}
		
		return response;
	}
	
}
