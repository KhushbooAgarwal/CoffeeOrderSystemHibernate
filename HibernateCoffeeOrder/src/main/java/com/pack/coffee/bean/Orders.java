package com.pack.coffee.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Orders {
	@Id
	private int order_Id;
	private int customer_Id;
	private Date order_Date;
	
	public Orders(){
	}

	public Orders(int order_Id, int customer_Id, Date order_Date) {
		super();
		this.order_Id = order_Id;
		this.customer_Id = customer_Id;
		this.order_Date = order_Date;
	}

	public int getOrder_Id() {
		return order_Id;
	}

	public void setOrder_Id(int order_Id) {
		this.order_Id = order_Id;
	}

	public int getCustomer_Id() {
		return customer_Id;
	}

	public void setCustomer_Id(int customer_Id) {
		this.customer_Id = customer_Id;
	}

	public Date getOrder_Date() {
		return order_Date;
	}

	public void setOrder_Date(Date order_Date) {
		this.order_Date = order_Date;
	}

		
}
