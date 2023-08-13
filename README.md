                                            RytCrop- Crop Management System

Overview

The RytCrop project suggests crops that are suitable for certain land textures which is very helpful
 for farmers. They can know the history of the crops they have planted before. We are also providing 
 features to sell their crops for profitable prices. We also provide security features like sign-in and
 sign-up where the farmer can securely log in. We have also included the government where government 
 officials will be able to get the whole history of farmers and their crops so that they can submit 
 them to the government. Farmers can also approximately predict their investment on the basis of their 
 crop. The aid request farmers can know about government loans, rates of interest, and other benefits 
 from the government. 


# Requirements to Run Project
 1) SQL server version 8.0 or above
 2) mysql-connector-java-8.0.30.jar
 3) Need to change the 'secure-file-priv' variable to null at "C:\ProgramData\MySQL\MySQL Server 8.0\my.ini"
 4) change the root password as per your system
 5) Give Access to the project to add and delete files in the MySQL database.


# Actions that can be done
 1) Login into the account (Farmer, Customer, Government)	 - Done By Abhiram

 2) Farmer
 	a) Register Crop 							- Done by Poojyanth
 	   - Additional Feature - Suggest Crops - based on user input via Numerical Search (Multiple)

 	b) Show Crop History  						- Done By Venkat
 	   - Search Via Primary Key (Single Record)
 	   - Delete Record in Database ()
 	c) Sell Crop							- Done By Sanjeev
	   - Sell a crop and calculate the profit for the crop

 	d) Aid Request							- Done by Sravan
 	   - Request Aid from the government and get an estimate of your loan

 3) Customer 								- Done By Sanjeev
 	a) Buy Crops
	   - Buy crops from the Farmer if they are available and calculate your bill

 	b) Show bills and past history
	   - Show all the past purchases

 4) Government 								- Done By Sravan
 	a) Show All Crops
	   -  Show all the crops in an area
 	b) Show all Farmers
	   - Show all the farmers in an area


 5)  CSV File Upload, Update							- Done by Poojyanth

 6)  Database Linking and SQL processing is done by Everyone
