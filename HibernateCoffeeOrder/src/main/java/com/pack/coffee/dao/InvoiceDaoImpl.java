package com.pack.coffee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.pack.coffee.bean.Customers;
import com.pack.coffee.bean.Invoices;
import com.pack.coffee.util.HibernetUtils;
import com.pack.coffee.util.MySQLConnectionManagement;

public class InvoiceDaoImpl implements InvoiceDao {

	@Override
	public int CreateInvoice(int invoiceNum,int orderId, float netValue, float gst, float serviceTax, float total,float price,float voucherAmt) throws ClassNotFoundException, SQLException {
			Session session=HibernetUtils.openSession();		
		Transaction transaction=session.beginTransaction();
	
		Invoices invoice = new Invoices(invoiceNum, orderId, netValue, gst, serviceTax, total, price, voucherAmt);
		int rows = (Integer)session.save(invoice);
		transaction.commit();
		session.close();
		return rows;
		
	}

	@Override
	public Invoices getInvoiceByOrderId(int orderId) throws ClassNotFoundException, SQLException {
		Session session=HibernetUtils.openSession();		
		Transaction transaction=session.beginTransaction();
		
		Invoices invoice = null;		
		Query<Invoices> query = session.createQuery("from Invoices where order_Id=:orderid");
		query.setParameter("orderid", orderId);
		
		if(query.uniqueResult()!=null)
			invoice=query.uniqueResult();
		
		transaction.commit();
		session.close();
		
		return invoice;
	
	}
	
	
	@Override
	public int getMaxInvoiceId() throws ClassNotFoundException, SQLException {
		Session session=HibernetUtils.openSession();		
		Transaction transaction=session.beginTransaction();
		
		int maxId =0;		
		Query<Integer> query = session.createQuery("select max(invoice_No) from Invoices");
		maxId=query.getSingleResult();
		
		transaction.commit();
		session.close();		
		return maxId;	
	}

}
