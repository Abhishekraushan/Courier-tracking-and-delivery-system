<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="javax.servlet.http.HttpSession;" %>
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
    <%
    String user = request.getParameter("user");
    System.out.println(user);
    if(user=="null"){  
    	 request.getSession().invalidate();}  
    %>    
    </div>
  </nav>
  <!-- **************************** -->
  <div class="row">
  <div class="col s12"  >
      
       <div class="row">
          <form class="col s12" action="Validation1" method="post">
          <div class="row">
          <h1 class="header center orange-text col s12">CDTS</h1>
          </div>
          <div class="row">
          <div class="col s3"> <img class="responsive-img" src="images/COURIER.jpg"></div>
          <div class="col s9">
            <div class="row">
            <div class="col s4"></div>
              <div class="input-field col s4">
               <i class="material-icons prefix">account_circle</i>
                <input  id="EmailId" name="EmailId" type="text" class="validate">
                <label for="EmailId">User Id</label>
              </div>
              <div class="col s4"></div>
              </div>
              <div class="row">
              <div class="col s4"></div>
              <div class="input-field col s4">
               <i class="material-icons prefix">input</i>
                <input id="password"  name="password" type="password" class="validate">
                <label for="password">Password</label>
              </div>
              <div class="col s4"></div>
            </div>
           
              <div class="row">
              <div class="col s6"></div>
                    <div class="input-field  col s2">
                     <a class="red-text" href="Register.jsp">Register new user</a><br><br>
                     <button class="btn waves-effect waves-light" type="submit" name="action">Submit
					    <i class="material-icons right">send</i>
					  </button>
                    </div>
                   <div class="col s4"></div>
                  </div>
            </div>
          </div>  
             </form>
          </div>   
        </div>
</div>

 <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="js/materialize.js"></script>
  <script src="js/init.js"></script>
</body>
</html>