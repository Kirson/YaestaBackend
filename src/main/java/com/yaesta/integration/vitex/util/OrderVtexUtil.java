package com.yaesta.integration.vitex.util;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.yaesta.integration.vitex.json.bean.Item;
import com.yaesta.integration.vitex.json.bean.ItemComplete;
import com.yaesta.integration.vitex.json.bean.OrderBean;
import com.yaesta.integration.vitex.json.bean.OrderComplete;
import com.yaesta.integration.vitex.json.bean.PriceTag;
import com.yaesta.integration.vitex.json.bean.Total;

public class OrderVtexUtil implements Serializable {

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -2030094517102167967L;
	private static BigDecimal oneHundred = new BigDecimal(100);
	private static Double oneHundredD = new Double(100);
	
	public static OrderComplete setRealValuesToOrderComplete(OrderComplete ori){
		OrderComplete response = new OrderComplete();
		response = ori;
		if(ori.getValue()!=null){
			response.setValue(ori.getValue().divide(oneHundred));
		}
		if(ori.getTotalPrice()!=null){
			response.setTotalPrice(ori.getTotalPrice().divide(oneHundred));
		}
		if(ori.getTotals()!=null && !ori.getTotals().isEmpty()){
			List<Total> totals = new ArrayList<Total>();
			for(Total t:ori.getTotals()){
				Total tt = t;
				tt.setValue(t.getValue()/oneHundredD);
				totals.add(tt);
			}
			response.setTotals(totals);
		}
		if(ori.getItems()!=null && !ori.getItems().isEmpty()){
			List<ItemComplete> items = new ArrayList<ItemComplete>();
			for(ItemComplete ic:ori.getItems()){
			   ItemComplete itC = ic;
			   itC.setPrice(ic.getPrice()/oneHundredD);
			   itC.setListPrice(ic.getListPrice()/oneHundredD);
			   if(ic.getCommission()!=null){
				   itC.setCommission(ic.getCommission()/oneHundredD);
			   }
			   if(ic.getTax()!=null) {
				   	itC.setTax(ic.getTax()/oneHundredD);
			   }
			   if(ic.getSellingPrice()!=null){
				   itC.setSellingPrice(ic.getSellingPrice()/oneHundredD);
			   }
			   /*
			   if(ic.getSellingPrice()!=null){
				   itC.setSellingPrice(ic.getSellingPrice()/oneHundredD);
			   }*/
			   if(ic.getManualPrice()!=null){
				   itC.setManualPrice(ic.getManualPrice()/oneHundredD);
			   }
			   if(ic.getShippingPrice()!=null){
				   itC.setShippingPrice(ic.getShippingPrice()/oneHundredD);
			   }
			   
			   if(ic.getPriceTags()!=null && !ic.getPriceTags().isEmpty()){
				   List<PriceTag> priceTags = new ArrayList<PriceTag>();
				   for(PriceTag pt:ic.getPriceTags()){
					   PriceTag ptg = pt;
					   if(!pt.getIsPercentual()){
						   ptg.setValue(pt.getValue()/oneHundredD);
					   }
					   priceTags.add(ptg);
				   }
				   itC.setPriceTags(priceTags);
			   }
			   
			   items.add(itC);
			}
			response.setItems(items);
		}
		return response;
	}
	
	public static OrderBean setRealValuesToOrderBean(OrderBean ori){
		OrderBean response = ori;
		response.setTotalValue(ori.getTotalValue().divide(oneHundred));
		
		if(ori.getItems()!=null && !ori.getItems().isEmpty()){
			List<Item> items = new ArrayList<Item>();
			for(Item it:ori.getItems()){
				Item itm = it;
				
				items.add(itm);
			}
			response.setItems(items);
		}
		
		return response;
	}
}
