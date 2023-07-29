<!DOCTYPE html>
<%@page import="dto.EmpDeductionDTO"%>
<%@page import="dao.EmpDeductionDAO"%>
<%@page import="dto.deductionDTO"%>
<%@page import="dao.DeductionDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="dto.DTO"%>
<%@page import="java.util.List"%>
<%@page import="utility.Connectionutility"%>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colorlib Templates">
    <meta name="author" content="Colorlib">
    <meta name="keywords" content="Colorlib Templates">

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

<%
Connectionutility.check(request, response);
			int aid = Integer.parseInt(request.getParameter("empid"));
	   		
	  		
			
			%>
    <div class="page-wrapper bg-gra-02 p-t-130 p-b-100 font-poppins">
        <div class="wrapper wrapper--w680">
            <div class="card card-4">
                <div class="card-body">
                    <h2 class="title">Deduction</h2>
                    <form method="get" action="../EditEmployeeDeduction">
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <label class="label">Emp Id</label>
                                    <input class="input--style-4" name="empid" value="<%=request.getParameter("empid")%>" type="text" id="empid" readonly>
                                </div>
                            </div>
                     <% 

try {
	 
	int aidd = Integer.parseInt(request.getParameter("aid"));
	int aidd2 = Integer.parseInt(request.getParameter("empid"));
 	EmpDeductionDAO dao = new EmpDeductionDAO();
 	EmpDeductionDTO dto = (EmpDeductionDTO) dao.retrieve(aidd2,aidd);
 	 
 	
 	    if(dto!= null) {
%>
                            <div class="col-2">
                                <div class="input-group">
                                    <label class="label">Deduction Amount</label>
                                    <input class="input--style-4" type="text" name="Deductionamt" id="Deductionamt" value="<%=dto.getDeductionamt()%>">
                                </div>
                            </div>
                        </div>
   <%	    	
	    	
	    }
 } catch(Exception e) {
	 e.printStackTrace();
 }
%>  
                        <div class="input-group">
                            <label class="label">Deduction Name</label>
                            <div class="rs-select2 js-select-simple select--no-search">
                                <select name="Deductionname" id="Deductionname">
                                    <option disabled="disabled" selected="selected">Choose option</option>
 <% 
 try {
 	 
int aid1 = Integer.parseInt(request.getParameter("aid"));
	 
DeductionDAO dao = new  DeductionDAO();
deductionDTO dto = (deductionDTO) dao.retrieve(aid1);
			 
	 
	    
if(dto!= null) {
	    	
%>
                                    <option selected><%=dto.getdeductionName()%></option>
                                
<%	    	
	    	
	    }
 } catch(Exception e) {
	 e.printStackTrace();
 }
%>
                                </select>
                                <div class="select-dropdown"></div>
                            </div>
                        </div>
                        
                        <div class="p-t-15">
                            <button class="btn btn--radius-2 btn--blue" type="submit">Submit</button>
                            
                            <a href="../EmployeeDeduction/EmpDeductionMaintainance.jsp?empid=<%=aid%>" class="btn btn--radius-2 btn--blue">Back</a>
                        </div>
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

    <script src="../CSS/js/global.js"></script>

</body>

</html>
