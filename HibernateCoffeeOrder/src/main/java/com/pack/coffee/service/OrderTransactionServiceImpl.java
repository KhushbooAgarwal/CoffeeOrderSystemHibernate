package com.pack.coffee.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pack.coffee.bean.AddOn;
import com.pack.coffee.bean.Coffee;
import com.pack.coffee.bean.OrderTransaction;
import com.pack.coffee.dao.OrderTransactionDao;
import com.pack.coffee.dao.OrderTransactionDaoImpl;

public class OrderTransactionServiceImpl implements OrderTransactionService {
	private OrderTransactionDao orderTran = new OrderTransactionDaoImpl();
	private CoffeeService coffServ = new CoffeeServiceImpl();
	private AddOnService addOnServ = new AddOnServiceImpl();
	int addOnId =0,coffeeId=0;
	@Override
	public int createOrderTran(int orderId, String coffeeName, String coffeeSize,String addOnName)
			throws ClassNotFoundException, SQLException {
		
		
		Coffee coffe = coffServ.getCoffeeByNameAndSize(coffeeName, coffeeSize);	
	
		AddOn addOn = addOnServ.getAddOnByName(addOnName);
		
		coffeeId = coffe.getCoffee_Id();
		if(addOn!=null)
		addOnId =  addOn.getAddOn_ID();
		
	//	System.out.println(coffeeId +"|"+ addOnId);
		
		int orderTId=0;
		orderTId = orderTran.getMaxOrderTranId();
		orderTId = orderTId+1;
		//System.out.println("+++++++++++++++++++++++++++" + orderTId);
		//System.out.println("+++++++++++++++++++++++++++" + orderId);
		orderTran.createOrderTran(orderTId,orderId, coffeeId, addOnId);
		return orderId;
	}

	@Override
	public List<OrderTransaction> getOrderTranByOrderID(int orderId) throws ClassNotFoundException, SQLException  {
	
		return orderTran.getOrderTranByOrderID(orderId);
		
	}

	@Override
	public List<Integer> getCoffeeIdByOrderID(int orderId) throws ClassNotFoundException, SQLException {
		return orderTran.getCoffeeIdByOrderID(orderId);
	}

	@Override
	public List<Integer> getAddOnIdByOrderID(int orderId) throws ClassNotFoundException, SQLException {
		return orderTran.getAddOnIdByOrderID(orderId);
	}
	
	

}
