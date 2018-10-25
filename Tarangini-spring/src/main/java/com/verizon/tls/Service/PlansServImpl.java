package com.verizon.tls.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.tls.Model.Plans;
import com.verizon.tls.dao.PlansDao;

@Service
public class PlansServImpl implements PlansService {

	@Autowired
	private PlansDao plandao;
	
	@Override
	public List<Plans> getAllPlans() {
		return plandao.findAll();
	}

	@Override
	public List<Plans> findAllByMaxSpeed(int speed) {
		return plandao.findAllByMaxSpeed(speed);
	}

	@Override
	public List<Plans> findAllByMaxUsage(int usage) {
		return plandao.findAllByMaxUsage(usage);
	}

	@Override
	public List<Plans> findAllByChargePerMonth(int charge) {
		return plandao.findAllByChargePerMonth(charge);
	}

}
