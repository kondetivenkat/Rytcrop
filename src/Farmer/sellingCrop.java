package Farmer;

import java.text.SimpleDateFormat;
import java.util.*;
public class sellingCrop 

{
	public void sellCrop(int Uid)
	{
		System.out.println("\nYour Crops presently available to sell : ");
		SQLselling sql = new SQLselling();
		//
		String query="select * from cropname_id \r\n"
				+ "where Crop_ID in \r\n"
				+ "(select Crop_Id from Crop_details where Farmer_Id = "+Uid+" and date_out = '')";
		try
		{
			sql.SQL(query);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		int fid=Uid;
		int price=0;
		Scanner obj=new Scanner(System.in);
		
		System.out.println("ENTER THE CROP_ID YOU WNAT TO SELL :");
		String id1= obj.nextLine();
		
		System.out.println("Enter tons of crop produced : ");
		double tons=obj.nextDouble();
		
		System.out.println("Enter crop budget  : ");
		double budget=obj.nextDouble();
		
		//change date format
		SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-YYYY");
        Calendar cal = Calendar.getInstance();
        String date= myFormat.format(cal.getTime());
        
		String query2="select * from crop_price;";
		try
		{
			price = sql.SQL2(query2,id1);
			System.out.println("Market Price per one Ton:  "+price);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		double profit=(tons*price)-budget;
		
		if(profit>0)
		{
			System.out.println("profit : "+profit);
		}
		else
		{
			double loss=(-1)*profit;
			System.out.println("loss : "+loss);
		}
		
		String query1="insert into sell values ("+fid+",'"+date+"','"+id1+"',"+tons+","+price+","+budget+","+profit+");";
		//Insert into Crop_details
		String query_2 = "update crop_details\r\n"
				+ "set Date_Out = '"+date+"'\r\n"
				+ "where Farmer_Id  = "+Uid+" and Crop_Id = '"+id1+"' and date_out = '';";
		try
		{
			sql.SQL1(query1);
			sql.SQL1(query_2);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		System.out.println("Successfully added to database");
		
	}
	
}
