package dao;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import beans.Customer;
import junit.framework.TestCase;

public class UserDAOTest extends TestCase {
	
	
	public void test() throws SQLException
	{	
	      UserDAO junit = new UserDAO();
	     junit.getDBConnection();
	     
	     //validation
	      String result_str = junit.validation("Syed","123");
	      assertEquals("Syed",result_str);
	  
	      //getNumber
	      int number = junit.getNumber("Mumbai");
	      assertEquals(7,number);
	      
	      //adduser(Customer)
	      Customer customer=new Customer("ASHISH", "KUMAR","Bari Bagicha, Maurya Vihar Colony Transport Nagar, Kumhrar, near DAV school","abhishekraushan2@gmail.com",3535,"Mumbai","Guwahati","dgdg","prime",23,(float) 14784.4,1,"ASKU4334MuGu9236");
	      int row = junit.adduser(customer);
	      assertEquals(1,row);
	}
}
