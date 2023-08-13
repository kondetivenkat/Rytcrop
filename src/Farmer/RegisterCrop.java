package Farmer;

import java.util.Scanner;

public class RegisterCrop extends User_Account {
	//Scanner scane = new Scanner(System.in);
	public void CropRecommendation()
	{
		SQLQueryProcessing sql = new SQLQueryProcessing();
		
		//System.out.print("Enter the location : ");
		//String Location = scan.nextLine();
		double rainfall, temperature, nitrogen, potassium, phosphorous,humidity,ph;
		
		System.out.print("Enter the Rainfall in the area : ");
		rainfall=scan.nextDouble();
		System.out.print("Enter the pH in the area : ");
		ph=scan.nextDouble();
		System.out.print("Enter the humidity in the area : ");
		humidity=scan.nextDouble();
		System.out.print("Enter the Temperature in the area : ");
		temperature = scan.nextDouble();
		System.out.print("Enter the nitrogen content : " );
		nitrogen = scan.nextDouble();
		System.out.print("Enter the potassium content : ");
		potassium = scan.nextDouble();
		System.out.print("Enter the phosphorous content : ");
		phosphorous = scan.nextDouble();
		
		/*
		nitrogen = 70;
		phosphorous = 40;
		potassium = 40;
		rainfall = 200;
		temperature = 20;
		humidity = 75;
		ph = 6;
		*/
		String query = "select * from ("
				+ "select No,N,P,K,temperature,humidity,ph,rainfall,label, \r\n"
				+ "sum(abs(N-"+nitrogen+")+abs(P-"+phosphorous+")+abs(K-"+potassium
				+ ") + abs(temperature-"+temperature+")+"
				+ "abs(humidity-"+humidity+")+abs(ph-"+ph+")+"
				+ "abs(rainfall-"+rainfall+"))"
				+ "as sum from crop_recommendation group by No order by sum\r\n"
				+ ") a group by a.label having sum = min(sum);";
		
		//System.out.println(query);
		//System.out.println('\n'+query3+'\n');
		System.out.println("\n\nHere are some crops suggested for you : ");
		//System.out.println(query);
		try 
		{
			 sql.result_retrun(query);
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
		
		
		//scane.close();
		
	}
	
	public void Add_Crop_Data(int F_ID,String c_ID)
	{
		(new AddCropData()).SQL(F_ID,c_ID);
	}
	
	public void CustomRegistration(int F_ID)
	{
		Scanner scanee = new Scanner(System.in);
		System.out.print("Want to get crop suggestions based on your soil properties (Y / N)? ");
		char  c = scanee.nextLine().charAt(0);
		if(c == 'Y' || c == 'y') CropRecommendation();
		System.out.print("\nEnter the Crop ID of the crop you want to plant : ");
		String C_ID = scanee.nextLine();
		Add_Crop_Data(F_ID,C_ID);
		//scanee.close();
		System.out.println("\n---Crop added to account---\n");
		
		//scanee.close();
	}
	
}
