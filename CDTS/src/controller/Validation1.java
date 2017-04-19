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

import dao.UserDAO;
//import dao.UserDetailsDAO;

/**
 * Servlet implementation class Validation
 */
@WebServlet("/Validation1")
public class Validation1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(true);
		
		
		String id=request.getParameter("EmailId");
		String pwd=request.getParameter("password");
		
		//session.setAttribute("EmailID", id);
		if(id==""||pwd==""){
			//out.println("<h2><font size=5 color=red>Please Fill  Empty Field</font></h2>");
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
		else{
		//UserDetailsDAO uddao=new UserDetailsDAO();
		UserDAO dao=new UserDAO();
		try {
			System.out.println("******************");
			dao.getDBConnection();
	
			
				String un=dao.validation(id,pwd);
				System.out.println(un);
				if(un==null){
					RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
					rd.forward(request, response);
				}
				else{
				request.setAttribute("user", un);
				session.setAttribute("usernm", un);
				RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
				rd.forward(request, response);
				}
			out.println("succss...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(NullPointerException e){
			//out.println("<h2><font size=4 color=red>Wrong user_id or password re-login..</font><h2>");
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
			
		}
		
		finally{
			try {
				dao.closeDBConnection();
				//uddao.closeDBConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		doGet(req, resp);
	}

}
