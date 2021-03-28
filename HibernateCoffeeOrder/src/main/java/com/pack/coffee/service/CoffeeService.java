package com.pack.coffee.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pack.coffee.bean.Coffee;

public interface CoffeeService {
		
	List<Coffee> getAllCoffeeDetails()throws ClassNotFoundException,SQLException;
	List<Coffee> getAllCoffeeNameDetails()throws ClassNotFoundException,SQLException;
	List<String> getAllCoffeeSize()throws ClassNotFoundException,SQLException;
	
	Coffee getCoffeeByNameAndSize(String coffeeName, String coffeeSize)  throws ClassNotFoundException, SQLException;
	public Float getPriceByCoffeeId(int coffeeId) throws ClassNotFoundException, SQLException;
	Coffee getCoffeeDetailsById(int coffeeId)throws ClassNotFoundException,SQLException;
}
