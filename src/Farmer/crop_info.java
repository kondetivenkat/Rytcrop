package Farmer;
import java.util.*;

public class crop_info extends CropHistory{
	
  public void info(int id) {	
	 
	  Scanner scan=new Scanner(System.in);
	  String namepart;
	  String query1 = "select * from (((farmer_id as f inner join  crop_details as c on f.farmer_id = c.farmer_id)\r\n"
	  		+ "inner join cropname_id as ci on c.crop_id = ci.crop_id) left join sell as s on f.Farmer_Id=s.Farmer_Id and c.Crop_Id=s.Crop_Id);";
	  // System.out.println(query1);
		while(true) {
			System.out.println();
			System.out.println("number 1->search by using id");
			System.out.println("number 2->search by using partial string");
			System.out.println("number 3->go to previous page");
			System.out.println("enter number:");
			int number=scan.nextInt();
			
		 switch(number) {
		   case 1:
			   try {
				   SQLV1(id,query1);
				   
			   }
			   catch(Exception e)
				{
					System.out.println(e);
				}
			   break ;
			   
		   case 2:
			   System.out.println("enter partial name:");
			   namepart=scan.next();
			    
			   try {
				   SQLV1(namepart);

			   }
			   catch(Exception e)
				{
					System.out.println(e);
				}
			   break ;
		   case 3:
			   return;
		   default:
			   System.out.println("give correct match String:");
			   
			   }
	   }


  
  }
}
