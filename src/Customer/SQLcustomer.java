package Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLcustomer {
	String url = "jdbc:mysql://localhost:3306/RytCrop";
    String uname = "root";
    String pass = "Poojyanth1002@";

    public String SQL_IN(String query,String un) throws Exception
    {
    	
        String p1="";
        int k=0;
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        for(int i = 0; i < 100&&rs.next();i++) 
        {
        String name = rs.getString("c_username");
        if(name.equals(un))
        {
        	p1 = rs.getString("c_password");
        	k++;
        }
        }
       if(k==0)
       {
    	   System.out.println("NO SUCH USER EXISTS !!");
       }
        st.close();
        con.close();
        return p1; 
    }
    public void SQL_UP(String query) throws Exception
    {       
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        Statement st = con.createStatement();
        int count = st.executeUpdate(query);
        System.out.println(count + "row/s affected");
       
        st.close();
        con.close();
    }
    public void SQL_change_pw(String query,String username,String p,String p1)throws Exception
    {
    	Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        	PreparedStatement s = con.prepareStatement(query);
            s.execute();
            System.out.println("Password changed successfully ");
        con.close();
    }
    public void SQL_delete(String query)throws Exception
    {
    	Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        	PreparedStatement s = con.prepareStatement(query);
            s.execute();
            System.out.println("Account deleted successfully");
        con.close();
    }
    public void SQL(String query,String query1) throws Exception
    {
        String[] cropName= new String[22]; 
        String[] cropId= new String[22]; 
        int[] cropPrice= new int[22];
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        for(int i = 0; i < 22&&rs.next();i++) 
        {
        String name = rs.getString("Crop_Name");
        cropName[i]=name;
        String name1 = rs.getString("Crop_id");
        cropId[i]=name1;
        }
        
        ResultSet rs1 = st.executeQuery(query1);
        for(int i = 0; i < 22&&rs1.next();i++) 
        {
        int price = rs1.getInt("price");
        cropPrice[i]=price;
        }
        System.out.println("price of crop per kg :");
        for(int i=0;i<22;i++)
        {
        	System.out.println(cropId[i]+  ":\t"   +cropName[i]+" -"+cropPrice[i]/1000+" Rs/kg");
        }
        st.close();
        con.close();
    }
    public int SQL1(String query,String id1) throws Exception
    {
        int name1=0;
        int k=0;
        
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        //ResultSet rs1 = st.executeQuery(query);
        
        for(int i = 0; i < 25&&rs.next();i++) 
        {
        String name = rs.getString("Crop_id");
        if(name.equals(id1))
        {
        	k++;
        }
        }
       
        st.close();
        con.close();
		return k;
    }
    public String SQL2(String query,String id1) throws Exception
    {
        int name1=0;
        int k=0;
        String cropName="";
        
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        for(int i = 0; i < 25&&rs.next();i++) 
        {
        String id = rs.getString("Crop_id");
        String name = rs.getString("Crop_Name");
        if(id.equals(id1))
        {
        	cropName=name;
        }
        }
       
        st.close();
        con.close();
		return cropName;
    }
    public int SQL3(String query,String id1) throws Exception
    {
        int name1=0;
        int k=0;
        String cropName="";
        int cropPrice=0;
        
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        for(int i = 0; i < 25&&rs.next();i++) 
        {
        String name = rs.getString("Crop_id");
        int Price = rs.getInt("price");
        if(name.equals(id1))
        {
        	cropPrice=Price;
        }
        }
       
        st.close();
        con.close();
		return cropPrice;
    }

}
