package com.prod.app.dao;

import com.prod.app.entity.CustomerDetailsEntity;

public interface CustomerDetailsDaoI {

	CustomerDetailsEntity getCustomerDetailsByProdId(Integer prodid);

}
