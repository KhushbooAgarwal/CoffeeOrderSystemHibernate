package com.pack.coffee.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pack.coffee.bean.AddOn;
import com.pack.coffee.dao.AddOnDao;
import com.pack.coffee.dao.AddOnDaoImpl;
import com.pack.coffee.dao.CoffeeDao;
import com.pack.coffee.dao.CoffeeDaoImpl;

public class AddOnServiceImpl implements AddOnService {
	private AddOnDao addOnDao =  new AddOnDaoImpl();

	
	@Override
	public List<AddOn> getAllAddOn() throws ClassNotFoundException, SQLException {
		return addOnDao.getAllAddOn();
	}

	
	@Override
	public AddOn getAddOnByName(String addOnName) throws ClassNotFoundException, SQLException {
		return addOnDao.getAddOnByName(addOnName);
	}
/*
	@Override
	public float getAddOnIdByName(int addOnId) throws ClassNotFoundException, SQLException {
		return addOnDao.getAddOnIdByName(addOnId);
	}*/


	@Override
	public float getAddOnPriceById(int addOnId) throws ClassNotFoundException, SQLException {
		return addOnDao.getAddOnPriceById(addOnId);
	
	}


	@Override
	public AddOn getAddOnDetailsById(int addOnId) throws ClassNotFoundException, SQLException {
		return addOnDao.getAddOnDetailsById(addOnId);
	}

}
