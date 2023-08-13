package Farmer;
import java.sql.*;
import java.io.BufferedReader;
import java.io.FileReader;
public class csvload {
    public static void cropinfo(){
      try {
    		   
    	   String url = "jdbc:mysql://localhost:3306/RytCrop";
           String uname = "root";
           String pass = "Vb@6301820630";
           String filepath1="D:\\Project\\farmer_id.csv";
          /* String filepath2="\"D:\\Project\\cropname_id.csv";
           String filepath3="\"D:\\Project\\sell.csv";
           String filepath4="\"D:\\Project\\crop_details.csv";
           String filepath5="\"D:\\Project\\avgcrop.csv";*/
           int batchSize = 100;
           
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection(url,uname,pass);
           con.setAutoCommit(false);
           String sqld1="drop table if exists farmer_id ; ";
          /* String sqld2="drop table if exists cropname_id ; ";
           String sqld3="drop table if exists sell ; ";
           String sqld4="drop table if exists crop_details ; ";
           String sqld5="drop table if exists avgcrop ; ";*/
           String sql1="create table farmer_id (farmer_id int,Farmer_FirstName varchar(30),Farmer_LastName varchar(30))";
          /* String sql2="create table cropname_id (Crop_Name varchar(30),crop_id varchar(30))";
           String sql3="create table sell (farmer_id int,Date_of_selling varchar(30),crop_id varchar(30),Tons int,price_per_tons int,Crop_Budget int,profit int)";
           String sql4="create table crop_details (farmer_id int,crop_id varchar(30),Datein varchar(30),Dateout varchar(30))";
           String sql5="create table avgcrop (N double,P double,K double,temperature double,humidity double,ph double,rainfall double,label varchar(40),crop_id varchar(30))";
         */  String sqli1 = "insert into farmer_id values(?,?,?)";
           /*String sqli2 = "insert into cropname_id values(?,?)";
           String sqli3 = "insert into sell values(?,?,?,?,?,?,?)";
           String sqli4 = "insert into crop_details values(?,?,?,?)";
           String sqli5 = "insert into avgcrop values(?,?,?,?,?,?,?,?,?)";*/
           Statement St = con.createStatement();
           St.executeUpdate(sqld1);
           St.executeUpdate(sql1);
         /*  St.executeUpdate(sqld2);
           St.executeUpdate(sql2);
           St.executeUpdate(sqld3);
           St.executeUpdate(sql3);
           St.executeUpdate(sqld4);
           St.executeUpdate(sql4);
           St.executeUpdate(sqld5);
           St.executeUpdate(sql5);*/
           PreparedStatement statement1 = con.prepareStatement(sqli1);
           /*PreparedStatement statement2 = con.prepareStatement(sqli2);
           PreparedStatement statement3 = con.prepareStatement(sqli3);
           PreparedStatement statement4 = con.prepareStatement(sqli4);
           PreparedStatement statement5 = con.prepareStatement(sqli5);*/
           BufferedReader lineReader1 = new BufferedReader(new FileReader(filepath1));
          /* BufferedReader lineReader2 = new BufferedReader(new FileReader(filepath2));
           BufferedReader lineReader3 = new BufferedReader(new FileReader(filepath3));
           BufferedReader lineReader4 = new BufferedReader(new FileReader(filepath4));
           BufferedReader lineReader5 = new BufferedReader(new FileReader(filepath5));*/
           String lineText = null;
           int count1 = 0;
           lineReader1.readLine();
           /*lineReader2.readLine();
           lineReader3.readLine();
           lineReader4.readLine();
           lineReader5.readLine();*/
           
           while ((lineText = lineReader1.readLine()) != null) {
               String[] data = lineText.split(",");
               int Farmer_id=Integer.parseInt(data[0]);
             
               String Farmer_FirstName = data[1];
               String Farmer_LastName=data[2];
   
               statement1.setInt(1, Farmer_id);
               statement1.setString(2, Farmer_FirstName);
               statement1.setString(3,Farmer_LastName);
               
               statement1.addBatch();
               if (count1 % batchSize == 0) {
                   statement1.executeBatch();
               }
           }
           lineReader1.close();
           statement1.executeBatch();
           con.commit();
           con.close();
      }
      catch (Exception exception) {
          exception.printStackTrace();
      }

    }
    public static void crophistory() {
      try {
     	    String url = "jdbc:mysql://localhost:3306/RytCrop";
            String uname = "root";
            String pass = "Vb@6301820630";
            String filepath2="D:\\Project\\cropname_id.csv";
            int batchSize = 100;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,uname,pass);
            con.setAutoCommit(false);
            String sqld2="drop table if exists cropname_id ; ";
            String sql2="create table cropname_id (Crop_Name varchar(30),crop_id varchar(30))";
            String sqli2 = "insert into cropname_id values(?,?)";
            Statement St = con.createStatement();
           
            St.executeUpdate(sqld2);
            St.executeUpdate(sql2);
            PreparedStatement statement2 = con.prepareStatement(sqli2);
            BufferedReader lineReader2 = new BufferedReader(new FileReader(filepath2));
            String lineText = null;
            int count1 = 0;
            lineReader2.readLine();
            while ((lineText = lineReader2.readLine()) != null) {
                String[] data = lineText.split(",");
                
                String Crop_Name = data[0];
                String Crop_id = data[1];
                
    
                statement2.setString(1, Crop_Name);
                statement2.setString(2,Crop_id);
               
                statement2.addBatch();
                if (count1 % batchSize == 0) {
                    statement2.executeBatch();
                }
            }
            lineReader2.close();
            statement2.executeBatch();
            con.commit();
            con.close();
    	}
        catch (Exception exception) {
            exception.printStackTrace();
        }
            
    }
    public static void classcrop() {
    	 try {
      	    String url = "jdbc:mysql://localhost:3306/RytCrop";
             String uname = "root";
             String pass = "Vb@6301820630";
             String filepath3="D:\\Project\\sell.csv";
             int batchSize = 100;
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con = DriverManager.getConnection(url,uname,pass);
             con.setAutoCommit(false);
             String sqld3="drop table if exists sell ; ";
             String sql3="create table sell (farmer_id int,Date_of_selling varchar(30),crop_id varchar(30),Tons int,price_per_tons int,Crop_Budget int,profit int)";
             String sqli3 = "insert into sell values(?,?,?,?,?,?,?)";
             Statement St = con.createStatement();
            
             St.executeUpdate(sqld3);
             St.executeUpdate(sql3);
             PreparedStatement statement3 = con.prepareStatement(sqli3);
             BufferedReader lineReader3 = new BufferedReader(new FileReader(filepath3));
             String lineText = null;
             int count1 = 0;
             lineReader3.readLine();
             while ((lineText = lineReader3.readLine()) != null) {
                 String[] data = lineText.split(",");
                 int Farmer_id=Integer.parseInt(data[0]);
                 String Date_of_selling=data[1];
                 String Crop_id = data[2];
                 String Tons=data[3];
                 String price_per_tons=data[4];
                 String crop_Budget=data[5];
                 String profit=data[6];
     
                 statement3.setInt(1, Farmer_id);
                 statement3.setString(2,Date_of_selling);
                 statement3.setString(3,Crop_id);
                 statement3.setString(4,Tons);
                 statement3.setString(5,price_per_tons);
                 statement3.setString(6,crop_Budget);
                 statement3.setString(7,profit);
                 statement3.addBatch();
                 if (count1 % batchSize == 0) {
                     statement3.executeBatch();
                 }
             }
             lineReader3.close();
             statement3.executeBatch();
             con.commit();
             con.close();
     	}
         catch (Exception exception) {
             exception.printStackTrace();
         }
             
     }
    public static void details() {
    	try {
      	    String url = "jdbc:mysql://localhost:3306/RytCrop";
             String uname = "root";
             String pass = "Vb@6301820630";
             String filepath4="D:\\Project\\crop_details.csv";
             int batchSize = 100;
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con = DriverManager.getConnection(url,uname,pass);
             con.setAutoCommit(false);
             String sqld4="drop table if exists crop_details ; ";
             String sql4="create table crop_details (farmer_id int,crop_id varchar(30),Datein varchar(30),Dateout varchar(30))";
             String sqli4 = "insert into crop_details values(?,?,?,?)";
             Statement St = con.createStatement();
            
             St.executeUpdate(sqld4);
             St.executeUpdate(sql4);
             PreparedStatement statement4 = con.prepareStatement(sqli4);
             BufferedReader lineReader4 = new BufferedReader(new FileReader(filepath4));
             String lineText = null;
             int count1 = 0;
             lineReader4.readLine();
             while ((lineText = lineReader4.readLine()) != null) {
                 String[] data = lineText.split(",");
                 int Farmer_id=Integer.parseInt(data[0]);
                 
                 String Crop_id = data[1];
                 String Datein = data[2];
                 String Dateout=data[3];
                
     
                 statement4.setInt(1, Farmer_id);
                 
                 statement4.setString(2,Crop_id);
                 statement4.setString(3,Datein);
                 statement4.setString(4,Dateout);
                 statement4.addBatch();
                 if (count1 % batchSize == 0) {
                     statement4.executeBatch();
                 }
             }
             lineReader4.close();
             statement4.executeBatch();
             con.commit();
             con.close();
     	}
         catch (Exception exception) {
             exception.printStackTrace();
         }
    }
    public static void recommend() {
    	try {
      	    String url = "jdbc:mysql://localhost:3306/RytCrop";
             String uname = "root";
             String pass = "Vb@6301820630";
             String filepath5="D:\\Project\\avgcrop.csv";
             int batchSize = 100;
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con = DriverManager.getConnection(url,uname,pass);
             con.setAutoCommit(false);
             String sqld5="drop table if exists avgcrop ; ";
             String sql5="create table avgcrop (N double,P double,K double,temperature double,humidity double,ph double,rainfall double,label varchar(40),crop_id varchar(30))";
             String sqli5 = "insert into avgcrop values(?,?,?,?,?,?,?,?,?)";
             Statement St = con.createStatement();
            
             St.executeUpdate(sqld5);
             St.executeUpdate(sql5);
             PreparedStatement statement5 = con.prepareStatement(sqli5);
             BufferedReader lineReader5 = new BufferedReader(new FileReader(filepath5));
             String lineText = null;
             int count1 = 0;
             lineReader5.readLine();
             while ((lineText = lineReader5.readLine()) != null) {
                 String[] data = lineText.split(",");
                 double N=Double.parseDouble(data[0]);
                 double P=Double.parseDouble(data[1]);
                 double K=Double.parseDouble(data[2]);
                 double temperature=Double.parseDouble(data[3]);
                 double humidity=Double.parseDouble(data[4]);
                 double ph=Double.parseDouble(data[5]);
                 double rainfall=Double.parseDouble(data[6]);
                 String label=data[7];
                 String crop_id=data[8];
                 
                
     
                 statement5.setDouble(1,N);
                 
                 statement5.setDouble(2,P);
                 statement5.setDouble(3,K);
                 statement5.setDouble(4,temperature);
                 statement5.setDouble(5,humidity);
                 statement5.setDouble(6,ph);
                 statement5.setDouble(7,rainfall);
                 statement5.setString(8,label);
                 statement5.setString(9,crop_id);
                 statement5.addBatch();
                 if (count1 % batchSize == 0) {
                     statement5.executeBatch();
                 }
             }
             lineReader5.close();
             statement5.executeBatch();
             con.commit();
             con.close();
     	}
         catch (Exception exception) {
             exception.printStackTrace();
         }
    }
    public static void main(String[] args) {
    	csvload.cropinfo();
    	csvload.crophistory();
    	csvload.classcrop();
    	csvload.details();
    	csvload.recommend();
    	System.out.println("Successful");
    }
    
}

       


