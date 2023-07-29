<!doctype html>
<%@page import="utility.Connectionutility"%>
<%@page import="dto.LeaveDTO"%>
<%@page import="java.util.Iterator"%>
<%@page import="dto.DTO"%>
<%@page import="java.util.List"%>
<%@page import="dao.LeaveDAO"%>
<%@page import="dao.EmployeeDAO"%>
<%@page import="dto.EmployeeDTO"%>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap"
	rel="stylesheet">

<link rel="stylesheet" href="../CSS/fonts/icomoon/style1.css">

<link rel="stylesheet" href="../CSS/css/owl.carousel.min.css">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="../CSS/css/bootstrap.min.css">
<link rel="stylesheet"
	href="../CSS/fonts/material-icon/css/material-design-iconic-font.min.css">
<!-- Style -->
<link rel="stylesheet" href="../CSS/css/style1.css">
<link href="../CSS/css/main.css" rel="stylesheet" media="all">

<title>Leave Maintaniance</title>
</head>
<body>
	<form method="get"
		action="#">
		<%
		Connectionutility.check(request, response);
		
	    Object empaid = session.getAttribute("Userid");
		int empid=(Integer) empaid;
		
		try {
			EmployeeDAO dao = new EmployeeDAO();
			EmployeeDTO dto = (EmployeeDTO) dao.retrieve(empid);

			if (dto != null) {
		%>

		<div class="content">

			<div class="container">
				<p align="center" class="mb-5"
					style="font-size: 25px; color: orange;">Leave Maintaniance</p>
				<table class="table table-striped custom-table">
					<thead>
						<tr>

							<th scope="col">Employee Id</th>
							<th scope="col"></th>
							<th scope="col"></th>
							<th scope="col">Employee Name</th>
							<th scope="col"></th>
							<th scope="col">Employee Email</th>
							<th scope="col"></th>
						</tr>

						<tr scope="row">
							<td><%=dto.getEmpId()%></td>
							<td></td>
							<td></td>
							<td><%=dto.getEmpName()%></td>
							<td></td>
							<td><%=dto.getEmpEmail()%></td>
						</tr>
						<tr scope="row">
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>


					</thead>
					<tbody>
					</tbody>
				</table>
				<%
				}
				} catch (Exception e) {
				e.printStackTrace();
				}
				%>
				<br>
				<br>
				<br>
				<div class="table-responsive">

					<table class="table table-striped custom-table">
						<thead>
							<tr>

								<th scope="col">Leave Id</th>
								<th scope="col">Leave From</th>
								<th scope="col">Leave To</th>
								<th scope="col">Leave Type</th>
								<th scope="col">Leave Description</th>
								<th scope="col"></th>
							</tr>


						</thead>
						<tbody>

							<%
							try {

								LeaveDAO dao = new LeaveDAO();
								List<DTO> dtolst = dao.retrieveAll(empid);

								Iterator itr = dtolst.iterator();
								LeaveDTO dto = new LeaveDTO();

								while (itr.hasNext()) {
									dto = (LeaveDTO) itr.next();
							%>
							<tr scope="row">
								<td><%=dto.getLeaveId()%></td>
								<td><%=dto.getLeaveFrom()%></td>
								<td><%=dto.getLeaveTo()%></td>
								<td><%=dto.getLeaveType()%></td>
								<td><%=dto.getLeaveDesc()%></td>
								
							</tr>
							<%
							}
							} catch (Exception e) {
							e.printStackTrace();
							}
							%>

						</tbody>

					</table>


					<br>
					<br>

					<div class="p-t-15" align="center">
						

						<a
							href="../panel1/EmployeePanel.jsp"
							class="btn btn--radius-2 btn--blue">Back</a>
					</div>
	</form>
	</div>
	</div>
	</div>






	<script src="../CSS/js/jquery-3.3.1.min.js"></script>
	<script src="../CSS/js/popper.min.js"></script>
	<script src="../CSS/js/bootstrap.min.js"></script>
	<script src="../CSS/js/main.js"></script>
</body>
</html>