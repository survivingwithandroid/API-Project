package it.francesco.api.exception;

import java.util.UUID;

public class CustomErrorDetails {

	// Class attributes
	private String detail;
	private String instance;
	private int status;
	private String title;
	private String type;
	
	
	
	public CustomErrorDetails(String detail, int status, String title, String type) {
		super();
		this.detail = detail;
		this.instance = UUID.randomUUID().toString();
		this.status = status;
		this.title = title;
		this.type = type;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getInstance() {
		return instance;
	}
	public void setInstance(String instance) {
		this.instance = instance;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
