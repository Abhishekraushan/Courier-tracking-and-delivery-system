package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import beans.Track;

import com.mysql.jdbc.Driver;

public class TrackingDAO {
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	
public void getDBConnection() throws SQLException{
	Driver driver =new Driver();
	DriverManager.registerDriver(driver);
	
	String url="jdbc:mysql://localhost:3306/cdts";
	 conn=DriverManager.getConnection(url,"root","");		
	}
public void closeDBConnection() throws SQLException{
	conn.close();
}


public List<Track> getTrackInfo(String trackid) throws SQLException{
	List<Track> track=new ArrayList<Track>();
	pst=conn.prepareStatement("SELECT * from trackingdetails where trackid=? ");
	pst.setString(1, trackid);
	rs=pst.executeQuery();
	while(rs.next()){
		track.add(new Track( rs.getString(2), rs.getString(3), rs.getString(4)));
	}
	return track;	
}
}
