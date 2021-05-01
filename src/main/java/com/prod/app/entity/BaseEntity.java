package com.prod.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import lombok.Data;

@Data
public class BaseEntity {

	
	@Column(name = "status")
	private String operation;
	
	@Column(name = "createdate")
	private long createDate;

	@Column(name = "createby")
	private String createdBy;

	@Column(name = "updatedate")
	private long updateDate;

	@Column(name = "updateby")
	private String updatedBy;

	@PrePersist
	public void onPrePersist() {
		audit("INSERT");
	}
	
	@PreUpdate
    public void onPreUpdate() {
        audit("UPDATE");
    }
     
    @PreRemove
    public void onPreRemove() {
        audit("DELETE");
    }
    

	private void audit(String operation) {
		setOperation(operation);
		setCreateDate((new Date()).getTime());
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public void setCreateDate(long createDate) {
		this.createDate = createDate;
	}

	public void setUpdateDate(long updateDate) {
		this.updateDate = updateDate;
	}

}
