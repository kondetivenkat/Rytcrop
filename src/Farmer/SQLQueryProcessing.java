package Farmer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

interface SQLQueriesInterface
{
	public void SQLQueryProcessing_upload();
	public void result_retrun(String query) throws Exception;
	public String result_ret(String query, String attribute,int n)throws Exception;
	public void update_table(String query) throws Exception;
	public boolean UserID_pwd_check(String query) throws Exception;
	public User_Account User_details_return(String query);
	public void load_data_from_file(String location,String table_name);
	public void SQL_Exit();
}

public class SQLQueryProcessing extends File_Manager implements SQLQueriesInterface {
	
	protected Connection con;
	protected Statement st;
	protected ResultSet rs;
	String SQL_location = "C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\rytcrop\\";
	String cur_dir = System.getProperty("user.dir").toString();
	
	String[] Table_Name = {
			"crop_details.csv",
			"crop_price.csv",
			"Crop_recommendation.csv",
			"Cropname_id.csv",				
			"Farmer_details.csv",
			"farmer_id.csv",
			"Id_loan.csv",
			"customer_login.csv",
			"id_subsidies.csv",
			"sell.csv",
			"UserID_password.csv",
			"avgcrop.csv",
			"Crop_date_season.csv"};
	
	public void SQLQueryProcessing_upload()
	{
		super.directory();
		
		Connection con1;
		Statement st1;
		String url1 = "jdbc:mysql://localhost:3306/";
        String uname1 = "root";
        String pass1 = "Poojyanth1002@";
		String sl = "drop database IF EXISTS RytCrop;";
		String s2=  "create database RytCrop;";
		try {
			Class.forName("com.mysql.jdbc.Driver");
	        con = DriverManager.getConnection(url1,uname1,pass1);
	        st1 = con.createStatement();
			st1.execute(sl);
			st1.executeUpdate(s2);
			st1.close();
			con.close();
		} catch (Exception e) {
				e.printStackTrace();
		}
		
		try {
			Administrator();
			String[] qu = {"create table crop_details(Farmer_Id int, Crop_Id varchar(4), Date_in varchar(11),Date_out varchar(11));\r\n"
					, "create table crop_price(Crop_Id varchar(4), price int);\r\n"
					, "create table crop_recommendation\r\n"
					+ "(No int, N int, P int, K int, temperature float,\r\n"
					+ "humidity float, ph float,  rainfall float, label varchar(20), sum float);\r\n"
					, "create table cropname_id(Crop_Name varchar(30), Crop_Id varchar(4));\r\n"
					, "create table farmer_id (Farmer_Id int,Farmer_FirstName varchar(30), Farmer_lastName varchar(30));\r\n"
					, "create table farmer_details(Farmer_Id int, Mobile_Number long,DateOfBirth varchar(10), AadhaarNumber varchar(15));\r\n"
					, "create table id_loan (Farmer_Id int, Loan_Amount int);\r\n"
					, "create table sell(Farmer_Id int, Date_of_selling varchar(11), Crop_Id varchar(4), Tons int, price_per_tons int, Crop_Budget int, Profit int);\r\n"
					, "create table userid_password(User_ID int, password varchar(30), category int);"
					, "create table id_subsidies(Farmer_Id int, subsidies varchar(30));\r\n"
					, "create table customer_login(c_username varchar(30), c_password varchar(30));\r\n"
					, "create table avgcrop(N float, P float, K float, temperature float,\r\n"
					+ "humidity float, ph float,  rainfall float, label varchar(20), Crop_Id varchar(4));"
					,"create table crop_date_season (Crop_Name varchar(30), season varchar(30));\r\n"};
			for(int i = 0; i < qu.length; i++)
				st.executeUpdate(qu[i]);
			
			Administrator_close();
		} catch (Exception e) {
			System.out.println("SQLQueryProcessing_upload");
			e.printStackTrace();
		}
		
		for(int z = 0; z < Table_Name.length; z++)
		{
			super.File_Delete(SQL_location+Table_Name[z]);
			super.File_copy(cur_dir+"\\src\\CSV_Files\\"+Table_Name[z],SQL_location+Table_Name[z]);
		}
				
		for(int z = 0; z < Table_Name.length; z++)
		{
			int l = Table_Name[z].indexOf(".csv");
			load_data_from_file(Table_Name[z],Table_Name[z].substring(0,l));
		}
	}
	
	private void Administrator() throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/RytCrop";
        String uname = "root";
        String pass = "Poojyanth1002@";
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url,uname,pass);
        st = con.createStatement();
        
	}
	
    public void result_retrun(String query) throws Exception
    {
        
        Administrator();        
        rs = st.executeQuery(query);
        
        for(int i = 0; i < 5&&rs.next();i++) {
        String name = rs.getString("label");
        String qury = "select Crop_ID from cropname_id where Crop_Name = '"+name+"';";
        System.out.println(name+" "+result_ret(qury,"Crop_ID",5));
        }
        
        Administrator_close();
    }
    
    public String result_ret(String query, String attribute,int n)throws Exception
    {
    	String res = "";
    	Administrator();        
        ResultSet ras = st.executeQuery(query);
        for(int i = 0; ras.next() && i < n;i++) 
        {
        	res = ras.getString(attribute);
        }
        Administrator_close();
        return res;
    }
    
    public void update_table(String query) throws Exception
    {
    	Administrator(); 
    	st.executeUpdate(query);
    	Administrator_close();
    }
    
    public boolean UserID_pwd_check(String query) throws Exception
    {
    	boolean fl = false;
    	Administrator();
    	rs = st.executeQuery(query);
    	for(int i = 0; rs.next();i++) 
    	{
    		if(i>0) return false;
            fl = true;
        }
    	Administrator_close();
    	return fl;
    }
    
    public User_Account User_details_return(String query)
    {
    	User_Account ua = null;
    	try {
    	Administrator();
    	rs = st.executeQuery(query);
    	rs.next();
    	ua = new User_Account(rs.getInt("User_ID"),rs.getString("password"),
    			rs.getString("Farmer_FirstName")+" "+rs.getString("Farmer_lastName"),rs.getLong("Mobile_Number"), " ",
    			rs.getString("AadhaarNumber"),rs.getString("DateOfBirth"),5,rs.getInt("category"));
    	Administrator_close();}
    	catch (Exception e)
    	{
    		System.out.println("User_details_return");
    		e.printStackTrace();
    	}
    	return ua;
    }
    
    public void Administrator_close() throws Exception
    {
        st.close();
        con.close();
    }
    
    public void load_data_from_file(String location,String table_name)
    {
    	String query = "LOAD DATA INFILE '"+location+"'\r\n"
    			+ "INTO TABLE "+table_name+"\r\n"
    			+ "FIELDS TERMINATED BY ','\r\n"
    			+ "ENCLOSED BY '\"'\r\n"
    			+ "LINES TERMINATED BY '\\n';";
    	try {
			Administrator();
			st.executeUpdate(query);
	    	Administrator_close();
		} catch (Exception e) {
			System.out.println("load_data_from_file");
			e.printStackTrace();
		} 
    	
    }
    
    public void SQL_Exit()
    {
    	for(int z = 0; z < Table_Name.length; z++)
		{
    		super.File_Delete(SQL_location+Table_Name[z]);
    		super.File_Delete(cur_dir+"\\src\\CSV_Files\\"+Table_Name[z]);
		}
    	
    	for(int z = 0; z < Table_Name.length; z++)
		{
    		int l = Table_Name[z].indexOf(".csv");
    		String query = "select * from "+Table_Name[z].substring(0,l)+"\r\n"
    				+ "into outfile '"+Table_Name[z]+"'\r\n"
    				+ "FIELDS TERMINATED BY ','\r\n"
    				+ "ENCLOSED BY '\"'\r\n"
    				+ "LINES TERMINATED BY '\\n';";
    		try {
    			Administrator();
    			st.execute(query);
    			Administrator_close();
    		} catch (Exception e) {
    			System.out.println("Update Failed. Try Again.");
    		} 
		}
    	
    	for(int z = 0; z < Table_Name.length; z++)
		{
			//fm.File_Delete(SQL_location+Table_Name[z]);
    		super.File_copy(SQL_location+Table_Name[z],cur_dir+"\\src\\CSV_Files\\"+Table_Name[z]);
		}
    	
    	
    	
    }
}