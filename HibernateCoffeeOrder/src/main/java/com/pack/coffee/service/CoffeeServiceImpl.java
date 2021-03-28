package com.pack.coffee.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pack.coffee.bean.Coffee;
import com.pack.coffee.dao.CoffeeDao;
import com.pack.coffee.dao.CoffeeDaoImpl;


public class CoffeeServiceImpl implements CoffeeService {
	private CoffeeDao coffeeDao =  new CoffeeDaoImpl();
	ArrayList<Coffee> coffeeList = new ArrayList<>();
	@Override
	public List<Coffee> getAllCoffeeDetails() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return coffeeDao.getAllCoffeeDetails();
	}
	
	@Override
	public List<Coffee> getAllCoffeeNameDetails() throws ClassNotFoundException, SQLException {
		
		return coffeeDao.getAllCoffeeNameDetails();
	}

	@Override
	public Coffee getCoffeeByNameAndSize(String coffeeName, String coffeeSize) throws ClassNotFoundException, SQLException {
		return coffeeDao.getCoffeeByNameAndSize(coffeeName, coffeeSize);
		 
	}

	@Override
	public Float getPriceByCoffeeId(int coffeeId) throws ClassNotFoundException, SQLException {
		return coffeeDao.getPriceByCoffeeId(coffeeId);
	}

	@Override
	public List<String> getAllCoffeeSize() throws ClassNotFoundException, SQLException {
		return coffeeDao.getAllCoffeeSize();
	}

	@Override
	public Coffee getCoffeeDetailsById(int coffeeId) throws ClassNotFoundException, SQLException {
		return coffeeDao.getCoffeeDetailsById(coffeeId);
	}

	

}
