<!DOCTYPE html>
<%@page import="dto.EmployeeDTO"%>
<%@page import="dto.DTO"%>
<%@page import="dao.EmployeeDAO"%>
<%@page import="utility.Connectionutility"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>View Data</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="../CSS/fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="../CSS/css/style.css">
</head>
<body>

	<%
	
	Connectionutility.check(request, response);
	
	try {

		int aid = Integer.parseInt(request.getParameter("aid"));

		EmployeeDAO dao = new EmployeeDAO();
		EmployeeDTO dto = (EmployeeDTO) dao.retrieve(aid);

		if (dto != null) {
	%>

	<div class="main">
		<div class="container">
			<div class="signup-content">
				<div class="signup-img">
					<img src="../CSS/images/signup-img.jpg" alt="">
				</div>
				<div class="signup-form">
					<form method="get"
						action="../Employee/EmployeeMaintainance.jsp"
						class="register-form" id="register-form">
						<h2>View Data</h2>
						<div class="form-row">
							<div class="form-group">
								<label for="name">Employee Id : <%=dto.getEmpId()%></label>
							</div>

						</div>

						<div class="form-group">
							<label for="name">Employee Name : <%=dto.getEmpName()%></label>
						</div>

						<div class="form-group">
							<label for="name">Employee Address : <%=dto.getEmpAddress()%></label>
						</div>

						<div class="form-group">
							<label for="name">Employee State : <%=dto.getEmpState()%></label>
						</div>

						<div class="form-group">
							<label for="name">Employee Email : <%=dto.getEmpEmail()%></label>
						</div>

						<div class="form-group">
							<label for="name">Employee Mobile No : <%=dto.getEmpMobileno()%></label>
						</div>

						<div class="form-group">
							<label for="name">Employee Gender : <%=dto.getEmpGender()%></label>
						</div>

						<div class="form-group">
							<label for="name">Employee Pan Details : <%=dto.getEmppan()%></label>
						</div>

						<div class="form-group">
							<label for="name">Employee DOJ : <%=dto.getEmpDOJ()%></label>
						</div>

						<div class="form-group">
							<label for="name">Employee Department : <%=dto.getEmpdepartment()%></label>
						</div>

						<div class="form-group">
							<label for="name">Employee Designation : <%=dto.getEmpdesignation()%></label>
						</div>

						<div class="form-group">
							<label for="name">Employee Bank Account No : <%=dto.getEmpbankaccno()%></label>
						</div>

						<div class="form-group">
							<label for="name">Employee Bank Name : <%=dto.getEmpbankname()%></label>
						</div>
						<div class="p-t-15">
							<input type="submit" value="Back" class="submit" name="submit"
								id="submit" />
						</div>
					</form>
				</div>
			</div>
		</div>

	</div>
	<%
	}

	} catch (Exception e) {
	e.printStackTrace();
	}
	%>
	<!-- JS -->
	<script src="../CSS/vendor/jquery/jquery.min.js"></script>
	<script src="../CSS/js/main.js"></script>
</body>
</html>