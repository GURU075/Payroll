<!doctype html>
<%@page import="dto.LeaveDTO"%>
<%@page import="java.util.Iterator"%>
<%@page import="dto.DTO"%>
<%@page import="java.util.List"%>
<%@page import="dao.LeaveDAO"%>
<%@page import="dao.EmployeeDAO"%>
<%@page import="dto.EmployeeDTO"%>
<%@page import="utility.Connectionutility"%>
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

<title>Allowane Maintaniance</title>
</head>
<body>
	<form method="get"
		action="../Leaves/AddLeaves.jsp">
		<%
		Connectionutility.check(request, response);
		int employeeid;
		int empaid = Integer.parseInt(request.getParameter("empid"));
		session.setAttribute("empid", empaid);

		try {

			EmployeeDAO dao = new EmployeeDAO();
			EmployeeDTO dto = (EmployeeDTO) dao.retrieve(empaid);
			employeeid = dto.getEmpId();

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
								<th scope="col">Edit</th>
								<th scope="col">Delete</th>
								<th scope="col"></th>
							</tr>


						</thead>
						<tbody>

							<%
							try {

								LeaveDAO dao = new LeaveDAO();
								List<DTO> dtolst = dao.retrieveAll(empaid);

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
								
								<td><a
									href="EditLeaves.jsp?aid=<%=dto.getLeaveId()%>&empid=<%=dto.getEmpid()%>"
									class="more"> Edit</a></td>
								<td><a
									href="DeleteLeaves.jsp?aid=<%=dto.getLeaveId()%>&empid=<%=dto.getEmpid()%>"
									class="more"> Delete</a></td>

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
						<button class="btn btn--radius-2 btn--blue" type="submit">New
							Record</button>

						<a
							href="../Leaves/SearchPage.jsp"
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