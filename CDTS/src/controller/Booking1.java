package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Customer;
//import beans.OrderDetails;

import dao.UserDAO;



//import dao.UserDetailsDAO;
import java.util.Random;

import controller.path;

/**
 * Servlet implementation class WelcomeUser
 */
@WebServlet("/Booking1")
public class Booking1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		String user=(String)request.getParameter("myhiddenvalue");  
	    System.out.println("--------------"+user);
	    request.setAttribute("user", user);
		
		  HttpSession session=request.getSession(false);  
	        if(session==null){  
	        	RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
	        }  
	        else{  
	        	 String name=(String)session.getAttribute("usernm");        
	  	       System.out.print("Hello, "+name+" Welcome to Profile");
			String first_name=request.getParameter("first_name");
			String last_name=request.getParameter("last_name");
			String address=request.getParameter("address");
			String email=request.getParameter("email");
						
			String source=request.getParameter("source");
			String destination=request.getParameter("destination");
			String product_details=request.getParameter("product_details");
			String type=request.getParameter("type");
			float weight=Float.parseFloat(request.getParameter("weight"));
			
			int quantity=Integer.parseInt(request.getParameter("quantity"));
			int mobile=Integer.parseInt(request.getParameter("mobile"));
			
			//System.out.print(mobile);
			
			if(first_name==""||last_name==""||address==""||email==""||source==""||destination==""||product_details==""||type==""){
				//out.println("<h2><font size=5 color=red>Please Fill  Empty Field</font></h2>");
				RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
				rd.include(request, response);
			}
			else{
				//int random=(int)(Math.random()*10);
				Random rand = new Random(); 
				String random1="";
				String random2="";
				 
				for (int j = 0; j<4; j++)
			     {
			       int pick = rand.nextInt(10);
			       int pick1 = rand.nextInt(10);
			       random1 +=Integer.toString(pick);
			       random2 +=Integer.toString(pick1);
			     }
							
				System.out.println(first_name.charAt(0)+"****");
				String courierId = ""+first_name.charAt(0)+first_name.charAt(1)+last_name.charAt(0)+last_name.charAt(1)+""+random1+""+source.charAt(0)+source.charAt(1)+destination.charAt(0)+destination.charAt(1)+""+random2;
				
				System.out.println(courierId);
			
				
			UserDAO userdao=new UserDAO();
			try {
				
				userdao.getDBConnection();
				
				int un=userdao.getNumber(source);
				int un2=userdao.getNumber(destination);
				
				path path = new path();
				int k=path.pathdistance(un,un2,courierId);
				System.out.println(k);		
			
				float p =path.Cal(k, weight, quantity, type);
				System.out.println("GGGGGGGGGGJ"+p);
				
				int days = path.calculate_days(k, type);
				System.out.println("days: "+days);
				
				Customer customer=new Customer(first_name,last_name,address,email,mobile,source,destination,product_details,type,weight,p,quantity,courierId);
				userdao.getDBConnection();
				int row=userdao.adduser(customer);
				System.out.println("User inserted in booking");
				request.setAttribute("fname", first_name);
				request.setAttribute("lname", last_name);
				request.setAttribute("address", address);
				request.setAttribute("email", email);
				request.setAttribute("mobile", Integer.toString(mobile));
				request.setAttribute("source", source);
				request.setAttribute("destination", destination);
				request.setAttribute("product_details", product_details);
				request.setAttribute("type", type);
				request.setAttribute("weight", Float.toString(weight));
				request.setAttribute("price", Float.toString(p));
				request.setAttribute("quantity", Integer.toString(quantity));
				request.setAttribute("courierId", courierId);
				request.setAttribute("days", Integer.toString(days));
				RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
				rd.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				out.print("HIIII");
				e.printStackTrace();
			}
			finally{
				try {
					//logindao.closeDBConnection();
					userdao.closeDBConnection();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
			}
			}
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
