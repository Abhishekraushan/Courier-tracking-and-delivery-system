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
<nav class="light-blue lighten-1" role="navigation">
<div class="nav-wrapper container"><a id="logo-container" href="Home.jsp" class="brand-logo">CDTS</a>
    
    <% String user=(String)request.getAttribute("user");  
    System.out.println(user);
    
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
	      // request.getSession().setAttribute("user", user);
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
  
   <nav class="light-blue lighten-4" role="navigation">
    <div class="nav-wrapper container">
       <div class="row">
        <form class="col s12" action="Fetch" method="post">
          <div class="row">
             <div class="col s6">
            </div>
           
            <div class="input-field col s5 grey lighten-1">
              <input placeholder="Courier Id" id="trackid" name="trackid" type="text" class="validate">
            </div>
            <input type="hidden" name="myhiddenvalue" value="<%= user %>" />
            <div class="input-field col s1">
             <button class="btn waves-effect waves-light" type="submit" name="action">Track
			    <i class="material-icons right">search</i>
			  </button>
            </div>
          </div>
          </form>
        </div>
    </div>
  </nav>
  <!-- **************************** -->

<div class="row">
<div class="col s3" >
  </div>
  <div class="col s6"  style="border-right:thick double #ff0000;border-left:thick double #ff0000;"> 
      <div class="row">
          <form class="col s12" action="Booking1" method="post">
          
          <div class="row">
          <h1 class="header center orange-text col s12">Booking</h1>
          </div>
            <div class="row">
              <div class="input-field col s6">
                <input  id="first_name" name="first_name" type="text" class="validate">
                <label for="first_name">First Name</label>
              </div>
              <input type="hidden" name="myhiddenvalue" value="<%= user %>" />
              <div class="input-field col s6">
                <input id="last_name"  name="last_name" type="text" class="validate">
                <label for="last_name">Last Name</label>
              </div>
            </div>
              <div class="row">
                    <div class="input-field col s12">
                      <textarea id="textarea1"  name="address" class="materialize-textarea"></textarea>
                      <label for="textarea1">Address</label>
                    </div>
                  </div>
            <div class="row">
              <div class="input-field col s6">
                <input id="email"  name="email" type="email" class="validate">
                <label for="email">Email</label>
              </div>
              <div class="input-field col s6">
                <input id="mobile" name="mobile" type="text"  class="validate" required>
                <label for="mobile">Mobile</label>
              </div>
            </div>
             <div class="row">
               <div class="input-field col s6">
					  <select class="browser-default" name="source">
					    <option value="" disabled selected>Source</option>
					    <option value="Delhi">Delhi</option>
					    <option value="Srinagar">Srinagar</option>
					    <option value="Ahemdabad">Ahemdabad</option>
					    <option value="Guwahati">Guwahati</option>
					    <option value="Calcutta">Calcutta</option>
					    <option value="Hyderabad">Hyderabad</option>
					    <option value="Mumbai">Mumbai</option>
					  </select>
				  </div>
              <div class="input-field col s6">
					  <select class="browser-default" name="destination">
					    <option value="" disabled selected>Destination</option>
					     <option value="Delhi">Delhi</option>
					    <option value="Srinagar">Srinagar</option>
					    <option value="Ahemdabad">Ahemdabad</option>
					    <option value="Guwahati">Guwahati</option>
					    <option value="Calcutta">Calcutta</option>
					    <option value="Hyderabad">Hyderabad</option>
					    <option value="Mumbai">Mumbai</option>
					  </select>
				  </div>
            </div>
            <div class="row">
              <div class="input-field col s6">
                <input id="product_details" name="product_details" type="text" class="validate">
                <label for="product_details">Product Details</label>
              </div>
              <div class="input-field col s6">
                 <p>
			      <input name="type" type="radio" id="test1" value="normal"/>
			      <label for="test1">Normal</label>
			    </p>
			    <p>
			      <input name="type" type="radio" id="test2" value="prime"/>
			      <label for="test2">Prime</label>
			    </p>
              </div>
            </div>
            <div class="row">
              <div class="input-field col s6">
                <input id="weight" name="weight" type="text" class="validate" required>
                <label for="weight">weight</label>
              </div>
             
              <div class="input-field col s6">
                <input id="quantity" name="quantity" type="number" class="validate" required>
                <label for="quantity">Quantity</label>
              </div>
            </div>
            <div class="row">
              <div class="col s4">
              </div>
            <div class="col s4">
             <button class="btn waves-effect waves-light" type="submit" name="action">Book
			    <i class="material-icons right">send</i>
			  </button>
            </div>
            <div class="col s4">
            </div>
          </div>
          </form>
        </div>
  </div>
  <div class="col s3">
  </div>
</div>

    <div class="section">

    </div>
 

  <footer class="page-footer orange">
    <div class="container">
      <div class="row">
        <div class="col l6 s12">
          <h5 class="white-text">Company Bio</h5>
          <p class="grey-text text-lighten-4">We are a team of college students working on this project like it's our full time job. Any amount would help support and continue development on this project and is greatly appreciated.</p>


        </div>
        <div class="col l3 s12">
          <h5 class="white-text">Settings</h5>
          <ul>
            <li><a class="white-text" href="#!">Link 1</a></li>
            <li><a class="white-text" href="#!">Link 2</a></li>
            <li><a class="white-text" href="#!">Link 3</a></li>
            <li><a class="white-text" href="#!">Link 4</a></li>
          </ul>
        </div>
        <div class="col l3 s12">
          <h5 class="white-text">Connect</h5>
          <ul>
            <li><a class="white-text" href="#!">Link 1</a></li>
            <li><a class="white-text" href="#!">Link 2</a></li>
            <li><a class="white-text" href="#!">Link 3</a></li>
            <li><a class="white-text" href="#!">Link 4</a></li>
          </ul>
        </div>
      </div>
    </div>
    <div class="footer-copyright">
      <div class="container">
      Made by <a class="orange-text text-lighten-3" href="http://materializecss.com">Materialize</a>
      </div>
    </div>
  </footer>


  <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="js/materialize.js"></script>
  <script src="js/init.js"></script>
</body>
</html>