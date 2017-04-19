package beans;

import static org.junit.Assert.assertEquals;

import junit.framework.TestCase;

public class CustomerTest extends TestCase {
	
	
	public void test()
	{
	      Customer junit = new Customer("Syed","Hasan","IIIT Guwahati","saudh58@gmail.com",801178863,"Guwahati","Delhi","Mobile","Electronics",500,25000,1,"AABBCC");
	      
	      String result_str = junit.getFirstName();
	      assertEquals("Syed",result_str);
	      
	      result_str = junit.getLastName();
	      assertEquals("Hasan",result_str);
	      
	      result_str = junit.getAddress();
	      assertEquals("IIIT Guwahati",result_str);
	      
	      result_str = junit.getEmail();
	      assertEquals("saudh58@gmail.com",result_str);
	      
	      int result_int =  junit.getMobile();
	      assertEquals(801178863,result_int);
	      
	      result_str = junit.getSource();
	      assertEquals("Guwahati",result_str);
	      
	      result_str = junit.getDestination();
	      assertEquals("Delhi",result_str);
	      
	      result_str = junit.getProductDetail();
	      assertEquals("Mobile",result_str);
	      
	      result_str = junit.getType();
	      assertEquals("Electronics",result_str);
	      
	     float result_flt =  junit.getWeight();
	      assertEquals(500.0,result_flt,0.0002);
	      
	      result_flt =  junit.getPrice();
	      assertEquals( 25000,result_flt,0.0002);
	      
	      result_int =  junit.getQuantity();
	      assertEquals( 1,result_int);
	      
	      result_str = junit.getCourierId();
	      assertEquals("AABBCC",result_str);
	            
	      
	}
}
