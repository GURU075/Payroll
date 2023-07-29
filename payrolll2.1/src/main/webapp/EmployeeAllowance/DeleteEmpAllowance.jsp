<%@page import="dao.EmpallowanceDAO"%>
<%@page import="utility.Connectionutility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
			
<%
Connectionutility.check(request, response);

 try {
	 int empid=Integer.parseInt(request.getParameter("empid"));
	 int aid = Integer.parseInt(request.getParameter("aid"));
		
		EmpallowanceDAO dao = new EmpallowanceDAO();
	 	 int result=dao.delete(aid,empid); 
 
	 if(result > 0 ) {
	    	response.sendRedirect("../EmployeeAllowance/EmpAllowanceMaintainance.jsp?empid="+empid);
	    } else {
	    	response.sendRedirect("../ErrorPage/ErrorPage.jsp");
	    }
 } catch(Exception e) {
	 e.printStackTrace();
 }	    
	    
%>