<!DOCTYPE html>
<%@page import="utility.Connectionutility"%>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

	<title>Contact Admin</title>

	<link href="https://fonts.googleapis.com/css?family=Montserrat:300,700" rel="stylesheet">

	<link type="text/css" rel="stylesheet" href="css/style2.css" />


</head>

<body>

<%
Connectionutility.check(request, response);
  	Object Position=session.getAttribute("UserPosition");
  
  %>
	<div id="notfound">
		<div class="notfound">
			<div class="notfound-404">
				<h1><span></span></h1>
			</div>
			<h2>Pdf Generated</h2>
			<p>Pdf Generated Successfully Check Your Drive</p>
			<%if(Position.equals("admin")) 
          {
          %>
          
                            <a href="../panel1/AdminPanel.jsp" class="btn btn--radius-2 btn--blue">Back to homepage</a>
                        	
          <%}else if(Position.equals("HR"))
        	  {%>
        	  
                            <a href="../panel1/HRPanel.jsp" class="btn btn--radius-2 btn--blue">Back to homepage</a>
                        	
                  <%}else if(Position.equals("EMP")){ %>
		 
        	  
                            <a href="../panel1/EmployeePanel.jsp" class="btn btn--radius-2 btn--blue">Back to homepage</a>
                        	
                  <%} %>
		</div>
	</div>

</body>

</html>
