package dao;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Track;
import junit.framework.TestCase;

public class TrackingDAOTest extends TestCase {
	
	
	public void test() throws SQLException
	{
	     TrackingDAO junit = new TrackingDAO();
	     junit.getDBConnection();
	     List<Track> result_str = junit.getTrackInfo("ASKU1027HyAh9943");
	     List<Track> track=new ArrayList<Track>();
	     track.add(new Track("Hyderabad","2017-03-24 18:30:01","2017-03-24 18:30:09"));
	     track.add(new Track("Mumbai","2017-03-24 20:30:01","2017-03-24 20:40:05"));
	     track.add(new Track("Ahemdabad","2017-03-25 18:30:01","2017-03-27 18:30:09"));
	     System.out.println(track);
	     System.out.println("****\n"+result_str);
	     
	      assertEquals(track,result_str);	        
	}
}
