package Customer;

public class customer_sign_up {
	private static String username;
	private static String password;
	private static String password1;
	
	
	
	customer_sign_up(String u,String p,String p1)
	{
		username=u;
		password=p;
		password1=p1;
	}
	
	public String getusername()   
    {  
        return username;  
    }  
    public String getpassword()   
    {  
        return password;  
    }  
    public String getpassword1()   
    {  
        return password1;  
    }  
    public void setusername(String u1)
    {  
        username=u1;  
    }  
    public void setpassword(String p1)
    {  
    	password=p1;  
    } 
    public void setpassword1(String p2)
    {  
    	password1=p2;  
    }
    public int check()
    {
    	
    	if (password.equals(password1))
        {
    		SQLcustomer sql1 = new SQLcustomer();
    		String query="insert into customer_login values ('"+username+"','"+password+"');";
    		try
    		{
    			sql1.SQL_UP(query);
    		}
    		catch(Exception e)
    		{
    			System.out.println(e);
    		}
    		System.out.println("User has logged in successfully! ");
            return 1;
        }
        else 
        {
        	System.out.println("ENTER SAME PASSWORD!!");
            return 0;
        }
    	
    }

}
