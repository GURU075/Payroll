<!DOCTYPE html>
<%@page import="java.util.Iterator"%>
<%@page import="dto.DTO"%>
<%@page import="java.util.List"%>
<%@page import="dao.DepartmentDAO"%>
<%@page import="dto.DepartmentDTO"%>
<%@page import="dto.DesignationDTO"%>
<%@page import="dao.DesignationDAO"%>
<%@page import="dto.BankDTO"%>
<%@page import="dao.BankDAO"%>
<%@page import="dao.EmployeeDAO"%>
<%@page import="dto.EmployeeDTO"%>
<%@page import="utility.Connectionutility"%>

<html lang="en">

<head>
<!-- Required meta tags-->
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Colorlib Templates">
<meta name="author" content="Colorlib">
<meta name="keywords" content="Colorlib Templates">

<!-- Title Page-->
<title>Edit Employee</title>

<!-- Icons font CSS-->
<link href="vendor/mdi-font/css/material-design-iconic-font.min.css"
	rel="stylesheet" media="all">
<link href="vendor/font-awesome-4.7/css/font-awesome.min.css"
	rel="stylesheet" media="all">
<!-- Font special for pages-->
<link
	href="https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Vendor CSS-->
<link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
<link href="vendor/datepicker/daterangepicker.css" rel="stylesheet"
	media="all">

<!-- Main CSS-->
<link href="css/main.css" rel="stylesheet" media="all">
</head>

<body>
	<%
	Connectionutility.check(request, response);
	
	try {

		int aid = Integer.parseInt(request.getParameter("aid"));

		EmployeeDAO dao = new EmployeeDAO();
		EmployeeDTO dto = (EmployeeDTO) dao.retrieve(aid);

		if (dto != null) {
			String gender=dto.getEmpGender();
	%>
	<div class="page-wrapper bg-gra-02 p-t-130 p-b-100 font-poppins">
		<div class="wrapper wrapper--w680">
			<div class="card card-4">
				<div class="card-body">
					<h2 class="title">Edit Employee</h2>
					<form method="GET"
						action="../EditEmployeeServelt">
						<div class="row row-space">
							<div class="col-2">
								<div class="input-group">
									<label class="label">Employee ID</label> <input
										class="input--style-4" type="text" name="emp_id" value="<%=dto.getEmpId()%>">
								</div>
							</div>
							<div class="col-2">
								<div class="input-group">
									<label class="label">Employee Name</label> <input
										class="input--style-4" type="text" name="emp_name" value="<%=dto.getEmpName()%>">
								</div>
							</div>

							<div class="col-2">
								<div class="input-group">
									<label class="label">Employee Address</label> <input
										class="input--style-4" type="text" name="emp_address" value="<%=dto.getEmpAddress()%>">
								</div>
							</div>

							<div class="col-2">
								<div class="input-group">
									<label class="label">Employee Email</label> <input
										class="input--style-4" type="text" name="emp_email" value="<%=dto.getEmpEmail()%>">
								</div>
							</div>
						</div>

						<div class="input-group">
							<label class="label">Employee State</label>
							<div class="rs-select2 js-select-simple select--no-search">
								<select name="emp_state">
								
								<option selected="selected"><%=dto.getEmpState() %></option>
										
									
									<option>Maharashtra</option>
									<option>Gujarat</option>
									<option>GOA</option>
									<option>Bihar</option>
									<option>Rajasthan</option>
									<option>Punjab</option>
									<option>Sikkam</option>
									<option>Tripura</option>
									<option>Tamil Nadu</option>
									<option>Manipur</option>
									<option>Madhya Pradesh</option>
								</select>
								<div class="select-dropdown"></div>
							</div>
						</div>

						<div class="row row-space">
							<div class="col-2">
								<div class="input-group">
									<label class="label">Employee DOJ</label>
									<div class="input-group-icon">
										<input type="date" name="emp_DOJ" value="<%=dto.getEmpDOJ()%>">
									</div>
								</div>
							</div>
							<div class="col-2">
								<div class="input-group">
									<label class="label">Gender</label>
									<div class="p-t-10">
									<% if(gender.equals("Male"))
									{ 
										%>
										<label class="radio-container m-r-45">Male <input
											type="radio" checked="checked" name="emp_gender" value="Male" checked>
											<span class="checkmark"></span></label>
										<%}else
										{
											%>
										 <label class="radio-container">Male <input
											type="radio" name="emp_gender" value="Male"> <span
											class="checkmark"></span>
										</label>
										<%} %>
										
										
										<% if(gender.equals("Female"))
									{ 
										%>
										<label class="radio-container m-r-45">Female <input
											type="radio" checked="checked" name="emp_gender" value="Female" checked>
											<span class="checkmark"></span></label>
										<%}else
										{
											%>
										 <label class="radio-container">Female <input
											type="radio" name="emp_gender" value="Female"> <span
											class="checkmark"></span>
										</label>
										<%} %>
									</div>
								</div>
							</div>
						</div>
						<div class="row row-space">

							<div class="col-2">
								<div class="input-group">
									<label class="label">Phone Number</label> <input
										class="input--style-4" type="text" name="emp_phone" value="<%=dto.getEmpMobileno()%>">
								</div>
							</div>
						</div>
						<div class="input-group">
							<label class="label">Department</label>
							<div class="rs-select2 js-select-simple select--no-search">
								<select name="emp_department">
									<option disabled="disabled" selected="selected">Choose
										option</option>
									<% 
try {
 	
	 DepartmentDAO dao1 = new DepartmentDAO();
	 List<DTO> dtolst = dao1.retrieveAll();
	 
	 Iterator itr = dtolst.iterator();
	 DepartmentDTO dto1 = new DepartmentDTO();
	    
	    while(itr.hasNext()) {
	    	dto1 = (DepartmentDTO) itr.next();
	    	
%>
									 <option selected><%=dto1.getDepartmentName()%></option>
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

						<div class="input-group">
							<label class="label">Designation</label>
							<div class="rs-select2 js-select-simple select--no-search">
								<select name="emp_designation">
									<option disabled="disabled" selected="selected">Choose
										option</option>
									<% 
try {
 	
	 DesignationDAO dao2 = new DesignationDAO();
	 List<DTO> dtolst = dao2.retrieveAll();
	 
	 Iterator itr = dtolst.iterator();
	 DesignationDTO dto2 = new DesignationDTO();
	    
	    while(itr.hasNext()) {
	    	dto2 = (DesignationDTO) itr.next();
	    	
	    	
%>
									<option selected><%=dto2.getDesignationName()%></option>
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

						<div class="row row-space">
							<div class="col-2">
								<div class="input-group">
									<label class="label">Employee Pan</label> <input
										class="input--style-4" type="text" name="emp_pan" value="<%=dto.getEmppan()%>">
								</div>
							</div>
							<div class="col-2">
								<div class="input-group">
									<label class="label">Employee Bank Account No</label> <input
										class="input--style-4" type="text" name="emp_bankacc" value="<%=dto.getEmpbankaccno()%>">
								</div>
							</div>

						</div>

						<div class="input-group">
							<label class="label">Bank</label>
							<div class="rs-select2 js-select-simple select--no-search">
								<select name="emp_bank">
									
									<% 
 try {
 	
	 BankDAO dao3 = new BankDAO();
 	 List<DTO> dtolst = dao3.retrieveAll();
 	 
 	 Iterator itr = dtolst.iterator();
 	BankDTO dto3 = new BankDTO();
	    
	    while(itr.hasNext()) {
	    	dto3 = (BankDTO) itr.next();
	    	
%>
									<option selected><%=dto3.getBankName()%></option>
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
							
							<a href="../Employee/EmployeeMaintainance.jsp" class="btn btn--radius-2 btn--blue">Back</a>
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
	<script src="vendor/jquery/jquery.min.js"></script>
	<!-- Vendor JS-->
	<script src="vendor/select2/select2.min.js"></script>
	<script src="vendor/datepicker/moment.min.js"></script>
	<script src="vendor/datepicker/daterangepicker.js"></script>

	<!-- Main JS-->
	<script src="js/global.js"></script>

</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
<!-- end document-->