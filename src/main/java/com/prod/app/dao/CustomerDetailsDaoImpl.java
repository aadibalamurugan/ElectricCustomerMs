package com.prod.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.prod.app.entity.CustomerDetailsEntity;
import com.prod.app.repository.CustomerDetailsRepository;


@Repository
@Transactional
public class CustomerDetailsDaoImpl implements CustomerDetailsDaoI {

	
	@Autowired
	
	CustomerDetailsRepository repository;
	
	@Transactional(readOnly = true)
	@Override
	public CustomerDetailsEntity getCustomerDetailsByProdId(Integer prodid) {
		return repository.findById(prodid).get();
	}

}
