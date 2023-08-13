package Farmer;
import java.util.*;

 public abstract class cropdetails{
	  abstract void details();
 }
 class crop_details extends cropdetails{
    public void details() {
    	
    	Scanner scanner=new Scanner(System.in);
    	cropclass sql = new cropclass();
    	
    	String query="select * from avgcrop natural join cropname_id as cid natural join crop_date_season as cds where cds.Crop_Name = cid.Crop_Name;";
    	
        while(true) {
        	System.out.println(" 1->printing single crop details");
			System.out.println(" 2->printing all crop details");
			
			System.out.println("enter your choice");
	        int num=scanner.nextInt();
	        switch(num) {
	        case 1:
	        	System.out.println("enter crop id:");
	        	String cid=scanner.next();
	        try
	   		 {
	   			 sql.SQLV2(cid,query);
	   		 }
	   	  
	   	   
	   		catch(Exception e)
	   		{
	   			System.out.println(e);
	   		}
	        break;
	        
	        case 2:
	        	try
		   		 {
		   			 sql.SQLV2(query);
		   		 }

		   		catch(Exception e)
		   		{
		   			System.out.println(e);
		   		}
	        	break;
	        case 3:
				   return;
				   
			 default:
				   System.out.println("give correct match String:");
				   	
	        }
			
        }
    	 
	    
	    
		
		
    }
}
