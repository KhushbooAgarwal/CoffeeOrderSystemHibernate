package com.pack.coffee.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pack.coffee.bean.Vouchers;
import com.pack.coffee.dao.VoucherDao;
import com.pack.coffee.dao.VoucherDaoImpl;

public class VoucherServiceImpl implements VoucherService {
	private VoucherDao vouchDao = new VoucherDaoImpl();

	@Override
	public ArrayList<Vouchers> getAllVochers() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vouchers getVoucherByVoucherName(String voucherName) throws ClassNotFoundException, SQLException {
		
		return vouchDao.getVoucherByVoucherName(voucherName);
	}

}
