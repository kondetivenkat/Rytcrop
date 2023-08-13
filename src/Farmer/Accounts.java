package Farmer;

import java.util.Scanner;

public class Accounts extends User_Account 
{
	public Accounts(int U_ID)
	{
		super(U_ID);
	}
	
	public Accounts()
	{
		super(0);
	}
	
	@Override
	public User_Account add_account()
	{
		Scanner scan = new Scanner(System.in);
		int count = 0;
		String query = "select count(User_ID) as count from UserID_password;";
		SQLQueryProcessing sql = new SQLQueryProcessing();
        
        try 
		{
			 count = Integer.parseInt(sql.result_ret(query,"count",1));
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
		
		int  cat;
		//User_Account U_A = new User_Account(U_ID);
		super.set_User_Name();
		super.set_pwd();
		super.set_mobile_number();
		super.set_Aadhaar();
		super.set_Address();
		super.set_DOB();
		super.set_cat();
		cat = super.get_cat();
		if(cat == 1)
			super.set_Land_acres();
		query = "insert into UserID_password values("+super.get_UID()+",'"
				+super.get_password()+"',"+super.get_cat()+");";
		
		String query2 = "insert into farmer_details values ("
						+ super.get_UID()+","+super.get_mobile_number()+",\""
						+ super.get_DOB() + "\",\"" + super.get_Aadhaar() + "\");";
		String query3 = "insert into farmer_id values ("
				+ super.get_UID() + ", '" + super.get_Uname() + "','');"; 
		
		try {
			sql.update_table(query);
			sql.update_table(query2);
			sql.update_table(query3);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		System.out.println("\nAccount Created.");
		System.out.println("Your USER ID is\t"+ super.get_UID() +"\n");
		return this;
		
	}
	
	public boolean Account_Login(int Uid,String pwd)
	{
		//System.out.println("A"+get_UID()+"B");
		SQLQueryProcessing sql = new SQLQueryProcessing();
		boolean fl = false;
		String query = "select * from UserID_Password "
				+ "where User_ID = "+Uid+" and password = \""+pwd+"\" ;";
		try {
			//System.out.println(query);
			if(sql.UserID_pwd_check(query))
			{
				//System.out.println("OK");
				fl = true;
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return fl;
	}
	
	public void set_User_Account(User_Account UA)
	{
		this.User_ID = UA.get_UID();
		this.password = UA.get_password();
		this.User_name = UA.get_Uname();
		this.mobile_number = UA.get_mobile_number();
		this.Address = UA.get_addr();
		this.Aadhaar = UA.get_Aadhaar();
		this.date_of_birth = UA.get_DOB();
		this.Land_acres = UA.get_land();
		this.category = UA.get_cat();
	}
	
}
