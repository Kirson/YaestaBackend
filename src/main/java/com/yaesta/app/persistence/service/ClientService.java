package com.yaesta.app.persistence.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaesta.app.persistence.entity.Customer;
import com.yaesta.app.persistence.entity.ClienteBodega;
import com.yaesta.app.persistence.entity.TramacoZone;
import com.yaesta.app.persistence.entity.YaEstaLog;
import com.yaesta.app.persistence.repository.ClientRepository;
import com.yaesta.app.persistence.repository.ClienteBodegaRepository;
import com.yaesta.app.persistence.vo.ClientResponseVO;
import com.yaesta.app.persistence.vo.ClientVO;
import com.yaesta.app.persistence.vo.ClientWarehouseVO;
import com.yaesta.app.util.ClientUtil;
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
	
	@Autowired
	YaEstaLogService logService;

	public List<Customer> getClients() {
		return clientRepository.findAll();
	}

	@Deprecated
	@Transactional
	public String updateInfo() {
		String response = "OK";

		// Obtener todas las ordenes
		OrderSchema os = orderVitexService.getOrdersRest(null);
		List<OrderComplete> ocList = new ArrayList<OrderComplete>();
		List<OrderBean> obList = os.getList();
		for (OrderBean ob : obList) {
			OrderComplete oc = orderVitexService.getOrderComplete(ob.getOrderId());
			ocList.add(oc);
		}

		// Iterar todas las ordenes
		for (OrderComplete oc : ocList) {
			Customer found = clientRepository.findByDocument(oc.getClientProfileData().getDocument());
			Customer client = new Customer();
			if (found != null) {
				client = found;
			} else {
				client.setCreateDate(new Date());
			}

			client.setDocument(oc.getClientProfileData().getDocument());
			client.setEmail(oc.getClientProfileData().getEmail());
			client.setFirstName(oc.getClientProfileData().getFirstName());
			client.setLastName(oc.getClientProfileData().getLastName());
			client.setVitexId(oc.getClientProfileData().getUserProfileId());
			client.setHomePhone(oc.getClientProfileData().getPhone());
			client.setCellPhone(oc.getClientProfileData().getPhone());

			String province = oc.getShippingData().getAddress().getState();
			String canton = oc.getShippingData().getAddress().getCity();

			TramacoZone tz = tramacoZoneService.getByProvinciaCantonParroquia(province, canton, canton);

			if (tz != null) {
				client.setGeoZone(tz.getCodigo() + "");
			}

			client.setProvince(province);
			client.setCanton(canton);

			client.setClientName(oc.getCustomerName());

			String address = oc.getShippingData().getAddress().getCountry() + " "
					+ oc.getShippingData().getAddress().getState() + " " + oc.getShippingData().getAddress().getCity()
					+ " - " + oc.getShippingData().getAddress().getStreet() + " "
					+ oc.getShippingData().getAddress().getNumber() + " "
					+ oc.getShippingData().getAddress().getComplement() + " POSTALCODE: "
					+ oc.getShippingData().getAddress().getPostalCode();
			client.setAddress(address);
			client.setPostalCode(oc.getShippingData().getAddress().getPostalCode());
			client.setWarehouseCode("COD" + client.getDocument());
			client.setCreateDate(new Date());
			client.setIsNew("S");

			if (oc.getPaymentData().getTransactions() != null && !oc.getPaymentData().getTransactions().isEmpty()) {
				for (Transaction tr : oc.getPaymentData().getTransactions()) {
					if (tr.getPayments() != null && !tr.getPayments().isEmpty()) {
						for (Payment py : tr.getPayments()) {
							client.setLastPaymentMethod(py.getPaymentSystemName());
							System.out.println("SystemPaymentname " + py.getPaymentSystemName());
							if (py.getPaymentSystemName()
									.equals(PaymentEnum.PAGO_CONTRA_ENTREGA.getPaymentSystemName())) {
								client.setUseCreditCard(Boolean.FALSE);
							} else if (py.getPaymentSystemName().equals(PaymentEnum.SAFETYPAY.getPaymentSystemName())) {
								client.setUseCreditCard(Boolean.FALSE);
							} else if (py.getPaymentSystemName().equals(
									PaymentEnum.TRANSFERENCIA_BANCARIA_OTRAS_ENTIDADES.getPaymentSystemName())) {
								client.setUseCreditCard(Boolean.FALSE);
							} else if (py.getPaymentSystemName().equals(PaymentEnum.PAYCLUB.getPaymentSystemName())) {
								client.setUseCreditCard(Boolean.TRUE);
							} else if (py.getPaymentSystemName()
									.equals(PaymentEnum.TARJETA_ALIA.getPaymentSystemName())) {
								client.setUseCreditCard(Boolean.TRUE);
							} else if (py.getPaymentSystemName()
									.equals(PaymentEnum.TARJETA_CREDITO.getPaymentSystemName())) {
								client.setUseCreditCard(Boolean.TRUE);
							} else if (py.getPaymentSystemName().equals(PaymentEnum.PAYPAL.getPaymentSystemName())) {
								client.setUseCreditCard(Boolean.TRUE);
							}

						} // fin for

					} //
				}

				clientRepository.save(client);
			}
		}

		List<Customer> clientList = clientRepository.findAll();

		for (Customer cl : clientList) {
			String code = "COD" + cl.getDocument();
			ClienteBodega found = clienteBodegaRepository.findOne(code);
			if (found == null) {
				ClienteBodega nCb = new ClienteBodega();
				nCb.setCodigo(code);
				nCb.setRazonSocial(cl.getClientName());
				nCb.setDireccionEntrega(cl.getAddress());
				nCb.setNombreVia(cl.getAddress());
				// nCb.setUbicacionGeografica(cl.getGeoZone());
				nCb.setNuevo("S");
				nCb.setFechaCreacion(new Date());
				clienteBodegaRepository.save(nCb);
			} else {
				found.setNuevo("N");
				clienteBodegaRepository.save(found);
			}
		}

		return response;
	}
	
	@Transactional
	public String updateNewCustomerList(){
		String result = "OK";
		try{
			List<Customer> customerList = clientRepository.findAll();
			
			if(customerList!=null && !customerList.isEmpty()){
				
				for(Customer cl:customerList){
					String code = "COD" + cl.getDocument();
					ClienteBodega found = clienteBodegaRepository.findOne(code);
					if (found == null) {
						ClienteBodega nCb = new ClienteBodega();
						nCb.setCodigo(code);
						nCb.setRazonSocial(cl.getClientName());
						nCb.setDireccionEntrega(cl.getAddress());
						nCb.setNombreVia(cl.getAddress());
						// nCb.setUbicacionGeografica(cl.getGeoZone());
						nCb.setNuevo("S");
						nCb.setFechaCreacion(new Date());
						clienteBodegaRepository.save(nCb);
					} else {
						found.setNuevo("N");
						clienteBodegaRepository.save(found);
					}
				}
			}
			
		}catch(Exception e){
			System.out.println("Error es "+e.getMessage());
			result = "ERROR";
		}
		return result;
	}

	public List<ClienteBodega> getNewToWarehouse() {
		List<ClienteBodega> newList = new ArrayList<ClienteBodega>();

		newList = clienteBodegaRepository.findByNuevo("S");

		return newList;
	}
	@Transactional
	public ClientResponseVO updateWarehouseClient(){
		ClientResponseVO crv = new ClientResponseVO();
		
		crv.setResponse("OK");
		try{
		List<ClienteBodega> updList = getNewToWarehouse();
		
			if(updList!=null && !updList.isEmpty()){
				for(ClienteBodega cb:updList){
					cb.setNuevo("N");
					clienteBodegaRepository.save(cb);
				}
			}
		}catch(Exception e){
			crv.setResponse("ERROR "+e.getMessage());
			YaEstaLog yaestalog = new YaEstaLog();
			yaestalog.setLogDate(new Date());
			yaestalog.setProcessName("WAREHOUSECUSTOMER-UPDATE");
			yaestalog.setTextinfo(crv.getResponse());
			logService.save(yaestalog);
		}
		return crv;
	}

	public List<ClientWarehouseVO> getNewClient() {
		List<ClientWarehouseVO> result = new ArrayList<ClientWarehouseVO>();
		List<ClienteBodega> query = getNewToWarehouse();
		if (query != null && !query.isEmpty()) {
			for (ClienteBodega cb : query) {
				ClientWarehouseVO cw = ClientUtil.fromClienteBodegaToClientWarehouse(cb);
				result.add(cw);
			}
		}
		return result;
	}

	public List<ClientVO> getAllVO() {
		List<ClientVO> result = new ArrayList<ClientVO>();
		List<Customer> query = this.getClients();
		if (query != null && !query.isEmpty()) {
			for (Customer c : query) {
				ClientVO cvo = ClientUtil.fromClientToClientVO(c);
				result.add(cvo);
			}
		}

		return result;
	}

	@Transactional
	public Customer updateCustomerInfo(OrderComplete oc) {

		Customer found = clientRepository.findByDocument(oc.getClientProfileData().getDocument());
		Customer client = new Customer();
		if (found != null) {
			client = found;
		} else {
			client.setCreateDate(new Date());
		}

		client.setDocument(oc.getClientProfileData().getDocument());
		client.setEmail(oc.getClientProfileData().getEmail());
		client.setFirstName(oc.getClientProfileData().getFirstName());
		client.setLastName(oc.getClientProfileData().getLastName());
		client.setVitexId(oc.getClientProfileData().getUserProfileId());
		client.setHomePhone(oc.getClientProfileData().getPhone());
		client.setCellPhone(oc.getClientProfileData().getPhone());

		String province = oc.getShippingData().getAddress().getState();
		String canton = oc.getShippingData().getAddress().getCity();

		TramacoZone tz = tramacoZoneService.getByProvinciaCantonParroquia(province, canton, canton);

		if (tz != null) {
			client.setGeoZone(tz.getCodigo() + "");
		}

		client.setProvince(province);
		client.setCanton(canton);

		client.setClientName(oc.getCustomerName());

		String address = oc.getShippingData().getAddress().getCountry() + " "
				+ oc.getShippingData().getAddress().getState() + " " + oc.getShippingData().getAddress().getCity()
				+ " - " + oc.getShippingData().getAddress().getStreet() + " "
				+ oc.getShippingData().getAddress().getNumber() + " "
				+ oc.getShippingData().getAddress().getComplement() + " POSTALCODE: "
				+ oc.getShippingData().getAddress().getPostalCode();
		client.setAddress(address);
		client.setPostalCode(oc.getShippingData().getAddress().getPostalCode());
		client.setWarehouseCode("COD" + client.getDocument());
		client.setCreateDate(new Date());
		client.setIsNew("S");

		if (oc.getPaymentData().getTransactions() != null && !oc.getPaymentData().getTransactions().isEmpty()) {
			for (Transaction tr : oc.getPaymentData().getTransactions()) {
				if (tr.getPayments() != null && !tr.getPayments().isEmpty()) {
					for (Payment py : tr.getPayments()) {
						client.setLastPaymentMethod(py.getPaymentSystemName());
						System.out.println("SystemPaymentname " + py.getPaymentSystemName());
						if (py.getPaymentSystemName().equals(PaymentEnum.PAGO_CONTRA_ENTREGA.getPaymentSystemName())) {
							client.setUseCreditCard(Boolean.FALSE);
						} else if (py.getPaymentSystemName().equals(PaymentEnum.SAFETYPAY.getPaymentSystemName())) {
							client.setUseCreditCard(Boolean.FALSE);
						} else if (py.getPaymentSystemName()
								.equals(PaymentEnum.TRANSFERENCIA_BANCARIA_OTRAS_ENTIDADES.getPaymentSystemName())) {
							client.setUseCreditCard(Boolean.FALSE);
						} else if (py.getPaymentSystemName().equals(PaymentEnum.PAYCLUB.getPaymentSystemName())) {
							client.setUseCreditCard(Boolean.TRUE);
						} else if (py.getPaymentSystemName().equals(PaymentEnum.TARJETA_ALIA.getPaymentSystemName())) {
							client.setUseCreditCard(Boolean.TRUE);
						} else if (py.getPaymentSystemName()
								.equals(PaymentEnum.TARJETA_CREDITO.getPaymentSystemName())) {
							client.setUseCreditCard(Boolean.TRUE);
						} else if (py.getPaymentSystemName().equals(PaymentEnum.PAYPAL.getPaymentSystemName())) {
							client.setUseCreditCard(Boolean.TRUE);
						}

					} // fin for

				} //
			}

			clientRepository.save(client);
		}

		String code = "COD" + client.getDocument();
		//ClienteBodega foundB = clienteBodegaRepository.findOne(code);
		if (found == null) {
			ClienteBodega nCb = new ClienteBodega();
			nCb.setCodigo(code);
			nCb.setRazonSocial(client.getClientName());
			nCb.setDireccionEntrega(client.getAddress());
			nCb.setNombreVia(client.getAddress());
			// nCb.setUbicacionGeografica(cl.getGeoZone());
			nCb.setNuevo("S");
			nCb.setFechaCreacion(new Date());
			clienteBodegaRepository.save(nCb);
		}/* 
		else {
			foundB.setNuevo("N");
			clienteBodegaRepository.save(foundB);
		}*/
		
		return client;
	}
}
