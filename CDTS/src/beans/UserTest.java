package beans;

import junit.framework.TestCase;

public class UserTest extends TestCase {
	
	public void test()
	{
		User junit = new User("saudh58@gmail.com","pass","Syed Saud Hasan","M","22","8011788630","Guwahati","Assam","Name of your best friend","Supriya");
		
		String result_str = junit.getEmailID();
	    assertEquals("saudh58@gmail.com",result_str);
	    
	    result_str = junit.getPassword();
	    assertEquals("pass",result_str);

	    result_str = junit.getFullName();
	    assertEquals("Syed Saud Hasan",result_str);
	    
	    result_str = junit.getGender();
	    assertEquals("M",result_str);
	    
	    result_str = junit.getAge();
	    assertEquals("22",result_str);
	    
	    result_str = junit.getMobile();
	    assertEquals("8011788630",result_str);
	    
	    result_str = junit.getCity();
	    assertEquals("Guwahati",result_str);
	    
	    result_str = junit.getState();
	    assertEquals("Assam",result_str);
	    
	    result_str = junit.getSecurity_question();
	    assertEquals("Name of your best friend",result_str);
	    
	    result_str = junit.getSecurity_answer();
	    assertEquals("Supriya",result_str);
	    
	    
	}

}
