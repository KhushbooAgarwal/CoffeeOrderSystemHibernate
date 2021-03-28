package com.pack.coffee.client;

import org.hibernate.SessionFactory;

import com.pack.coffee.persentation.CoffeePersentation;
import com.pack.coffee.persentation.CoffeePersentationImpl;
import com.pack.coffee.util.HibernetUtils;

public class CoffeeOrderClient {

	public static void main(String[] args) {
		SessionFactory sf = HibernetUtils.getSessionFactory();
		
CoffeePersentation coffee=new CoffeePersentationImpl();
		coffee.checkCustomer();
		coffee.showCoffee();
	}
}
