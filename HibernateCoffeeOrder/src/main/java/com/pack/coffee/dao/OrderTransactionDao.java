package com.pack.coffee.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pack.coffee.bean.OrderTransaction;

public interface OrderTransactionDao {
	
	int createOrderTran(int orderTranId ,int orderId,int coffeeId,int addOnID)throws ClassNotFoundException,SQLException;
	List<OrderTransaction> getOrderTranByOrderID(int orderId)throws ClassNotFoundException,SQLException;
	public int getMaxOrderTranId() throws ClassNotFoundException, SQLException;
	public List<Integer> getCoffeeIdByOrderID(int orderId) throws ClassNotFoundException, SQLException;
	public List<Integer> getAddOnIdByOrderID(int orderId)  throws ClassNotFoundException, SQLException;
}
