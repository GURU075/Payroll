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
	 
	 
 
 	Connection con = Connectionutility.getconnection2();
 	Statement stmt = con.createStatement();
 	String strQuery = "delete from totalworkdays where year=" + request.getParameter("aid");
 	
 	 int result = stmt.executeUpdate(strQuery);
 	    if(result > 0 ) {
 	    	response.sendRedirect("../TotalWorkDays/MonthMaintanince.jsp?aid="+request.getParameter("aid"));
 	    } else {
 	    	response.sendRedirect("../ErrorPage/ErrorPage.jsp");
 	    }
 } catch(Exception e) {
	 e.printStackTrace();
 }	    
	    
%>