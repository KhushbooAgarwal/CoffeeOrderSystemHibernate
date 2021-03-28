package com.pack.coffee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.pack.coffee.bean.Coffee;
import com.pack.coffee.bean.Customers;
import com.pack.coffee.bean.OrderTransaction;
import com.pack.coffee.util.HibernetUtils;
import com.pack.coffee.util.MySQLConnectionManagement;

public class OrderTransactionDaoImpl implements OrderTransactionDao {

	@Override
	public int createOrderTran(int orderTranId , int orderId, int coffeeId, int addOnID)
			throws ClassNotFoundException, SQLException {
		Session session=HibernetUtils.openSession();		
		Transaction transaction=session.beginTransaction();
		
		OrderTransaction ordTran =  new OrderTransaction(orderTranId, orderId, coffeeId, addOnID);
		int rows = (Integer)session.save(ordTran);
		transaction.commit();
		session.close();
		return rows;
		
	}

	@Override
	public List<OrderTransaction> getOrderTranByOrderID(int orderId)
			throws ClassNotFoundException, SQLException {
		Session session=HibernetUtils.openSession();		
		Transaction transaction=session.beginTransaction();
		List<OrderTransaction> ordTranList = new ArrayList<>();
		

		Query<OrderTransaction> query = session.createQuery("from OrderTransaction where order_Id =:orderid"); 
		query.setParameter("orderid", orderId);
		
		ordTranList = query.getResultList();
		
		transaction.commit();
		session.close();

		return ordTranList;
	}
	
	@Override
	public List<Integer> getCoffeeIdByOrderID(int orderId)
			throws ClassNotFoundException, SQLException {
		Session session=HibernetUtils.openSession();		
		Transaction transaction=session.beginTransaction();
		List<Integer> ordTranList = new ArrayList<>();
		
		Query<Integer> query = session.createQuery("select distinct(coffee_Id) from OrderTransaction where order_Id =:orderid"); 
		query.setParameter("orderid", orderId);
	
		ordTranList = query.getResultList();
		
		transaction.commit();
		session.close();

		return ordTranList;
	}
	@Override
	public List<Integer> getAddOnIdByOrderID(int orderId)
			throws ClassNotFoundException, SQLException {
		Session session=HibernetUtils.openSession();		
		Transaction transaction=session.beginTransaction();
		List<Integer> ordTranList = new ArrayList<>();
		
	Query<Integer> query = session.createQuery("select addOn_ID from OrderTransaction where order_Id =:orderid"); 
	query.setParameter("orderid", orderId);

	ordTranList = query.getResultList();
	
	transaction.commit();
	session.close();
		return ordTranList;
	}

	@Override
	public int getMaxOrderTranId() throws ClassNotFoundException, SQLException {
		Session session=HibernetUtils.openSession();		
		Transaction transaction=session.beginTransaction();
		
		int maxId =0;		
		Query<Integer> query = session.createQuery("select max(orderTran_Id) from OrderTransaction");
		maxId=query.getSingleResult();
		
		transaction.commit();
		session.close();		
		return maxId;
	}
}
