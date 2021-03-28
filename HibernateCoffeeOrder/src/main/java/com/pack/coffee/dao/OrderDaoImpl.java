package com.pack.coffee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.pack.coffee.bean.Customers;
import com.pack.coffee.bean.OrderTransaction;
import com.pack.coffee.bean.Orders;
import com.pack.coffee.util.HibernetUtils;
import com.pack.coffee.util.MySQLConnectionManagement;

public class OrderDaoImpl implements OrderDao {
	
	private static java.sql.Date getCurrentDate() {
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Date(today.getTime());
	}

	@Override
	public int CreateOrder(int orderId,int customerId, String orderDate, int voucherId)
			throws ClassNotFoundException, SQLException {
		Session session=HibernetUtils.openSession();		
		Transaction transaction=session.beginTransaction();
		
		Orders ordTran = new Orders(orderId, customerId, getCurrentDate());
		int rows = (Integer)session.save(ordTran);
		transaction.commit();
		session.close();
		return rows;
	}

	@Override
	public Orders getOrderByCustid(int customerId) throws ClassNotFoundException, SQLException {
		Session session=HibernetUtils.openSession();		
		Transaction transaction=session.beginTransaction();
		
		Orders orders = null;		
		Query<Orders> query = session.createQuery("from Orders where customer_Id =:custId");
		query.setParameter("custId", customerId);
	
		orders=query.getSingleResult();
		
		transaction.commit();
		session.close();


		return orders;
	}
	@Override
	public int getMaxOrderId() throws ClassNotFoundException, SQLException {
		Session session=HibernetUtils.openSession();		
		Transaction transaction=session.beginTransaction();
		
		int maxId =0;		
		Query<Integer> query = session.createQuery("select max(order_Id) from Orders");
		maxId=query.uniqueResult();
		
		transaction.commit();
		session.close();		
		return maxId;
	}
/*
	@Override
	public boolean isOrderIsPresent(int orderId) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		int id= 0;
		
		connection = MySQLConnectionManagement.getConnection();	
		PreparedStatement statement = connection.prepareStatement("SELECT ORDER_ID FROM ORDERS WHERE ORDER_ID =?");
		statement.setInt(1, orderId);
		
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {		
			id = resultSet.getInt(1);
			
			System.out.println(orderId);
			
		}
		connection.close(); 
		if(id!=0)
			return true;
		else 
			return false;
		

	}
	*/


}
