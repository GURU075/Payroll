<%@page import="dto.deductionDTO"%>
<%@page import="dto.DTO"%>
<%@page import="dao.DeductionDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="utility.Connectionutility"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
			
<%

Connectionutility.check(request, response);

try {
	 
	int aid = Integer.parseInt(request.getParameter("aid"));
	
	 DeductionDAO dao = new DeductionDAO();
 	 int result=dao.delete(aid); 
 	
 	if(result > 0 ) {
	    	response.sendRedirect("../Deduction/DeductionMaintaniance.jsp");
	    } else {
	    	response.sendRedirect("../ErrorPage/ErrorPage.jsp");
	    } 
	    
 } catch(Exception e) {
	 e.printStackTrace();
 }

	    
%>