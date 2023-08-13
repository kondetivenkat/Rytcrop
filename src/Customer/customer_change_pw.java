package Customer;

public class customer_change_pw 
{
	private static String username;
	private static String password,npw;
	customer_change_pw(String u,String p,String p1)
	{
		username=u;
		password=p;
		npw=p1;
	}
    
    void  check() 
    {
		SQLcustomer sql = new SQLcustomer();

		String query1="select * from customer_login;";
		String pw ="";
		int k=0;
		try
		{
			pw=sql.SQL_IN(query1,username);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
    	if (pw.equals(password))
        {
    		String query="update customer_login set c_password = '"+npw+"' where c_username ='"+username+"';";
    		try
    		{
    			sql.SQL_change_pw(query,username,password,npw);
    		}
    		catch(Exception e)
    		{
    			System.out.println(e);
    		}
        }
        else 
        {
        	System.out.println("Enter password correctly!! ");
        }
    }
}
