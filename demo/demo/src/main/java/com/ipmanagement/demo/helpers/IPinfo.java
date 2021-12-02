package com.ipmanagement.demo.helpers;

import org.springframework.data.annotation.Id;

public class IPinfo {
	
	private Long id;
	private String ipAddress;
	private String status;
	
	public IPinfo(Long identification, String ip_address, String ip_status) {
		this.id = identification;
		this.ipAddress = ip_address;
		this.status = ip_status;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getTimestamp() {
		return status;
	}
	public void setTimestamp(String st) {
		this.status = st;
	}

}
