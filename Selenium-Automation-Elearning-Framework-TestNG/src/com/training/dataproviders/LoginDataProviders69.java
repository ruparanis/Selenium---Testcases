package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.bean.UNF_069Bean;
import com.training.dao.UNF_069DAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders69 {

	@DataProvider(name = "db-inputs")
	public static Object [][] getDBData() {

		List<LoginBean> list = new UNF_069DAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[2]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getPassword(); 
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	@DataProvider(name = "db-productinputs")
	public static Object [][] getProductData() {

		List<UNF_069Bean> list = new UNF_069DAO().getproduct69(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(UNF_069Bean temp : list){
			Object[]  obj = new Object[6]; 
			obj[0] = temp.getproductname(); 
			obj[1] = temp.getmetatitle();
			obj[2] = temp.getmodel();
			obj[3] = temp.getprice();
			obj[4] = temp.getquantity();
			obj[5] = temp.getcategory();
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	
	
	
	@DataProvider(name = "excel-inputs")
	public static Object[][] getExcelData(){
		String fileName ="C:/Users/RUPARANI/Desktop/TestData.xlsx"; 
		String sheetName ="Sheet1";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetName); 
	}
	
	@DataProvider(name = "xls-inputs")
	public static Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/RUPARANI/Desktop/TestData.xls", "Sheet1"); 
	}
}
