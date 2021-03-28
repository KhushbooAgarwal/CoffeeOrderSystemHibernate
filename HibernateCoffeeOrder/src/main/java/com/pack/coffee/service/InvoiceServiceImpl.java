package com.pack.coffee.service;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pack.coffee.bean.AddOn;
import com.pack.coffee.bean.Coffee;
import com.pack.coffee.bean.Invoices;
import com.pack.coffee.bean.OrderTransaction;
import com.pack.coffee.bean.Vouchers;
import com.pack.coffee.dao.InvoiceDao;
import com.pack.coffee.dao.InvoiceDaoImpl;

public class InvoiceServiceImpl implements InvoiceService {
	private InvoiceDao invoiceDao = new InvoiceDaoImpl();
	private CoffeeService coffServ = new CoffeeServiceImpl();
	private AddOnService addOnServ = new AddOnServiceImpl();
	private VoucherService voucherSer  =  new VoucherServiceImpl();
	private OrderTransactionService orderTran =  new OrderTransactionServiceImpl();
	private CustomerService custServ =  new CustomerServiceImpl();
	private Invoices invoice = null;
	Date date=java.util.Calendar.getInstance().getTime();
	
		@Override
	public int createInvoice(int orderId,String voucherName,String coffeeName,String coffeeSize ,String addOnName) throws ClassNotFoundException, SQLException {
		
		int invoiceId=0;
		float voucherDis = 0f,voucherAmount=0f,price=0f,netValue=0f, gst =0f,serviceTax=0f,total=0f;
		float coffeePrice=0,addOnPrice=0,totalAddOn=0,totalcoffPrice=0;
		String pattern = "####.##";
		DecimalFormat format = new DecimalFormat(pattern);
		List<Integer> coffeeIdList = orderTran.getCoffeeIdByOrderID(orderId) ;
		List<Integer> addOnIdList = orderTran.getAddOnIdByOrderID(orderId) ;
		

		for(Integer cIdList : coffeeIdList) {
			coffeePrice = coffServ.getPriceByCoffeeId(cIdList);
			
	//		System.out.println("****************" +coffeePrice );
			totalcoffPrice+=coffeePrice;
		}
		
		for(Integer aIdList : addOnIdList) {
			addOnPrice = addOnServ.getAddOnPriceById(aIdList);
	//		System.out.println("addOnPrice *******************"+addOnPrice);
			totalAddOn+=addOnPrice;
			}
		
	
		price=totalcoffPrice+totalAddOn;
		invoiceId = invoiceDao.getMaxInvoiceId();
		invoiceId = orderId+1;
		
		Vouchers voucher = voucherSer.getVoucherByVoucherName(voucherName);
		if(voucher!=null) {
			voucherDis = voucher.getVoucher_Discount();
			voucherAmount = price * (voucherDis/100);
		}
		else
		{
			voucherAmount=0f;
		}
		
		netValue = price - voucherAmount;
		gst  = netValue * .18f;
		serviceTax = netValue*.08f;
		
		total = netValue + gst +serviceTax;
		invoiceDao.CreateInvoice(invoiceId,orderId, Float.valueOf(format.format(netValue)), Float.valueOf(format.format(gst)), Float.valueOf(format.format(serviceTax)), Float.valueOf(format.format(total)),Float.valueOf(format.format(price)), Float.valueOf(format.format(voucherAmount)));
		
		return invoiceId;
	}

	@Override
	public Invoices getInvoiceByOrderId(int orderId) throws ClassNotFoundException,SQLException{
		
		return invoiceDao.getInvoiceByOrderId(orderId);
	}
	
	
	@Override
	public void showInvoice(int orderId,int customerId) throws ClassNotFoundException,SQLException{
		List<OrderTransaction> OrderTranDetail =  new ArrayList<OrderTransaction>();
		Coffee coffeeName=null;
		AddOn addOnName=null;
		String nameAddOn;
		invoice = invoiceDao.getInvoiceByOrderId(orderId);
		String cName = custServ.getCustomerName(customerId);
		OrderTranDetail = orderTran.getOrderTranByOrderID(orderId);
		System.out.println("************************Final Bill Invoice*********************");
		System.out.println("Customer Name : " + cName);
		System.out.println("Invoice Date : "+date);
		System.out.println("-------------------------------------------------------");
		System.out.println("Product                  Size                  AddOn");
		System.out.println("-------------------------------------------------------");
		for(OrderTransaction list :OrderTranDetail) {
			coffeeName = coffServ.getCoffeeDetailsById(list.getCoffee_Id());
			addOnName=addOnServ.getAddOnDetailsById(list.getAddOn_ID());
			if(addOnName==null)
				nameAddOn="";
			else
				nameAddOn=addOnName.getAddOn_Name();
			
			System.out.println(coffeeName.getCoffee_Name()+"              " + coffeeName.getCoffee_Size()+"              "+nameAddOn);
		}
		System.out.println("-------------------------------------------------------");
		System.out.println("Total Value : " + invoice.getPrice());
		System.out.println("Disount : " + invoice.getVoucher_Discount());
		System.out.println("Net Value : " + invoice.getNet_Value());
		System.out.println("GST : " + invoice.getGst());
		System.out.println("Service Tax : " + invoice.getService_Tax());		
		System.out.println("Total Bill : " + invoice.getTotal());
	}

}
