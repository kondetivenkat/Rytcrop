package Farmer;
import java.sql.*;

import java.util.*;

interface Governmentschemes
{
	public void subscidies();
	public void machinary();
	public void governmentloans(int a,int b);
}


class Governmentactions implements Governmentschemes
{
	public void machinary()
	{
		System.out.printf("\n\nGovernment Funded Equipments ::::\n\n");
		System.out.println("Seeds, Urea, 25 grades for P&K fertilizers, mulcher, cutter, spreader, rotatorplough");
	}
	
	public void subscidies()
	{
		System.out.printf("\n\nGovernment Subscidies ::::\n\n");
		System.out.println("30 percent of the cost of high end equipments like tractors, 100 percent for transport machinary");
	}
	
	public void governmentloans(int acre,int investment)
	{
		System.out.printf("\n\nGovernemt Loans :\n\n");
		System.out.println("Loan will be provided as less as at 7 percent rate of interest in all Government banks");
	}
}

class GovernmentBankLoans extends Governmentactions
{
	@Override
	public void governmentloans(int acre,int investment)
	{
		System.out.printf("\n\nYour Financial Profile ::::\n\n");
		System.out.println("Your Investment approximately = "+ investment);
		System.out.printf("\nYour Bank loan interest = 7%% of investment = %.2f as interest per year\n",0.07*investment);
		double a = 1.07*investment;
		double b = acre*5000;
		double c = a-b;
		System.out.println("\nGovernment fund under RAITHU YOJANA is 5000 per acre = "+acre*5000);
		System.out.printf("\nAmount payable by you approximately after deducting Government fund is approximately = %.2f  per year.",c);
	}
}


public class AidRequest{
     public void aid(int perno)
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
        String cpname;
        int acreno,pid,investment;
        Governmentactions obj = new Governmentactions();
        GovernmentBankLoans obj1 = new GovernmentBankLoans();
        System.out.println("\n\nGOVERNMENT OF INDIA WELCOMES YOU\n");
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        System.out.print("Enter your Crop ID : \t");
        
        String crid = sc.nextLine();
        int check = 0;
        ResultSet rs1 = st.executeQuery(query);
        while(rs1.next())
        {
        	userData =  rs1.getString(5);
        	pid = rs1.getInt(1);
        	if(crid.equals(userData)&&perno==pid)
        	{
        		check=1;
        		System.out.println("Your Crop is Found");
        		cpname = rs1.getString(8);
        		if(cpname.equals("mango"))
        		{
        			System.out.println("Enter number of acers of your crop :");
        			acreno = sc1.nextInt();
        			investment = acreno*80000;
        			obj.subscidies();
        			obj.machinary();
        			obj1.governmentloans(acreno,investment);
        			break;
        		}
        		else if(cpname.equals("rice"))
        		{
        			System.out.println("Enter number of acers of your crop :");
        			acreno = sc1.nextInt();
        			investment = acreno*17000;
        			obj1.governmentloans(acreno,investment);
        			obj.subscidies();
        			obj.machinary();
        			break;
        		}
        		else if(cpname.equals("maize"))
        		{
        			System.out.println("Enter number of acers of your crop :");
        			acreno = sc1.nextInt();
        			investment = acreno*15200;
        			obj1.governmentloans(acreno,investment);
        			obj.subscidies();
        			obj.machinary();
        			
        			break;
        		}
        		else if(cpname.equals("chickpea"))
        		{
        			System.out.println("Enter number of acers of your crop :");
        			acreno = sc1.nextInt();
        			investment = acreno*11250;
        			obj1.governmentloans(acreno,investment);
        			obj.subscidies();
        			obj.machinary();
        			
        			break;
        		}
        		else if(cpname.equals("kidneybeans"))
        		{
        			System.out.println("Enter number of acers of your crop :");
        			acreno = sc1.nextInt();
        			investment = acreno*10600;
        			obj1.governmentloans(acreno,investment);
        			obj.subscidies();
        			obj.machinary();
        			
        			break;
        		}
        		else if(cpname.equals("pigeonpeas"))
        		{
        			System.out.println("Enter number of acers of your crop :");
        			acreno = sc1.nextInt();
        			investment = acreno*14200;
        			obj1.governmentloans(acreno,investment);
        			obj.subscidies();
        			obj.machinary();
        			
        			break;
        		}
        		else if(cpname.equals("mothbeans"))
        		{
        			System.out.println("Enter number of acers of your crop :");
        			acreno = sc1.nextInt();
        			investment = acreno*13900;
        			obj1.governmentloans(acreno,investment);
        			obj.subscidies();
        			obj.machinary();
        			
        			break;
        		}
        		else if(cpname.equals("mungbean"))
        		{
        			System.out.println("Enter number of acers of your crop :");
        			acreno = sc1.nextInt();
        			investment = acreno*12600;
        			obj1.governmentloans(acreno,investment);
        			obj.subscidies();
        			obj.machinary();
        			
        			break;
        		}
        		else if(cpname.equals("blackgram"))
        		{
        			System.out.println("Enter number of acers of your crop :");
        			acreno = sc1.nextInt();
        			investment = acreno*14200;
        			obj1.governmentloans(acreno,investment);
        			obj.subscidies();
        			obj.machinary();
        			
        			break;
        		}
        		else if(cpname.equals("lentil"))
        		{
        			System.out.println("Enter number of acers of your crop :");
        			acreno = sc1.nextInt();
        			investment = acreno*16400;
        			obj1.governmentloans(acreno,investment);
        			obj.subscidies();
        			obj.machinary();
        			
        			break;
        		}
        		else if(cpname.equals("pomegranate"))
        		{
        			System.out.println("Enter number of acers of your crop :");
        			acreno = sc1.nextInt();
        			investment = acreno*46000;
        			obj1.governmentloans(acreno,investment);
        			obj.subscidies();
        			obj.machinary();
        			
        			break;
        		}
        		else if(cpname.equals("banana"))
        		{
        			System.out.println("Enter number of acers of your crop :");
        			acreno = sc1.nextInt();
        			investment = acreno*65000;
        			obj1.governmentloans(acreno,investment);
        			obj.subscidies();
        			obj.machinary();
        			
        			break;
        		}
        		
        		else if(cpname.equals("grapes"))
        		{
        			System.out.println("Enter number of acers of your crop :");
        			acreno = sc1.nextInt();
        			investment = acreno*60000;
        			obj1.governmentloans(acreno,investment);
        			obj.subscidies();
        			obj.machinary();
        			
        			break;
        		}
        		else if(cpname.equals("watermelon"))
        		{
        			System.out.println("Enter number of acers of your crop :");
        			acreno = sc1.nextInt();
        			investment = acreno*53000;
        			obj1.governmentloans(acreno,investment);
        			obj.subscidies();
        			obj.machinary();
        			
        			break;
        		}
        		else if(cpname.equals("muskmelon"))
        		{
        			System.out.println("Enter number of acers of your crop :");
        			acreno = sc1.nextInt();
        			investment = acreno*46000;
        			obj1.governmentloans(acreno,investment);
        			obj.subscidies();
        			obj.machinary();
        			
        			break;
        		}
        		else if(cpname.equals("apple"))
        		{
        			System.out.println("Enter number of acers of your crop :");
        			acreno = sc1.nextInt();
        			investment = acreno*90000;
        			obj1.governmentloans(acreno,investment);
        			obj.subscidies();
        			obj.machinary();
        			
        			break;
        		}
        		else if(cpname.equals("orange"))
        		{
        			System.out.println("Enter number of acers of your crop :");
        			acreno = sc1.nextInt();
        			investment = acreno*43000;
        			obj1.governmentloans(acreno,investment);
        			obj.subscidies();
        			obj.machinary();
        			
        			break;
        		}
        		else if(cpname.equals("papaya"))
        		{
        			System.out.println("Enter number of acers of your crop :");
        			acreno = sc1.nextInt();
        			investment = acreno*35000;
        			obj1.governmentloans(acreno,investment);
        			obj.subscidies();
        			obj.machinary();
        			
        			break;
        		}
        		else if(cpname.equals("coconut"))
        		{
        			System.out.println("Enter number of acers of your crop :");
        			acreno = sc1.nextInt();
        			investment = acreno*54000;
        			obj1.governmentloans(acreno,investment);
        			obj.subscidies();
        			obj.machinary();
        			
        			break;
        		}
        		else if(cpname.equals("cotton"))
        		{
        			System.out.println("Enter number of acers of your crop :");
        			acreno = sc1.nextInt();
        			investment = acreno*61000;
        			obj1.governmentloans(acreno,investment);
        			obj.subscidies();
        			obj.machinary();
        			
        			break;
        		}
        		else if(cpname.equals("jute"))
        		{
        			System.out.println("Enter number of acers of your crop :");
        			acreno = sc1.nextInt();
        			investment = acreno*42000;
        			obj1.governmentloans(acreno,investment);
        			obj.subscidies();
        			obj.machinary();
        			
        			break;
        		}
        		else if(cpname.equals("coffee"))
        		{
        			System.out.println("Enter number of acers of your crop :");
        			acreno = sc1.nextInt();
        			investment = acreno*60000;
        			obj1.governmentloans(acreno,investment);
        			obj.subscidies();
        			obj.machinary();
        			
        			break;
        		}
        	}
        	
        	
        }
        
        if(check==0)
    	{
    		System.out.printf("Person Id or Crop Id is Wrong ...\n");
    		System.out.println("Please Try Again ...");
    	}
        check=0;
        st.close();
        con.close();
    	 }
    	 catch(Exception e)
    	 {
    		 System.out.println(e);
    	 }
     }
}
