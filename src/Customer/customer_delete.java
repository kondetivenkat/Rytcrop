package Customer;

public class customer_delete {
	private static String username;
	private static String password;
	customer_delete(String u,String p)
	{
		username=u;
		password=p;
	}
    
    void check() 
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
    		String query="delete from customer_login where c_username='"+username+"'";
    		try
    		{
    			sql.SQL_delete(query);
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
