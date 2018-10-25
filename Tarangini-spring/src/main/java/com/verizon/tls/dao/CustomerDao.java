package com.verizon.tls.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.tls.Model.Customer;
@Repository
public interface CustomerDao extends JpaRepository<Customer,Integer> {

}
