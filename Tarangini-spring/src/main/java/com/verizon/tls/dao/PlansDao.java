package com.verizon.tls.dao;

import java.time.LocalDate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.tls.Model.Plans;

@Repository
public interface PlansDao extends JpaRepository<Plans,String>{


	List<Plans> findAllByMaxSpeed(int speed);
	List<Plans> findAllByMaxUsage(int usage);
	List<Plans> findAllByChargePerMonth(int charge);
	
}
