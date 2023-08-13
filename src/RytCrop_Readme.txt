                                            RytCrop- Crop Management System

Overview

The RytCrop project suggests crops that are suitable for certain land textures which is very helpful
 for farmers. They can know the history of the crops they have planted before. We are also providing 
 features to sell their crops for profitable prices. We also provide secure features like sign-in and
 sign up where the farmer can securely log in. We have also included the government where government 
 officials will be able to get the whole history of farmers and their crops so that they can submit 
 them to the government. Farmers can also approximately predict their investment on the basis of their 
 crop. The aid request farmers can know about government loans, rates of interest, and other benefits 
 from the government. 


# Requirements to Run Project
 1) SQL server version 8.0 or above
 2) mysql-connector-java-8.0.30.jar
 3) Need to change the 'secure-file-priv' variable to null at "C:\ProgramData\MySQL\MySQL Server 8.0\my.ini"
 4) change the root password as per your system
 5) Give Access for the project to add and delete files in MySQL database.


# Actions that can be done
 1) Login into account (Farmer, Customer, Government)
 2) Farmer
 	a) Register Crop 
 	   - Additional Feature - Suggest Crops - based on user input via Numerical Search (Multiple)
 	b) Show Crop History 
 	   - Search Via Primary Key (Single Record)
 	   - Delete Record in Database ()
 	c) Sell Crop
 	d) Aid Request
 3) Customer
 	a) Sell Crops
 	b) Show bills and past history
 4) Government
 	a) Show All Crops
 	b) Show all Farmers