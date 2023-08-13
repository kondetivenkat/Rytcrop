package Customer;

public class items {
	 private String id;  
	    private String pname;  
	    private int qty;  
	    private double price;  
	    private double totalPrice;  
	    
	    items(String id, String pname, int qty, double price, double totalPrice)   
	    {  
	        this.id=id;  
	        this.pname = pname;  
	        this.qty = qty;  
	        this.price = price;  
	        this.totalPrice = totalPrice;  
	    } 
	            public String getId()   
	            {  
	                return id;  
	            }  
	            public String getPname()   
	            {  
	                return pname;  
	            }  
	            public int getQty()   
	            {  
	                return qty;  
	            }  
	            public double getPrice()   
	            {  
	                return price;  
	            }  
	            public double getTotalPrice()   
	            {  
	                return totalPrice;  
	            }
	            public static void displayFormat()   
	            {  
	                System.out.format("-----------------------------------------------------------------------------------------------------------------------------------");  
	                System.out.print("\nProduct ID \t\tName\t\tQuantity\t\tRate \t\t\t\tTotal Price\n");  
	                System.out.format("-----------------------------------------------------------------------------------------------------------------------------------\n");  
	            }   
	            public void display()   
	            {  
	                System.out.format("   %-9s             %-9s      %5d               %9.2f                       %14.2f\n" ,id, pname, qty, price, totalPrice);  
	            }  
}
