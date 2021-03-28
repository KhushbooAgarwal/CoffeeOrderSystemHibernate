package com.pack.coffee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.pack.coffee.bean.Coffee;
import com.pack.coffee.bean.Customers;
import com.pack.coffee.util.HibernetUtils;
import com.pack.coffee.util.MySQLConnectionManagement;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public int addCustomer(int custId,String custName, long phoneNum) throws ClassNotFoundException, SQLException {
		Session session=HibernetUtils.openSession();		
		Transaction transaction=session.beginTransaction();
		
		Customers c = new Customers(custId, custName, phoneNum);
		int rows = (Integer)session.save(c);
		transaction.commit();
		session.close();
		return rows;
	}
	
	@Override
	public Customers getCustomerByPhone(long phoneNum) throws ClassNotFoundException, SQLException {
		Session session=HibernetUtils.openSession();		
		Transaction transaction=session.beginTransaction();
		
		Customers customer = null;		
		Query<Customers> query = session.createQuery("from Customers where phone_Number=: phnum");
		
		query.setParameter("phnum", phoneNum);
			
		if(query.uniqueResult()!=null)
		customer=query.uniqueResult();
		
		transaction.commit();
		session.close();
		
		return customer;
	}

	@Override
	public int getMaxCustomer() throws ClassNotFoundException, SQLException {	
		Session session=HibernetUtils.openSession();		
		Transaction transaction=session.beginTransaction();
		
		int maxId =0;		
		Query<Integer> query = session.createQuery("select max(customer_Id) from Customers");
		maxId=query.getSingleResult();
		
		transaction.commit();
		session.close();		
		return maxId;	
	}

	@Override
	public int checkCustomer(long phoneNum) throws ClassNotFoundException, SQLException {
		Session session=HibernetUtils.openSession();		
		Transaction transaction=session.beginTransaction();
		
		int custId =0;		
		Query<Integer> query = session.createQuery("select customer_Id from Customers where phone_Number=:phnum");
		query.setParameter("phnum", phoneNum);
		
		
		if(query.uniqueResult()!=null)
		custId=query.uniqueResult();
		
		
		transaction.commit();
		session.close();		

		return custId;
	}

	@Override
	public Customers getCustomerId(String custName, long phoneNum) throws ClassNotFoundException, SQLException {
		Session session=HibernetUtils.openSession();		
		Transaction transaction=session.beginTransaction();
		
		Customers customer = null;		
		Query<Customers> query = session.createQuery("from Customers where customer_Id=:custname and phone_number=:phnum");
		query.setParameter("custname", custName);
		query.setParameter("phnum", phoneNum);
		customer=query.getSingleResult();
		
		transaction.commit();
		session.close();

		return customer;
	}
	
	@Override
	public String getCustomerName(int custId) throws ClassNotFoundException, SQLException {
		Session session=HibernetUtils.openSession();		
		Transaction transaction=session.beginTransaction();
		String custName=null;

		Query<String> query = session.createQuery("select customer_Name from Customers where customer_Id =:custId");
		query.setParameter("custId", custId);
	
		custName=query.uniqueResult();
		
		transaction.commit();
		session.close();

		return custName;
	}


}
