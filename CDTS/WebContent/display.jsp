<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.Track"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
  <title>e-Delivery</title>

  <!-- CSS  -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
</head>
<body bgcolor="blanchedalmond">

<nav class="light-blue lighten-1" role="navigation">
    <div class="nav-wrapper container"><a id="logo-container" href="Home.jsp" class="brand-logo">CDTS</a>
     <% String user=(String)request.getAttribute("user");  
    System.out.println(user);
    request.setAttribute("user", user);
    if(user == null){%>
     <ul class="right hide-on-med-and-down">
        <li><a href="login.jsp">Login</a></li>
      </ul>

      <ul id="nav-mobile" class="side-nav">
        <li><a href="login.jsp">Login</a></li>
      </ul>
      <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>  
  <%
    }
    else
    {
    	     
	       System.out.println("Hello, "+user+" Welcome to Profile");
    	%>
    	 <ul class="right hide-on-med-and-down">
        <li><form action="login.jsp?user=null" method="post">
        <button class="btn waves-effect waves-light" type="submit" name="action">Logout <%=user %>
			  </button>
			  </form></li>
     	 </ul>

      <ul id="nav-mobile" class="side-nav">
        <li><a href="login.jsp?user=null">Logout</a></li>
      </ul>
      <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
    	<%
    }
    %>
    </div>
  </nav>
  <!-- **************************** -->


<center><font size="18" color="grey" style=""><u>
	Tracking Details</u></font></center><br><br><br>
	<%	
	//HttpSession hs = request.getSession(true);
	//String tid = request.getAttribute(trackid);
	List<Track> ques=new ArrayList<Track>();
	ques=(List<Track>)request.getAttribute("track");	
	int i=0;
	ArrayList<String> ans=new ArrayList<String>();%>
	<table align="center">
	<tr>
	<th> Location </th>
	<th> Arrival Time </th>
	<th> Departure Time </th>
	</tr>
	<%
	for(Track e : ques){
		i+=1;%>
		<tr>
		<td> <%= e.getPosition() %> </td>
		<%if(e.getArrival()==null){%>
			<td> <% out.println("__");%></td>
		<% } else{%>
		<td> <%= e.getArrival().toString().replaceAll("\\.\\d+", "")%></td>
		<% }
		if(e.getDeparture()==null){%>
		<td> <% out.println("__");%></td>
		<% }
		else{ %>
		<td> <%=e.getDeparture().toString().replaceAll("\\.\\d+", "") %></td>
		</tr>
		<%	}
		} 
		%>
		</table>
		
 <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="js/materialize.js"></script>
  <script src="js/init.js"></script>
</body>
</html>