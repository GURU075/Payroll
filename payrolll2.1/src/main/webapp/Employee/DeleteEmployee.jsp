<%@page import="dto.EmployeeDTO"%>
<%@page import="dao.EmployeeDAO"%>
<%@page import="utility.Connectionutility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
			
<%
Connectionutility.check(request, response);
 try {
	 
	 int aid = Integer.parseInt(request.getParameter("aid"));
		
		EmployeeDAO dao = new EmployeeDAO();
	 	 int result=dao.delete(aid); 
 
	 if(result > 0 ) {
	    	response.sendRedirect("../Employee/EmployeeMaintainance.jsp");
	    } else {
	    	response.sendRedirect("../ErrorPage/ErrorPage.jsp");
	    }
 } catch(Exception e) {
	 e.printStackTrace();
 }	    
	    
%>