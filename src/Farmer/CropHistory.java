package Farmer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class CropHistory {
	String url = "jdbc:mysql://localhost:3306/RytCrop";
    String uname = "root";
    String pass = "Poojyanth1002@";
    
    
    public void SQLV1(int id1,String query) throws Exception
    {
        String tst = "";
        String name="";
        String[] dateout= new String[100];
        String[] production= new String[100];
        String[] price= new String[100];
        String[] budget= new String[100];
        String[] profit= new String[100];
        String[] crop_id= new String[100];
        String[] datein= new String[100];
        String[] cropname= new String[100];
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        Statement st = con.createStatement();
       
        int count1=0;
      
       ResultSet rs = st.executeQuery(query);  
      
       for(int i = 0; i < 100&&rs.next();i++) {
        	int id = rs.getInt("Farmer_Id");
        	
        if(id==id1)
        {
        	
        	name = rs.getString("Farmer_FirstName");
        	crop_id[count1]=rs.getString("Crop_Id");
        	if(i == 1) tst = crop_id[count1];
        	cropname[count1]=rs.getString("Crop_Name");
        	datein[count1]=rs.getString("Date_in");
        	dateout[count1]=rs.getString("Date_out");
        	production[count1] = rs.getString("Tons");
        	price[count1] = rs.getString("price_per_tons");
        	budget[count1] = rs.getString("Crop_Budget");
        	profit[count1] = rs.getString("Profit");
        	count1++;
        }
        }

        System.out.println("Farmer_id :"+id1);        
        System.out.println("Farmer_FirstName :"+name);
        System.out.println();
        System.out.printf("|%12s|%12s|%12s|%12s|%12s|%12s|%12s|%12s|\n","cropid", "cropname" ,"Datein" ,"Dateout","Tones", "price/tones", "budget" ,"profit");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
  
        for(int i=0;i<count1;i++) {
        	//if(crop_id[i] != tst)
        	System.out.printf("|%12s|%12s|%12s|%12s|%12s|%12s|%12s|%12s|\n",crop_id[i],cropname[i],datein[i],dateout[i],production[i],price[i],budget[i],profit[i]);
        }
        
        
        st.close();
        con.close();
    }
    public void SQLV1(String partialname) throws Exception {
        String[] dateout= new String[100];
        String[] production= new String[100];
        String[] price= new String[100];
        String[] budget= new String[100];
        String[] profit= new String[100];
        String[] crop_id= new String[100];
        String[] datein= new String[100];
        String[] cropname= new String[100];
        int id1[]=new int[100];
        String Name[]=new String[100];
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        Statement st = con.createStatement();
       
        String query2=  "select * from (((farmer_id as f inner join  crop_details as c on f.farmer_id = c.farmer_id)\r\n"
   	                 		+ " inner join cropname_id as ci on c.crop_id = ci.crop_id) inner join sell as s on f.Farmer_Id=s.Farmer_Id and c.Crop_Id=s.Crop_Id)";
        		
        
        
        ResultSet rs1 = st.executeQuery(query2);
        
        int count1=0;
        while(rs1.next()) {
        	 Name[count1]=rs1.getString("Farmer_FirstName");
        	if(Name[count1].contains(partialname)) {
        		id1[count1] = rs1.getInt("Farmer_Id");
          	    crop_id[count1]=rs1.getString("Crop_Id");
            	cropname[count1]=rs1.getString("Crop_Name");
            	datein[count1]=rs1.getString("Date_in");
            	dateout[count1]=rs1.getString("Date_out");
            	production[count1] = rs1.getString("Tons");
            	price[count1] = rs1.getString("price_per_tons");
            	budget[count1] = rs1.getString("Crop_Budget");
            	profit[count1] = rs1.getString("Profit");
            	
            	count1++;
          		
        	}

        }
        
        System.out.println();
        
        for(int i=0;i<count1;i++) {
        	System.out.printf("Farmer_id :%d\n",id1[i]);        
            System.out.printf("Farmer_FirstName :%s\n",Name[i]);
            System.out.printf("|%12s|%12s|%12s|%12s|%12s|%12s|%12s|%12s|\n","cropid", "cropname" ,"Datein" ,"Dateout","Tones", "price/tones", "budget" ,"profit");
            System.out.println("-----------------------------------------------------------------------------------------------------------");
      
        	System.out.printf("|%12s|%12s|%12s|%12s|%12s|%12s|%12s|%12s|\n",crop_id[i],cropname[i],datein[i],dateout[i],production[i],price[i],budget[i],profit[i]);
        }
  
        st.close();
        con.close();
    }
}