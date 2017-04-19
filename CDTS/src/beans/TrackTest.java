package beans;

import junit.framework.TestCase;
import static org.junit.Assert.*;

public class TrackTest extends TestCase {
	
	public void test()
	{
		
		Track junit = new Track("AABBCC","Delhi","2017-05-04 23:12:11","2017-05-05 22:34:53");
		
		String result_str = junit.getTrackId();
	    assertEquals("AABBCC",result_str);
	    
	    result_str = junit.getPosition();
	    assertEquals("Delhi",result_str);
	
	    result_str = junit.getArrival();
	    assertEquals("2017-05-04 23:12:11",result_str);
	    
	    result_str = junit.getDeparture();
	    assertEquals("2017-05-05 22:34:53",result_str);
	}

}
