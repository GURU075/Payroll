<!doctype html>
 <%@page import="dto.BankDTO"%>
 <%@page import="dao.BankDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="dto.DTO"%>
<%@page import="java.util.List"%>
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

    <title>Bank Maintaniance</title>
  </head>
  <body>
  

  <div class="content">
    
    <div class="container">
      <h2 class="mb-5">Bank Maintaniance</h2>
      

      <div class="table-responsive">

        <table class="table table-striped custom-table">
          <thead>
            <tr>
              
              <th scope="col">Bank Id</th>
              <th scope="col">Bank Name</th>
              <th scope="col">Bank Branch</th>
              <th scope="col">Bank Description</th>
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
 	
	 BankDAO dao = new BankDAO();
 	 List<DTO> dtolst = dao.retrieveAll();
 	 
 	 Iterator itr = dtolst.iterator();
 	BankDTO dto = new BankDTO();
	    
	    while(itr.hasNext()) {
	    	dto = (BankDTO) itr.next();
	    	
%>
            <tr scope="row">
                <td><%= dto.getBankId()%></td>
                      <td><%= dto.getBankName()%></td>
                      <td><%= dto.getBankBranch()%></td>
                      <td><%= dto.getBankDesc()%></td>
                      
                      <td> <a href="ViewBank.jsp?aid=<%= dto.getBankId()%>" class="more"> View</a> </td>
                      <td> <a href="EditBank.jsp?aid=<%= dto.getBankId()%>" class="more"> Edit</a> </td>
                      <td> <a href="DeleteBank.jsp?aid=<%= dto.getBankId()%>" class="more"> Delete</a> </td>
            
            </tr>
<%	    	
	    	
	    }
 } catch(Exception e) {
	 e.printStackTrace();
 }
 %>  
 							
          </tbody>
          
        </table>
        
        
        
                    <form method="get" action="../Bank/AddBank.jsp">
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