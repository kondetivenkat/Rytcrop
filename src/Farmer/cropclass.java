package Farmer;
import java.sql.*;


public class cropclass {
	String url = "jdbc:mysql://localhost:3306/RytCrop";
    String uname = "root";
    String pass = "Poojyanth1002@";
	public void SQLV2(String id,String query)throws Exception{
		
        
        String ID="";
        String cname="",season="";
        double nitro = 0,phosp=0,potas=0,temp=0,humid=0,ph=0,rainfall=0;
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url,uname,pass);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int count1=0;
     
     
        for(int i=0;i<100 && rs.next();i++) {
        	 ID=rs.getString("Crop_id");
        	if(ID.equals(id)) {
        	     cname = rs.getString("Crop_Name");
            	 nitro=rs.getDouble("N");
            	 phosp=rs.getDouble("P");
            	 potas=rs.getDouble("K");
            	 temp=rs.getDouble("temperature");
            	 humid=rs.getDouble("humidity");
            	 ph=rs.getDouble("ph");
            	 rainfall=rs.getDouble("rainfall");
            	 season=rs.getString("Season");
            	count1++;
        	}
        	
        }
        System.out.println("printing crop details\n");
        System.out.printf("|%12s|%12s|%12s|%12s|%12s|%12s|%12s|%12s|%12s|%12s|\n","cropid", "cropname" ,"Nitrogen" ,"Phosporous","Potas", "temperature", "humidity" ,"ph","rainfall","Season");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
  
        for(int i=0;i<count1;i++) {
        	
        	System.out.printf("|%12s|%12s|%12f|%12f|%12f|%12f|%12f|%12f|%12f|%12s|\n",id,cname,nitro,phosp,potas,temp,humid,ph,rainfall,season);
        }
        
        
        
        stmt.close();
        conn.close();
    }
	public void SQLV2(String query) throws Exception{
			
	        String[] ID= new String[100];
	        String[] cname= new String[100];
	        String[] season= new String[100];
	        Double[] nitro= new Double[100];
	        Double[] phospo= new Double[100];
	        Double[] potas= new Double[100];
	        Double[] temp= new Double[100];
	        Double[] humid= new Double[100];
	        Double[] ph= new Double[100];
	        Double[] rainfall= new Double[100];
	        
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn = DriverManager.getConnection(url,uname,pass);
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        int count=0;
	        for(int i=0;i<100 && rs.next();i++) {
	        	     ID[count]=rs.getString("Crop_id");
	        	     cname[count] = rs.getString("Crop_Name");
	            	 nitro[count]=rs.getDouble("N");
	            	 phospo[count]=rs.getDouble("P");
	            	 potas[count]=rs.getDouble("K");
	            	 temp[count]=rs.getDouble("temperature");
	            	 humid[count]=rs.getDouble("humidity");
	            	 ph[count]=rs.getDouble("ph");
	            	 rainfall[count]=rs.getDouble("rainfall");
	            	 season[count]=rs.getString("Season");
	            	 count++;
	            
	        	}
	        System.out.println("printing crop details\n");
	        System.out.printf("|%12s|%12s|%12s|%12s|%12s|%12s|%12s|%12s|%12s|%12s|\n","cropid", "cropname" ,"Nitrogen" ,"Phosporous","Potas", "temperature", "humidity" ,"ph","rainfall","Season");
	        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
	  
	        for(int i=0;i<count;i++) {
	        	
	        	System.out.printf("|%12s|%12s|%12f|%12f|%12f|%12f|%12f|%12f|%12f|%12s|\n",ID[i],cname[i],nitro[i],phospo[i],potas[i],temp[i],humid[i],ph[i],rainfall[i],season[i]);
	        }
	        
	        
	        
	        stmt.close();
	        conn.close();
	    }
	      
	}


