package Customer;
import java.util.*;

public class customer_login {
	public static  int login()
	{
		//String UN="teja";
		//String PW="1234";
		Scanner in = new Scanner(System.in);
		System.out.println("1: Sign_in");
		System.out.println("2: Sign_up");
		System.out.println("3: Change_Password");
		System.out.println("4: Delete account");
		System.out.println("choice : ");
		int choice = in.nextInt();
		int k=0;
		
		if(choice==1)
		{
			System.out.println("Please enter username");
		    String UN = in.next();
		    System.out.println("Please enter password");
		    String PW = in.next();
		    customer_sign_in si = new customer_sign_in(UN,PW);
		    k= si.check();
		}
		if(choice==2)
		{
			System.out.println("Please enter username");
		    String UN1 = in.next();
		    System.out.println("Please enter password");
		    String PW1 = in.next();
		    System.out.println("Please enter password again");
		    String PW2 = in.next();
		    customer_sign_up su = new customer_sign_up(UN1,PW1,PW2);
		    k= su.check();
		}
		if(choice==3)
		{
			System.out.println("Please enter username");
		    String cUN = in.next();
		    System.out.println("Please enter password");
		    String cPW = in.next();
		    System.out.println("Please enter new password");
		    String cPWN = in.next();
		    customer_change_pw cp = new customer_change_pw(cUN,cPW,cPWN);
		    cp.check();
		    k=1;
		}
		if(choice==4)
		{
			System.out.println("Please enter username");
		    String dUN = in.next();
		    System.out.println("Please enter password");
		    String dPW = in.next();
		    customer_delete cp = new customer_delete(dUN,dPW);
		    cp.check();
		    k=1;
		}
		return k;
	    
	}
	}


