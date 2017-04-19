package controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import beans.Track;
import dao.TrackingDAO;

/**
 * Servlet implementation class Validation
 */
@WebServlet("/Fetch")
public class Fetch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String user=(String)request.getParameter("myhiddenvalue");  
	    System.out.println("$$$$$$$$$"+user);
	    request.setAttribute("user", user);
		
		HttpSession session=request.getSession(true);
		
		String tid=request.getParameter("trackid");
		session.setAttribute("trackid", tid);
		if(tid==""){
			//out.println("<h2><font size=5 color=red>Please Fill  Empty Field</font></h2>");
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
		else{
		//UserDetailsDAO uddao=new UserDetailsDAO();
		TrackingDAO dao=new TrackingDAO();
		try {
			dao.getDBConnection();
			
			List<Track> track=dao.getTrackInfo(tid);
			request.setAttribute("track", track);		
		      RequestDispatcher rd=request.getRequestDispatcher("display.jsp");
		      rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(NullPointerException e){
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

