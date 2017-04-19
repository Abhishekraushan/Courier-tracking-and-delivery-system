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
  
  <script type="text/javascript">
  var currentValue = 0;
  var dummy = '<div class="row"><div class="input-field col s12"><input id="arrival"  name="arrival" type="text" class="validate"><label for="arrival">Enter Arrival Timestamp(yyyy-mm-dd hh-mm-ss)</label></div></div>\r\n';
  var dummy1 = '<div class="row"><div class="input-field col s12"><input id="departure"  name="departure" type="text" class="validate"><label for="departure">Enter Departure Timestamp(yyyy-mm-dd hh-mm-ss)</label></div></div>\r\n';
  function handleClick(myRadio) {
	  document.getElementById('wrapper').innerHTML = dummy;
  }
  function handleClick2(myRadio) {
	  document.getElementById('wrapper2').innerHTML = dummy1;
  }
  </script>
</head>
<body bgcolor="blanchedalmond">

	<nav class="light-blue lighten-1" role="navigation">
<div class="nav-wrapper container"><a id="logo-container" href="Home.jsp" class="brand-logo">CDTS</a>
    
    <%String user = (String)request.getAttribute("user");
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
    	%>
    	 <ul class="right hide-on-med-and-down">
        <li><a href="login.jsp">Logout <%=user %></a></li>
      </ul>

      <ul id="nav-mobile" class="side-nav">
        <li><a href="login.jsp">Logout</a></li>
      </ul>
      <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
    	<%
    }
    %>
     
    </div>
  </nav>
  <!-- **************************** -->
	
	<center><font size="18" color="grey" style=""><u>
	<h5>HubManagement System</h5></br>
	<h6> Update Details </h6>
	</u></font></center><br>
		
		 <div class="row">
	  		<div class="col s4"></div>
            <div class="col s4">
            <form action="Hubmanager" method="post">
            <div class="row">
              <div class="input-field col s12">
                <input  id="trackid" name="trackid" type="text" class="validate">
                <label for="trackid">Enter Tracking Id</label>
              </div>
             </div>
              <div class="row">
               <div class="input-field col s12">
					  <select class="browser-default" name="position">
					    <option value="" disabled selected>Enter Location</option>
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
                    <div class="input-field col s12">
                      <p>
					      <input name="timestamp" type="radio" id="test1" value="arrival" onclick="handleClick(this);" />
					      <label for="test1">Enter Arrival Timestamp(yyyy-mm-dd hh-mm-ss)</label>
					    </p>
					    <div id="wrapper"></div>
					    
					    <p>
					      <input name="timestamp" type="radio" id="test2" value="departure" onclick="handleClick2(this);"/>
					      <label for="test2">Enter Departure Timestamp(yyyy-mm-dd hh-mm-ss)</label>
					    </p>
					    <div id="wrapper2"></div>
					    
                    </div>
               </div>
           
             <!-- <div class="row">
                    <div class="input-field col s12">
                      <input id="arrival"  name="arrival" type="text" class="validate">
                      <label for="arrival">Enter Arrival Timestamp(yyyy-mm-dd hh-mm-ss)</label>
                    </div>
               </div>
            <div class="row">
              <div class="input-field col s12">
                <input id="departure"  name="departure" type="text" class="validate">
                <label for="departure">Enter Departure Timestamp(yyyy-mm-dd hh-mm-ss)</label>
              </div> 
            </div> -->
            
             <div class="row">
              <div class="col s4">
              </div>
            <div class="col s4">
             <button class="btn waves-effect waves-light" type="submit" name="action">Update
			    <i class="material-icons right">send</i>
			  </button>
            </div>
            <div class="col s4">
            </div>
          </div>
            
           </form> 
 		</div>
             <div class="col s4">
				 
			</div>
	</div>
	
		
 <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="js/materialize.js"></script>
  <script src="js/init.js"></script>
</body>
</html>