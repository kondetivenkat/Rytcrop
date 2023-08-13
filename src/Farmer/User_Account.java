package Farmer;

import java.util.Scanner;

public class User_Account {
	protected int User_ID;
	protected String password;
	protected String User_name;
	protected Long mobile_number;
	protected String Address;
	protected String Aadhaar;
	protected String date_of_birth;
	protected double Land_acres;
	protected Integer category;
	Scanner scan = new Scanner(System.in);
	
	public User_Account()
	{
		this(0, "", "", 0, "", "", "", 0,0);
	}
	
	public User_Account(int u_id)
	{
		this(u_id, "", "", 0, "", "", "", 0,0);
	}
	
	public User_Account(User_Account UA)
	{
		this(UA.get_UID(),UA.get_password(),UA.get_Uname(),UA.get_mobile_number(),
				UA.get_addr(),UA.get_Aadhaar(),UA.get_DOB(),UA.get_land(),UA.get_cat());
	}

	public User_Account(int u_ID, String pwd, String u_Name, long mno, String addr, String aadh, String dob,
			double land,int cat) {
		User_ID = u_ID;
		password = pwd;
		User_name = u_Name;
		mobile_number = mno;
		Address = addr;
		Aadhaar = aadh;
		date_of_birth = dob;
		Land_acres = land;
		category = cat;
	}
	
	public void set_User_Account(int u_ID, String pwd, String u_Name, long mno, String addr, String aadh, String dob,
			double land,int cat) {
		User_ID = u_ID;
		password = pwd;
		User_name = u_Name;
		mobile_number = mno;
		Address = addr;
		Aadhaar = aadh;
		date_of_birth = dob;
		Land_acres = land;
		category = cat;
	}
	
	
	
	public void set_User_Name()
	{
		try {
		System.out.print("Enter User Name : ");
		User_name = scan.nextLine();
		}
		catch (Exception IME)
		{
			System.out.println("Wrong input. Try Again.");
			set_User_Name();
		}
	}
	
	public void set_pwd()
	{
		try {
		System.out.print("Enter new Password : ");
		password = scan.nextLine();
		}
		catch (Exception IME)
		{
			System.out.println("Wrong input. Try Again.");
			set_pwd();
		}
		
	}
	
	public void set_cat()
	{
		try {
			System.out.print("Category : \n"
					+ "1) Farmer\n"
					+ "2) Customer\n"
					+ "3) Government Employee\n"
					+ "Choose a category : ");
			category = scan.nextInt();
			if(category.toString().length() != 1)
				throw new Exception("Wrong Input");
			if(category != 1 && category != 2 && category !=3)
				throw new Exception("Wrong Input");
		}
		catch (Exception IME)
		{
			System.out.println("-----Wrong input. Try Again.-----");
			set_cat();
		}
	}
	
	public void set_mobile_number()
	{
		try {
		System.out.print("Enter your Mobile Number : ");
		mobile_number = Long.parseLong(scan.nextLine());
		if(mobile_number.toString().length() != 10)
			throw new Exception();
		}
		catch (Exception IME)
		{
			System.out.println("-----Wrong input. Try Again.-----");
			set_mobile_number();
		}
	}
	
	public void set_Address()
	{
		try {
		System.out.print("Enter your Address : ");
		Address = scan.nextLine();
		}
		catch (Exception IME)
		{
			System.out.println("Wrong input. Try Again.");
			set_Address();
		}
	}
	
	public void set_Aadhaar()
	{
		try {
		System.out.print("Enter your Aadhaar Number : ");
		Aadhaar = scan.nextLine();
		}
		catch (Exception IME)
		{
			System.out.println("Wrong input. Try Again.");
			set_Aadhaar();
		}
	}
	
	public void set_DOB()
	{
		try {
		System.out.print("Enter your Date of birth (dd-mm-yyyy) : ");
		date_of_birth = scan.nextLine();
		}
		catch (Exception IME)
		{
			System.out.println("Wrong input. Try Again.");
			set_DOB();
		}
	}
	
	public void set_Land_acres()
	{
		try {
		System.out.print("Enter your Land area(acres) : ");
		Land_acres = scan.nextDouble();		
		}
		catch (Exception IME)
		{
			System.out.println("Wrong input. Try Again.");
			set_Land_acres();
		}
	}
	
	public int get_UID()
	{
		return User_ID;
	}
	
	public String get_password()
	{
		return password;
	}
	
	public String get_Uname()
	{
		return User_name;
	}
	
	public int get_cat()
	{
		return category;
	}
	
	public long get_mobile_number()
	{
		return mobile_number;
	}
	public String get_DOB()
	{
		return date_of_birth;
	}
	
	public double get_land()
	{
		return Land_acres;
	}
	
	public String get_addr()
	{
		return Address;
	}
	
	public String get_Aadhaar()
	{
		return Aadhaar;
	}
	
	public String get_All()
	{
		return User_name +" "+ password+ " "+ mobile_number+" "
				+Aadhaar+" "+Address+" "+date_of_birth+" "+Land_acres;
	}

	public User_Account add_account() {
		String query = "insert into UserID_password values("+get_UID()+",'"
				+get_password()+"',"+get_cat()+");";
		
		String query2 = "insert into farmer_details values ("
						+ get_UID()+","+get_mobile_number()+",\""
						+ get_DOB() + "\",\"" + get_Aadhaar() + "\");";
		String query3 = "insert into farmer_id values ("
				+ get_UID() + ", '" + get_Uname() + "','');"; 
		return null;
	}
	 
}
