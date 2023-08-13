package Farmer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Customer.buycrop;
import Government.Government;


public class Main{
	
	public static void main(String  args[]) throws NumberFormatException, IOException
	{
																// IF ELSE FOR COMMAND LINE ARGUMENTS
		if(args[0].equals("h") || args[0].equals("help"))
		{
			System.out.println("Please Check the ReadMe file in the Project Folder");
		}
		else if(args[0].equals("v") || args[0].equals("version"))
		{
			System.out.println("Project RytCrop : version : 1.08");
		}
		else if(args[0].equals("r") || args[0].equals("run"))
		{
			SQLQueryProcessing sql = new SQLQueryProcessing();
			sql.SQLQueryProcessing_upload();
			Scanner input = new Scanner(System.in);
			int Uid = 0, choice;
			boolean login = false,fl = true;
			String pwd = "";
			Accounts ac = new Accounts();
			RegisterCrop RS = new RegisterCrop();
			sellingCrop sc = new sellingCrop();
			ArrayList<User_Account> U_Accs = new ArrayList<User_Account>(); 
			
			//	creating a new USER ID for Sign UP 
			try {
				Uid = Integer.parseInt(
						(new SQLQueryProcessing().result_ret(
								"select * from userid_password order by User_ID desc;","User_ID",1)));
				Uid++;
			}
			catch(Exception e)
			{
				System.out.println("-------Please Restart the Program after Checking the .csv Files.-------\n");
				System.exit(-1);
				System.out.println(e);
			}
			// MAIN LOOP
			while(true) 
			{
				try 
				{
					System.out.print("Enter as :");
					System.out.println("\t1) Farmer \t2) Customer \t3) Government Employee\n");
					System.out.print("Enter your choice :\t");
					int enter = input.nextInt();
					System.out.println("\n");
					
					switch(enter)
					{
					case 1 :
						System.out.println("---------Entered as Farmer---------\n");
													//		LOOP FOR WHOLE CODE FROM SIGN-IN AND SIGNUP
						while(fl) 
						{
							System.out.println("1) SIGN IN\t2) SIGN UP\t3) GO TO PREVIOUS PAGE\t-1) Exit");
							System.out.print("Enter your choice : ");
							choice = input.nextInt();
							System.out.println();
													//		CHOICE FOR SIGN-IN AND SIGN-UP OR EXIT
							switch(choice) 
							{
							
							//		SIGN-IN
							case 1:
								System.out.print("Enter your User ID(Farmer) : ");
								int Uid_2 = input.nextInt();
								System.out.print("Enter your Password : ");
								pwd = input.nextLine();
								pwd = input.nextLine();
								
								login = ac.Account_Login(Uid_2,pwd);
								
								if(login)
								{
									// SQL Query for User Accounts extraction
									String query = "select User_ID, password, category, Mobile_Number, DateOfBirth,"
											+ " AadhaarNumber, fid.Farmer_FirstName, fid.Farmer_lastName from "
											+ "(UserID_Password up inner join farmer_details fd on up.User_ID = fd.Farmer_ID )"
											+ " inner join farmer_id fid on fd.Farmer_ID = fid.Farmer_ID  "
											+ "where User_ID = "+Uid_2+" and password = \""+pwd+"\" ;";
									
									ac.set_User_Account((new SQLQueryProcessing()).User_details_return(query));
									fl = false;
								}
								else
								{
									System.out.println("\n-------Wrong UID / Password. Try Again.-------\n");
								}
								
								while(login)
								{
									System.out.println("\n  Available Actions");
									System.out.println(" 1) Crop Registration");
									System.out.println(" 2) Crop History");
									System.out.println(" 3) Sell Crop");
									System.out.println(" 4) Request Aid");
									System.out.println("-1) Exit");
									System.out.print("Enter your choice : ");
									int ch = input.nextInt();
									
									switch(ch)
									{
									case 1 :
										RS.CustomRegistration(ac.get_UID());
										break;
										
									case 2 : 
										cropmodifications cmfd = new cropmodifications();
										cmfd.crop_mod(ac.get_UID());
										break;
										
									case 3 :
										sc.sellCrop(ac.get_UID());
										break;
										
									case 4 :
										AidRequest aid =  new AidRequest();
										aid.aid(ac.get_UID());
										break;
										
									case -1	:
									 //System.out.println(TC.time_end());
										input.close();
										sql.SQL_Exit();
										System.out.println("-Exit-");
										input.close();
										System.exit(-1);
										break;
										
									default : 
										System.out.println("\n-------Wrong Input. Try Again.-------\n");
									}			
								}
								break;
								
							//		SIGN-UP
							case 2:
								Accounts newUA = new Accounts(Uid++);
								U_Accs.add(newUA.add_account());
								fl = true;
								break;
								
							//		GO TO PREVIOUS PAGE
							case 3:
								fl = false;
								break;
								
							//		EXIT CODE 
							case -1:
								sql.SQL_Exit();
								input.close();
								System.out.println("--EXIT--");
								System.exit(-1);
								break;
								
							//		DEFAULT CASE / INVALID CHOICE
							default : 
								System.out.println("\n-------Wrong Input. Try Again.-------\n");
							}
						}
						break;
					
					//		CUSTOMER 
					case 2:
						System.out.println("---------Entered as Customer---------\n");
						buycrop Buy = new buycrop();
						Buy.buy_crop();
						sql.SQL_Exit();
						break;
					
					// GOVERNMENT EMPLOYEE
					case 3:
						System.out.println("---------Entered as Government Employee---------\n");
						System.out.println("1) SignIn\t2) SignUp\t-1) Exit");
						System.out.print("Enter your choice : ");
						choice = input.nextInt();
						System.out.println();
						
						//		CHOICE FOR SIGN-IN AND SIGN-UP OR EXIT
						switch(choice) 
						{
						case 1 :
							System.out.print("Enter your User ID(Government) : ");
							int Uid_2 =input.nextInt();
							System.out.print("Enter your Password : ");
							pwd = input.nextLine();
							pwd = input.nextLine();
							
							login = ac.Account_Login(Uid_2,pwd);
							
							if(login)
							{
								String query = "select User_ID, password, category, Mobile_Number, DateOfBirth,"
										+ " AadhaarNumber, fid.Farmer_FirstName, fid.Farmer_lastName from "
										+ "(UserID_Password up inner join farmer_details fd on up.User_ID = fd.Farmer_ID )"
										+ " inner join farmer_id fid on fd.Farmer_ID = fid.Farmer_ID  "
										+ "where User_ID = "+Uid_2+" and password = \""+pwd+"\" ;";
										System.out.println(query);
								ac.set_User_Account((new SQLQueryProcessing()).User_details_return(query));
								//if(ac.get_cat() == 3) 
								{
								Government govern = new Government();
								govern.Gov();
								}
								//else
								//{
									//System.out.println("-------Your Account is not a Government Account.-------\n");
								//}
							}
							else 
							{
								System.out.println("\n-------Wrong UID / Password. Try Again.-------\n");
							}
							break;
						case 2 :
							U_Accs.add((new Accounts(Uid++)).add_account());
							break;
						}
						sql.SQL_Exit();
						break;
					default :
						System.out.println("\n-------Wrong Input. Try Again.-------\n");
						
					}
				}
				catch (InputMismatchException ime)
				{
					System.out.println("\n-------Wrong Input. Try Again.-------\n");
					input.next();
				}
				catch (Exception e)
				{
					System.out.println(e);
					System.out.println("Please Restart the Program.");
				}
			}
		}
	}
}