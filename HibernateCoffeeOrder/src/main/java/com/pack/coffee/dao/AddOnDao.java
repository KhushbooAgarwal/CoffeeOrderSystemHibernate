package com.pack.coffee.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pack.coffee.bean.AddOn;


public interface AddOnDao {	
	
	List<AddOn> getAllAddOn()throws ClassNotFoundException,SQLException;
	AddOn getAddOnByName(String addOnName)throws ClassNotFoundException,SQLException;
//	public float getAddOnIdByName(int addOnId) throws ClassNotFoundException, SQLException;
	public float getAddOnPriceById(int addOnId) throws ClassNotFoundException, SQLException;
	AddOn getAddOnDetailsById(int addOnId)throws ClassNotFoundException,SQLException;
}
