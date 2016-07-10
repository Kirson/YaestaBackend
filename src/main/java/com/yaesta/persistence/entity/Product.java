package com.yaesta.persistence.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "product",schema="yaesta")
public class Product implements Serializable{

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -7916918770092663560L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq_gen")
	@SequenceGenerator(name = "product_seq_gen", sequenceName = "product_id_seq")
	private Long id;
	
	@JoinColumn(name = "supplier_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Supplier supplier;
	
	@JoinColumn(name = "main_product", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Product mainProduct;
	
	@JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Category category;
	
	@JoinColumn(name = "brand_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Brand brand;
	
	@JoinColumn(name = "store_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Store store;
	
	@Column(name = "sku")
	private String sku;
	
	@Column(name = "ean13")
	private String ean13;
	
	@Column(name = "upc")
	private String upc;
	
	
	
	@Column(name="quantity")
	private Long quantity;
	
	@Column(name="own_price")
	private BigDecimal ownPrice;
	
	@Column(name="store_price")
	private BigDecimal storePrice;
	
	@Column(name = "maker")
	private String maker;
	
	@Column(name = "model")
	private String model;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "short_description")
	private String shortDescription;
	
	@Column(name = "picture")
	private String picture;
	
	@Column(name="width")
	private BigDecimal width;
	
	@Column(name="height")
	private BigDecimal height;
	
	@Column(name="depth")
	private BigDecimal depth;
	
	@Column(name="weight")
	private BigDecimal weight;
	
	@Column(name = "vitex_id")
	private String vitexId;
	
	@Column(name="date_add")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateAdd;
	
	@Column(name="date_upd")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpd;
	
	@org.hibernate.annotations.Type(type="com.yaesta.persistence.util.SQLXMLType")
	@Column(name="product_info")
	private String productInfo;
	
	@Column(name="is_sku")
	private Boolean isSku;
	
	@Transient
	private List<Product> skuList;
	
	public Product(){
		skuList = new ArrayList<Product>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Product getMainProduct() {
		return mainProduct;
	}

	public void setMainProduct(Product mainProduct) {
		this.mainProduct = mainProduct;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getEan13() {
		return ean13;
	}

	public void setEan13(String ean13) {
		this.ean13 = ean13;
	}

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	
	

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public void setVitexId(String vitexId) {
		this.vitexId = vitexId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getOwnPrice() {
		return ownPrice;
	}

	public void setOwnPrice(BigDecimal ownPrice) {
		this.ownPrice = ownPrice;
	}

	public BigDecimal getStorePrice() {
		return storePrice;
	}

	public void setStorePrice(BigDecimal storePrice) {
		this.storePrice = storePrice;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public BigDecimal getWidth() {
		return width;
	}

	public void setWidth(BigDecimal width) {
		this.width = width;
	}

	public BigDecimal getHeight() {
		return height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	public BigDecimal getDepth() {
		return depth;
	}

	public void setDepth(BigDecimal depth) {
		this.depth = depth;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public String getVitexId() {
		return vitexId;
	}

	

	public Date getDateAdd() {
		return dateAdd;
	}

	public void setDateAdd(Date dateAdd) {
		this.dateAdd = dateAdd;
	}

	public Date getDateUpd() {
		return dateUpd;
	}

	public void setDateUpd(Date dateUpd) {
		this.dateUpd = dateUpd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public String getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}
	
	

	public Boolean getIsSku() {
		return isSku;
	}

	public void setIsSku(Boolean isSku) {
		this.isSku = isSku;
	}

	public List<Product> getSkuList() {
		return skuList;
	}

	public void setSkuList(List<Product> skuList) {
		this.skuList = skuList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}
