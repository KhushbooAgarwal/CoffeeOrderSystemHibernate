package com.pack.coffee.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customers {

		@Id
		private int customer_Id;
		private String customer_Name;
		private long phone_Number;
		
	public Customers() {		
		}

	public Customers(int customer_Id, String customer_Name, long phone_Number) {
		super();
		this.customer_Id = customer_Id;
		this.customer_Name = customer_Name;
		this.phone_Number = phone_Number;
	}

	public int getCustomer_Id() {
		return customer_Id;
	}

	public void setCustomer_Id(int customer_Id) {
		this.customer_Id = customer_Id;
	}

	public String getCustomer_Name() {
		return customer_Name;
	}

	public void setCustomer_Name(String customer_Name) {
		this.customer_Name = customer_Name;
	}

	public long getPhone_Number() {
		return phone_Number;
	}

	public void setPhone_Number(long phone_Number) {
		this.phone_Number = phone_Number;
	}

	
}

