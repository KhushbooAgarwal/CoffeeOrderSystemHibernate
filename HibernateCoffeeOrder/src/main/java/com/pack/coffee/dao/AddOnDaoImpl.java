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

import com.pack.coffee.bean.AddOn;
import com.pack.coffee.bean.Coffee;
import com.pack.coffee.util.HibernetUtils;
import com.pack.coffee.util.MySQLConnectionManagement;

public class AddOnDaoImpl implements AddOnDao {

	@Override
	public List<AddOn> getAllAddOn() throws ClassNotFoundException, SQLException {
	
		Session session=HibernetUtils.openSession();		
		Transaction transaction=session.beginTransaction();
		
		List<AddOn> addOnList = new ArrayList<>();

		Query<AddOn> query = session.createQuery("from AddOn"); 
		addOnList = query.getResultList();
		
		transaction.commit();
		session.close();
		return addOnList;
		
		
	}
	

	
	@Override
	public AddOn getAddOnByName(String addOnName) throws ClassNotFoundException, SQLException {
		Session session=HibernetUtils.openSession();		
		Transaction transaction=session.beginTransaction();
		AddOn addOn = null;
		
		Query<AddOn> query = session.createQuery("from AddOn where addOn_Name=:name");
		query.setParameter("name", addOnName);
		
		addOn=query.getSingleResult();
		
		transaction.commit();
		session.close();

		return addOn;
	
	}
/*
	@Override
	public float getAddOnIdByName(int addOnId) throws ClassNotFoundException, SQLException {
		Connection connection = null;
			float price= 0f;
		
			connection = MySQLConnectionManagement.getConnection();	
		PreparedStatement statement = connection.prepareStatement("SELECT ADDON_PRICE FROM ADDON WHERE AddOn_ID=?");
		statement.setInt(1, addOnId);

		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			price = resultSet.getFloat(1);
			
		}
		connection.close(); // throwing check exception SQLException

		return price;
	
	}
	*/

	@Override
	public float getAddOnPriceById(int addOnId) throws ClassNotFoundException, SQLException {
		Session session=HibernetUtils.openSession();		
		Transaction transaction=session.beginTransaction();	
		Float price =0f;
		
		Query<Float> query = session.createQuery("select addOn_Price from AddOn where addOn_ID=:aId");
		query.setParameter("aId", addOnId);
		
		price =query.getSingleResult();
		transaction.commit();
		session.close();
		

		return price;
	
	
	}



	@Override
	public AddOn getAddOnDetailsById(int addOnId) throws ClassNotFoundException, SQLException {
		
		Session session=HibernetUtils.openSession();		
		Transaction transaction=session.beginTransaction();
		AddOn addOn = null;
		
		Query<AddOn> query = session.createQuery("from AddOn where addOn_ID=:addOnId");
		query.setParameter("addOnId", addOnId);
		
		addOn=query.getSingleResult();
		
		transaction.commit();
		session.close();

		return addOn;
	
	}
}
