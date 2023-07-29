<%@page import="dao.EmpDeductionDAO"%>
<%@page import="utility.Connectionutility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
			
<%
Connectionutility.check(request, response);

 try {
	 int empid=Integer.parseInt(request.getParameter("empid"));
	 int aid = Integer.parseInt(request.getParameter("aid"));
		
		EmpDeductionDAO dao = new EmpDeductionDAO();
	 	 int result=dao.delete(aid,empid); 
 
	 if(result > 0 ) {
	    	response.sendRedirect("../EmployeeDeduction/EmpDeductionMaintainance.jsp?empid="+empid);
	    } else {
	    	response.sendRedirect("../ErrorPage/ErrorPage.jsp");
	    }
 } catch(Exception e) {
	 e.printStackTrace();
 }	    
	    
%>