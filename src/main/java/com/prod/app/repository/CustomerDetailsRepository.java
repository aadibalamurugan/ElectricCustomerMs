package com.prod.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prod.app.entity.CustomerDetailsEntity;


public interface CustomerDetailsRepository extends JpaRepository<CustomerDetailsEntity, Integer> {

}
