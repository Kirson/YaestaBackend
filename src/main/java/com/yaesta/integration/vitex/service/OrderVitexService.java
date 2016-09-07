package com.yaesta.integration.vitex.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
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
import com.yaesta.app.persistence.entity.Catalog;
import com.yaesta.app.persistence.entity.Customer;
import com.yaesta.app.persistence.entity.Guide;
import com.yaesta.app.persistence.entity.Order;
import com.yaesta.app.persistence.entity.OrderItem;
import com.yaesta.app.persistence.entity.Supplier;
import com.yaesta.app.persistence.entity.SupplierContact;
import com.yaesta.app.persistence.repository.SupplierContactRepository;
import com.yaesta.app.persistence.service.CatalogService;
import com.yaesta.app.persistence.service.ClientService;
import com.yaesta.app.persistence.service.GuideService;
import com.yaesta.app.persistence.service.OrderService;
import com.yaesta.app.persistence.service.SupplierService;
//import com.yaesta.app.persistence.util.HibernateProxyTypeAdapter;
import com.yaesta.app.persistence.util.YaestaTypeAdapter;
import com.yaesta.app.util.SupplierUtil;
import com.yaesta.app.util.UtilDate;
import com.yaesta.integration.base.enums.DeliveryEnum;
import com.yaesta.integration.base.util.BaseUtil;
import com.yaesta.integration.datil.json.bean.FacturaConsulta;
import com.yaesta.integration.datil.json.bean.FacturaRespuestaSRI;
import com.yaesta.integration.datil.json.enums.PagoEnum;
import com.yaesta.integration.datil.service.DatilService;
import com.yaesta.integration.tramaco.dto.GuideBeanDTO;
import com.yaesta.integration.tramaco.dto.GuideDTO;
import com.yaesta.integration.tramaco.service.TramacoService;
import com.yaesta.integration.vitex.bean.GuideContainerBean;
import com.yaesta.integration.vitex.bean.GuideInfoBean;
import com.yaesta.integration.vitex.bean.InvoiceSchemaBean;
import com.yaesta.integration.vitex.bean.SupplierDeliveryInfo;
import com.yaesta.integration.vitex.json.bean.CategoryVtex;
import com.yaesta.integration.vitex.json.bean.InvoiceResponse;
import com.yaesta.integration.vitex.json.bean.InvoiceSchema;
import com.yaesta.integration.vitex.json.bean.ItemComplete;
import com.yaesta.integration.vitex.json.bean.ItemInvoice;
import com.yaesta.integration.vitex.json.bean.OrderBean;
import com.yaesta.integration.vitex.json.bean.OrderCancel;
import com.yaesta.integration.vitex.json.bean.OrderComplete;
import com.yaesta.integration.vitex.json.bean.OrderConversation;
import com.yaesta.integration.vitex.json.bean.OrderSchema;
import com.yaesta.integration.vitex.json.bean.Paging;
import com.yaesta.integration.vitex.json.bean.Payment;
import com.yaesta.integration.vitex.json.bean.PriceTag;
import com.yaesta.integration.vitex.json.bean.Total;
import com.yaesta.integration.vitex.json.bean.Transaction;
import com.yaesta.integration.vitex.json.bean.enums.PaymentEnum;
import com.yaesta.integration.vitex.service.base.BaseVitexService;
import com.yaesta.integration.vitex.util.OrderVtexUtil;
import com.yaesta.integration.vitex.wsdl.OrderChangeStatus;
import com.yaesta.integration.vitex.wsdl.OrderChangeStatusResponse;
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
	private CategoryVitexService categoryVitexService; 

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
	
	@Autowired
	private DatilService datilService;
	
	@Autowired
	private CatalogService catalogService;
	
	@Autowired
	private ClientService clientService;

	private Client client;
	private WebTarget target;
	
	private @Value("${mail.smtp.from}") String mailFrom;
	private @Value("${mail.smtp.to}") String mailTo;
	private @Value("${mail.smtp.to.name}") String mailToName;
	private @Value("${mail.smtp.cc}") String mailCc;
	private @Value("${mail.smtp.cc.name}") String mailCcName;
	private @Value("${mail.text.guide}") String mailTextGuide;
	private @Value("${mail.text.guide.2}") String mailTextGuide2;
	private @Value("${mail.text.guide.3}") String mailTextGuide3;
	private @Value("${mail.text.guide.4}") String mailTextGuide4;
	private @Value("${mail.text.guide.5}") String mailTextGuide5;
	private @Value("${mail.text.guide.6}") String mailTextGuide6;
	private @Value("${mail.text.guide.7}") String mailTextGuide7;
	private @Value("${mail.text.guide.8}") String mailTextGuide8;
	private @Value("${mail.text.guide.token}") String mailTextGuideToken;
	private @Value("${tramaco.contacts}") String tramacoContacts;
	private @Value("${tramaco.contacts.names}") String tramacoContactsNames;
	private @Value("${datil.iva.value}") String datilIvaValue;
	private @Value("${datil.iva.percent.value}") String datilIvaPercentValue;

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
		BigDecimal totalDiscounts = new BigDecimal(0);
		BigDecimal totalShipping = new BigDecimal(0);
		for (Total total : response.getTotals()) {
			// System.out.println("====>>>>"+total.getName());
			if (total.getId().equals("Items")) {
				// System.out.println("====>>>>");
				total.setSpanishName("Total Items");
				totalPrice.add(new BigDecimal(total.getValue()));
			} else if (total.getId().equals("Discounts")) {
				total.setSpanishName("Total Descuentos");
				totalPrice.subtract(new BigDecimal(total.getValue()));
				totalDiscounts = new BigDecimal(total.getValue());
			} else if (total.getId().equals("Shipping")) {
				total.setSpanishName("Costo de Envio");
				totalPrice.add(new BigDecimal(total.getValue()));
				totalShipping = new BigDecimal(total.getValue());
			} else if (total.getId().equals("Tax")) {
				total.setSpanishName("Total Impuestos");
				totalPrice.add(new BigDecimal(total.getValue()));
			}
			updateTotals.add(total);
		}
		response.setTotalPrice(totalPrice);
		response.setTotals(updateTotals);
		
		List<ItemComplete> icList = new ArrayList<ItemComplete>();
		
		
		
		if(response.getItems()!=null && !response.getItems().isEmpty()){
			
			BigDecimal partialSellerPrice = totalShipping.divide(new BigDecimal(response.getItems().size()), 2,RoundingMode.CEILING);
			BigDecimal partialDiscount = totalDiscounts.divide(new BigDecimal(response.getItems().size()), 2, RoundingMode.CEILING);
			
			for(ItemComplete ic:response.getItems()){
				ItemComplete itc = ic;
				try{
					String refId = (String)ic.getRefId();
					String[] supplierCode = SupplierUtil.returnSupplierCode(refId);
					Supplier sp = supplierService.findById(new Long(supplierCode[0]));
					itc.setSupplierName(sp.getName());
				}catch(Exception e){
					//Nothing TODO.
				}
				itc.setDiscount(partialDiscount.doubleValue());
				itc.setSellingPrice(partialSellerPrice.doubleValue());
				icList.add(itc);
			}
			
			response.setItems(icList);
		}

		List<SupplierDeliveryInfo> sdiList = buildSupplierDeliveryInfo(response);
		response.setSupplierDeliveryInfoList(sdiList);
		
		OrderConversation orderConversation = getOrderConversation(orderId);
		if(!orderConversation.getCustomerEmail().equals("")){
			response.getClientProfileData().setEmail(orderConversation.getCustomerEmail());
		}
		response = persistOrder(response,null);

		try {
			generateOrderItem(response);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		try{
			if(json!=null){
				json = json.substring(1,json.length());
				json = json.substring(0,json.length()-1);
				System.out.println("json "+ json);
				String [] partZero = json.split("\"to\":");
				String [] partOne = partZero[1].split("\"email\":");
				String [] emailData = partOne[1].split(",");
				email = emailData[0];
				email = email.replace("\"", "");
				email = email.trim();
			}
		}catch(Exception e){
			System.out.println("Error obteniendo email enmascarado de cliente "+json);
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
		
		String dateParts[] = UtilDate.dateParts(order.getCreateDate());
		order.setPeriode(dateParts[0]+"-"+dateParts[1]);
		
		GsonBuilder gBuilder = new GsonBuilder();
		//gBuilder.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		gBuilder.registerTypeAdapter(OrderComplete.class, new YaestaTypeAdapter<OrderComplete>());
		
		System.out.println("Order Complete " + orderComplete.getOrderId());

		Gson gson = gBuilder.create();

		String orderInfo = gson.toJson(orderComplete);

		order.setOrderInfo(orderInfo);

		orderService.saveOrder(order);
		
		Customer customer=clientService.updateCustomerInfo(orderComplete); //capturar informacion del cliente

		if(order.getClient()==null){
			order.setClient(customer);
			orderService.saveOrder(order);
		}
		
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
	
	public GuideContainerBean generateGuides(GuideInfoBean guideInfoBean){
		GuideContainerBean result = new GuideContainerBean(); 
		GuideInfoBean response = guideInfoBean;
		List<GuideDTO> responseList = new ArrayList<GuideDTO>();
		
		OrderComplete orderComplete = guideInfoBean.getOrderComplete();
		
		Order order = orderService.findByVitexId(orderComplete.getOrderId());
		
		List<SupplierDeliveryInfo> supplierDeliveryInfoList = guideInfoBean.getSupplierDeliveryInfoList();
		
		orderComplete.setSupplierDeliveryInfoList(supplierDeliveryInfoList);
		GuideDTO guideDTO = new GuideDTO();
		guideDTO.setOrderComplete(orderComplete);
		guideDTO.setCustomerAdditionalInfo(guideInfoBean.getCustomerAdditionalInfo());
		
		GuideDTO resultGuideInfo = tramacoService.generateGuides(guideDTO);
		
		List<GuideBeanDTO> guideInfoBeanList = resultGuideInfo.getGuideBeanList();
		List<GuideBeanDTO> guideInfoList = new ArrayList<GuideBeanDTO>();
		
		if(guideInfoBeanList!=null && !guideInfoBeanList.isEmpty()){
			for(GuideBeanDTO gbd:guideInfoBeanList){
				Guide guide = new Guide();
				guide.setCreateDate(new Date());
				guide.setOrderVitexId(orderComplete.getOrderId());
				guide.setVitexDispatcherId(gbd.getGuideResponse().getSalidaGenerarGuiaWs().getLstGuias().get(0).getId()+"%"+gbd.getGuideResponse().getSalidaGenerarGuiaWs().getLstGuias().get(0).getGuia());
				guide.setGuideInfo(new Gson().toJson(gbd));
				guide.setOrder(order);
				guide.setDeliveryCost(gbd.getDeliveryCost());
				guide.setDeliveryPayment(gbd.getDeliveryPayment());
				guide.setItemValue(gbd.getItemValue());
				guide.setDeliveryStatus("GENERATED");
				guide.setSupplier(gbd.getSupplier());
				guideService.saveGuide(guide);
				gbd.setGuide(guide);
				guideInfoList.add(gbd);
			}
			
			guideDTO.setGuideBeanList(guideInfoList);
			//LLamar ahora al servicio de pdfs
			resultGuideInfo = tramacoService.generateGuidesPDF(guideDTO);
			guideInfoBeanList = resultGuideInfo.getGuideBeanList();
			//Realizar segunda iteracion para las guias
			List<Guide> guides = new ArrayList<Guide>();
			for(GuideBeanDTO gbd:guideInfoBeanList){
				Guide guide = gbd.getGuide();
				guide.setStatus("GENERATED-PDF");
				guide.setDocumentUrl(gbd.getPdfUrl());
				guide.setDeliveryName("TRAMACO");
				guideService.saveGuide(guide);
				guides.add(guide);
				response.getPdfPathList().add(gbd.getPdfUrl());
			}
			
			responseList.add(resultGuideInfo);
			guideDTO=resultGuideInfo;
		}
		
		result.setGuideInfoBean(response);
		
		result.setGuides(responseList);
		
		List<MailInfo> mailInfoList= prepareMailOrder(orderComplete,supplierDeliveryInfoList);
		
		for(MailInfo mailInfo:mailInfoList){
			for(GuideBeanDTO gDto:guideDTO.getGuideBeanList()){
				if(gDto.getSupplier().getId()==mailInfo.getRefId()){
					mailInfo.getAttachmentList().add(gDto.getPdfUrl());
				}
			}
			mailService.sendMailTemplate(mailInfo, "guideNotification.vm");	
		}
		
		return result;
	}

	
	public OrderCancel cancelOrder(OrderComplete orderComplete){
		
		client = ClientBuilder.newClient();

		String restUrl = this.vitexRestUrl + "/api/oms/pvt/orders/" + orderComplete.getOrderId() + "/cancel";
		target = client.target(restUrl);

		MultivaluedMap<String, Object> myHeaders = new MultivaluedHashMap<String, Object>();
		myHeaders.add(vitexRestAppkeyName, vitexRestAppkey);
		myHeaders.add(vitexRestTokenName, vitexRestToken);
		String json = target.request(MediaType.TEXT_PLAIN).headers(myHeaders).post(Entity.json(orderComplete.getOrderId()), String.class);


		OrderCancel response = new Gson().fromJson(json, OrderCancel.class);
		
		Order order = orderService.findByVitexId(orderComplete.getOrderId());
		order.setMotiveCancelText(orderComplete.getMotiveCancelText());
		
		Catalog motiveCancel = catalogService.findById(orderComplete.getMotiveCancelId());
		order.setMotiveCancel(motiveCancel);
		order.setStatus("canceled");
		order.setCancelDate(new Date());
		
		orderService.saveOrder(order);
		
		return response;
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

		String restUrl = this.vitexRestUrl + "/api/oms/pvt/orders/" + orderId + "/changestatus/"+action;
		target = client.target(restUrl);

		MultivaluedMap<String, Object> myHeaders = new MultivaluedHashMap<String, Object>();
		myHeaders.add(vitexRestAppkeyName, vitexRestAppkey);
		myHeaders.add(vitexRestTokenName, vitexRestToken);
		String json = target.request(MediaType.TEXT_PLAIN).headers(myHeaders).post(Entity.json(orderId), String.class);

		OrderComplete response = new Gson().fromJson(json, OrderComplete.class);

		return response;
	}
	
	
	private List<MailInfo> prepareMailOrder(OrderComplete orderComplete,List<SupplierDeliveryInfo> supplierDeliveryInfoList){
		
		List<MailInfo> mailInfoList= new ArrayList<MailInfo>();
		
		for(SupplierDeliveryInfo sdi:supplierDeliveryInfoList){
		
			if(sdi.getSelected()){
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
			
			MailParticipant mpCc = new MailParticipant();
			mpCc.setEmail(mailCc);
			mpCc.setName(mailCcName);
			receiverTotal.add(mpCc);
			if( sdi.getDelivery()!=null && sdi.getDelivery().getNemonic().equals(DeliveryEnum.TRAMACO.getNemonic())){
				String[] contactsCourierNames = tramacoContactsNames.split("%");
				String[] contactsCourierEmails = tramacoContacts.split("%");
			
				for(int j=0;j<contactsCourierNames.length;j++){
					MailParticipant mpCourier = new MailParticipant();
					mpCourier.setEmail(contactsCourierEmails[j]);
					mpCourier.setName(contactsCourierNames[j]);
					receiverTotal.add(mpCourier);
				}
			}
			
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
			
			
			
			
			List<ItemComplete> icSupplierList = sdi.getItems();
			if(icSupplierList!=null && !icSupplierList.isEmpty()){
				for(ItemComplete ic:icSupplierList){
					ItemInfo iInfo = new ItemInfo();
					iInfo.setSupplierName(sdi.getSupplier().getName());
					iInfo.setName(ic.getName());
					iInfo.setPrice(ic.getPrice());
					iInfo.setUrl(ic.getImageUrl());
					if(ic.getRefId()!=null){
						iInfo.setRefCode((String)ic.getRefId());
					}
					iInfo.setQuantity(ic.getQuantity());
					mailInfo.getItemInfoList().add(iInfo);
				}
			}
			
		    String subject = "Notificación de pedido " + " - Orden: "+orderComplete.getOrderId() + " - Proveedor: "+supplier.getName();
			receiverTotal.addAll(recSupplierList);	
			mailInfo.setReceivers(receiverTotal);
			String strMailTextGuide = mailTextGuide;
			strMailTextGuide = strMailTextGuide.replace(mailTextGuideToken, determineDeliveryName(sdi.getDelivery()));
			mailInfo.setGeneralText(strMailTextGuide);
			mailInfo.setRefId(supplier.getId());
			mailInfo.setRefVtexId(orderComplete.getOrderId());
			mailInfo.setSubject(subject);
			
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
		}//fin del for
		
		
		
		return mailInfoList;
	}
	
	public MultivaluedMap<String, Object> buildHeaders(){
	
		MultivaluedMap<String, Object> myHeaders = new MultivaluedHashMap<String, Object>();
		myHeaders.add(vitexRestAppkeyName, vitexRestAppkey);
		myHeaders.add(vitexRestTokenName, vitexRestToken);
		return myHeaders;
	}
	
	public InvoiceResponse prepareVitexInvoice(OrderComplete orderComplete){
		InvoiceResponse response = new InvoiceResponse();
		Order order = orderService.findByVitexId(orderComplete.getOrderId());
		if(order.getInvoice()!=null){
			Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
			FacturaRespuestaSRI facturaRespuestaSRI = gson.fromJson(order.getInvoice(),FacturaRespuestaSRI.class);
		    String trackNumber =  "";
			List<Guide> guides = guideService.findByOrder(order);
			if(guides!=null && !guides.isEmpty()){
			   String vitexDispatcherId = guides.get(0).getVitexDispatcherId();
			   String[] codes = vitexDispatcherId.split("%");
			   if(codes.length>0){
				   trackNumber = codes[1];
			   }
			}
			
			InvoiceSchemaBean isb = new InvoiceSchemaBean();
			isb.setOrderComplete(orderComplete);
			InvoiceSchema is = new InvoiceSchema();
			is.setType("OUTPUT");
			is.setTrackingNumber(trackNumber);
			
			FacturaConsulta fc = datilService.findInvoice(facturaRespuestaSRI.getId());
			if(fc!=null){
		       is.setInvoiceNumber(fc.getAutorizacion().getNumero());
		       is.setIssuanceDate(fc.getFechaEmision());
		       is.setCourier("");
		       is.setInvoiceValue(facturaRespuestaSRI.getTotales().getImporteTotal());
		       List<ItemInvoice> itemInvoiceList = new ArrayList<ItemInvoice>();
		       for(ItemComplete ic:orderComplete.getItems()){
		    	   ItemInvoice ii = new ItemInvoice();
		    	   ii.setId(ic.getId());
		    	   ii.setPrice(ic.getPrice());
		    	   ii.setQuantity(ic.getQuantity());
		    	   itemInvoiceList.add(ii);
		       }
		       is.setItems(itemInvoiceList);
			}
			isb.setInvoiceSchema(is);
		  response = prepareInvoiceVitexOrder(isb);
		}
		
		return response;
	}
	
	
	
	private InvoiceResponse prepareInvoiceVitexOrder(InvoiceSchemaBean invoiceSchemaBean){
		InvoiceResponse response = new InvoiceResponse();
		String restUrl = this.vitexRestUrl + "/api/oms/pvt/orders/" + invoiceSchemaBean.getOrderComplete().getOrderId() + "/invoice";
		
		System.out.println("URL" + restUrl);
		
		client = ClientBuilder.newClient();
		target = client.target(restUrl);
		
		Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
		
		String json = gson.toJson(invoiceSchemaBean.getInvoiceSchema());
		
		System.out.println("VTEXT INVOICE:"+json);
		
		
		
		String responseJson = target.request(MediaType.APPLICATION_JSON_TYPE).headers(buildHeaders()).post(Entity.json(json), String.class);
		
		System.out.println("==>>"+responseJson);
		
		response = gson.fromJson(responseJson, InvoiceResponse.class);
		
		return response;
	}
	
	@SuppressWarnings("unused")
	public OrderComplete changeStatus(String orderId,String status) {
		OrderComplete oc = this.getOrderComplete(orderId);
		OrderChangeStatus query = objectFactory.createOrderChangeStatus();
		query.setIdOrder(new Integer(oc.getSequence()));
		query.setStatusOrder(objectFactory.createString(status));
		

		OrderChangeStatusResponse response = (OrderChangeStatusResponse) webServiceTemplate.marshalSendAndReceive(query,
				new SoapActionCallback("http://tempuri.org/IService/OrderChangeStatus"));
		return this.getOrderComplete(orderId);
	}
	
	
	@Transactional
	public synchronized  String loadOrderItem(){
		String response = "OK";
		try{
		OrderSchema os = getOrdersRest(null);
		
		if(os!=null){
			for(OrderBean ob:os.getList()){
				OrderComplete oc = getOrderComplete(ob.getOrderId());
				System.out.println("Orde completa "+oc.getOrderId());
			}
			
		}
		}catch(Exception e){
			response="ERROR";
			System.out.println("Error en "+e.getMessage());
			e.printStackTrace();
		}
		return response;
	}
	
	private void generateOrderItem(OrderComplete oc) throws ParseException{
		
        Order order = orderService.findByVitexId(oc.getOrderId());
        
        if(order.getHasItems().equals("0")){
		
		String formaPago = "N/A";
		if(oc.getPaymentData().getTransactions()!=null && !oc.getPaymentData().getTransactions().isEmpty()){
			for(Transaction tr:oc.getPaymentData().getTransactions()){
				if(tr.getPayments()!=null && !tr.getPayments().isEmpty()){
					for(Payment py:tr.getPayments()){
						formaPago = py.getPaymentSystemName();
						if(py.getPaymentSystemName().equals(PaymentEnum.PAGO_CONTRA_ENTREGA.getPaymentSystemName())){
							formaPago = formaPago + ": " + PagoEnum.EFECTIVO.getDescripcionSRI();
						}else if(py.getPaymentSystemName().equals(PaymentEnum.SAFETYPAY.getPaymentSystemName())){
							formaPago = formaPago + ": " + PagoEnum.TRANSFER_OTRO_BANCO.getDescripcionSRI();
						}else if(py.getPaymentSystemName().equals(PaymentEnum.TRANSFERENCIA_BANCARIA_OTRAS_ENTIDADES.getPaymentSystemName())){
							formaPago = formaPago + ": " + PagoEnum.TRANSFER_OTRO_BANCO.getDescripcionSRI();
						}
						else if(py.getPaymentSystemName().equals(PaymentEnum.PAYCLUB.getPaymentSystemName())){
							formaPago = formaPago + ": " +PagoEnum.TARJETA_CREDITO_NACIONAL.getDescripcionSRI();
						}else if(py.getPaymentSystemName().equals(PaymentEnum.TARJETA_ALIA.getPaymentSystemName())){
							formaPago = formaPago + ": " +PagoEnum.TARJETA_CREDITO_NACIONAL.getDescripcionSRI();
						}else if(py.getPaymentSystemName().equals(PaymentEnum.TARJETA_CREDITO.getPaymentSystemName())){
							formaPago = formaPago + ": " +PagoEnum.TARJETA_CREDITO_NACIONAL.getDescripcionSRI();
						}
						else if(py.getPaymentSystemName().equals(PaymentEnum.PAYPAL.getPaymentSystemName())){
							formaPago = formaPago + ": " +PagoEnum.TARJETA_CREDITO_INTERNACIONAL.getDescripcionSRI();
						}
						
					}//fin for
					
				}//
			}
		}
		
		for(SupplierDeliveryInfo sdi:oc.getSupplierDeliveryInfoList()){
			for(ItemComplete ic:sdi.getItems()){
				OrderItem oi = new OrderItem();
				oi.setOrder(order);
				oi.setCustomerName(oc.getCustomerName());
				oi.setCustomerDocument(oc.getClientProfileData().getDocument());
				oi.setCustomerPhone(oc.getClientProfileData().getPhone());
				oi.setCustomerState(oc.getShippingData().getAddress().getState());
				oi.setCustomerCanton(oc.getShippingData().getAddress().getCity());
				String address = oc.getShippingData().getAddress().getStreet() + " " + oc.getShippingData().getAddress().getNumber() + " " + oc.getShippingData().getAddress().getComplement(); 
				Double deliveryPayment = 0D;
				Boolean hasAdjunto = false;
				if(oc.getPaymentData().getTransactions()!=null && !oc.getPaymentData().getTransactions().isEmpty()){
					for(Transaction tr:oc.getPaymentData().getTransactions()){
						if(tr.getPayments()!=null && !tr.getPayments().isEmpty()){
							for(Payment py:tr.getPayments()){
								if(py.getPaymentSystemName().trim().toLowerCase().equals(PaymentEnum.PAGO_CONTRA_ENTREGA.getPaymentSystemName().toLowerCase())){
									hasAdjunto = true; 
									deliveryPayment = deliveryPayment+py.getValue();
								}
							}//fin for
							
						}//
					}
				}
				
				Double itemValue = 0D;
				
				itemValue = itemValue+ic.getPrice()*ic.getQuantity();
				itemValue = (double) Math.round(itemValue * 100) / 100;
				
				
				Double discount=0D;
				Boolean hasTax = Boolean.FALSE;
				if(ic.getPriceTags()!=null && !ic.getPriceTags().isEmpty()){
					for(PriceTag pt:ic.getPriceTags()){
						if(pt.getName().contains("discount@price")){
							Double val= pt.getValue();
							if(val.intValue()<0){
								val = val* (-1);
							}
						    val = (double) Math.round(val * 100) / 100;
						    discount=val;
							//break;
						}
						if(pt.getName().contains("tax@price")){
							hasTax=Boolean.TRUE;
						}
						if(pt.getName().contains("discount@price")){
							Double val= pt.getValue();
							if(val<0){
								val = val* (-1);
							}
						    val = (double) Math.round(val * 100) / 100;
						    discount = val;
						}
					}
				}else{
					discount=0D;
				}
				
				if(ic.getShippingPrice()!=null){
					System.out.println("shippingPrice "+ ic.getShippingPrice());
				}else{
					System.out.println("Sin costo de cobro de envio");
					//carga.setValorCobro(0D);
				}
				Double iva = 0D;
				itemValue = itemValue - discount;
				if(ic.getTax().intValue()>0){
					iva=ic.getTax();
				}else{
					if(hasTax){
						iva=BaseUtil.calculateIVA(itemValue,new Integer(datilIvaValue),datilIvaPercentValue);
					}
				}
				itemValue = itemValue + iva;
				
				
				oi.setCustomerAddress(address);
				oi.setSupplierName(sdi.getSupplier().getName());
				oi.setSupplier(sdi.getSupplier());
				oi.setVitexId(oc.getOrderId());
				oi.setUnitPrice(ic.getPrice());
				oi.setDiscount(discount);
				oi.setPrice(ic.getPrice()*ic.getQuantity());
				oi.setCustomerValue(itemValue);
				oi.setQuantity(new Long(ic.getQuantity()));
				oi.setProductDescription(ic.getName());
				String[] productKey = SupplierUtil.returnSupplierCode((String)ic.getRefId());
				oi.setProductKey(productKey[2]);
				oi.setOrderSequence(oc.getSequence());
				oi.setOrderDate(UtilDate.fromIsoToDate(oc.getCreationDate()));
				oi.setWayToPay(formaPago);
				oi.setOrderStatus(oc.getStatus());
				oi.setStatusDescription(oc.getStatusDescription());
				oi.setCustomerName(oc.getCustomerName());
				oi.setSkuId(ic.getSellerSku());
				if(hasAdjunto){
					oi.setValueReceivables(itemValue);
				}else{
					oi.setValueReceivables(0D);
				}
				
				if(ic.getAdditionalInfo()!=null){
					oi.setBrandName(ic.getAdditionalInfo().getBrandName());
					CategoryVtex cvt = categoryVitexService.getCategoryFromPath(ic.getAdditionalInfo().getCategoriesIds());
					if(cvt!=null){
						oi.setCategoryName(cvt.getName());
					}
				}
				oi.setIsWarehouse(sdi.getSupplier().getIsWarehouse());
				orderService.saveOrderItem(oi);
			}
		}
          order.setHasItems("1");
        }
		orderService.saveOrder(order);
	}
   

	private String determineDeliveryName(Catalog delivery){
		String result = "";
		if(delivery!=null){
			for(DeliveryEnum de:DeliveryEnum.values()){
				if(de.getNemonic().equals(delivery.getNemonic())){
					result=delivery.getName();
					break;
				}
			}
		}
		return result;
	}
  
}
