<!DOCTYPE html>
<%@page import="dto.DepartmentDTO"%>
<%@page import="dao.DepartmentDAO"%>
<%@page import="utility.Connectionutility"%>
<html lang="en">

<head>
    

    <!-- Title Page-->
    <title>Edit Department</title>

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
                    <h2 class="title">Edit Department</h2>
                    <form method="get" action="../EditDepartmentServlet">
                        <div class="row row-space">
                            <div class="col-2">
 <%
 
 Connectionutility.check(request, response);

try {
	 
	 
	 int aid = Integer.parseInt(request.getParameter("aid"));
	 
	 DepartmentDAO dao = new DepartmentDAO();
	 DepartmentDTO dto = (DepartmentDTO) dao.retrieve(aid);
	 
	
	    if(dto!= null) {
	
%>
                                <div class="input-group">
                                    <label class="label">Department ID</label>
                                    <input class="input--style-4" type="number" id="depid" name="depid" value="<%= dto.getDepartmentId()%>" readonly>
                                </div>
                            </div>
                            <div class="col-2">
                                <div class="input-group">
                                    <label class="label">Department Name</label>
                                    <input class="input--style-4" type="text" id="depname" name="depname" value="<%= dto.getDepartmentName()%>">
                                </div>
                            </div>
                            
                            <div class="col-2">
                                <div class="input-group">
                                    <label class="label">Department Location</label>
                                    <input class="input--style-4" type="text" id="deplocation" name="deplocation" value="<%= dto.getDepartmentLocation()%>" >
                                </div>
                            </div>
                            
                            <div class="col-2">
                                <div class="input-group">
                                    <label class="label">Department Description</label>
                                    <input class="input--style-4" type="text" id= "depcomment" name="depcomment" value="<%= dto.getDepartmentDesc()%>">
                                </div>
                            </div>
                        </div>
                        
                        <div class="p-t-15">
                            <button class="btn btn--radius-2 btn--blue" type="submit">Submit</button>
                            
                            <a href="../Department/DepartmentMaintaniance.jsp" class="btn btn--radius-2 btn--blue">Back</a>
                        </div>
            <%  	    	
	    } 
	    
 } catch(Exception e) {
	 e.printStackTrace();
 }
	    	
%>	            
                    </form>
                </div>
            </div>
        </div>
    </div>

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
