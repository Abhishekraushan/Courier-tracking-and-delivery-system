<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

<center><font size="18" color="grey" style=""><u>
	Tracking Details
	</u></font></center><br><br><br>
	
	<%
	String tid=(String)request.getAttribute("tid");
	String position=(String)request.getAttribute("position");
	String arrival=(String)request.getAttribute("arrival");
	String departure=(String)request.getAttribute("departure");
	
	%>
	<center> <h3>TrackId updated </h3> </br> </br> 
	
	
	
	
	<table border="2" width="60%">
	<tr> 
	<th><center> TrackId</center></th>
	<th><center> Location</center> </th>
	<th><center> Arrival Timestamp</center> </th>
	<th><center> Departure Timestamp</center> </th>
	</tr>
	
	<tr>
	<td><center><%=tid %></center> </td>
	<td><center><%=position %></center> </td>
	<td><center><%=arrival %></center> </td>
	<td><center><%=departure %></center> </td>
	</tr>
	</table>
		
	</center>
<!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="js/materialize.js"></script>
  <script src="js/init.js"></script>
</body>
</html>