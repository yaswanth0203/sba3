package com.verizon.tls.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.tls.Model.Customer;
import com.verizon.tls.dao.CustomerDao;

@Service
public class CustomerServImpl implements CustomerService {

	@Autowired
	private CustomerDao custdao;
	
	@Override
	public Customer addCustomer(Customer cust) {
		return custdao.save(cust); 
	}

	@Override
	public Customer getCustomerByOrderNumber(int orderNumber) {
		Customer customer = null;
		
		// optional can handle both finding and retrieveing in a single request
		Optional<Customer> optCustomer = custdao.findById(orderNumber);
		if (optCustomer.isPresent()) {
			customer = optCustomer.get();
		}
		return customer;
	}

}
