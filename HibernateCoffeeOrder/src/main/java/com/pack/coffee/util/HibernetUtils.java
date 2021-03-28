package com.pack.coffee.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernetUtils {
	

	private static SessionFactory sessFactory = null;
	public static SessionFactory getSessionFactory() {
		
		if(sessFactory == null) {
			StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
			sessFactory =meta.getSessionFactoryBuilder().build();
		}
		
		return sessFactory;
	}
	
	public static Session openSession() {
		return sessFactory.openSession();
	}

	
}
