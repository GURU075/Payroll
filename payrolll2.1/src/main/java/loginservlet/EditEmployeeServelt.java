package loginservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.Connectionutility;

/**
 * Servlet implementation class EditEmployeeServelt
 */
public class EditEmployeeServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEmployeeServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		int EmpId=Integer.parseInt(request.getParameter("emp_id"));
		String EmpName=request.getParameter("emp_name");
		String EmpAddress=request.getParameter("emp_address");
		String EmpState=request.getParameter("emp_state");
		String EmpEmail=request.getParameter("emp_email");
		String EmpMobileNo=request.getParameter("emp_phone");
		String EmpGender=request.getParameter("emp_gender");
		String EmpPan=request.getParameter("emp_pan");
		String EmpDepartment=request.getParameter("emp_department");
		String EmpDesignation=request.getParameter("emp_designation");
		String EmpAccNo=request.getParameter("emp_bankacc");
		String EmpBankAccName=request.getParameter("emp_bank");
		
		String EmpDOJ1=request.getParameter("emp_DOJ");
//		System.out.println("Leavefrom >>>>  " + EmpDOJ1);
		Date LeaveFrom=Date.valueOf(EmpDOJ1);
		
		String strQuery = "update employee set employeename=?,employeeaddress=?,employeestate=?,employeeemail=?,employeemobno=?,employeegender=?,EmployeePan=?,EMPDOJ=?,EmpDepartment=?,EmpDesignation=?,EmpBankAcc=?,EmpBankName=? where employeeid=?";
		
		Connection con=null;
		try
		{
			con=Connectionutility.getconnection2();
			PreparedStatement stmt=con.prepareStatement(strQuery);
			
			stmt.setString(1, EmpName);
			stmt.setString(2, EmpAddress);
			stmt.setString(3, EmpState);
			stmt.setString(4, EmpEmail);
			stmt.setString(5, EmpMobileNo);
			stmt.setString(6, EmpGender);
			stmt.setString(7, EmpPan);
			stmt.setDate(8, LeaveFrom);
			stmt.setString(9, EmpDepartment);
			stmt.setString(10, EmpDesignation);
			stmt.setString(11, EmpAccNo);
			stmt.setString(12, EmpBankAccName);
			
			stmt.setInt(13, EmpId);
			
			int result = stmt.executeUpdate();
		
			if(result == 1) {
				
				response.sendRedirect("../payrolll2.0/Employee/EmployeeMaintainance.jsp");
			} else {
				out.println(" Not inserted !!!!! ");
			}
			 
			
		} catch(Exception e) {
			e.printStackTrace();
			out.println(" Not inserted !!!!! ");
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
