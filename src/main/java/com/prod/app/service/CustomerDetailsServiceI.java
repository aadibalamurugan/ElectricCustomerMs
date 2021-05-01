package com.prod.app.service;

import com.prod.app.response.CommonMessage;

public interface CustomerDetailsServiceI {

	CommonMessage getCustomerDetailsByProdId(Integer prodid);

}
