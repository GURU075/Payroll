<!DOCTYPE html>
<%@page import="dto.AllowanceDTO"%>
<%@page import="dao.AllowanceDAO"%>
<%@page import="utility.Connectionutility"%>
<html lang="en">

<head>
    

    <!-- Title Page-->
    <title>Allowance</title>

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
<% 

Connectionutility.check(request, response);

 try {
	 
	 
 	 int aid = Integer.parseInt(request.getParameter("aid"));
	 
	 AllowanceDAO dao = new AllowanceDAO();
 	 AllowanceDTO dto = (AllowanceDTO) dao.retrieve(aid);
 	 
 	
 	    if(dto!= null) {
	
%>
    <div class="page-wrapper bg-gra-02 p-t-130 p-b-100 font-poppins">
        <div class="wrapper wrapper--w680">
            <div class="card card-4">
                <div class="card-body">
                    <h2 class="title">Allowance</h2>
                    <form method="get" action="../EditAllowanceServlet">
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <label class="label">Allowance ID</label>
                                    <input class="input--style-4" type="number" id="allowanceId" name="allowanceId" value="<%=dto.getAllowanceId()%>" readonly>
                                </div>
                            </div>
                            <div class="col-2">
                                <div class="input-group">
                                    <label class="label">Allowance Name</label>
                                    <input class="input--style-4" type="text" id="allowanceName" name="allowanceName" value="<%=dto.getAllowanceName()%>">
                                </div>
                            </div>
                            
                            <div class="col-2">
                                <div class="input-group">
                                    <label class="label">Allowance Description</label>
                                    <input class="input--style-4" type="text" id= "allowanceDesc" name="allowanceDesc" value="<%=dto.getAllowanceDesc()%>">
                                </div>
                            </div>
                        </div>
                        
                        <div class="p-t-15">
                            <button class="btn btn--radius-2 btn--blue" type="submit">Submit</button>
                            
                            <a href="../Allowance/AllowanceMaintaniance.jsp" class="btn btn--radius-2 btn--blue">Back</a>
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
