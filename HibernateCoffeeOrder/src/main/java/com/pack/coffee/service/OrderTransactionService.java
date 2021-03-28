package com.pack.coffee.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pack.coffee.bean.Coffee;
import com.pack.coffee.bean.OrderTransaction;

public interface OrderTransactionService {
	
	int createOrderTran(int orderId,String coffeeName, String coffeeSize,String addOn)throws ClassNotFoundException,SQLException;
	List<OrderTransaction> getOrderTranByOrderID(int orderId) throws ClassNotFoundException,SQLException;
	public List<Integer> getCoffeeIdByOrderID(int orderId) throws ClassNotFoundException, SQLException;
	public List<Integer> getAddOnIdByOrderID(int orderId)  throws ClassNotFoundException, SQLException;
}

