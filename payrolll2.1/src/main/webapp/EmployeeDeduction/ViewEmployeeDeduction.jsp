<!DOCTYPE html>
<%@page import="dao.EmpDeductionDAO "%>
<%@page import="dto.EmpDeductionDTO" %>
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
	
 	EmpDeductionDAO dao = new EmpDeductionDAO();
 	EmpDeductionDTO dto = (EmpDeductionDTO) dao.retrieve(aidd2,aidd);
 	 
 	
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
                                <label for="name">Deduction Id : <%= dto.getDeductionid() %></label>
                            </div>
                            
                         <div class="form-group">
                                <label for="name">Deduction Name : <%= dto.getDeductionname()%></label>
                            </div>
                            
                            <div class="form-group">
                                <label for="name">Deduction Amount : <%= dto.getDeductionamt()%></label>
                            </div>
                      <div class="p-t-15">
                            
                            <a href="../EmployeeDeduction/EmpDeductionMaintainance.jsp?empid=<%= dto.getEmpid()%>" class="btn btn--radius-2 btn--blue">Back</a>
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
    <script src="../CSS/vendor/jquery/jquery.min.js"></script>
    <script src="../CSS/js/main.js"></script>
</body>
</html>