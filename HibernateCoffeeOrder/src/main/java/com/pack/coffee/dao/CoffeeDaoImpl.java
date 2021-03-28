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
import com.pack.coffee.util.HibernetUtils;
import com.pack.coffee.util.MySQLConnectionManagement;

public class CoffeeDaoImpl implements CoffeeDao {

	@Override
	public List<Coffee> getAllCoffeeDetails() throws ClassNotFoundException, SQLException {
		Session session=HibernetUtils.openSession();		
		Transaction transaction=session.beginTransaction();
		
		List<Coffee> coffeeList = new ArrayList<>();

		Query<Coffee> query = session.createQuery("from Coffee cf order by cf.coffee_Name"); 
		coffeeList = query.getResultList();
		
		transaction.commit();
		session.close();
		return coffeeList;
		
	}
	
	@Override
	public List<Coffee> getAllCoffeeNameDetails() throws ClassNotFoundException, SQLException {
		
		Session session=HibernetUtils.openSession();		
		Transaction transaction=session.beginTransaction();
		
		List<Coffee> coffeeNameList = new ArrayList<>();		
		
		Query<Coffee> query = session.createQuery("select distinct(cf.coffee_Name) from Coffee cf"); 
		coffeeNameList = query.getResultList();
		
		transaction.commit();
		session.close();
		return coffeeNameList;
	
	}

	@Override
	public Coffee getCoffeeByNameAndSize(String coffeeName, String coffeeSize)
			throws ClassNotFoundException, SQLException {
		Session session=HibernetUtils.openSession();		
		Transaction transaction=session.beginTransaction();
		
		Coffee coffee = null;		
		Query<Coffee> query = session.createQuery("from Coffee where coffee_Name=: name and coffee_Size=:csize");
		
		query.setParameter("name", coffeeName);
		query.setParameter("csize", coffeeSize);
		
		coffee=query.getSingleResult();
		
		transaction.commit();
		session.close();
		return coffee;
	
	}
	
	@Override
	public Float getPriceByCoffeeId(int coffeeId) throws ClassNotFoundException, SQLException {
		Session session=HibernetUtils.openSession();		
		Transaction transaction=session.beginTransaction();	
		Float price =0f;
		
		Query<Float> query = session.createQuery("select coffee_Price from Coffee where coffee_Id=:cId");
		query.setParameter("cId", coffeeId);
		
		if(query.uniqueResult()!=null)
		price =query.uniqueResult();
		transaction.commit();
		session.close();
		return price;
	
	}

	@Override
	public List<String> getAllCoffeeSize() throws ClassNotFoundException, SQLException {
		
		Session session=HibernetUtils.openSession();		
		Transaction transaction=session.beginTransaction();
		
		List<String> coffeesize = new ArrayList<>();		
		
		Query<String> query = session.createQuery("select distinct(cf.coffee_Size) from Coffee cf"); 
		coffeesize = query.getResultList();
		
		transaction.commit();
		session.close();
		return coffeesize;
		
	}

	@Override
	public Coffee getCoffeeDetailsById(int coffeeId) throws ClassNotFoundException, SQLException {
		Session session=HibernetUtils.openSession();		
		Transaction transaction=session.beginTransaction();	
		Coffee coffee = null;	
		
		Query<Coffee> query = session.createQuery("from Coffee where coffee_Id=:cId");
		query.setParameter("cId", coffeeId);
		
		coffee =query.getSingleResult();
		transaction.commit();
		session.close();
		

		return coffee;
	}

	

}
