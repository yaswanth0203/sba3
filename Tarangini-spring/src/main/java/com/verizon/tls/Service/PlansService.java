package com.verizon.tls.Service;

import java.util.List;

import com.verizon.tls.Model.Plans;

public interface PlansService {

//	Plans getPlansByTitle(String title);
	List<Plans>getAllPlans();
	
	List<Plans> findAllByMaxSpeed(int speed);
	List<Plans> findAllByMaxUsage(int usage);
	List<Plans> findAllByChargePerMonth(int charge);
}
