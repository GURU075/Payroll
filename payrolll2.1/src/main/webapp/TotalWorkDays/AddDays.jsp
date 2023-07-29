<!DOCTYPE html>
<%@page import="dto.EmpallowanceDTO"%>
<%@page import="dao.EmpallowanceDAO"%>
<%@page import="dto.AllowanceDTO"%>
<%@page import="dao.AllowanceDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="dto.DTO"%>
<%@page import="java.util.List"%>
<%@page import="utility.Connectionutility"%>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colorlib Templates">
    <meta name="author" content="Colorlib">
    <meta name="keywords" content="Colorlib Templates">

    <!-- Title Page-->
    <title>ADD TWD</title>

    <!-- Icons font CSS-->
    <link href="../CSS/vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="../CSS/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="../CSS/vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="../CSS/vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="../CSS/css/main.css" rel="stylesheet" media="all">
</head>

<body>
<%
Connectionutility.check(request, response);
%>
    <div class="page-wrapper bg-gra-02 p-t-130 p-b-100 font-poppins">
        <div class="wrapper wrapper--w680">
            <div class="card card-4">
                <div class="card-body">
                    <h2 class="title">Total Work Days</h2>
                    <form method="get" action="../TotalWorkDaysServlet">
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <label class="label">Year</label>
                                    <input class="input--style-4" name="year" type="text" id="year">
                                </div>
                            </div>
                            <div class="col-2">
                                <div class="input-group">
                                    <label class="label">Total Working Days</label>
                                    <input class="input--style-4" type="text" name="TWD" id="TWD">
                                </div>
                            </div>
                        </div>
                        
                        <div class="input-group">
                            <label class="label">Month</label>
                            <div class="rs-select2 js-select-simple select--no-search">
                                <select name="months" id="months">
                                    <option disabled="disabled" selected="selected">Choose Month</option>
                        
                                    <option>January</option>
                                    <option>February</option>
                                    <option>March</option>
                                    <option>April</option>
                                    <option>May</option>
                                    <option>June</option>
                                    <option>July</option>
                                    <option>August</option>
                                    <option>September</option>
                                    <option>October</option>
                                    <option>November</option>
                                    <option>December</option>
                                </select>
                                <div class="select-dropdown"></div>
                            </div>
                        </div>
                        
                        <div class="p-t-15">
                            <button class="btn btn--radius-2 btn--blue" type="submit">Submit</button>
                            
                            <a href="../TotalWorkDays/TWDMaintanince.jsp" class="btn btn--radius-2 btn--blue">Back</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Jquery JS-->
    <script src="../CSS/vendor/jquery/jquery.min.js"></script>
    <!-- Vendor JS-->
    <script src="../CSS/vendor/select2/select2.min.js"></script>
    <script src="../CSS/vendor/datepicker/moment.min.js"></script>
    <script src="../CSS/vendor/datepicker/daterangepicker.js"></script>

    <script src="../CSS/js/global.js"></script>

</body>

</html>
