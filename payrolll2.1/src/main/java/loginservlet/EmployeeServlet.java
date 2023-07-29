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
 * Servlet implementation class DesignationServlet
 */
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
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
		
//		String EmpDOJ1=request.getParameter("emp_DOJ");
//		Date EmpDOJ=Date.valueOf(EmpDOJ1);
		
		String EmpDOJ1=request.getParameter("emp_DOJ");
		System.out.println("Leavefrom >>>>  " + EmpDOJ1);
		
		System.out.print("\nValue"+EmpId);
		System.out.print("\nValue"+EmpName);
		System.out.print("\nValue"+EmpAddress);
		System.out.print("\nValue"+EmpState);
		System.out.print("\nValue"+EmpEmail);
		System.out.print("\nValue"+EmpMobileNo);
		System.out.print("\nValue"+EmpGender);
		System.out.print("\nValue"+EmpPan);
		System.out.print("\nValue"+EmpDepartment);
		System.out.print("\nValue"+EmpDesignation);
		System.out.print("\nValue"+EmpAccNo);
		System.out.print("\nValue"+EmpBankAccName);
		Date LeaveFrom=Date.valueOf(EmpDOJ1);
		
		
		
		
//		String StrEmployeeID=request.getParameter("txtId");
//		String StrEmployeeName=request.getParameter("txtName");
//		String StrEmployeeAddress=request.getParameter("address");
//		String StrEmployeeState=request.getParameter("states");
//		String StrEmployeeEmail=request.getParameter("email");
//		String StrEmployeeMobNo=request.getParameter("no");
//		String StrEmployeeGender=request.getParameter("gen");
//		String[] StrEmployeeLang=request.getParameterValues("fav_lan");
		
		String strQuery="insert into employee values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			Connection con=Connectionutility.getconnection2();
			PreparedStatement stmt=con.prepareStatement(strQuery);
			
			stmt.setInt(1, EmpId);
			stmt.setString(2, EmpName);
			stmt.setString(3, EmpAddress);
			stmt.setString(4, EmpState);
			stmt.setString(5, EmpEmail);
			stmt.setString(6, EmpMobileNo);
			stmt.setString(7, EmpGender);
			stmt.setString(8, EmpPan);
			stmt.setDate(9, LeaveFrom);
			stmt.setString(10, EmpDepartment);
			stmt.setString(11, EmpDesignation);
			stmt.setString(12, EmpAccNo);
			stmt.setString(13, EmpBankAccName);
			
			
			
			int result=stmt.executeUpdate();
			
			if(result==1)
			{
				response.sendRedirect("../payrolll2.0/Employee/EmployeeMaintainance.jsp");
//				out.print("Successfully Inserted");
			}
			else
			{
				out.print("Not Inserted !!!");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			out.print("Not Inserted !!!");
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
