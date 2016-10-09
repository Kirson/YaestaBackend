
package com.yaesta.integration.vitex.json.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yaesta.app.persistence.entity.Catalog;
import com.yaesta.app.persistence.entity.Guide;
import com.yaesta.integration.vitex.bean.SupplierDeliveryInfo;

@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "orderId",
    "sequence",
    "marketplaceOrderId",
    "marketplaceServicesEndpoint",
    "sellerOrderId",
    "origin",
    "affiliateId",
    "salesChannel",
    "merchantName",
    "status",
    "statusDescription",
    "value",
    "creationDate",
    "lastChange",
    "orderGroup",
    "totals",
    "items",
    "marketplaceItems",
    "clientProfileData",
    "giftRegistryData",
    "marketingData",
    "ratesAndBenefitsData",
    "shippingData",
    "paymentData",
    "packageAttachment",
    "sellers",
    "callCenterOperatorData",
    "followUpEmail",
    "lastMessage",
    "hostname",
    "changesAttachment",
    "openTextField",
    "roundingError",
    "orderFormId",
    "customerName",
    "appStatus",
    "totalPrice",
    "supplierDeliveryInfoList",
    "error",
    "motiveCancelId",
    "motiveCancelText",
    "pending",
    "motivePendingText",
    "pendingSolutionText",
    "guides"
})
public class OrderComplete implements Serializable {

    @JsonProperty("orderId")
    private String orderId;
    @JsonProperty("sequence")
    private String sequence;
    @JsonProperty("marketplaceOrderId")
    private String marketplaceOrderId;
    @JsonProperty("marketplaceServicesEndpoint")
    private String marketplaceServicesEndpoint;
    @JsonProperty("sellerOrderId")
    private String sellerOrderId;
    @JsonProperty("origin")
    private String origin;
    @JsonProperty("affiliateId")
    private String affiliateId;
    @JsonProperty("salesChannel")
    private String salesChannel;
    @JsonProperty("merchantName")
    private Object merchantName;
    @JsonProperty("status")
    private String status;
    @JsonProperty("statusDescription")
    private String statusDescription;
    @JsonProperty("value")
    private BigDecimal value;
    @JsonProperty("creationDate")
    private String creationDate;
    @JsonProperty("lastChange")
    private String lastChange;
    @JsonProperty("orderGroup")
    private String orderGroup;
    @JsonProperty("totals")
    private List<Total> totals = new ArrayList<Total>();
    @JsonProperty("items")
    private List<ItemComplete> items = new ArrayList<ItemComplete>();
    @JsonProperty("marketplaceItems")
    private List<Object> marketplaceItems = new ArrayList<Object>();
    @JsonProperty("clientProfileData")
    private ClientProfileData clientProfileData;
    @JsonProperty("giftRegistryData")
    private Object giftRegistryData;
    @JsonProperty("marketingData")
    private Object marketingData;
    @JsonProperty("ratesAndBenefitsData")
    private RatesAndBenefitsData ratesAndBenefitsData;
    @JsonProperty("shippingData")
    private ShippingData shippingData;
    @JsonProperty("paymentData")
    private PaymentData paymentData;
    @JsonProperty("packageAttachment")
    private PackageAttachment packageAttachment;
    @JsonProperty("sellers")
    private List<Seller> sellers = new ArrayList<Seller>();
    @JsonProperty("callCenterOperatorData")
    private Object callCenterOperatorData;
    @JsonProperty("followUpEmail")
    private String followUpEmail;
    @JsonProperty("lastMessage")
    private String lastMessage;
    @JsonProperty("hostname")
    private String hostname;
    @JsonProperty("changesAttachment")
    private Object changesAttachment;
    @JsonProperty("openTextField")
    private Object openTextField;
    @JsonProperty("roundingError")
    private Integer roundingError;
    @JsonProperty("orderFormId")
    private String orderFormId;
    @JsonProperty("customerName")
    private String customerName;
    @JsonProperty("appStatus")
    private String appStatus;
    @JsonProperty("totalPrice")
    private BigDecimal totalPrice;
    @JsonProperty("supplierDeliveryInfoList")
    private List<SupplierDeliveryInfo> supplierDeliveryInfoList;
    @JsonProperty("error")
    private String error;
    @JsonProperty("motiveCancelId")
    private Long motiveCancelId;
    @JsonProperty("motiveCancelText")
    private String motiveCancelText;
    @JsonProperty("deliverySelected")
    private Catalog deliverySelected;
    @JsonProperty("pending")
    private Boolean pending;
    @JsonProperty("motivePendingText")
    private String motivePendingText;
    @JsonProperty("pendingSolutionText")
    private String pendingSolutionText;
    @JsonProperty("guides")
    private List<Guide> guides;
    
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    
    public OrderComplete(){
    	pending=Boolean.FALSE;
    	guides = new ArrayList<Guide>();
    }
    
    /**
     * 
     * @return
     *     The orderId
     */
    @JsonProperty("orderId")
    public String getOrderId() {
        return orderId;
    }

    /**
     * 
     * @param orderId
     *     The orderId
     */
    @JsonProperty("orderId")
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * 
     * @return
     *     The sequence
     */
    @JsonProperty("sequence")
    public String getSequence() {
        return sequence;
    }

    /**
     * 
     * @param sequence
     *     The sequence
     */
    @JsonProperty("sequence")
    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    /**
     * 
     * @return
     *     The marketplaceOrderId
     */
    @JsonProperty("marketplaceOrderId")
    public String getMarketplaceOrderId() {
        return marketplaceOrderId;
    }

    /**
     * 
     * @param marketplaceOrderId
     *     The marketplaceOrderId
     */
    @JsonProperty("marketplaceOrderId")
    public void setMarketplaceOrderId(String marketplaceOrderId) {
        this.marketplaceOrderId = marketplaceOrderId;
    }

    /**
     * 
     * @return
     *     The marketplaceServicesEndpoint
     */
    @JsonProperty("marketplaceServicesEndpoint")
    public String getMarketplaceServicesEndpoint() {
        return marketplaceServicesEndpoint;
    }

    /**
     * 
     * @param marketplaceServicesEndpoint
     *     The marketplaceServicesEndpoint
     */
    @JsonProperty("marketplaceServicesEndpoint")
    public void setMarketplaceServicesEndpoint(String marketplaceServicesEndpoint) {
        this.marketplaceServicesEndpoint = marketplaceServicesEndpoint;
    }

    /**
     * 
     * @return
     *     The sellerOrderId
     */
    @JsonProperty("sellerOrderId")
    public String getSellerOrderId() {
        return sellerOrderId;
    }

    /**
     * 
     * @param sellerOrderId
     *     The sellerOrderId
     */
    @JsonProperty("sellerOrderId")
    public void setSellerOrderId(String sellerOrderId) {
        this.sellerOrderId = sellerOrderId;
    }

    /**
     * 
     * @return
     *     The origin
     */
    @JsonProperty("origin")
    public String getOrigin() {
        return origin;
    }

    /**
     * 
     * @param origin
     *     The origin
     */
    @JsonProperty("origin")
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * 
     * @return
     *     The affiliateId
     */
    @JsonProperty("affiliateId")
    public String getAffiliateId() {
        return affiliateId;
    }

    /**
     * 
     * @param affiliateId
     *     The affiliateId
     */
    @JsonProperty("affiliateId")
    public void setAffiliateId(String affiliateId) {
        this.affiliateId = affiliateId;
    }

    /**
     * 
     * @return
     *     The salesChannel
     */
    @JsonProperty("salesChannel")
    public String getSalesChannel() {
        return salesChannel;
    }

    /**
     * 
     * @param salesChannel
     *     The salesChannel
     */
    @JsonProperty("salesChannel")
    public void setSalesChannel(String salesChannel) {
        this.salesChannel = salesChannel;
    }

    /**
     * 
     * @return
     *     The merchantName
     */
    @JsonProperty("merchantName")
    public Object getMerchantName() {
        return merchantName;
    }

    /**
     * 
     * @param merchantName
     *     The merchantName
     */
    @JsonProperty("merchantName")
    public void setMerchantName(Object merchantName) {
        this.merchantName = merchantName;
    }

    /**
     * 
     * @return
     *     The status
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The statusDescription
     */
    @JsonProperty("statusDescription")
    public String getStatusDescription() {
        return statusDescription;
    }

    /**
     * 
     * @param statusDescription
     *     The statusDescription
     */
    @JsonProperty("statusDescription")
    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    /**
     * 
     * @return
     *     The value
     */
    @JsonProperty("value")
    public BigDecimal getValue() {
        return value;
    }

    /**
     * 
     * @param value
     *     The value
     */
    @JsonProperty("value")
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    /**
     * 
     * @return
     *     The creationDate
     */
    @JsonProperty("creationDate")
    public String getCreationDate() {
        return creationDate;
    }

    /**
     * 
     * @param creationDate
     *     The creationDate
     */
    @JsonProperty("creationDate")
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * 
     * @return
     *     The lastChange
     */
    @JsonProperty("lastChange")
    public String getLastChange() {
        return lastChange;
    }

    /**
     * 
     * @param lastChange
     *     The lastChange
     */
    @JsonProperty("lastChange")
    public void setLastChange(String lastChange) {
        this.lastChange = lastChange;
    }

    /**
     * 
     * @return
     *     The orderGroup
     */
    @JsonProperty("orderGroup")
    public String getOrderGroup() {
        return orderGroup;
    }

    /**
     * 
     * @param orderGroup
     *     The orderGroup
     */
    @JsonProperty("orderGroup")
    public void setOrderGroup(String orderGroup) {
        this.orderGroup = orderGroup;
    }

    /**
     * 
     * @return
     *     The totals
     */
    @JsonProperty("totals")
    public List<Total> getTotals() {
        return totals;
    }

    /**
     * 
     * @param totals
     *     The totals
     */
    @JsonProperty("totals")
    public void setTotals(List<Total> totals) {
        this.totals = totals;
    }

    /**
     * 
     * @return
     *     The items
     */
    @JsonProperty("items")
    public List<ItemComplete> getItems() {
        return items;
    }

    /**
     * 
     * @param items
     *     The items
     */
    @JsonProperty("items")
    public void setItems(List<ItemComplete> items) {
        this.items = items;
    }

    /**
     * 
     * @return
     *     The marketplaceItems
     */
    @JsonProperty("marketplaceItems")
    public List<Object> getMarketplaceItems() {
        return marketplaceItems;
    }

    /**
     * 
     * @param marketplaceItems
     *     The marketplaceItems
     */
    @JsonProperty("marketplaceItems")
    public void setMarketplaceItems(List<Object> marketplaceItems) {
        this.marketplaceItems = marketplaceItems;
    }

    /**
     * 
     * @return
     *     The clientProfileData
     */
    @JsonProperty("clientProfileData")
    public ClientProfileData getClientProfileData() {
        return clientProfileData;
    }

    /**
     * 
     * @param clientProfileData
     *     The clientProfileData
     */
    @JsonProperty("clientProfileData")
    public void setClientProfileData(ClientProfileData clientProfileData) {
        this.clientProfileData = clientProfileData;
    }

    /**
     * 
     * @return
     *     The giftRegistryData
     */
    @JsonProperty("giftRegistryData")
    public Object getGiftRegistryData() {
        return giftRegistryData;
    }

    /**
     * 
     * @param giftRegistryData
     *     The giftRegistryData
     */
    @JsonProperty("giftRegistryData")
    public void setGiftRegistryData(Object giftRegistryData) {
        this.giftRegistryData = giftRegistryData;
    }

    /**
     * 
     * @return
     *     The marketingData
     */
    @JsonProperty("marketingData")
    public Object getMarketingData() {
        return marketingData;
    }

    /**
     * 
     * @param marketingData
     *     The marketingData
     */
    @JsonProperty("marketingData")
    public void setMarketingData(Object marketingData) {
        this.marketingData = marketingData;
    }

    /**
     * 
     * @return
     *     The ratesAndBenefitsData
     */
    @JsonProperty("ratesAndBenefitsData")
    public RatesAndBenefitsData getRatesAndBenefitsData() {
        return ratesAndBenefitsData;
    }

    /**
     * 
     * @param ratesAndBenefitsData
     *     The ratesAndBenefitsData
     */
    @JsonProperty("ratesAndBenefitsData")
    public void setRatesAndBenefitsData(RatesAndBenefitsData ratesAndBenefitsData) {
        this.ratesAndBenefitsData = ratesAndBenefitsData;
    }

    /**
     * 
     * @return
     *     The shippingData
     */
    @JsonProperty("shippingData")
    public ShippingData getShippingData() {
        return shippingData;
    }

    /**
     * 
     * @param shippingData
     *     The shippingData
     */
    @JsonProperty("shippingData")
    public void setShippingData(ShippingData shippingData) {
        this.shippingData = shippingData;
    }

    /**
     * 
     * @return
     *     The paymentData
     */
    @JsonProperty("paymentData")
    public PaymentData getPaymentData() {
        return paymentData;
    }

    /**
     * 
     * @param paymentData
     *     The paymentData
     */
    @JsonProperty("paymentData")
    public void setPaymentData(PaymentData paymentData) {
        this.paymentData = paymentData;
    }

    /**
     * 
     * @return
     *     The packageAttachment
     */
    @JsonProperty("packageAttachment")
    public PackageAttachment getPackageAttachment() {
        return packageAttachment;
    }

    /**
     * 
     * @param packageAttachment
     *     The packageAttachment
     */
    @JsonProperty("packageAttachment")
    public void setPackageAttachment(PackageAttachment packageAttachment) {
        this.packageAttachment = packageAttachment;
    }

    /**
     * 
     * @return
     *     The sellers
     */
    @JsonProperty("sellers")
    public List<Seller> getSellers() {
        return sellers;
    }

    /**
     * 
     * @param sellers
     *     The sellers
     */
    @JsonProperty("sellers")
    public void setSellers(List<Seller> sellers) {
        this.sellers = sellers;
    }

    /**
     * 
     * @return
     *     The callCenterOperatorData
     */
    @JsonProperty("callCenterOperatorData")
    public Object getCallCenterOperatorData() {
        return callCenterOperatorData;
    }

    /**
     * 
     * @param callCenterOperatorData
     *     The callCenterOperatorData
     */
    @JsonProperty("callCenterOperatorData")
    public void setCallCenterOperatorData(Object callCenterOperatorData) {
        this.callCenterOperatorData = callCenterOperatorData;
    }

    /**
     * 
     * @return
     *     The followUpEmail
     */
    @JsonProperty("followUpEmail")
    public String getFollowUpEmail() {
        return followUpEmail;
    }

    /**
     * 
     * @param followUpEmail
     *     The followUpEmail
     */
    @JsonProperty("followUpEmail")
    public void setFollowUpEmail(String followUpEmail) {
        this.followUpEmail = followUpEmail;
    }

    /**
     * 
     * @return
     *     The lastMessage
     */
    @JsonProperty("lastMessage")
    public String getLastMessage() {
        return lastMessage;
    }

    /**
     * 
     * @param lastMessage
     *     The lastMessage
     */
    @JsonProperty("lastMessage")
    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    /**
     * 
     * @return
     *     The hostname
     */
    @JsonProperty("hostname")
    public String getHostname() {
        return hostname;
    }

    /**
     * 
     * @param hostname
     *     The hostname
     */
    @JsonProperty("hostname")
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    /**
     * 
     * @return
     *     The changesAttachment
     */
    @JsonProperty("changesAttachment")
    public Object getChangesAttachment() {
        return changesAttachment;
    }

    /**
     * 
     * @param changesAttachment
     *     The changesAttachment
     */
    @JsonProperty("changesAttachment")
    public void setChangesAttachment(Object changesAttachment) {
        this.changesAttachment = changesAttachment;
    }

    /**
     * 
     * @return
     *     The openTextField
     */
    @JsonProperty("openTextField")
    public Object getOpenTextField() {
        return openTextField;
    }

    /**
     * 
     * @param openTextField
     *     The openTextField
     */
    @JsonProperty("openTextField")
    public void setOpenTextField(Object openTextField) {
        this.openTextField = openTextField;
    }

    /**
     * 
     * @return
     *     The roundingError
     */
    @JsonProperty("roundingError")
    public Integer getRoundingError() {
        return roundingError;
    }

    /**
     * 
     * @param roundingError
     *     The roundingError
     */
    @JsonProperty("roundingError")
    public void setRoundingError(Integer roundingError) {
        this.roundingError = roundingError;
    }

    /**
     * 
     * @return
     *     The orderFormId
     */
    @JsonProperty("orderFormId")
    public String getOrderFormId() {
        return orderFormId;
    }

    /**
     * 
     * @param orderFormId
     *     The orderFormId
     */
    @JsonProperty("orderFormId")
    public void setOrderFormId(String orderFormId) {
        this.orderFormId = orderFormId;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @JsonProperty("totalPrice")
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	@JsonProperty("totalPrice")
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	@JsonProperty("supplierDeliveryInfoList")
	public List<SupplierDeliveryInfo> getSupplierDeliveryInfoList() {
		return supplierDeliveryInfoList;
	}

	@JsonProperty("supplierDeliveryInfoList")
	public void setSupplierDeliveryInfoList(List<SupplierDeliveryInfo> supplierDeliveryInfoList) {
		this.supplierDeliveryInfoList = supplierDeliveryInfoList;
	}

	@JsonProperty("customerName")
	public String getCustomerName() {
		customerName = this.getClientProfileData().getFirstName() + " " + this.getClientProfileData().getLastName();
		return customerName;
	}

	@JsonProperty("customerName")
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@JsonProperty("appStatus")
	public String getAppStatus() {
		return appStatus;
	}

	@JsonProperty("appStatus")
	public void setAppStatus(String appStatus) {
		this.appStatus = appStatus;
	}

	@JsonProperty("error")
	public String getError() {
		return error;
	}

	@JsonProperty("error")
	public void setError(String error) {
		this.error = error;
	}

	@JsonProperty("motiveCancelId")
	public Long getMotiveCancelId() {
		return motiveCancelId;
	}

	@JsonProperty("motiveCancelId")
	public void setMotiveCancelId(Long motiveCancelId) {
		this.motiveCancelId = motiveCancelId;
	}

	@JsonProperty("motiveCancelText")
	public String getMotiveCancelText() {
		return motiveCancelText;
	}

	@JsonProperty("motiveCancelText")
	public void setMotiveCancelText(String motiveCancelText) {
		this.motiveCancelText = motiveCancelText;
	}

	@JsonProperty("deliverySelected")
	public Catalog getDeliverySelected() {
		return deliverySelected;
	}

	@JsonProperty("deliverySelected")
	public void setDeliverySelected(Catalog deliverySelected) {
		this.deliverySelected = deliverySelected;
	}

	@JsonProperty("pending")
	public Boolean getPending() {
		return pending;
	}

	@JsonProperty("pending")
	public void setPending(Boolean pending) {
		this.pending = pending;
	}

	@JsonProperty("motivePendingText")
	public String getMotivePendingText() {
		return motivePendingText;
	}

	@JsonProperty("motivePendingText")
	public void setMotivePendingText(String motivePendingText) {
		this.motivePendingText = motivePendingText;
	}

	@JsonProperty("pendingSolutionText")
	public String getPendingSolutionText() {
		return pendingSolutionText;
	}

	@JsonProperty("pendingSolutionText")
	public void setPendingSolutionText(String pendingSolutionText) {
		this.pendingSolutionText = pendingSolutionText;
	}

	@JsonProperty("guides")
	public List<Guide> getGuides() {
		return guides;
	}

	@JsonProperty("guides")
	public void setGuides(List<Guide> guides) {
		this.guides = guides;
	}
    
    

}
