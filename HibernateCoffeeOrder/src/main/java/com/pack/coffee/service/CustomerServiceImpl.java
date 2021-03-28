package com.pack.coffee.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pack.coffee.bean.Customers;
import com.pack.coffee.dao.CustomerDao;
import com.pack.coffee.dao.CustomerDaoImpl;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDao custDao = new CustomerDaoImpl();	;
	@Override
	public int addCustomer(String custName, long phoneNum) throws ClassNotFoundException, SQLException {
		
		Customers customer=null;
		int result = 0;
		
		customer = custDao.getCustomerByPhone(phoneNum);
		
		if(customer!=null) {
			result =customer.getCustomer_Id();
		}
		else {
			int custId= custDao.getMaxCustomer();
			custId = custId+1;
			custDao.addCustomer(custId,custName, phoneNum);
			result = custId;
		}
			return result;
	}

	@Override
	public Customers getCustomerByPhone(long phoneNum) throws ClassNotFoundException, SQLException {
		return custDao.getCustomerByPhone(phoneNum);	
		
	}

	@Override
	public int checkCustomer(long phoneNum) throws ClassNotFoundException, SQLException {
		
		return custDao.checkCustomer(phoneNum);
	}

	@Override
	public Customers getCustomerId(String custName, long phoneNum) throws ClassNotFoundException, SQLException {
				return custDao.getCustomerId(custName, phoneNum);
	}

	@Override
	public String getCustomerName(int custId) throws ClassNotFoundException, SQLException {
		return  custDao.getCustomerName(custId);
	}

}
