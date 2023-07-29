<!DOCTYPE html>
<%@page import="dto.AllowanceDTO"%>
<%@page import="dto.DTO"%>
<%@page import="dao.AllowanceDAO"%>
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
	 
	 AllowanceDAO dao = new AllowanceDAO();
 	 AllowanceDTO dto = (AllowanceDTO) dao.retrieve(aid);
 	 
 	
 	    if(dto!= null) {
	
%>

    <div class="main">
        <div class="container">
            <div class="signup-content">
                <div class="signup-img">
                    <img src="../CSS/images/signup-img.jpg" alt="">
                </div>
                <div class="signup-form">
                    <form method="get" action="../Allowance/AllowanceMaintaniance.jsp" class="register-form" id="register-form">
                        <h2>View Data</h2>
                        <div class="form-row">
                            <div class="form-group">
                                <label for="name">Allowance Id :  <%= dto.getAllowanceId()%></label>
                            </div>
                            
                        </div>
						<div class="form-group">
                                <label for="name">Allowance Name : <%= dto.getAllowanceName()%></label>
                            </div>
                            
                         <div class="form-group">
                                <label for="name">Allowance Description : <%= dto.getAllowanceDesc()%></label>
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