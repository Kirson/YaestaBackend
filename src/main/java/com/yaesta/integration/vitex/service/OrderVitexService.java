package com.yaesta.integration.vitex.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/*
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
*/

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.MultivaluedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yaesta.app.mail.ItemInfo;
import com.yaesta.app.mail.MailInfo;
import com.yaesta.app.mail.MailParticipant;
import com.yaesta.app.mail.MailService;
import com.yaesta.app.persistence.entity.Guide;
import com.yaesta.app.persistence.entity.Order;
import com.yaesta.app.persistence.entity.Supplier;
import com.yaesta.app.persistence.entity.SupplierContact;
import com.yaesta.app.persistence.repository.SupplierContactRepository;
import com.yaesta.app.persistence.service.GuideService;
import com.yaesta.app.persistence.service.OrderService;
import com.yaesta.app.persistence.service.SupplierService;
import com.yaesta.app.persistence.util.HibernateProxyTypeAdapter;
import com.yaesta.app.util.SupplierUtil;
import com.yaesta.app.util.UtilDate;
import com.yaesta.integration.tramaco.dto.DeliveryInfoDTO;
import com.yaesta.integration.tramaco.dto.GuideDTO;
import com.yaesta.integration.tramaco.dto.SupplierDTO;
import com.yaesta.integration.tramaco.service.TramacoService;
import com.yaesta.integration.vitex.bean.GuideInfoBean;
import com.yaesta.integration.vitex.bean.SupplierDeliveryInfo;
import com.yaesta.integration.vitex.json.bean.ItemComplete;
import com.yaesta.integration.vitex.json.bean.OrderBean;
import com.yaesta.integration.vitex.json.bean.OrderComplete;
import com.yaesta.integration.vitex.json.bean.OrderConversation;
import com.yaesta.integration.vitex.json.bean.OrderSchema;
import com.yaesta.integration.vitex.json.bean.Paging;
import com.yaesta.integration.vitex.json.bean.Total;
import com.yaesta.integration.vitex.service.base.BaseVitexService;
import com.yaesta.integration.vitex.util.OrderVtexUtil;
import com.yaesta.integration.vitex.wsdl.OrderGet;
import com.yaesta.integration.vitex.wsdl.OrderGetNext50FromIdV3;
import com.yaesta.integration.vitex.wsdl.OrderGetNext50FromIdV3Response;
import com.yaesta.integration.vitex.wsdl.OrderGetResponse;
import com.yaesta.integration.vitex.wsdl.OrderGetV3;
import com.yaesta.integration.vitex.wsdl.OrderGetV3Response;
import com.yaesta.integration.vitex.wsdl.dto.ArrayOfOrderDTO;
import com.yaesta.integration.vitex.wsdl.dto.OrderDTO;
import com.yaesta.integration.vitex.wsdl.dto.OrderDeliveryDTO;
import com.yaesta.integration.vitex.wsdl.dto.OrderItemDTO;
import com.yaesta.integration.vitex.wsdl.dto.OrderItemDiscountDTO;
import com.yaesta.integration.vitex.wsdl.dto.ProductDTO;
import com.yaesta.integration.vitex.wsdl.vo.GuideVO;
import com.yaesta.integration.vitex.wsdl.vo.ItemDiscountVO;
import com.yaesta.integration.vitex.wsdl.vo.OrderDeliveryVO;
import com.yaesta.integration.vitex.wsdl.vo.OrderItemVO;
import com.yaesta.integration.vitex.wsdl.vo.OrderVO;

@Service
public class OrderVitexService extends BaseVitexService {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private WebServiceTemplate webServiceTemplate;

	@Autowired
	private ProductVitexService productVitexService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private GuideService guideService;

	@Autowired
	private SupplierService supplierService;
	
	@Autowired
	private SupplierContactRepository supplierContactRepository;
	
	@Autowired
	private TramacoService tramacoService;
	
	@Autowired
	private MailService mailService;

	private Client client;
	private WebTarget target;
	
	private @Value("${mail.smtp.from}") String mailFrom;
	private @Value("${mail.smtp.to}") String mailTo;
	private @Value("${mail.smtp.to.name}") String mailToName;
	private @Value("${mail.text.guide}") String mailTextGuide;
	private @Value("${mail.text.guide.2}") String mailTextGuide2;
	private @Value("${mail.text.guide.3}") String mailTextGuide3;
	private @Value("${mail.text.guide.4}") String mailTextGuide4;
	private @Value("${mail.text.guide.5}") String mailTextGuide5;
	private @Value("${mail.text.guide.6}") String mailTextGuide6;
	private @Value("${mail.text.guide.7}") String mailTextGuide7;
	private @Value("${mail.text.guide.8}") String mailTextGuide8;
	private @Value("${mail.text.guide.token}") String mailTextGuideToken;

	public OrderVitexService() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Bean( name = "propertyConfigurer" )
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        PropertySourcesPlaceholderConfigurer configurer = 
                new PropertySourcesPlaceholderConfigurer();

        return configurer;
    }

	public ArrayOfOrderDTO getOrders(Integer sequence) {

		OrderGetNext50FromIdV3 query = objectFactory.createOrderGetNext50FromIdV3();
		query.setSequence(sequence);
		OrderGetNext50FromIdV3Response response = (OrderGetNext50FromIdV3Response) webServiceTemplate
				.marshalSendAndReceive(query,
						new SoapActionCallback("http://tempuri.org/IService/OrderGetNext50FromIdV3"));
		return response.getOrderGetNext50FromIdV3Result().getValue();

	}

	public List<OrderVO> getOrdersNext50(Integer sequence) {
		List<OrderVO> result = new ArrayList<OrderVO>();

		ArrayOfOrderDTO array = getOrders(sequence);

		if (array != null) {
			if (array.getOrderDTO() != null && !array.getOrderDTO().isEmpty()) {
				for (OrderDTO odto : array.getOrderDTO()) {
					OrderVO ovo = new OrderVO();
					ovo.setId(odto.getId().getValue().longValue());
					ovo.setVitexId(odto.getId().getValue().longValue() + "");
					ovo.setCity(odto.getAddress().getValue().getCity().getValue());
					ovo.setCost(odto.getCost().getValue());
					ovo.setStore(odto.getStoreName().getValue());
					ovo.setCustomerVitexId(odto.getClientId().getValue() + "");
					ovo.setCustomerFirstName(odto.getClient().getValue().getFirstName().getValue());
					ovo.setCustomerLastName(odto.getClient().getValue().getLastName().getValue());
					ovo.setPurchaseDate(UtilDate.toDate(odto.getPurchaseDate().getValue()));
					if (odto.getOrderDeliveries().getValue().getOrderDeliveryDTO() != null
							&& !odto.getOrderDeliveries().getValue().getOrderDeliveryDTO().isEmpty()) {
						for (OrderDeliveryDTO oddto : odto.getOrderDeliveries().getValue().getOrderDeliveryDTO()) {
							OrderDeliveryVO odvo = new OrderDeliveryVO();
							odvo.setFreightId(oddto.getFreightId().getValue() + "");
							odvo.setFreightName(oddto.getFreightName().getValue());
							odvo.setOrderStatusDescription(
									oddto.getOrderStatus().getValue().getDescription().getValue());
							odvo.setOrderStatusCode(oddto.getOrderStatus().getValue().getId().getValue());
							if (oddto.getDeliveryDate().getValue() != null) {
								odvo.setDeliveryDate(UtilDate.toDate(oddto.getDeliveryDate().getValue()));
							}
							if (oddto.getOrderItems().getValue().getOrderItemDTO() != null
									&& !oddto.getOrderItems().getValue().getOrderItemDTO().isEmpty()) {
								for (OrderItemDTO oidto : oddto.getOrderItems().getValue().getOrderItemDTO()) {
									OrderItemVO oivo = new OrderItemVO();
									oivo.setCost(oidto.getCost().getValue());

									ProductDTO pdto = productVitexService.findById(oidto.getProductId().getValue());

									oivo.setProductRefId(oidto.getProductRefId().getValue());
									oivo.setProductName(pdto.getName().getValue());
									oivo.setProductId(oidto.getProductId().getValue() + "");
									oivo.setProductVitexId(oidto.getProductId().getValue() + "");
									oivo.setShippingCost(oidto.getShippingCost().getValue());
									if (oidto.getDiscounts() != null && oidto.getDiscounts().getValue() != null
											&& oidto.getDiscounts().getValue().getOrderItemDiscountDTO() != null
											&& !oidto.getDiscounts().getValue().getOrderItemDiscountDTO().isEmpty()) {
										oivo.setTotalDiscount(new BigDecimal(0));
										for (OrderItemDiscountDTO oiddto : oidto.getDiscounts().getValue()
												.getOrderItemDiscountDTO()) {
											ItemDiscountVO idvo = new ItemDiscountVO();
											idvo.setValue(oiddto.getValue().getValue());
											idvo.setDescription(oiddto.getDiscountName().getValue());
											BigDecimal tempDiscount = oivo.getTotalDiscount();
											tempDiscount = tempDiscount.add(oiddto.getValue().getValue());
											oivo.setTotalDiscount(tempDiscount);
											oivo.getDiscounts().add(idvo);
										}
									}
									odvo.getItems().add(oivo);

								}
							}
							ovo.getDeliveries().add(odvo);
						}
					}

					result.add(ovo);
				}

			}

		}

		return result;
	}

	public OrderDTO findById(Integer orderId) {
		OrderGet query = objectFactory.createOrderGet();
		query.setOrderId(orderId);
		OrderGetResponse response = (OrderGetResponse) webServiceTemplate.marshalSendAndReceive(query,
				new SoapActionCallback("http://tempuri.org/IService/OrderGet"));
		return response.getOrderGetResult().getValue();

	}

	public OrderDTO findOrderById(String orderId) {
		OrderGetV3 query = objectFactory.createOrderGetV3();
		query.setOrderId(objectFactory.createString(orderId));

		OrderGetV3Response response = (OrderGetV3Response) webServiceTemplate.marshalSendAndReceive(query,
				new SoapActionCallback("http://tempuri.org/IService/OrderGetV3"));
		return response.getOrderGetV3Result().getValue();
	}

	public OrderVO findOrder(String orderId) {
		OrderVO ovo = new OrderVO();
		OrderDTO odto = findOrderById(orderId);
		if (odto != null) {

			ovo.setId(odto.getId().getValue().longValue());
			ovo.setVitexId(odto.getId().getValue().longValue() + "");
			ovo.setCity(odto.getAddress().getValue().getCity().getValue());
			ovo.setCost(odto.getCost().getValue());
			ovo.setStore(odto.getStoreName().getValue());
			ovo.setCustomerVitexId(odto.getClientId().getValue() + "");
			ovo.setCustomerFirstName(odto.getClient().getValue().getFirstName().getValue());
			ovo.setCustomerLastName(odto.getClient().getValue().getLastName().getValue());
			ovo.setPurchaseDate(UtilDate.toDate(odto.getPurchaseDate().getValue()));
			if (odto.getOrderDeliveries().getValue().getOrderDeliveryDTO() != null
					&& !odto.getOrderDeliveries().getValue().getOrderDeliveryDTO().isEmpty()) {
				for (OrderDeliveryDTO oddto : odto.getOrderDeliveries().getValue().getOrderDeliveryDTO()) {
					OrderDeliveryVO odvo = new OrderDeliveryVO();
					odvo.setFreightId(oddto.getFreightId().getValue() + "");
					odvo.setFreightName(oddto.getFreightName().getValue());
					odvo.setOrderStatusDescription(oddto.getOrderStatus().getValue().getDescription().getValue());
					odvo.setOrderStatusCode(oddto.getOrderStatus().getValue().getId().getValue());
					if (oddto.getDeliveryDate().getValue() != null) {
						odvo.setDeliveryDate(UtilDate.toDate(oddto.getDeliveryDate().getValue()));
					}
					if (oddto.getOrderItems().getValue().getOrderItemDTO() != null
							&& !oddto.getOrderItems().getValue().getOrderItemDTO().isEmpty()) {
						for (OrderItemDTO oidto : oddto.getOrderItems().getValue().getOrderItemDTO()) {
							OrderItemVO oivo = new OrderItemVO();
							oivo.setCost(oidto.getCost().getValue());

							ProductDTO pdto = productVitexService.findById(oidto.getProductId().getValue());

							oivo.setProductRefId(oidto.getProductRefId().getValue());
							oivo.setProductName(pdto.getName().getValue());
							oivo.setProductId(oidto.getProductId().getValue() + "");
							oivo.setProductVitexId(oidto.getProductId().getValue() + "");
							oivo.setProductRefId(pdto.getRefId().getValue());
							oivo.setShippingCost(oidto.getShippingCost().getValue());
							if (oidto.getDiscounts().getValue().getOrderItemDiscountDTO() != null
									&& !oidto.getDiscounts().getValue().getOrderItemDiscountDTO().isEmpty()) {
								oivo.setTotalDiscount(new BigDecimal(0));
								for (OrderItemDiscountDTO oiddto : oidto.getDiscounts().getValue()
										.getOrderItemDiscountDTO()) {
									ItemDiscountVO idvo = new ItemDiscountVO();
									idvo.setValue(oiddto.getValue().getValue());
									idvo.setDescription(oiddto.getDiscountName().getValue());
									BigDecimal tempDiscount = oivo.getTotalDiscount();
									tempDiscount = tempDiscount.add(oiddto.getValue().getValue());
									oivo.setTotalDiscount(tempDiscount);
									oivo.getDiscounts().add(idvo);
								}
							}
							odvo.getItems().add(oivo);

						}
					}
					ovo.getDeliveries().add(odvo);
				}
			}

		}

		return ovo;
	}

	public OrderSchema getOrdersRest(String status) {

		client = ClientBuilder.newClient();

		String restUrl = this.vitexRestUrl + "/api/oms/pvt/orders/?per_page=100";
		
		if(status!=null){
			restUrl = restUrl + "&filter=status:"+status;
		}
		
		System.out.println("restUrl::"+restUrl);
		
		target = client.target(restUrl);
		
		MultivaluedMap<String, Object> myHeaders = new MultivaluedHashMap<String, Object>();
		myHeaders.add(vitexRestAppkeyName, vitexRestAppkey);
		myHeaders.add(vitexRestTokenName, vitexRestToken);
		String json = target.request(MediaType.TEXT_PLAIN).headers(myHeaders).get(String.class);

		OrderSchema response = new Gson().fromJson(json, OrderSchema.class);
		
		if(response.getList()!=null && !response.getList().isEmpty()){
			List<OrderBean> list = new ArrayList<OrderBean>();
			for(OrderBean ob:response.getList()){
				OrderBean obean = OrderVtexUtil.setRealValuesToOrderBean(ob);
				list.add(obean);
			}
			response.setList(list);
		}
		
		return response;
	}
	
	
	public OrderSchema getOrdersRestPaging() {

		client = ClientBuilder.newClient();

		String restUrl = this.vitexRestUrl + "/api/oms/pvt/orders/";
		
		OrderSchema input = new OrderSchema();
		Paging paging = new Paging();
		paging.setPerPage(50);
		input.setPaging(paging);
		
		Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
		String jsonInput = gson.toJson(input);
		restUrl=restUrl+"["+jsonInput+"]";
		System.out.println("rest"+restUrl);
		target = client.target(restUrl);
		
		MultivaluedMap<String, Object> myHeaders = new MultivaluedHashMap<String, Object>();
		myHeaders.add(vitexRestAppkeyName, vitexRestAppkey);
		myHeaders.add(vitexRestTokenName, vitexRestToken);
		String json = target.request(MediaType.TEXT_PLAIN).headers(myHeaders).get(String.class);

		OrderSchema response = new Gson().fromJson(json, OrderSchema.class);
		return response;
	}

	public OrderComplete getOrderComplete(String orderId) {

		client = ClientBuilder.newClient();

		String restUrl = this.vitexRestUrl + "/api/oms/pvt/orders/" + orderId;
		target = client.target(restUrl);

		MultivaluedMap<String, Object> myHeaders = new MultivaluedHashMap<String, Object>();
		myHeaders.add(vitexRestAppkeyName, vitexRestAppkey);
		myHeaders.add(vitexRestTokenName, vitexRestToken);
		String json = target.request(MediaType.TEXT_PLAIN).headers(myHeaders).get(String.class);
		


		OrderComplete responseOri = new Gson().fromJson(json, OrderComplete.class);
		//Los precios en VTex vienen en string se considera que los dos ultimos son posiciones
		//decimales por lo cual esta conversion los transformara en el valor real de la orden
		OrderComplete response = OrderVtexUtil.setRealValuesToOrderComplete(responseOri);
				
		List<Total> updateTotals = new ArrayList<Total>();
		BigDecimal totalPrice = new BigDecimal(0);
		for (Total total : response.getTotals()) {
			// System.out.println("====>>>>"+total.getName());
			if (total.getId().equals("Items")) {
				// System.out.println("====>>>>");
				total.setSpanishName("Total Items");
				totalPrice.add(new BigDecimal(total.getValue()));
			} else if (total.getId().equals("Discounts")) {
				total.setSpanishName("Total Descuentos");
				totalPrice.subtract(new BigDecimal(total.getValue()));
			} else if (total.getId().equals("Shipping")) {
				total.setSpanishName("Costo de Envio");
				totalPrice.add(new BigDecimal(total.getValue()));
			} else if (total.getId().equals("Tax")) {
				total.setSpanishName("Total Impuestos");
				totalPrice.add(new BigDecimal(total.getValue()));
			}
			updateTotals.add(total);
		}
		response.setTotalPrice(totalPrice);
		response.setTotals(updateTotals);

		List<SupplierDeliveryInfo> sdiList = buildSupplierDeliveryInfo(response);
		response.setSupplierDeliveryInfoList(sdiList);
		
		OrderConversation orderConversation = getOrderConversation(orderId);
		if(!orderConversation.getCustomerEmail().equals("")){
			response.getClientProfileData().setEmail(orderConversation.getCustomerEmail());
		}
		response = persistOrder(response,null);

		// generateGuides(response);
		return response;
	}
	
	public OrderConversation getOrderConversation(String orderId){
		client = ClientBuilder.newClient();

		String restUrl = this.vitexRestUrl + "/api/oms/pvt/orders/" + orderId + "/conversation-message";
		target = client.target(restUrl);

		MultivaluedMap<String, Object> myHeaders = new MultivaluedHashMap<String, Object>();
		myHeaders.add(vitexRestAppkeyName, vitexRestAppkey);
		myHeaders.add(vitexRestTokenName, vitexRestToken);
		String json = target.request(MediaType.TEXT_PLAIN).headers(myHeaders).get(String.class);
		String email = "";
		if(json!=null){
			json = json.substring(1,json.length());
			json = json.substring(0,json.length()-1);
			//System.out.println("json "+ json);
			String [] partOne = json.split("\"email\":");
			String [] emailData = partOne[1].split(",");
			email = emailData[0];
			email = email.replace("\"", "");
			email = email.trim();
		}
		
		OrderConversation ocon = new OrderConversation();
		
		ocon.setCustomerEmail(email);
		
		
		return ocon;
	}

	private OrderComplete persistOrder(OrderComplete orderComplete, String status) {

		Order found = orderService.findByVitexId(orderComplete.getOrderId());

		Order order = new Order();
        

		if (found != null) {
			order = found;
			order.setUpdDate(new Date());

		} else {
			// order.setCreateDate(orderComplete.getCreationDate());
			order.setCreateDate(new Date());
			orderComplete.setAppStatus("registered");
		}

		if(status!=null){
        	order.setStatus(status);
        }
        else{
        	order.setStatus(orderComplete.getAppStatus());
        }
        order.setVitexStatus(orderComplete.getStatus());
		order.setVitexId(orderComplete.getOrderId());
		order.setTotalPrice(orderComplete.getValue());
		
		GsonBuilder gBuilder = new GsonBuilder();

		gBuilder.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);

		Gson gson = gBuilder.create();

		String orderInfo = gson.toJson(orderComplete);

		order.setOrderInfo(orderInfo);

		orderService.saveOrder(order);

		return orderComplete;

	}

	private List<SupplierDeliveryInfo> buildSupplierDeliveryInfo(OrderComplete orderComplete) {
		List<SupplierDeliveryInfo> deliveryInfoList = new ArrayList<SupplierDeliveryInfo>();

		List<String> supplierCodes = new ArrayList<String>();

		// Obtener los codigos de proveedores
		for (ItemComplete ic : orderComplete.getItems()) {
			if (ic.getRefId() != null) {
				String refId = (String) ic.getRefId();
				System.out.println("refId " + refId);
				String[] supplierCode = SupplierUtil.returnSupplierCode(refId);
				System.out.println("refId " + supplierCode[0] + " " + supplierCode[1]);
				if (!supplierCodes.contains(supplierCode[0])) {
					System.out.println("agrega " + supplierCode[0]);
					supplierCodes.add(supplierCode[0]);
				}
			}
		}

		for (String sc : supplierCodes) {
			if (sc != null && !sc.equals("")) {
				Supplier supplier = supplierService.findById(new Long(sc));
				SupplierDeliveryInfo sdi = new SupplierDeliveryInfo();
				sdi.setSupplier(supplier);
				for (ItemComplete ic : orderComplete.getItems()) {
					String refId = (String) ic.getRefId();
					String[] supplierCode = SupplierUtil.returnSupplierCode(refId);
					if (sc.equals(supplierCode[0])) {
						sdi.getItems().add(ic);
					}
				}
				deliveryInfoList.add(sdi);
			}
		}

		return deliveryInfoList;
	}
	
	public GuideInfoBean generateGuides(GuideInfoBean guideInfoBean){
		GuideInfoBean response = guideInfoBean;
		List<GuideDTO> responseList = new ArrayList<GuideDTO>();
		
		OrderComplete orderComplete = guideInfoBean.getOrderComplete();
		
		List<SupplierDeliveryInfo> supplierDeliveryInfoList = guideInfoBean.getSupplierDeliveryInfoList();
		
		for(SupplierDeliveryInfo sdi:supplierDeliveryInfoList ){
			GuideDTO guideDTO = new GuideDTO();
			
			SupplierDTO supplierDTO = new SupplierDTO();
			
			supplierDTO.setSupplier(sdi.getSupplier());
			DeliveryInfoDTO dif = new DeliveryInfoDTO();
			dif.setItemList(sdi.getItems());
			dif.setPackages(sdi.getPackages());
			dif.setDeliveryDate(sdi.getDeliveryDate());
			supplierDTO.setDeliveryInfo(dif);
			guideDTO.setSupplierInfo(supplierDTO);
			guideDTO.setOrderComplete(orderComplete);
			guideDTO = tramacoService.generateGuide(guideDTO);
			response.setError(guideDTO.getResponse());
			response.getErrorList().addAll(guideDTO.getErrorList());
			
			System.out.println("Error " + response.getError());
			for(String er:response.getErrorList()){
				System.out.println("***"+er);
			}
			
			Guide guide = new Guide();
			guide.setCreateDate(new Date());
			guide.setOrderVitexId(orderComplete.getOrderId());
			guide.setVitexDispatcherId(guideDTO.getGuideResponse().getSalidaGenerarGuiaWs().getLstGuias().get(0).getId()+"%"+guideDTO.getGuideResponse().getSalidaGenerarGuiaWs().getLstGuias().get(0).getGuia());
			guide.setGuideInfo(new Gson().toJson(guideDTO));
			guideService.saveGuide(guide);
			guideDTO.setGuide(guide);
			
			GuideDTO gDTO=tramacoService.generateGuiaPDF(guideDTO);
			response.getPdfPathList().add(gDTO.getPdfUrl());
			
			responseList.add(gDTO);
		}
		
		response.setGuides(responseList);
		
		List<MailInfo> mailInfoList= prepareMailOrder(orderComplete,supplierDeliveryInfoList);
		
		for(MailInfo mailInfo:mailInfoList){
			for(GuideDTO gDto:responseList){
				if(gDto.getSupplierInfo().getSupplier().getId()==mailInfo.getRefId()){
					mailInfo.getAttachmentList().add(gDto.getPdfUrl());
				}
			}
			mailService.sendMailTemplate(mailInfo, "guideNotification.vm");	
		}
		
		return response;
	}

	public String generateGuides(OrderComplete orderComplete) {

		String result = "OK";

		List<String> supplierCodes = new ArrayList<String>();

		// Obtener los codigos de proveedores
		for (ItemComplete ic : orderComplete.getItems()) {
			if (ic.getRefId() != null) {
				String refId = (String) ic.getRefId();
				String[] supplierCode = SupplierUtil.returnSupplierCode(refId);
				if (!supplierCodes.contains(supplierCode[0])) {
					supplierCodes.add(supplierCode[0]);
				}
			} else {
				result = "Error:refIf:nulo";
			}
		}

		List<GuideVO> guides = new ArrayList<GuideVO>();

		for (String s : supplierCodes) {
			GuideVO guide = new GuideVO();
			guide.setSupplierVitexId(s);
			guides.add(guide);
		}

		// Iterar los Items y formar informacion de guias
		for (ItemComplete ic : orderComplete.getItems()) {
			for (GuideVO guide : guides) {
				String refId = (String) ic.getRefId();
				String[] supplierCode = SupplierUtil.returnSupplierCode(refId);
				if (guide.getSupplierVitexId().equals(supplierCode[0])) {
					guide.getItems().add(ic);
				}
			}
		}

		// persistir guias
		for (GuideVO gvo : guides) {
			Guide guide = new Guide();
			guide.setCreateDate(new Date());
			guide.setOrderVitexId(orderComplete.getOrderId());
			guide.setGuideInfo(new Gson().toJson(gvo));
			guideService.saveGuide(guide);
		}
		orderComplete.setAppStatus("generated-guide");
		orderComplete = persistOrder(orderComplete,"generated-guide");

		return result;
	}

	public OrderComplete changeStatus(OrderComplete orderComplete, String action) {

		
		if (orderComplete != null) {
			orderComplete.setError("OK");
			System.out.println("====>>>>1)");
			try{
			if(action==null){
				action = orderComplete.getAppStatus();
			}else{
				orderComplete.setAppStatus(action);
			}
			

			if (action.equals("cancel")) {
				OrderComplete cancelOrder = changeVitexOrder(orderComplete.getOrderId(), "/" + action);
				orderComplete = cancelOrder;
			}

			if (action.equals("invoice")) {
				OrderComplete invoiceOrder = changeVitexOrder(orderComplete.getOrderId(), "/" + action);
				orderComplete = invoiceOrder;
			}

			if (action.equals("approved")) {

				List<SupplierDeliveryInfo> sdiList = buildSupplierDeliveryInfo(orderComplete);
				orderComplete.setSupplierDeliveryInfoList(sdiList);
			}

			orderComplete = persistOrder(orderComplete,action);
			}catch(Exception e){
				orderComplete.setError("ERROR:"+e.getMessage());
			}

		}else{
			System.out.println("====>>>>2)");
			
		}
		return orderComplete;
	}

	private OrderComplete changeVitexOrder(String orderId, String action) {
		client = ClientBuilder.newClient();

		String restUrl = this.vitexRestUrl + "/api/oms/pvt/orders/" + orderId + action;
		target = client.target(restUrl);

		MultivaluedMap<String, Object> myHeaders = new MultivaluedHashMap<String, Object>();
		myHeaders.add(vitexRestAppkeyName, vitexRestAppkey);
		myHeaders.add(vitexRestTokenName, vitexRestToken);
		String json = target.request(MediaType.TEXT_PLAIN).headers(myHeaders).get(String.class);

		OrderComplete response = new Gson().fromJson(json, OrderComplete.class);

		return response;
	}
	
	
	private List<MailInfo> prepareMailOrder(OrderComplete orderComplete,List<SupplierDeliveryInfo> supplierDeliveryInfoList){
		
		List<MailInfo> mailInfoList= new ArrayList<MailInfo>();
		
		for(SupplierDeliveryInfo sdi:supplierDeliveryInfoList){
			
			MailInfo mailInfo = new MailInfo();
			
			MailParticipant sender = new MailParticipant();
			sender.setName("YaEsta.com");
			sender.setEmail(mailFrom);
			mailInfo.setMailSender(sender);
			
			MailParticipant receiver = new MailParticipant();
			receiver.setName(mailToName);
			receiver.setEmail(mailTo);
			mailInfo.setMailReceiver(receiver);
			
			List<MailParticipant> receiverTotal = new ArrayList<MailParticipant>();
				
			
			
			List<MailParticipant> recSupplierList = new ArrayList<MailParticipant>();
			Supplier supplier = sdi.getSupplier();
			List<SupplierContact> supplierContactList = supplierContactRepository.findBySupplier(supplier);
			if(supplierContactList!=null && !supplierContactList.isEmpty()){
				for(SupplierContact sc:supplierContactList){
					if(sc.getEmail()!=null){
						MailParticipant mp = new MailParticipant();
						mp.setEmail(sc.getEmail());
						mp.setName(supplier.getName());
						recSupplierList.add(mp);
					}
				}
			}
			if(supplier.getContactEmail()!=null){
				MailParticipant mp = new MailParticipant();
				mp.setEmail(supplier.getContactEmail());
				mp.setName(supplier.getName());
				recSupplierList.add(mp);
			}
			//Test Only
			/*
			MailParticipant mp = new MailParticipant();
			mp.setEmail("Cristhian.Herrera@gmail.com");
			mp.setName("Kirs Herrera");
			recSupplierList.add(mp);
			*/
			List<ItemComplete> icSupplierList = sdi.getItems();
			if(icSupplierList!=null && !icSupplierList.isEmpty()){
				for(ItemComplete ic:icSupplierList){
					ItemInfo iInfo = new ItemInfo();
					iInfo.setName(ic.getName());
					iInfo.setPrice(ic.getPrice());
					iInfo.setUrl(ic.getImageUrl());
					if(ic.getRefId()!=null){
						iInfo.setRefCode((String)ic.getRefId());
					}
					mailInfo.getItemInfoList().add(iInfo);
				}
			}
			
		
			receiverTotal.addAll(recSupplierList);	
			mailInfo.setReceivers(receiverTotal);
			mailInfo.setGeneralText(mailTextGuide);
			mailInfo.setRefId(supplier.getId());
			mailInfo.setRefVtexId(orderComplete.getOrderId());
			mailInfo.setSubject("Notificacion de pedido");
			
			//Agregar textos de guia
			mailInfo.getTextList().add(mailTextGuide2);
			String codeText = mailTextGuide3;
			codeText = codeText.replace(mailTextGuideToken, orderComplete.getOrderId());
			mailInfo.getTextList().add(codeText);
			mailInfo.getTextList().add(mailTextGuide4);
			mailInfo.getTextList().add(mailTextGuide5);
			mailInfo.getTextList().add(mailTextGuide6);
			mailInfo.getTextList().add(mailTextGuide7);
			mailInfo.getTextList().add(mailTextGuide8);
			
			mailInfoList.add(mailInfo);
		}
		
		
		
		return mailInfoList;
	}
}
