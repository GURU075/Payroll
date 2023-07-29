<!DOCTYPE html>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="utility.Connectionutility"%>
<%@page import="java.sql.Connection"%>
<%@page import="dto.deductionDTO"%>
<%@page import="dao.DeductionDAO"%>
<html lang="en">

<head>
    

    <!-- Title Page-->
    <title>Edit Deduction</title>

    <!-- Icons font CSS-->
    <link href="../CSS/vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="../CSS/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="../CSS/vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="../CSS/vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="../CSS/css/main.css" rel="stylesheet" media="all">
</head>

<body>
    <div class="page-wrapper bg-gra-02 p-t-130 p-b-100 font-poppins">
        <div class="wrapper wrapper--w680">
            <div class="card card-4">
                <div class="card-body">
                    <h2 class="title">Deduction</h2>
                    <form method="get" action="../EditDeductionServlet2">
                        <div class="row row-space">
                            <div class="col-2">
                            
<% 
Connectionutility.check(request, response);


try {
	 
	 
	 int aid = Integer.parseInt(request.getParameter("aid"));
	 
	 DeductionDAO dao = new DeductionDAO();
	 deductionDTO dto = (deductionDTO) dao.retrieve(aid);
	 
	
	    if(dto!= null) {
	
%>

                                <div class="input-group">
                                    <label class="label">Deduction ID</label>
                                    <input class="input--style-4" type="number" id="deductionid" name="deductionid" value="<%= dto.getdeductionId()%>" readonly>
                                </div>
                            </div>
                            <div class="col-2">
                                <div class="input-group">
                                    <label class="label">Deduction Name</label>
                                    <input class="input--style-4" type="text" id="deductionname" name="deductionname" value="<%= dto.getdeductionName()%>">
                                </div>
                            </div>
                            
                            <div class="col-2">
                                <div class="input-group">
                                    <label class="label">Deduction Description</label>
                                    <input class="input--style-4" type="text" id= "deductionidDesc" name="deductionidDesc" value="<%= dto.getdeductionDesc()%>">
                                </div>
                            </div>
                        </div>
                        
                        <div class="p-t-15">
                            <button class="btn btn--radius-2 btn--blue" type="submit">Submit</button>
                            
                            <a href="../Deduction/DeductionMaintaniance.jsp" class="btn btn--radius-2 btn--blue">Back</a>
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
    <!-- Jquery JS-->
    <script src="../CSS/vendor/jquery/jquery.min.js"></script>
    <!-- Vendor JS-->
    <script src="../CSS/vendor/select2/select2.min.js"></script>
    <script src="../CSS/vendor/datepicker/moment.min.js"></script>
    <script src="../CSS/vendor/datepicker/daterangepicker.js"></script>

    <!-- Main JS-->
    <script src="../CSS/js/global.js"></script>

</body>

</html>
