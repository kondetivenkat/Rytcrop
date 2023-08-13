package Customer;
import java.util.*;

public class buycrop {
	public void buy_crop()
	{
		int log = 0;
		SQLcustomer sql =new SQLcustomer();
		while (log == 0)
		{
		log=customer_login.login();	
		System.out.println();
		if(log==1)//after successfully logging in 
		{
			System.out.println();
			System.out.println("Enter 1 to buy a crop ");
			Scanner scan=new Scanner(System.in);
			int q=scan.nextInt();
		if(q==1)
		{
		String query="Select * from Cropname_Id";
		String query1="Select * from crop_price";
		try
		{
			sql.SQL(query,query1);//to print the crop names along with their present market price
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		System.out.println("Enter the crop id :");
		Scanner sc=new Scanner(System.in);
		String id=sc.nextLine();
		int check=0;
		String cropName = null;
		
		String query3="Select * from sell";//to check whether at least one farmer has produced this crop 
		try
		{
			check=sql.SQL1(query3,id);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		String query5="Select * from crop_price";
		int cropPrice = 0;
		try
		{
			cropPrice=sql.SQL3(query5,id);// to get the selected crop price from the table
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		if(check>0) 
		{
			String query4="Select * from cropname_id";
			try
			{
				cropName=sql.SQL2(query4,id);//to get the crop_name from the id which was entered by the user 
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
			System.out.println("quantity : ");
			int quantity=sc.nextInt();
			cropPrice=cropPrice/1000;
			bill.reciept(id,cropName,quantity,cropPrice);
			
		}
		else
		{
			System.out.println("no Seller is selling the crop");// if check <0 that means there is no farmer selling that crop
		}
	}scan.close();
	}
		else
		{
			System.out.println("Wrong UserName / Password\n");
		}
		}
	}
}
