package com.prod.app.response;

import lombok.Data;

@Data
public class CommonMessage {
	private String message;
	private String code;
	private Object response;

}
