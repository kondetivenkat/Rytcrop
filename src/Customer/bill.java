package Customer;
import java.text.SimpleDateFormat;
import java.util.*;

public class bill {
	public static void reciept(String id,String productName,int quantity,int price)
	{
        double totalPrice = 0.0; 
        double cgst;
        double sgst;
        double subtotal=0.0;
        double discount=0.0;
        
        System.out.println("\t\t\t\t--------------------Invoice-----------------");  
        System.out.println("\t\t\t\t\t "+"  "+"Dhanush Mart Grocery Shop");  
        System.out.println("\t\t\t\t\t3/98 Sricity,Near Chennai");  
        System.out.println("\t\t\t\t\t"  +"    " +"Opposite IIIT Sricity");  
        System.out.println("GSTIN: 03AWBPP8756K592"+"\t\t\t\t\t\t\tContact: (+91) 9988776655");
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");    
        Date date = new Date(); 
        System.out.println("Date: "+formatter.format(date)+"  "+"\t\t\t\t\t\t\t (+91) 9998887770");
        
        totalPrice = price * quantity;
        items product =new items(id, productName, quantity, price, totalPrice);    
        items.displayFormat();
            product.display();
        
        
        System.out.println("\n\t\t\t\t\t\t\t\t\t\tTotal Amount (Rs.) " +totalPrice);
        discount = totalPrice*2/100;  
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t    Discount (Rs.) " +discount);
        subtotal = totalPrice-discount;   
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t          Subtotal "+subtotal);
        sgst=totalPrice*12/100;  
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t          SGST (%) "+sgst);  
        cgst=totalPrice*12/100;  
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t          CGST (%) "+cgst);
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t     Invoice Total " +(subtotal+cgst+sgst));  
        System.out.println("\t\t\t\t----------------Thank You for Shopping!!-----------------");  
        System.out.println("\t\t\t\t                     Visit Again"); 
	}

}