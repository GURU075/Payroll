<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="utility.Connectionutility"%>
<%@page import="java.sql.Connection"%>
<%@page import="dto.BankDTO"%>
<%@page import="dto.DTO"%>
<%@page import="dao.BankDAO"%>
<%@page import="utility.Connectionutility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
			
<%

Connectionutility.check(request, response);

try {
	 
	int aid = Integer.parseInt(request.getParameter("aid"));
	
	 BankDAO dao = new BankDAO();
 	 int result=dao.delete(aid); 
 	 
	
 	 if(result > 0 ) {
	    	response.sendRedirect("../Bank/BankMaintaniance.jsp");
	    } else {
	    	response.sendRedirect("../ErrorPage/ErrorPage.jsp");
	    } 
	    
 } catch(Exception e) {
	 e.printStackTrace();
 }
	    	
	    
%>