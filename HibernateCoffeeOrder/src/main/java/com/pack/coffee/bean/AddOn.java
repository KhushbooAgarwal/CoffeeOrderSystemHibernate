package com.pack.coffee.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AddOn {
	@Id
	private int addOn_ID;
	private String addOn_Name;
	
	private float addOn_Price;
	
public AddOn() {
		
	}



public AddOn(int addOn_ID, String addOn_Name, float addOn_Price) {
	super();
	this.addOn_ID = addOn_ID;
	this.addOn_Name = addOn_Name;
	this.addOn_Price = addOn_Price;
}



public int getAddOn_ID() {
	return addOn_ID;
}

public void setAddOn_ID(int addOn_ID) {
	this.addOn_ID = addOn_ID;
}

public String getAddOn_Name() {
	return addOn_Name;
}

public void setAddOn_Name(String addOn_Name) {
	this.addOn_Name = addOn_Name;
}

public float getAddOn_Price() {
	return addOn_Price;
}

public void setAddOn_Price(float addOn_Price) {
	this.addOn_Price = addOn_Price;
}



}
