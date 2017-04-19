package dao;

import java.sql.*;

import beans.User;
import beans.Customer;
import beans.Registers;

import com.mysql.jdbc.Driver;
public class UserDAO {
	Connection conn;
	PreparedStatement pst;
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
		else {
			
			return null;}
	}
	
	public int getNumber(String src) throws SQLException
	{
		pst=conn.prepareStatement("select * from city where Name=?");
		pst.setString(1, src);
		ResultSet rs=pst.executeQuery();
		if(rs.next())
			return (rs.getInt(1));
		else {
			
			return 0;}
	}
	
	public void adduser(Registers log) throws SQLException{
		pst=conn.prepareStatement("insert into login values(?,?,?,?,?,?,?,?,?)");
		pst.setString(1, log.getUserId());
		pst.setString(2, log.getPassword());
		pst.setString(3, log.getFullName());
		pst.setInt(4, log.getMobile());
		pst.setString(5, log.getState());
		pst.setString(6, log.getCity());
		pst.setInt(7, log.getAge());
		pst.setString(8, log.getGender());
		pst.setString(9, log.getAddress());
		pst.executeUpdate();
	}
	
	public int adduser(Customer log) throws SQLException{
		pst=conn.prepareStatement("insert into booking values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
		pst.setString(1, log.getFirstName());
		pst.setString(2, log.getLastName());
		pst.setString(3, log.getAddress());
		pst.setString(4, log.getEmail());
		pst.setInt(5, log.getMobile());
		pst.setString(6, log.getSource());
		pst.setString(7, log.getDestination());
		pst.setString(8, log.getProductDetail());
		pst.setString(9, log.getType());
		pst.setFloat(10, log.getWeight());
		pst.setFloat(11, log.getPrice());
		pst.setInt(12, log.getQuantity());
		pst.setString(13, log.getCourierId());
		int row=pst.executeUpdate();
		return row;
	}
}
