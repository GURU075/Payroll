<!doctype html>
<%@page import="dto.deductionDTO"%>
<%@page import="java.util.Iterator"%>
<%@page import="dto.DTO"%>
<%@page import="java.util.List"%>
<%@page import="dao.DeductionDAO"%>
<%@page import="utility.Connectionutility"%>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="../CSS/fonts/icomoon/style1.css">

    <link rel="stylesheet" href="../CSS/css/owl.carousel.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="../CSS/css/bootstrap.min.css">
    <link rel="stylesheet" href="../CSS/fonts/material-icon/css/material-design-iconic-font.min.css">
    <!-- Style -->
    <link rel="stylesheet" href="../CSS/css/style1.css">
     <link href="../CSS/css/main.css" rel="stylesheet" media="all">

    <title>Deduction Maintaniance</title>
  </head>
  <body>
  

  <div class="content">
    
    <div class="container">
      <h2 class="mb-5">Deduction Maintaniance</h2>
      

      <div class="table-responsive">

        <table class="table table-striped custom-table">
          <thead>
            <tr>
              
              <th scope="col">Deduction Id</th>
              <th scope="col">Deduction Name</th>
              <th scope="col">Deduction Description</th>
              <th scope="col">View</th>
              <th scope="col">Edit</th>
              <th scope="col">Delete</th>
              <th scope="col"></th>
            </tr>
          </thead>
       <tbody>
          
<% 
Connectionutility.check(request, response);


try {
 	
	 DeductionDAO dao = new DeductionDAO();
	 List<DTO> dtolst = dao.retrieveAll();
	 
	 Iterator itr = dtolst.iterator();
	 deductionDTO dto = new deductionDTO();
	    
	    while(itr.hasNext()) {
	    	dto = (deductionDTO) itr.next();
	    	
%>
            <tr scope="row">
                <td>
                        <%=dto.getdeductionId()%>
                      </td>
                      <td><%= dto.getdeductionName()%></td>
                      <td>
                        <%= dto.getdeductionDesc()%>
                      </td>
                      <td> <a href="ViewDeduction.jsp?aid=<%= dto.getdeductionId()%>" class="more"> View</a> </td>
					  <td> <a href="EditDeduction.jsp?aid=<%= dto.getdeductionId()%>" class="more"> Edit</a> </td>
					  <td> <a href="DeleteDeduction.jsp?aid=<%= dto.getdeductionId()%>" class="more"> Delete</a> </td>	
            
            </tr>
<%	    	
	    	
	    }
 } catch(Exception e) {
	 e.printStackTrace();
 }
 %>  
 							
          </tbody>
          
        </table>
        
        
        
                    <form method="get" action="../Deduction/Deduction.jsp">
                        <div class="p-t-15">
                            <button class="btn btn--radius-2 btn--blue" type="submit">New Record</button>
                            
                            <a href="../panel1/AdminPanel.jsp" class="btn btn--radius-2 btn--blue">Back</a>
                        </div>
                        
                    </form>
                </div>
            </div>
        </div>
    

 
    
    

    <script src="../CSS/js/jquery-3.3.1.min.js"></script>
    <script src="../CSS/js/popper.min.js"></script>
    <script src="../CSS/js/bootstrap.min.js"></script>
    <script src="../CSS/js/main.js"></script>
  </body>
</html>