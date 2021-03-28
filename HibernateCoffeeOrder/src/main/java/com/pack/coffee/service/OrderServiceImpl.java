package com.pack.coffee.service;

import java.util.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pack.coffee.bean.Customers;
import com.pack.coffee.bean.Invoices;
import com.pack.coffee.bean.Orders;
import com.pack.coffee.dao.OrderDao;
import com.pack.coffee.dao.OrderDaoImpl;
import com.pack.coffee.dao.OrderTransactionDao;
import com.pack.coffee.dao.OrderTransactionDaoImpl;

public class OrderServiceImpl implements OrderService {
	private OrderDao orderDao = new OrderDaoImpl();
	private OrderTransactionDao orderTDao =  new OrderTransactionDaoImpl();


	@Override
	public Orders getOrderByCustid(int customerId) throws ClassNotFoundException,SQLException {
		return orderDao.getOrderByCustid(customerId);	
		
	}
	@Override
	public int CreateOrder(int customerId, String orderDate, int voucherId)
			throws ClassNotFoundException, SQLException {		
		
			int orderId=0;
			orderId = orderDao.getMaxOrderId();
			orderId = orderId+1;
			orderDao.CreateOrder(orderId,customerId, orderDate, voucherId);	
		
		return orderId;
	}

}
