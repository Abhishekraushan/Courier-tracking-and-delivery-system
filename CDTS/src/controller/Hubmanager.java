package controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.HubMangerDAO;
import beans.Track;

/**
 * Servlet implementation class Validation
 */
@WebServlet("/Hubmanager")
public class Hubmanager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(true);
		
		String tid=request.getParameter("trackid");
		String position=request.getParameter("position");
		String arrival=request.getParameter("arrival");
		String departure=request.getParameter("departure");
		if(departure ==""){
			departure = null;
		}
		if(arrival ==""){
			arrival = null;
		}
		
		//out.println(tid+position+arrival+departure);
		
		session.setAttribute("trackid", tid);
		if(tid=="" || position==""){
			RequestDispatcher rd=request.getRequestDispatcher("hubmanager.jsp");
			rd.include(request, response);
		}
		else{
		//UserDetailsDAO uddao=new UserDetailsDAO();
		HubMangerDAO dao=new HubMangerDAO();
		try {
			dao.getDBConnection();
			
			Track track = new Track(tid,position,arrival,departure);
			int row =dao.addTrackInfo(track);
			
			if(row==0){
				RequestDispatcher rd=request.getRequestDispatcher("HubManager.jsp");
			     rd.forward(request, response);
			}
			else{          
		      request.setAttribute("tid", tid);
		      request.setAttribute("position", position);
		      request.setAttribute("arrival", arrival);
		      request.setAttribute("departure", departure);
		      RequestDispatcher rd=request.getRequestDispatcher("confirmation.jsp");
		      rd.forward(request, response);
		      
			  System.out.println("success...");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(NullPointerException e){
			//out.println("<h2><font size=4 color=red>Wrong user_id or password re-login..</font><h2>");
			RequestDispatcher rd=request.getRequestDispatcher("hubmanager.jsp");
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

