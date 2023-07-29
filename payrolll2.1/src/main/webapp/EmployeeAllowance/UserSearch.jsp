<%@page import="utility.Connectionutility" %>
<html>

  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="author" content="colorlib.com">
    <link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet" />
    <link href="../CSS/css/Search.css" rel="stylesheet" />
    <link href="../CSS/css/style.css" rel="stylesheet" />
    <link href="../CSS/css/main.css" rel="stylesheet" />
    <link href="../CSS/css/style1.css" rel="stylesheet" />
  </head>
  <body>
  <%

  Connectionutility.check(request, response);
%>
    <div class="s130">
      <form method="get" action="../EmployeeAllowance/EmpAllowanceMaintainance.jsp">
        <div class="inner-form">
          <div class="input-field first-wrap">
            <div class="svg-wrapper">
              <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">
                <path d="M15.5 14h-.79l-.28-.27C15.41 12.59 16 11.11 16 9.5 16 5.91 13.09 3 9.5 3S3 5.91 3 9.5 5.91 16 9.5 16c1.61 0 3.09-.59 4.23-1.57l.27.28v.79l5 4.99L20.49 19l-4.99-5zm-6 0C7.01 14 5 11.99 5 9.5S7.01 5 9.5 5 14 7.01 14 9.5 11.99 14 9.5 14z"></path>
              </svg>
            </div>
            <input id="search" type="text" name="empid" id="empid" placeholder="Enter Employee ID" />
          </div>
          <div class="input-field second-wrap">
            <button class="btn-search" type="submit">SEARCH</button>
          </div>
          </div>
          <span></span>
          <span></span>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <span class="p-t-15">
                            <a href="../panel1/HRPanel.jsp" class="btn btn--radius-2 btn--blue">Back</a>
                        	</span>
      </form>
      
    </div>
    
    
    <script src="../CSS/js/extention/choices.js"></script>
  </body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>
