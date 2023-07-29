<%@page import="dao.LeaveDAO" %>
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
	 
	 int empid=Integer.parseInt(request.getParameter("empid"));
	 int aid = Integer.parseInt(request.getParameter("aid"));
		
		LeaveDAO dao = new LeaveDAO();
	 	 int result=dao.delete(aid,empid); 
	 	 
 	    if(result > 0 ) {
 	    	response.sendRedirect("../Leaves/LeaveMaintainance.jsp?empid="+empid);
 	    } else {
 	    	response.sendRedirect("../ErrorPage/ErrorPage.jsp");
 	    }
 } catch(Exception e) {
	 e.printStackTrace();
 }	    
	    
%>