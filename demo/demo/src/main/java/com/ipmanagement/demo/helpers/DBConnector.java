package com.ipmanagement.demo.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBConnector {
//Make connection to a local database
	
	public String connectToDatabase(String query) {// Update the table
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3333/ipManagement", "root", "Jayreeeed#91");//Connect to the database
			Statement statement = conn.createStatement();
			int result = statement.executeUpdate(query);
			if (result > 0) {//update successful
				return "Successfully updated!";
			}
			else {//Failure to update database
				return null;
			}
		} catch (SQLException e) {//Connection to database failed.
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet executeQuery(String query) {//Executes queries without making any updates to the table
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3333/ipManagement", "root", "Jayreeeed#91");
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			return rs;
		} catch (SQLException e) {//Connection to database failed.
			e.printStackTrace();
			return null;
		}
	}
	
	
	public String addIPToDatabase(String ip) {//Add the IP address to the database
		String rs = connectToDatabase("insert into ipAddresses (address, status) values('"+ ip + "', 'available');");
		return rs;
	}
	
	public ArrayList <IPinfo> returnAllIPAddresses() {//Return all the IP addresses in the database
		ResultSet rs = executeQuery("select * from ipAddresses");
		ArrayList <IPinfo> ip_address_table = new ArrayList<IPinfo>();
		try {
			while(rs.next()) {//While there is another row of data
				IPinfo ip_info = new IPinfo(rs.getLong("id"), rs.getString("address"), rs.getString("status"));
				ip_address_table.add(ip_info);
			}
			return ip_address_table;
		} catch (SQLException e) {//there are no rows of data
			e.printStackTrace();
		}
		return null;
	}
	
	public String changeIPToAcquired(String ip) {//Change the IP address status to "acquired"
		String query = "update ipAddresses set status = 'acquired' where address = '" + ip + "';";
		String result = connectToDatabase(query);
		
		return result;	
	}
	
	public String changeIPToAvailable(String ip) {//Change the IP address status to "available"
		String query = "update ipAddresses set status = 'available' where address = '" + ip + "';";
		String result = connectToDatabase(query);
		
		return result;
	}
}
