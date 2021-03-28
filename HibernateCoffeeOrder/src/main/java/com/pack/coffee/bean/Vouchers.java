package com.pack.coffee.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vouchers {

	@Id
	private int voucher_ID;
	private String voucher_Name;
	private float voucher_Discount;
	
public Vouchers() {		
	}



public Vouchers(int voucher_ID, String voucher_Name, float voucher_Discount) {
	super();
	this.voucher_ID = voucher_ID;
	this.voucher_Name = voucher_Name;
	this.voucher_Discount = voucher_Discount;
}



public int getVoucher_ID() {
	return voucher_ID;
}

public void setVoucher_ID(int voucher_ID) {
	this.voucher_ID = voucher_ID;
}

public String getVoucher_Name() {
	return voucher_Name;
}

public void setVoucher_Name(String voucher_Name) {
	this.voucher_Name = voucher_Name;
}



public float getVoucher_Discount() {
	return voucher_Discount;
}



public void setVoucher_Discount(float voucher_Discount) {
	this.voucher_Discount = voucher_Discount;
}


}
