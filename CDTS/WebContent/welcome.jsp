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
  
  <style>
  ul li {
  display: block;
  position: relative;
  float: left;
}
  
  </style>
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
	Courier Delivery System
	</u></font></center><br>
	
	<%
	String fname=(String)request.getAttribute("fname");
	String lname=(String)request.getAttribute("lname");
	String address=(String)request.getAttribute("address");
	String email=(String)request.getAttribute("email");
	String mobile=(String)request.getAttribute("mobile");
	String source=(String)request.getAttribute("source");
	String destination=(String)request.getAttribute("destination");
	String product_details=(String)request.getAttribute("product_details");
	String type=(String)request.getAttribute("type");
	String weight=(String)request.getAttribute("weight");
	String price=(String)request.getAttribute("price");
	String quantity=(String)request.getAttribute("quantity");
	String courierId=(String)request.getAttribute("courierId");
	String days=(String)request.getAttribute("days");
	%>
	<center>
	<h2 class="teal lighten-2"><%=courierId %></h2>
	<h5 class="teal-text">Confirm delivery within <%=days %> days</h5></center>
	  <div class="row">
	  <div class="col s1"></div>
             <div class="col s3">
             <table class=" striped responsive-table ">
				<tbody>
				<tr><td class="teal-text"> Name: </td><td> <%=fname+" "+lname %></td></tr> 
				<tr><td class="teal-text"> Address:</td><td> <%=address %></td></tr>
				<tr><td class="teal-text"> Email:</td><td> <%=email %></td></tr>
				<tr><td class="teal-text"> Mobile:</td><td> <%=mobile %></td></tr>
				<tr><td class="teal-text"> Source:</td><td> <%=source %></td></tr>
				<tr><td class="teal-text"> Destination:</td><td> <%=destination %></td></tr></tbody></table>
             </div>
 
             <div class="col s3">
				 <table class=" striped responsive-table ">
				<tbody>
				<tr><td class="teal-text"> Product:</td><td> <%=product_details %></td></tr>
				<tr><td class="teal-text"> Type:</td><td> <%=type %></td></tr>
				<tr><td class="teal-text"> Weight:</td><td> <%=weight %></td></tr>
				<tr><td class="teal-text"> Price:</td><td> <%=price %></td></tr>
				<tr><td class="teal-text"> Quantity:</td><td> <%=quantity %></td></tr></tbody></tbody></table>
			</div>
	 <div class="col s5">
	  <form class="col s12" action="Home.jsp" method="post">
	   
	    <input type="hidden" name="myhiddenvalue" value="<%= user %>" />
          <div class="row">
            <div class="input-field ">
               <button class="btn waves-effect waves-light" type="submit" name="action">Back
			    <i class="material-icons right">fast_rewind</i>
			  </button>
            </div>
            </div>
            <div class="row">
             <div class="input-field ">
            <a class='dropdown-button btn' href='#' data-activates='dropdown1'>Payment
             <i class="material-icons right">payment</i></a>
              <ul id='dropdown1' class='dropdown-content'>
			    <li><a href="#!">Cash</a></li>
			    <li class="divider"></li>
			    <li><a href="#!">Net banking</a>
			     <li class="divider"></li>
			    <li><a href="#!">Credit Card</a>
			     <li class="divider"></li>
			    <li><a href="#!">Debit Card</a>
			    </li>
			    </ul>
             </div>
          </div>
          </form>
	 </div>
	</div>
	
	
	
	 <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="js/materialize.js"></script>
  <script src="js/init.js"></script>
</body>
</html>