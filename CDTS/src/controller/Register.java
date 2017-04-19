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

import beans.Registers;
//import beans.OrderDetails;

import dao.UserDAO;
//import dao.UserDetailsDAO;
import java.util.Random; 

/**
 * Servlet implementation class WelcomeUser
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
			String userid=request.getParameter("userId");
			String password=request.getParameter("password");
			String fullname=request.getParameter("full_name");
			String address=request.getParameter("address");
			String state=request.getParameter("state");
			String city=request.getParameter("city");
			String gender=request.getParameter("gender");
			int age=Integer.parseInt(request.getParameter("age"));
			int mobile=Integer.parseInt(request.getParameter("mobile"));
			
			//System.out.print(mobile);
			
			if(userid==""||password==""||fullname==""||address==""||city==""||state==""||gender==""){
				//out.println("<h2><font size=5 color=red>Please Fill  Empty Field</font></h2>");
				RequestDispatcher rd=request.getRequestDispatcher("Register.jsp");
				rd.include(request, response);
			}
			else{
			
			UserDAO userdao=new UserDAO();
			try {
				
				userdao.getDBConnection();
				
				Registers customer=new Registers(userid,password,fullname,state,mobile,city,address,gender,age);
				userdao.getDBConnection();
				userdao.adduser(customer);
				System.out.println("User inserted in booking");
				request.setAttribute("userid", userid);
				request.setAttribute("password", password);
				request.setAttribute("fullname", fullname);
				request.setAttribute("state", state);
				request.setAttribute("mobile", mobile);
				request.setAttribute("city", city);
				request.setAttribute("address", address);
				request.setAttribute("gender", gender);
				request.setAttribute("age", age);
				
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
