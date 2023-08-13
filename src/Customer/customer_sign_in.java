package Customer;

public class customer_sign_in {
	
	private static String username;
	private static String password,pw;
	
	//private static String un="teja";
	//private static String pw="1234";
	
	
	
	customer_sign_in(String u,String p)
	{
		username=u;
		password=p;
	}
	
	public String getusername()   
    {  
        return username;  
    }  
    public String getpassword()   
    {  
        return password;  
    }  
    public void setusername(String u1)
    {  
        username=u1;  
    }  
    public void setpassword(String p1)
    {  
    	password=p1;  
    }
    
    
    
    int  check()
    {
		SQLcustomer sql = new SQLcustomer();
		String query="select * from customer_login;";
		String pw ="";
		try
		{
			pw=sql.SQL_IN(query,username);
			//System.out.println(pw.equals(password));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
    	if (pw.equals(password))
        {
    		System.out.println("User has logged in successfully! ");
            return 1;
        }
        else 
        {
        	System.out.println("User has not logged in successfully! ");
            return 0;
        }
    	
    }

}
