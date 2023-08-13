package Government;
import java.sql.*;
public class Government{
     public void Gov()
     {
    	 try {
    	 String url = "jdbc:mysql://localhost:3306/rytcrop";
    	 String uname = "root";
    	 String pass = "Poojyanth1002@";
    	 String query = "select * from farmer_id f inner join crop_details c on f.Farmer_Id = c.Farmer_Id inner join cropname_id cd on c.Crop_Id = cd.Crop_Id";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        String userData;
        while(rs.next())
        {
        	userData = rs.getInt(1) + " ::: "+ rs.getString(2) + " " + rs.getString(3) + " \t\t::: " + rs.getString(5)+ " ::: " + rs.getString(6) + " --> "+ rs.getString(7) + " \t\t::: "+ rs.getString(8) ;
        	System.out.println(userData+"\n");
        }
        
        st.close();
        con.close();
    	 }
    	 catch (Exception e)
    	 {
    		 System.out.println(e);
    	 }
     }
}