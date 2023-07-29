<%@page import="dto.AllowanceDTO"%>
<%@page import="dto.DTO"%>
<%@page import="dao.AllowanceDAO"%>
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
	
	 AllowanceDAO dao = new AllowanceDAO();
 	 int result=dao.delete(aid); 
 	
 	if(result > 0 ) {
	    	response.sendRedirect("../Allowance/AllowanceMaintaniance.jsp");
	    } else {
	    	response.sendRedirect("../ErrorPage/ErrorPage.jsp");
	    } 
	    
 } catch(Exception e) {
	 e.printStackTrace();
 }
	    	
%>