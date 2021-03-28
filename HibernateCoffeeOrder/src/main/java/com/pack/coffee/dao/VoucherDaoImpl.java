package com.pack.coffee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.pack.coffee.bean.Orders;
import com.pack.coffee.bean.Vouchers;
import com.pack.coffee.util.HibernetUtils;
import com.pack.coffee.util.MySQLConnectionManagement;

public class VoucherDaoImpl implements VoucherDao {

	@Override
	public ArrayList<Vouchers> getAllVouchers() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vouchers getVoucherByVoucherName(String voucherName) throws ClassNotFoundException, SQLException {
		Session session=HibernetUtils.openSession();		
		Transaction transaction=session.beginTransaction();
		Vouchers voucher=null;

		Query<Vouchers> query = session.createQuery("from Vouchers where voucher_Name=:vname");
		query.setParameter("vname", voucherName);
		
		voucher=query.uniqueResult();
		
		transaction.commit();
		session.close();

		return voucher;
	}

}
