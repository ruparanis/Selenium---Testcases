package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.LoginBean;
import com.training.bean.UNF_069Bean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

public class UNF_069DAO {
	
	Properties properties; 
	
	public UNF_069DAO() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<LoginBean> getLogins(){
		String sql = properties.getProperty("get.logins"); 
		
		GetConnection gc  = new GetConnection(); 
		List<LoginBean> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<LoginBean>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				LoginBean temp = new LoginBean(); 
				temp.setUserName(gc.rs1.getString(1));
				temp.setPassword(gc.rs1.getString(2));

				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	
	public List<UNF_069Bean> getproduct69(){
		String sql = properties.getProperty("get.product69"); 
		
		GetConnection gc  = new GetConnection(); 
		List<UNF_069Bean> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<UNF_069Bean>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				UNF_069Bean temp = new UNF_069Bean(); 
				temp.setproductname(gc.rs1.getString(1));
				temp.setmetatitle(gc.rs1.getString(2));
				temp.setmodel(gc.rs1.getString(3));
				temp.setprice(gc.rs1.getString(4));
				temp.setquantity(gc.rs1.getString(5));
				temp.setcategory(gc.rs1.getString(6));

				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	public static void main(String[] args) {
		new UNF_069DAO().getLogins().forEach(System.out :: println);
		new UNF_069DAO().getproduct69().forEach(System.out :: println);
		
		
	}
	 
	


}
