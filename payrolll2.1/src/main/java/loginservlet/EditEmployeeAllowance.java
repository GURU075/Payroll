package loginservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AllowanceDAO;
import dao.EmpallowanceDAO;
import dto.AllowanceDTO;
import dto.EmpallowanceDTO;
import utility.Connectionutility;

/**
 * Servlet implementation class EmployeeAllowanceServlet
 */
public class EditEmployeeAllowance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEmployeeAllowance() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
		
			
			String StrEmpid=request.getParameter("empid");
			String StrAllowance=request.getParameter("allowancename");
			String StrAllowanceAMT=request.getParameter("allowanceamt");
			int allod=0;
			
			Connection con=null;
			ResultSet rs=null;
	        String StrQuery="select * from allowance where Allowance_Name='"+StrAllowance+"'";
			
			try
	        {
	  	 		
	        	con=Connectionutility.getconnection2();
				Statement stmt=con.createStatement();
				rs=stmt.executeQuery(StrQuery);
				while(rs.next())
				{
				allod=rs.getInt(1);
				}
	        }
			catch(Exception e)
			{
				e.printStackTrace();
			}
	   	 
	  	 	EmpallowanceDTO adto=new EmpallowanceDTO();
	  	 	adto.setEmpid(Integer.parseInt(StrEmpid));
	  	 	adto.setAllowanceid(allod);
	  	 	adto.setAllowancename(StrAllowance);
	  	 	adto.setAllowanceamt(Integer.parseInt(StrAllowanceAMT));
	        
	  	 	
	  	 	try {
	     	 EmpallowanceDAO dao = new EmpallowanceDAO ();
	     	 
	     	   int result = dao.update(adto);

	     	   if(result == 1) {
					
	     		   response.sendRedirect("../payrolll2.0/EmployeeAllowance/EmpAllowanceMaintainance.jsp?empid="+StrEmpid);
				   } else {
					   
					   out.print("Error Contact Admin");
//					   response.sendRedirect("../payrolll2.0/ErrorPage/SuccessPage.jsp");
				    }
	        }
	        
	        catch(Exception e) {
				e.printStackTrace();
				response.sendRedirect("../payrolll2.0/ErrorPage/SuccessPage.jsp");
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
