<%@page import="dto.DepartmentDTO"%>
<%@page import="dto.DTO"%>
<%@page import="dao.DepartmentDAO"%>
<%@page import="utility.Connectionutility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
			
<%
Connectionutility.check(request, response);
try {
	 
	int aid = Integer.parseInt(request.getParameter("aid"));
	
	DepartmentDAO dao = new DepartmentDAO();
 	 int result=dao.delete(aid); 
 	
 	if(result > 0 ) {
	    	response.sendRedirect("../Department/DepartmentMaintaniance.jsp");
	    } else {
	    	response.sendRedirect("../ErrorPage/ErrorPage.jsp");
	    } 
	    
 } catch(Exception e) {
	 e.printStackTrace();
 } 
%>