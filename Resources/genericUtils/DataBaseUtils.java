package com.genericUtils;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtils {

	Connection con=null;
	/**
	 * To resgister the DataBase
	 * @throws SQLException 
	 */
	public void connectDataBase() throws SQLException {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(IpathConstants.DatabaseURL, IpathConstants.DataBaseusername, IpathConstants.DataBasePassword);
		
	}
	
	/**
	 * To execute the query 
	 * @param query
	 * @param colIndex
	 * @param expData
	 * @throws SQLException
	 */
	public void executeAndGetData(String query,int colIndex,String expData) throws SQLException 
	//string query:"select*from emp"
	{
		Statement state=con.createStatement();
		ResultSet result = state.executeQuery(query);
		
		boolean flag=false;
		
		while(result.next()) {
			String actualdata = result.getString(colIndex);
			
			if(actualdata.equalsIgnoreCase(expData)) {
				flag=true;
				break;
			}
		}
		if(flag==true) {
			System.out.println("----data is present----");
		}
		else {
			System.out.println("----data is not present----");
		}	
	}
	
	/**
	 * This Method Is Used to CloseDataBase
	 * @throws SQLException
	 */
	public void disconnectDataBase() throws SQLException {
		con.close();
	}
}
