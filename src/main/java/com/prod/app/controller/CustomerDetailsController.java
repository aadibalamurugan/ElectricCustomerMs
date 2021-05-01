package com.prod.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prod.app.response.CommonMessage;
import com.prod.app.service.CustomerDetailsServiceI;
import com.prod.app.util.CustomerConstant;
import com.prod.app.util.ProductMsExternalCall;

@RestController
@RequestMapping("/electriccustomerms")
public class CustomerDetailsController {

	private static final Logger logger = LogManager.getLogger(CustomerDetailsController.class);

	private CustomerDetailsServiceI cservice;

	private ProductMsExternalCall externalCall;

	@Autowired
	public CustomerDetailsController(CustomerDetailsServiceI cservice, ProductMsExternalCall externalCall) {
		// super();
		this.cservice = cservice;
		this.externalCall = externalCall;
	}

	@GetMapping(value = "/error")
	public String error() {
		return "Error handling";
	}

	// Get a Basic Tracking Details by Trackingid
	@GetMapping(value = "/getCustDetailsByProdId/{id}")
	public CommonMessage getCustomerDetailsByProdId(@PathVariable(name = "id") Integer prodid) {
		CommonMessage commonMessage = new CommonMessage();
		logger.info("getCustomerDetailsByProdId --- started");

		try {
			commonMessage = cservice.getCustomerDetailsByProdId(prodid);
		} catch (Exception e) {
			commonMessage.setCode(CustomerConstant.SERVERCODE);
			commonMessage.setMessage(CustomerConstant.SEVER_FETCH_MESSAGE);
		}
		return commonMessage;

	}

	@GetMapping(value = "/getProductDetailForCustomerId/{id}")
	public CommonMessage getProductDetailForCustomerId(@PathVariable(name = "id") Integer id) {
		CommonMessage commonMessage = new CommonMessage();
		CommonMessage response = null;
		logger.info("getProductmsById --- started");

		try {
			response = externalCall.getProductDetailForCustomerId(id);
			
			if (response.getCode() != CustomerConstant.SUCCESSCODE) {
				commonMessage.setCode(CustomerConstant.SUCCESSCODE);
				commonMessage.setMessage(CustomerConstant.SUCCESS_FETCH_MESSAGE);
				commonMessage.setResponse(response.getResponse());
			} else {
				commonMessage.setCode(CustomerConstant.SUCCESSCODE);
				commonMessage.setMessage(CustomerConstant.SUCCESS_NO_FETCH_MESSAGE);
				commonMessage.setResponse(response.getResponse());
			}
		} catch (Exception e) {
			e.printStackTrace();
			commonMessage.setCode(CustomerConstant.SERVERCODE);
			commonMessage.setMessage(CustomerConstant.SEVER_FETCH_MESSAGE);
			commonMessage.setResponse(response.getResponse());
		}
		return commonMessage;

	}

}
