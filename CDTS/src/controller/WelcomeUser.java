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

import beans.User;
//import beans.UserDetails;

import dao.UserDAO;
//import dao.UserDetailsDAO;

/**
 * Servlet implementation class WelcomeUser
 */
@WebServlet("/WelcomeUser")
public class WelcomeUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
			String EmailID=request.getParameter("EmailID");
			String Password=request.getParameter("Password");
			String Full_Name=request.getParameter("Full_Name");
			String Gender=request.getParameter("Gender");
			String Age=request.getParameter("Age");
			String Mobile=request.getParameter("Mobile");
			String City=request.getParameter("City");
			String State=request.getParameter("State");
			String Security_Question=request.getParameter("Security_Question");
			String Security_Answer=request.getParameter("Security_Answer");
			if(EmailID==""||Password==""||Full_Name==""||Gender==""||Age==""||Mobile==""||City==""||State==""||Security_Question==""||Security_Answer==""){
				out.println("<h2><font size=5 color=red>Please Fill  Empty Field</font></h2>");
				RequestDispatcher rd=request.getRequestDispatcher("registeruser1.jsp");
				rd.include(request, response);
			}
			else{
			//String phone=request.getParameter("phone");
			//UserDetailsDAO userdao=new UserDetailsDAO();
			UserDAO userdao=new UserDAO();
			try {
				//int random=(int)(Math.random()*1000);
				userdao.getDBConnection();
				//int sno=userdao.getLastSerial();
				//sno+=1;
				//String userid=name+sno;
			//	String password=name+random;
				//String role="user";
				User user=new User(EmailID,Password,Full_Name,Gender,Age,Mobile,City,State,Security_Question,Security_Answer);
				userdao.getDBConnection();
				userdao.adduser(user);
				System.out.println("User inserted in user_table");
				//UserDetails det=new UserDetails(userid, name, phone, sno);
				//userdao.adduserdet(det);
				//System.out.println("User inserted in UserDetails");
				request.setAttribute("usr", Full_Name);
				request.setAttribute("pass", Password);
				RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
				rd.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
		// TODO Auto-generated method stub
	}

}
