package controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;



/**
 * Servlet implementation class Validation
 */
@WebServlet("/path")
public class path extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	public int calculate_days(int distance, String type)
	{
	    int days;
	    
	    if(distance <= 500)
	        days = 3;
	    else if(distance >500 && distance <=1500)
	        days = 7;
	    else if(distance >1500 && distance <=4500)
	        days = 12;
	    else if(distance >4500 && distance <6500)
	        days = 14;
	    else days = 16;

	  //  printf("%d\n",type);

	    if(type=="Normal")
	  //  printf("%d \n\n",days);
	    	return days;

	    else {
	    	//printf("%d \n\n",days-(int)days/4);
	    	return (days-(int)days/4);
	    }

	//return 0;
	}

	
	public float Cal(int distance, float weight, int qty, String type)
	{
		float Service_Tax = (float)(distance*0.000001);
		System.out.println("fffd"+type);
		if(distance == 0)
			{
				if(type.equals("prime"))
					return (float)(weight*qty*0.2 + Service_Tax); // prime charges 10 times
				else if(type.equals("normal"))
					return (float)(weight*qty*0.1 + Service_Tax);
				else return(float)(-1);	
			}
		else if(distance > 0) {
				if(type.equals("prime"))
					return (float)((weight*qty*0.2*distance) + Service_Tax); // prime charges 10 times
				 
					else if(type.equals("normal"))
					return (float)(weight*qty*0.1*distance + Service_Tax);	
				else return(float)(-2);	
			}
		else return(float)(-3);	
	}
//calculate
	
	
	public int pathdistance(int a, int b, String c){
	
	int dista=0;
	String	S = Integer.toString(a);
	String	D = Integer.toString(b);
		int s = a;
		int d = b;
		
		if(S=="" || D==""){
			;
		}
		else{
		try {
			
		//	String fname=(String)request.getAttribute("courierId");
			
			Driver driver =new Driver();
			DriverManager.registerDriver(driver);
			
			 Connection conn;
			 String url="jdbc:mysql://localhost:3306/cdts";
			 conn=DriverManager.getConnection(url,"root","");
			
			 String sql = "select route from route where S="+s+";";
			 String sql2 = "select * from city where Sno=?";
			 String dec=null;
			 PreparedStatement pst=conn.prepareStatement("insert into trackingdetails values(?,?,?,?)");
			 
			 PreparedStatement pst2=conn.prepareStatement(sql2);
			 System.out.println(sql);
			 Statement stmt= conn.createStatement();
			 ResultSet rs = stmt.executeQuery(sql);
			 
			 while(rs.next())
			 {
				 //System.out.println(rs.getString("route"));
				 String val1 = rs.getString("route");
				 String [] tokens = val1.split("\\*");
				 //System.out.println(tokens[0]+"----"+tokens[1]);
				 int i=0;
				 
				 for(i=0;i<tokens.length;i++)
				 {
					 int distance=0,dst=0;
					 
					 String[] dist = tokens[i].split("\\+");					 
					 
					 int j=0;
					 for(j=0;j<dist.length;j++)
					 {
						 String[] val = dist[j].split("\\/");
						 
						 int k=0;
						 
						 for(k=0;k<val.length/2;k++)
						 {
							if(d== Integer.parseInt(val[0]))
							{
								int p=0;
								for(p=0;p<dist.length;p++)
								{
									val = dist[p].split("\\/");
									
									if(d!= Integer.parseInt(val[0]))
									{
										System.out.println("$$$$$$$$$$$$$$"+val[0]);
										pst2.setString(1,val[0]);
										ResultSet rs2=pst2.executeQuery();
										if(rs2.next())
										 dec=rs2.getString(2);
										else 
											dec=null;
										
										
										pst.setString(1, c );
										pst.setString(2, dec);
										pst.setString(3, null);
										pst.setString(4, null);
										
										pst.executeUpdate();
									}
									else{
										System.out.println(val[0]);
										pst2.setString(1,val[0]);
										ResultSet rs2=pst2.executeQuery();
										if(rs2.next())
										 dec=rs2.getString(2);
										else 
											dec=null;
										
										pst.setString(1, c );
										pst.setString(2, dec);
										pst.setString(3, null);
										pst.setString(4, null);
										pst.executeUpdate();
										System.out.println("Distance = "+val[1]);
										 dista=Integer.parseInt(val[1]);
										break;
									}
								}
							}
						 }
					 }
					 
				 }
				
			 }
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(NullPointerException e){
			
		}
		
		finally{
			/*try {
				//dao.closeDBConnection();
				//uddao.closeDBConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
		}
		}
		 return dista;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();	
		out.println("Hello");
		//HttpSession session=request.getSession(true);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("End");
		doGet(req, resp);
	}

}

