package com.pack.coffee.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pack.coffee.bean.AddOn;

public interface AddOnService {
	
	List<AddOn> getAllAddOn()throws ClassNotFoundException,SQLException;
	AddOn getAddOnByName(String addOnName) throws ClassNotFoundException,SQLException;
	
	//float getAddOnIdByName(int addOnId) throws ClassNotFoundException,SQLException;
	
	float getAddOnPriceById(int addOnId) throws ClassNotFoundException,SQLException;
	AddOn getAddOnDetailsById(int addOnId)throws ClassNotFoundException,SQLException;
}
