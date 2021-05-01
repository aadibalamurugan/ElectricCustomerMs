package com.prod.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.prod.app.util.AuditListener;

import lombok.Data;

@Data
@EntityListeners(AuditListener.class)
@Entity
@Table(name = "elec_customer_main" , schema = "elec_customer_schema")
public class CustomerDetailsEntity  extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customerid")
	private Integer customerId;

	@Column(name = "customername")
	private String customerName;

	@Column(name = "customeraddress")
	private String customerAddress;
	
	@Column(name = "customerarea")
	private String customerArea;

	@Column(name = "customercountry")
	private String customerCountry;

	@Column(name = "customerphone")
	private Integer customerPhone;

	

}
