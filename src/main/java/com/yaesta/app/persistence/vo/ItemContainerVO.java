package com.yaesta.app.persistence.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.yaesta.app.mail.ItemInfo;
import com.yaesta.app.mail.ItemInfoGuide;
import com.yaesta.app.mail.ItemInfoSupplier;

public class ItemContainerVO implements Serializable {

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -1409722763210446578L;
	private List<ItemInfo> itemInfoList;
	private List<ItemInfoGuide> itemInfoGuideList;
	private List<ItemInfoSupplier> itemInfoSupplierList;
	
	public ItemContainerVO(){
		itemInfoList = new ArrayList<ItemInfo>();
		itemInfoGuideList = new ArrayList<ItemInfoGuide>();
		itemInfoSupplierList = new ArrayList<ItemInfoSupplier>();
	}

	public List<ItemInfo> getItemInfoList() {
		return itemInfoList;
	}

	public void setItemInfoList(List<ItemInfo> itemInfoList) {
		this.itemInfoList = itemInfoList;
	}

	public List<ItemInfoGuide> getItemInfoGuideList() {
		return itemInfoGuideList;
	}

	public void setItemInfoGuideList(List<ItemInfoGuide> itemInfoGuideList) {
		this.itemInfoGuideList = itemInfoGuideList;
	}

	public List<ItemInfoSupplier> getItemInfoSupplierList() {
		return itemInfoSupplierList;
	}

	public void setItemInfoSupplierList(List<ItemInfoSupplier> itemInfoSupplierList) {
		this.itemInfoSupplierList = itemInfoSupplierList;
	}
	
	
	
}
