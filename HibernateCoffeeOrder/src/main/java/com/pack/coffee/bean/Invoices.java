package com.pack.coffee.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Invoices {
	
	@Id
	private int invoice_No;
	private int order_Id;
	private float net_Value;
	private float gst;
	private float service_Tax;
	private float total;
	private float price;
	private float voucher_Discount;


	public Invoices(){
	}


	public Invoices(int invoice_No, int order_Id, float net_Value, float gst, float service_Tax, float total,
			float price, float voucher_Discount) {
		super();
		this.invoice_No = invoice_No;
		this.order_Id = order_Id;
		this.net_Value = net_Value;
		this.gst = gst;
		this.service_Tax = service_Tax;
		this.total = total;
		this.price = price;
		this.voucher_Discount = voucher_Discount;
	}





	public int getInvoice_No() {
		return invoice_No;
	}


	public void setInvoice_No(int invoice_No) {
		this.invoice_No = invoice_No;
	}


	public int getOrder_Id() {
		return order_Id;
	}


	public void setOrder_Id(int order_Id) {
		this.order_Id = order_Id;
	}


	public float getNet_Value() {
		return net_Value;
	}


	public void setNet_Value(float net_Value) {
		this.net_Value = net_Value;
	}


	public float getGst() {
		return gst;
	}


	public void setGst(float gst) {
		this.gst = gst;
	}


	public float getService_Tax() {
		return service_Tax;
	}


	public void setService_Tax(float service_Tax) {
		this.service_Tax = service_Tax;
	}


	public float getTotal() {
		return total;
	}


	public void setTotal(float total) {
		this.total = total;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public float getVoucher_Discount() {
		return voucher_Discount;
	}


	public void setVoucher_Discount(float voucher_Discount) {
		this.voucher_Discount = voucher_Discount;
	}


	
	

}
