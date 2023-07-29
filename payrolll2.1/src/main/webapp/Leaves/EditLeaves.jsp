<!DOCTYPE html>
<%@page import="dao.LeaveDAO" %>
<%@page import="dto.LeaveDTO" %>
<%@page import="java.util.*" %>
<%@page import="dto.DTO"%>
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
    <title>Add Leaves</title>

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
	 
	int aidd = Integer.parseInt(request.getParameter("aid"));
	int aidd2 = Integer.parseInt(request.getParameter("empid"));
	 
	 LeaveDAO dao = new LeaveDAO();
	 LeaveDTO dto = (LeaveDTO) dao.retrieve(aidd,aidd2);
	 
	
	    if(dto!= null) {
	    

%>
    <div class="page-wrapper bg-gra-02 p-t-130 p-b-100 font-poppins">
		<div class="wrapper wrapper--w680">
			<div class="card card-4">
				<div class="card-body">
					<h2 class="title">Add Employee</h2>
					<form method="GET" action="../EditLeaveServlet1">
						<div class="row row-space">
							

							<div class="col-2">
								<div class="input-group">
									<label class="label">Emp ID</label> <input
										class="input--style-4" type="text" name="emp_id" value="<%=aidd2%>" readonly>
								</div>
							</div>
							
							<div class="col-2">
								<div class="input-group">
									<label class="label">Leave ID</label> <input
										class="input--style-4" type="text" name="leave_id" value="<%=aidd%>" readonly>
								</div>
							</div>
						</div>

						
						<div class="row row-space">
							<div class="col-2">
								<div class="input-group">
									<label class="label">Leave From</label>
									<div class="input-group-icon">
										<input type="date"
											name="leave_from" value="<%=dto.getLeaveFrom()%>"> 
									</div>
								</div>
							</div><
                        
                       
							<div class="col-2">
								<div class="input-group">
									<label class="label">Leave To</label>
									<div class="input-group-icon">
										<input type="date"
											name="leave_to" value="<%=dto.getLeaveTo()%>"> 
									</div>
								</div>
							</div>
                        
                        </div>
                        <div class="input-group">
							<label class="label">Leave Type</label>
							<div class="rs-select2 js-select-simple select--no-search">
								<select name="leave_type">
								<option selected="selected"><%=dto.getLeaveType() %></option>
									<option>Paid</option>
									<option>Unpiad</option>
									
								</select>
								<div class="select-dropdown"></div>
							</div>
						</div>
						
						<div class="col-2">
                                <div class="input-group">
                                    <label class="label">Leave Desciption</label>
                                    <input class="input--style-4" type="text" name="leave_desc" id="leave_desc" value="<%=dto.getLeaveDesc()%>">
                                </div>
                            </div>
                            
                      
                        
                        <div class="p-t-15">
                            <button class="btn btn--radius-2 btn--blue" type="submit">Submit</button>
                            
                            <a href="../Leaves/LeaveMaintainance.jsp?empid=<%=aidd2%>" class="btn btn--radius-2 btn--blue">Back</a>
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

    <script src="../CSS/js/global.js"></script>

</body>

</html>
