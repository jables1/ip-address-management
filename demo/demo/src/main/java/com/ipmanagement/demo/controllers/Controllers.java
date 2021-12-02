package com.ipmanagement.demo.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ipmanagement.demo.helpers.DBConnector;
import com.ipmanagement.demo.helpers.IPinfo;

@RestController
public class Controllers {

	private DBConnector database = new DBConnector();
	
	@PostMapping("/create-ip-address")
	public String CreateIPAddress(@RequestBody String ipAddress) {
		String result = database.addIPToDatabase(ipAddress);
		return result;
//		Create IP addresses - take in a CIDR block (e.g. 10.0.0.1/24) and add 
//		all IP addresses within that block to the data store with status “available”
	}
	
	@RequestMapping("/list-all-ip-addresses")
	public ArrayList<IPinfo> getAllIPAddresses() {
		ArrayList <IPinfo> response = database.returnAllIPAddresses();
		return response;
//		List IP addresses - return all IP addresses in the system with their current status
//			
	}
	
	@PostMapping("/acquired")
	public String changeIPToAqcuired(@RequestBody String ipAddress) {
		String result = database.changeIPToAcquired(ipAddress);
		return result;
//		Acquire an IP - set the status of a certain IP to “acquired”
	}

	@PostMapping("/available")
	public String changeIPToAvailable(@RequestBody String ipAddress) {
		String result = database.changeIPToAvailable(ipAddress);
		return result;
//		Release an IP - set the status of a certain IP to “available”
	}
}
