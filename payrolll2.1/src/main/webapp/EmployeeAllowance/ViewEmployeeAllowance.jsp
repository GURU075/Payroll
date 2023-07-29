<!DOCTYPE html>
<%@page import="dao.EmpallowanceDAO "%>
<%@page import="dto.EmpallowanceDTO" %>
<%@page import="utility.Connectionutility"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>View Data</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="../CSS/fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="../CSS/css/style.css">
</head>
<body>

<% 

Connectionutility.check(request, response);

try {
	 
	 
	int aidd = Integer.parseInt(request.getParameter("aid"));
	int aidd2 = Integer.parseInt(request.getParameter("empid"));
	
 	EmpallowanceDAO dao = new EmpallowanceDAO();
 	EmpallowanceDTO dto = (EmpallowanceDTO) dao.retrieve(aidd2,aidd);
 	 
 	
 	    if(dto!= null) {
%>

    <div class="main">
        <div class="container">
            <div class="signup-content">
                <div class="signup-img">
                    <img src="../CSS/images/signup-img.jpg" alt="">
                </div>
                <div class="signup-form">
                    <form method="get" id="register-form">
                        <h2>View Data</h2>
                        <div class="form-row">
                            <div class="form-group">
                                <label for="name">Employee Id :  <%= dto.getEmpid()%> </label>
                            </div>
                            
                        </div>
						<div class="form-group">
                                <label for="name">Allowance Id : <%= dto.getAllowanceid() %></label>
                            </div>
                            
                         <div class="form-group">
                                <label for="name">Allowance Name : <%= dto.getAllowancename()%></label>
                            </div>
                            
                            <div class="form-group">
                                <label for="name">Allowance Amount : <%= dto.getAllowanceamt()%></label>
                            </div>
                      <div class="p-t-15">
                            
                            <a href="../EmployeeAllowance/EmpAllowanceMaintainance.jsp?empid=<%= dto.getEmpid()%>" class="btn btn--radius-2 btn--blue">Back</a>
                        </div>
                        
                    </form>
                </div>
            </div>
        </div>

    </div>
<%  	    	
	    } 
	    
 } catch(Exception e) {
	 e.printStackTrace();
 }
	    	
%>
    <!-- JS -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="js/main.js"></script>
</body>
</html>