package com.verizon.tls.restApi;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.tls.Model.Customer;
import com.verizon.tls.Model.Plans;
import com.verizon.tls.Service.CustomerServImpl;
import com.verizon.tls.Service.CustomerService;
import com.verizon.tls.Service.PlansServImpl;
import com.verizon.tls.Service.PlansService;

@RestController
@CrossOrigin
@RequestMapping("/Tarangini")
public class TaranginiApi {

	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private PlansService plansService;
	
	
	@GetMapping
	public ResponseEntity<List<Plans>> getAllPlans() {
		return new ResponseEntity<>(plansService.getAllPlans(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer cust) {
		ResponseEntity<Customer> resp = null;


		if (resp == null) {
			Customer c = customerService.addCustomer(cust);
			if (c == null)
				resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			else
				resp = new ResponseEntity<>(c, HttpStatus.OK);
		}
		return resp;
	}
	
	@GetMapping("/{type}/{srhValue}")
	public ResponseEntity<List<Plans>> getAllPlans(@PathVariable("type") String typeBy,
			@PathVariable("srhValue") int searchValue) {

		ResponseEntity<List<Plans>> resp=null;

		switch (typeBy) {
		case "maxSpeed":
			List<Plans> cByMaxSpeed = plansService.findAllByMaxSpeed(searchValue);
			if (cByMaxSpeed != null && cByMaxSpeed.size() != 0) {
				resp = new ResponseEntity<>(cByMaxSpeed, HttpStatus.OK);
			} else {
				resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			break;
		case "maxUsage":
			List<Plans> cByMaxUsage = plansService.findAllByMaxUsage(searchValue);
			if (cByMaxUsage != null && cByMaxUsage.size() != 0) {
				resp = new ResponseEntity<>(cByMaxUsage, HttpStatus.OK);
			} else {
				resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			break;
		case "chargePerMonth":
			List<Plans> cByChargerPerMnth = plansService.findAllByChargePerMonth(searchValue);
			if (cByChargerPerMnth != null && cByChargerPerMnth.size() != 0) {
				resp = new ResponseEntity<>(cByChargerPerMnth, HttpStatus.OK);
			} else {
				resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			break;
			default:
				resp=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				break;
		}
		return resp;
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") int ordernum) {
		ResponseEntity<Customer> resp;

		Customer c = customerService.getCustomerByOrderNumber(ordernum);
		if (c == null)
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp = new ResponseEntity<>(c, HttpStatus.OK);
		return resp;
	}
}
