package Farmer;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

interface modifies{
	 void crop_update(int fid);
	 void crop_delete(int fid);
}

class cropupdates implements modifies{
	String url = "jdbc:mysql://localhost:3306/RytCrop";
    String uname = "root";
    String pass = "Poojyanth1002@";
	
	public void crop_update(int fid) {
		try {
		     Class.forName("com.mysql.cj.jdbc.Driver");
		     Connection con = DriverManager.getConnection(url,uname,pass);
		     Statement st = con.createStatement();
			  Scanner sc=new Scanner(System.in);
			  System.out.println("enter number of tons :");
			  int ton=sc.nextInt();
			  System.out.println("enter price per ton:");
			  int ppt=sc.nextInt();
			  System.out.println("enter budget of crop:");
			  int budget=sc.nextInt();
			  System.out.println("enter profit of crop:");
			  int profit=sc.nextInt();
			 int rs=st.executeUpdate("update sell set Tons=('"+ton+"'),price_per_tons=('"+ppt+"'),Crop_Budget=('"+budget+"'),Profit=('"+profit+"') where Farmer_Id=('"+fid+"')");
	}
		catch(Exception e){
			System.out.println(e);
		}
	}
	public void crop_delete(int fid) {
		try {
		     Class.forName("com.mysql.cj.jdbc.Driver");
		     Connection con = DriverManager.getConnection(url,uname,pass);
		     Statement st = con.createStatement();
			  Scanner sc=new Scanner(System.in);
			  System.out.println("enter crop id:");
			  String cid=sc.next();
			  int rs=st.executeUpdate("delete from farmer_id where Farmer_Id=('"+fid+"')");
			  int rs1=st.executeUpdate("delete from crop_details where Farmer_Id=('"+fid+"')");
			  int rs2=st.executeUpdate("delete from sell where Farmer_Id=('"+fid+"')");
			  System.out.println("successfully deleted !");
	}
		catch(Exception e) {
			System.out.println(e);
		}
}
}
public class cropmodifications {
	 public void crop_mod(int Uid) {
		 crop_info cf=new crop_info();
     	   crop_details cd=new crop_details();
     	  modifies minsert=new cropupdates();
     	   Scanner sc = new Scanner(System.in);
     	     
           int choice1;
           
           while(true){
          	 System.out.println();
          	 System.out.println("1->printing farmer crop History");
              System.out.println("2->printing Crop Details");
               System.out.println("3->insert/ Register Crop crop data");
               System.out.println("4->update crop data");
               System.out.println("5->delete crop data");
               System.out.println("6->Go to Previous page");
               System.out.println();
          	 System.out.println("enter choice:");
          	  choice1=sc.nextInt();
            	switch(choice1) {
            	case 1:
            		cf.info(Uid);
            		break;
            	case 2:
            		cd.details();
            		break;
            	case 3:
            		RegisterCrop RS = new RegisterCrop();
            		RS.CustomRegistration(Uid);
            		break;
            	case 4:
            		minsert.crop_update(Uid);
            		break;
            	case 5:
            		minsert.crop_delete(Uid);
            		break;
            	case 6:
            		return;
            	default :
            		System.out.println("Enter correct choice:");
            	}
            }
	 }
}
