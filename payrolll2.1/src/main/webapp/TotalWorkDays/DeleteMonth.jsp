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
	 
	 
 	int year=Integer.parseInt(request.getParameter("aid"));
 	
 	Connection con = Connectionutility.getconnection2();
 	Statement stmt = con.createStatement();
 	String strQuery = "delete from totalworkdays where year="+year+" and month='"+request.getParameter("month")+"'";
 	
 	 int result = stmt.executeUpdate(strQuery);
 	    if(result > 0 ) {
 	    	response.sendRedirect("../TotalWorkDays/MonthMaintanince.jsp?aid="+year);
 	    } else {
 	    	response.sendRedirect("../ErrorPage/ErrorPage.jsp");
 	    }
 } catch(Exception e) {
	 e.printStackTrace();
 }	    
	    
%>