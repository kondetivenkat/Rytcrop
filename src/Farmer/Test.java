package Farmer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
	
	protected Connection con;
	protected Statement st;
	protected ResultSet rs;
	
	private void Administrator() throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/";
        String uname = "root";
        String pass = "Poojyanth1002@";
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url,uname,pass);
        st = con.createStatement();
        
	}
	public void Administrator_close() throws Exception
    {
        st.close();
        con.close();
        
    }
	
	public void testUP()
	{
		try {
			Administrator();
			String sl = "create database RytCrop";
			st.executeUpdate(sl);
			Administrator_close();
		} catch (Exception e) {
			try {
				Administrator_close();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		
		File_Manager fm = new File_Manager();
		String cur_dir = System.getProperty("user.dir").toString();
		fm.File_copy("C:\\Users\\POOJYANTH REDDY\\eclipse-workspace\\ProjectRytCrop\\src\\crop_details.csv", "C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\rytcrop\\farmer_id.csv");
	}
}
