package dao;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import beans.Track;
import junit.framework.TestCase;

public class HubManagerDAOTest extends TestCase {
		
	public void test() throws SQLException
	{
		//validation
		HubMangerDAO junit = new HubMangerDAO();
		 junit.getDBConnection();
	     String result_str = junit.validation("Syed","123");
	      assertEquals("Syed",result_str);	 
	     
	      
	      //addTrackInfo
	      Track track = new Track("ASKU4334MuGu9236","Mumbai","2017-12-01 05:24:12","2017-12-01 05:24:12");
	      int row = junit.addTrackInfo(track);
	      assertEquals(1,row);
	}
}
