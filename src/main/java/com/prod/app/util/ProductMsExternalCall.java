package com.prod.app.util;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.prod.app.response.CommonMessage;

@FeignClient(name ="electricprodms" , url="localhost:8088")
public interface ProductMsExternalCall {



	@GetMapping("/electricprodms/getproductDetails/{id}")
	public CommonMessage  getProductDetailForCustomerId(@PathVariable Integer prodid);
}
