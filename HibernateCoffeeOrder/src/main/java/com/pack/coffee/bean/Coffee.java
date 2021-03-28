package com.pack.coffee.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Coffee {
	@Id
	private int coffee_Id;
	private String coffee_Name;
	private String coffee_Size;
	private float coffee_Price;
	
	
	public Coffee() {
		
	}


	public int getCoffee_Id() {
		return coffee_Id;
	}


	public void setCoffee_Id(int coffee_Id) {
		this.coffee_Id = coffee_Id;
	}


	public String getCoffee_Name() {
		return coffee_Name;
	}


	public void setCoffee_Name(String coffee_Name) {
		this.coffee_Name = coffee_Name;
	}


	public String getCoffee_Size() {
		return coffee_Size;
	}


	public void setCoffee_Size(String coffee_Size) {
		this.coffee_Size = coffee_Size;
	}


	public float getCoffee_Price() {
		return coffee_Price;
	}


	public void setCoffee_Price(float coffee_Price) {
		this.coffee_Price = coffee_Price;
	}


	public Coffee(int coffee_Id, String coffee_Name, String coffee_Size, float coffee_Price) {
		super();
		this.coffee_Id = coffee_Id;
		this.coffee_Name = coffee_Name;
		this.coffee_Size = coffee_Size;
		this.coffee_Price = coffee_Price;
	}

}
