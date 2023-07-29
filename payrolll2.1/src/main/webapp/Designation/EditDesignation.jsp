<!DOCTYPE html>
<%@page import="dto.DesignationDTO"%>
<%@page import="dao.DesignationDAO"%>
<%@page import="utility.Connectionutility"%>
<html lang="en">

<head>
    

    <!-- Title Page-->
    <title>Designation</title>

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
                    <h2 class="title">Designation</h2>
                    <form method="get" action="../EditDesignation">
                        <div class="row row-space">
                            <div class="col-2">
 <%
 
 Connectionutility.check(request, response);
 
try {
	 
	 
	 int aid = Integer.parseInt(request.getParameter("aid"));
	 
	 DesignationDAO dao = new DesignationDAO();
	 DesignationDTO dto = (DesignationDTO) dao.retrieve(aid);
	 
	
	    if(dto!= null) {
%>
                                <div class="input-group">
                                    <label class="label">Designation ID</label>
                                    <input class="input--style-4" type="number" id="desiid" name="desiid" value="<%= dto.getDesignationId()%>" readonly>
                                </div>
                            </div>
                            <div class="col-2">
                                <div class="input-group">
                                    <label class="label">Designation Name</label>
                                    <input class="input--style-4" type="text" id="desiname" name="desiname" value="<%= dto.getDesignationName()%>">
                                </div>
                            </div>
                            
                            <div class="col-2">
                                <div class="input-group">
                                    <label class="label">Designation Description</label>
                                    <input class="input--style-4" type="text" id= "desicomment" name="desicomment" value="<%= dto.getDesignationDesc()%>">
                                </div>
                            </div>
                        </div>
                        
                        <div class="p-t-15">
                            <button class="btn btn--radius-2 btn--blue" type="submit">Submit</button>
                            
                            <a href="../Designation/DesignationMaintanaince.jsp" class="btn btn--radius-2 btn--blue">Back</a>
                        </div>
                        
                    </form>
                </div>
            </div>
        </div>
    </div>
<%  	    	
	    
	    }   
 } 
catch(Exception e) 
{
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
