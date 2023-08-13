package Farmer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddCropData extends RegisterCrop{
	public void SQL(int farmerID,String cropID)
	{       
		 SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YYYY");  
		 Date date = new Date();  
		 String date_str = (formatter.format(date));  
		
		
		SQLQueryProcessing sql = new SQLQueryProcessing();
        String query = "insert into crop_details values("+farmerID+",'"+cropID+"',\""+
		date_str+"\",\"\");";
        
        try 
		{
			 sql.update_table(query);
			 
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
        
	}
}
