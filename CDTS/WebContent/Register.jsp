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
     
      <ul id="nav-mobile" class="side-nav">
        <li><a href="login.jsp">Login</a></li>
      </ul>
      <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
    </div>
  </nav>
  <!-- **************************** -->
	<center><font size="18" color="grey" style=""><u>
	Register
	</u></font></center></br>
	<form action="Register" method="post">
	 <div class="row">
	 <div class="col s2"></div>
	  <div class="col s3">
	  
	    <div class="input-field col s12">
                <input  id="userId" name="userId" type="text" class="validate">
                <label for="userId">UserId</label>
              </div>
	    <div class="input-field col s12">
	     <input  id="password" name="password" type="text" class="validate">
                <label for="password">Password</label>
              </div>
	    <div class="input-field col s12">
	     <input  id="full_name" name="full_name" type="text" class="validate">
                <label for="full_name">Full Name</label>
              </div>
	    
	    </br>
	  </div>
	  
	  <div class="col s3">
             <div class="input-field col s12">
	     	 <input  id="mobile" name="mobile" type="text" class="validate">
                <label for="mobile">Mobile</label>
              </div>
             
              <div class="input-field col s12">
               <input  id="state" name="state" type="text" class="validate">
                <label for="state">State</label>
              </div>
	    <div class="input-field col s12">
	     <input  id="city" name="city" type="text" class="validate">
                <label for="city">City</label>
              </div>
		<br>
		</div>
	  
	  <div class="col s3">
	  <div class="input-field col s12">
	     <input  id="age" name="age" type="text" class="validate">
                <label for="age">Age</label>
              </div>
	  
	    <div class=" col s12">
              Gender:
			      <input name="gender" type="radio" id="test1" value="male"/>
			      <label for="test1">Male</label>
			   
			      <input name="gender" type="radio" id="test2" value="female"/>
			      <label for="test2">Female</label>
			   
          </div>
	  
	  <div class="input-field col s12">
                      <textarea id="textarea1"  name="address" class="materialize-textarea"></textarea>
                      <label for="textarea1">Address</label>
                    </div>
             </div>
             
		<div class="col s1">	
	</div>
	 
	  <div class="col s3"></div>
	 </div>
	 
	 <div class="row">
	 <div class="col s5">
	  </div>
	 <div class="col s3">
	 <a class="red-text" href="login.jsp">Already Register, Login</a><br><br></div>
	</div>
	<div class="col s4"></div>
	</div>
	 
	 <div class="row">
	 <div class="col s5">
	 </div>
	 <div class="col s3">
	  <button class="btn waves-effect waves-light" type="submit" name="action">Register
			    <i class="material-icons right">send</i>
			  </button>
	</div>
	<div class="col s4"></div>
	</div>
	 </form>
	 <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="js/materialize.js"></script>
  <script src="js/init.js"></script>
</body>
</html>