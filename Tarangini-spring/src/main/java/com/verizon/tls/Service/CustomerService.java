package com.verizon.tls.Service;

import com.verizon.tls.Model.Customer;


public interface CustomerService {

	Customer addCustomer(Customer cust);
	Customer getCustomerByOrderNumber(int orderNumber);
}
