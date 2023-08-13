package Farmer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLselling {
    public void SQL(String query) throws Exception
    {
        String url = "jdbc:mysql://localhost:3306/RytCrop";
        String uname = "root";
        String pass = "Poojyanth1002@";
        
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        for(int i = 0; i < 25&&rs.next();i++) 
        {
        String name = rs.getString("Crop_Name");
        String name1 = rs.getString("Crop_id");
        System.out.println(name1+"\t-\t"+name);
        }
       
        st.close();
        con.close();
    }
    public int SQL2(String query,String id1) throws Exception
    {
        String url = "jdbc:mysql://localhost:3306/RytCrop";
        String uname = "root";
        String pass = "Poojyanth1002@";
        int name1=0;
        
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        for(int i = 0; i < 25&&rs.next();i++) 
        {
        String name = rs.getString("Crop_id");
        if(name.equals(id1))
        {
        	name1 = rs.getInt("price");
        }
        }
       
        st.close();
        con.close();
		return name1;
    }
    public void SQL1(String query) throws Exception
    {
        String url = "jdbc:mysql://localhost:3306/RytCrop";
        String uname = "root";
        String pass = "Poojyanth1002@";
        
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        Statement st = con.createStatement();
        int count = st.executeUpdate(query);
        //System.out.println(count + "row/s affected");
       
        st.close();
        con.close();
    }
}

