package com.pack.coffee.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderTransaction {
	@Id
	private int orderTran_Id;
	private int order_Id;
	private int coffee_Id;
	private int addOn_ID;

	public OrderTransaction(){
	}

	public OrderTransaction(int orderTran_Id, int order_Id, int coffee_Id, int addOn_ID) {
		super();
		this.orderTran_Id = orderTran_Id;
		this.order_Id = order_Id;
		this.coffee_Id = coffee_Id;
		this.addOn_ID = addOn_ID;
	}

	public int getOrderTran_Id() {
		return orderTran_Id;
	}

	public void setOrderTran_Id(int orderTran_Id) {
		this.orderTran_Id = orderTran_Id;
	}

	public int getOrder_Id() {
		return order_Id;
	}

	public void setOrder_Id(int order_Id) {
		this.order_Id = order_Id;
	}

	public int getCoffee_Id() {
		return coffee_Id;
	}

	public void setCoffee_Id(int coffee_Id) {
		this.coffee_Id = coffee_Id;
	}

	public int getAddOn_ID() {
		return addOn_ID;
	}

	public void setAddOn_ID(int addOn_ID) {
		this.addOn_ID = addOn_ID;
	}

	

}
