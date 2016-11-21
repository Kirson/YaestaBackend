package com.yaesta.integration.vitex.util;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.yaesta.integration.datil.json.enums.PagoEnum;
import com.yaesta.integration.vitex.bean.PaymentBean;
import com.yaesta.integration.vitex.json.bean.Item;
import com.yaesta.integration.vitex.json.bean.ItemComplete;
import com.yaesta.integration.vitex.json.bean.LogisticsInfo;
import com.yaesta.integration.vitex.json.bean.OrderBean;
import com.yaesta.integration.vitex.json.bean.OrderComplete;
import com.yaesta.integration.vitex.json.bean.Payment;
import com.yaesta.integration.vitex.json.bean.PriceTag;
import com.yaesta.integration.vitex.json.bean.Total;
import com.yaesta.integration.vitex.json.bean.Transaction;
import com.yaesta.integration.vitex.json.bean.enums.PaymentEnum;

public class OrderVtexUtil implements Serializable {

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -2030094517102167967L;
	private static BigDecimal oneHundred = new BigDecimal(100);
	private static Double oneHundredD = new Double(100);

	public static OrderComplete setRealValuesToOrderComplete(OrderComplete ori) {
		OrderComplete response = new OrderComplete();
		response = ori;
		if (ori.getValue() != null) {
			response.setValue(ori.getValue().divide(oneHundred));
		}
		if (ori.getTotalPrice() != null) {
			response.setTotalPrice(ori.getTotalPrice().divide(oneHundred));
		}
		if (ori.getTotals() != null && !ori.getTotals().isEmpty()) {
			List<Total> totals = new ArrayList<Total>();
			for (Total t : ori.getTotals()) {
				Total tt = t;
				tt.setValue(t.getValue() / oneHundredD);
				totals.add(tt);
			}
			response.setTotals(totals);
		}
		if (ori.getItems() != null && !ori.getItems().isEmpty()) {
			List<ItemComplete> items = new ArrayList<ItemComplete>();
			for (ItemComplete ic : ori.getItems()) {
				ItemComplete itC = ic;
				itC.setPrice(ic.getPrice() / oneHundredD);
				itC.setListPrice(ic.getListPrice() / oneHundredD);
				if (ic.getCommission() != null) {
					itC.setCommission(ic.getCommission() / oneHundredD);
				}
				if (ic.getTax() != null) {
					itC.setTax(ic.getTax() / oneHundredD);
				}
				if (ic.getSellingPrice() != null) {
					itC.setSellingPrice(ic.getSellingPrice() / oneHundredD);
				}

				if (ic.getManualPrice() != null) {
					itC.setManualPrice(ic.getManualPrice() / oneHundredD);
				}
				if (ic.getShippingPrice() != null) {
					itC.setShippingPrice(ic.getShippingPrice() / oneHundredD);
				}

				if (ic.getPriceTags() != null && !ic.getPriceTags().isEmpty()) {
					List<PriceTag> priceTags = new ArrayList<PriceTag>();
					for (PriceTag pt : ic.getPriceTags()) {
						PriceTag ptg = pt;
						if (!pt.getIsPercentual()) {
							ptg.setValue(pt.getValue() / oneHundredD);
						}
						priceTags.add(ptg);
					}
					itC.setPriceTags(priceTags);
				}

				items.add(itC);
			}
			response.setItems(items);
		}

		if (ori.getPaymentData().getTransactions() != null && !ori.getPaymentData().getTransactions().isEmpty()) {
			List<Transaction> transList = new ArrayList<Transaction>();
			for (Transaction tr : ori.getPaymentData().getTransactions()) {
				Transaction tran = tr;
				List<Payment> payList = new ArrayList<Payment>();
				for (Payment pa : tran.getPayments()) {
					Payment py = pa;
					py.setValue(pa.getValue() / oneHundredD);
					py.setReferenceValue(pa.getReferenceValue() / oneHundredD);
					payList.add(py);
				}
				tran.setPayments(payList);
				transList.add(tran);
			} // fin for
			response.getPaymentData().setTransactions(transList);
		}

		if (ori.getShippingData().getLogisticsInfo() != null && !ori.getShippingData().getLogisticsInfo().isEmpty()) {
			List<LogisticsInfo> logiInfoList = new ArrayList<LogisticsInfo>();
			for (LogisticsInfo li : ori.getShippingData().getLogisticsInfo()) {
				LogisticsInfo lInfo = li;
				lInfo.setPrice(li.getPrice() / oneHundredD);
				lInfo.setListPrice(li.getListPrice() / oneHundredD);
				lInfo.setSellingPrice(li.getSellingPrice() / oneHundredD);
				logiInfoList.add(lInfo);
			}
			response.getShippingData().setLogisticsInfo(logiInfoList);
		}

		return response;
	}

	public static OrderBean setRealValuesToOrderBean(OrderBean ori) {
		OrderBean response = ori;
		response.setTotalValue(ori.getTotalValue().divide(oneHundred));

		if (ori.getItems() != null && !ori.getItems().isEmpty()) {
			List<Item> items = new ArrayList<Item>();
			for (Item it : ori.getItems()) {
				Item itm = it;

				items.add(itm);
			}
			response.setItems(items);
		}

		return response;
	}

	public static PaymentBean getPaymentBean(OrderComplete orderComplete) {

		PaymentBean paymentBean = new PaymentBean();

		String formaPago = "N/A";
		if (orderComplete.getPaymentData().getTransactions() != null
				&& !orderComplete.getPaymentData().getTransactions().isEmpty()) {
			for (Transaction tr : orderComplete.getPaymentData().getTransactions()) {
				if (tr.getPayments() != null && !tr.getPayments().isEmpty()) {
					for (Payment py : tr.getPayments()) {
						formaPago = py.getPaymentSystemName();
						paymentBean.setPaymentMethod(py.getPaymentSystemName());
						if (py.getPaymentSystemName().equals(PaymentEnum.PAGO_CONTRA_ENTREGA.getPaymentSystemName())) {
							formaPago = formaPago + ": " + PagoEnum.EFECTIVO.getDescripcionSRI();
						} else if (py.getPaymentSystemName().equals(PaymentEnum.SAFETYPAY.getPaymentSystemName())) {
							formaPago = formaPago + ": " + PagoEnum.TRANSFER_OTRO_BANCO.getDescripcionSRI();
						} else if (py.getPaymentSystemName()
								.equals(PaymentEnum.TRANSFERENCIA_BANCARIA_OTRAS_ENTIDADES.getPaymentSystemName())) {
							formaPago = formaPago + ": " + PagoEnum.TRANSFER_OTRO_BANCO.getDescripcionSRI();
						} else if (py.getPaymentSystemName().equals(PaymentEnum.PAYCLUB.getPaymentSystemName())) {
							formaPago = formaPago + ": " + PagoEnum.TARJETA_CREDITO_NACIONAL.getDescripcionSRI();
						} else if (py.getPaymentSystemName().equals(PaymentEnum.TARJETA_ALIA.getPaymentSystemName())) {
							formaPago = formaPago + ": " + PagoEnum.TARJETA_CREDITO_NACIONAL.getDescripcionSRI();
						} else if (py.getPaymentSystemName()
								.equals(PaymentEnum.TARJETA_CREDITO.getPaymentSystemName())) {
							formaPago = formaPago + ": " + PagoEnum.TARJETA_CREDITO_NACIONAL.getDescripcionSRI();
						} else if (py.getPaymentSystemName().equals(PaymentEnum.PAYPAL.getPaymentSystemName())) {
							formaPago = formaPago + ": " + PagoEnum.TARJETA_CREDITO_INTERNACIONAL.getDescripcionSRI();
						}

					} // fin for

				} //
			}
		}

		paymentBean.setDescription(formaPago);

		return paymentBean;
	}
}
