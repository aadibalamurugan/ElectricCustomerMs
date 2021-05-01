package com.prod.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.prod.app.dao.CustomerDetailsDaoI;
import com.prod.app.entity.CustomerDetailsEntity;
import com.prod.app.response.CommonMessage;
import com.prod.app.response.CustomerDetailsResponse;
import com.prod.app.util.CustomerConstant;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsServiceI {

	private static final Logger logger = LogManager.getLogger(CustomerDetailsServiceImpl.class);

	@Autowired
	CustomerDetailsDaoI customerdao;

	@Transactional
	@Override
	public CommonMessage getCustomerDetailsByProdId(Integer prodid) {
		logger.info("CustomerDetailsServiceImpl  ::: getCustomerDetailsByProdId()");

		CommonMessage response = new CommonMessage();

		CustomerDetailsResponse prodResponse = new CustomerDetailsResponse();

		CustomerDetailsEntity trackentity = customerdao.getCustomerDetailsByProdId(prodid);

		if (trackentity.getCustomerId() != 0) {

			prodResponse.setCustomerId(String.valueOf(trackentity.getCustomerId()));
			prodResponse.setCustomerName(trackentity.getCustomerName());
			prodResponse.setCustomerAddress(String.valueOf(trackentity.getCustomerAddress()));
			prodResponse.setCustomerArea(trackentity.getCustomerArea());
			prodResponse.setCustomerPhone(String.valueOf(trackentity.getCustomerPhone()));
			prodResponse.setCustomerCountry(trackentity.getCustomerCountry());
			prodResponse.setStatus(trackentity.getOperation());
			prodResponse.setCreateDate(String.valueOf(trackentity.getCreateDate()));
			prodResponse.setUpdateDate(String.valueOf(trackentity.getUpdateDate()));
			prodResponse.setUpdatedBy(trackentity.getUpdatedBy());
			prodResponse.setCreatedBy(trackentity.getCreatedBy());

			response.setCode(CustomerConstant.SUCCESSCODE);
			response.setMessage(CustomerConstant.SUCCESS_FETCH_MESSAGE);
			response.setResponse(prodResponse);
		} else {
			response.setCode(CustomerConstant.SUCCESSCODE);
			response.setMessage(CustomerConstant.SUCCESS_NO_FETCH_MESSAGE);
			response.setResponse(prodResponse);
		}

		return response;
	}

}
