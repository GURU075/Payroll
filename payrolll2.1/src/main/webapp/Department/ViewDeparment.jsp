<!DOCTYPE html>
<%@page import="dto.DepartmentDTO"%>
<%@page import="dto.DTO"%>
<%@page import="dao.DepartmentDAO"%>
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
		 
		 
		 	int aid = Integer.parseInt(request.getParameter("aid"));
			 
			 DepartmentDAO dao = new DepartmentDAO();
		 	 DepartmentDTO dto = (DepartmentDTO) dao.retrieve(aid);
		 	 
		 	
		 	    if(dto!= null) {
	
%>
    <div class="main">
        <div class="container">
            <div class="signup-content">
                <div class="signup-img">
                    <img src="../CSS/images/signup-img.jpg" alt="">
                </div>
                <div class="signup-form">
                    <form method="get" action="../Department/DepartmentMaintaniance.jsp" class="register-form" id="register-form">
                        <h2>View Data</h2>
                        <div class="form-row">
                            <div class="form-group">
                                <label for="name">Department Id :  <%= dto.getDepartmentId()%></label>
                            </div>
                            
                        </div>
						<div class="form-group">
                                <label for="name">Department Name : <%= dto.getDepartmentName()%></label>
                            </div>
                            
                         <div class="form-group">
                                <label for="name">Department Branch : <%= dto.getDepartmentLocation()%></label>
                            </div>
                            
                            <div class="form-group">
                                <label for="name">Department Description : <%= dto.getDepartmentDesc()%></label>
                            </div>
                        
                        <div class="p-t-15">
                            <input type="submit" value="Back" class="submit" name="submit" id="submit" />
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