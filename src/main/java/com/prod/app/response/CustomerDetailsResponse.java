package com.prod.app.response;

import java.io.Serializable;

import lombok.Data;

@Data
public class CustomerDetailsResponse  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private String customerId;
	
	private String customerName;
	
	private String customerAddress;
	
	private String customerArea;
	
	private String  customerCountry;
	
	private String  customerPhone;
	
	private String createDate;
	
	private String updateDate;
	
	private String createdBy;
	
	private String updatedBy;

	private String  status;
	
}
