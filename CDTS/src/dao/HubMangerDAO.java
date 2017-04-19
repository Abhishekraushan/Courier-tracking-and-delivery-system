package dao;

import java.sql.*;

import beans.Track;

import com.mysql.jdbc.Driver;
public class HubMangerDAO {
	Connection conn;
	PreparedStatement pst,pst2;
	ResultSet rs;
	public void getDBConnection() throws SQLException{
		
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cdts", "root", "");
		System.out.println("Connection Created");
	}
	public void closeDBConnection() throws SQLException{
		conn.close();
		System.out.println("Connection Closed");
	}
	public String validation(String uid,String pwd) throws SQLException
	{
		pst=conn.prepareStatement("select * from login where userid=? and password=?");
		pst.setString(1, uid);
		pst.setString(2, pwd);
		ResultSet rs=pst.executeQuery();
		if(rs.next())
			return (rs.getString(1));
		else 
			return null;
	}
	public int addTrackInfo(Track log) throws SQLException{
		if(log.getArrival()== null && log.getDeparture()!=null){
			pst2=conn.prepareStatement("select * from trackingdetails where position=? and trackid=?");
			pst2.setString(1, log.getPosition());
			pst2.setString(2, log.getTrackId());
			ResultSet rs=pst2.executeQuery();
			if(rs.next()){
				if(rs.getString(2)==null){
					return 0;
				}
				else{
					pst=conn.prepareStatement("update trackingdetails set departure=? where position=? and trackid=? ");
					pst.setString(1, log.getDeparture());
					pst.setString(2, log.getPosition());
					pst.setString(3, log.getTrackId());	
					int row =pst.executeUpdate();
					return row;
				}
			}
			else{
				return 0;
			}
				
			
		}
		else{
		pst=conn.prepareStatement("update trackingdetails set arrival=?,departure=? where position=? and trackid=? ");
		pst.setString(1, log.getArrival());
		pst.setString(2, log.getDeparture());
		pst.setString(3, log.getPosition());
		pst.setString(4, log.getTrackId());	
		int row =pst.executeUpdate();
		return row;
		}
	}
}