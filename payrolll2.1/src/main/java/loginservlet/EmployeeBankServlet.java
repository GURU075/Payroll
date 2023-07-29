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

import dto.EmployeeBankDTO;
import dao.EmployeeBankDAO;
import utility.Connectionutility;

/**
 * Servlet implementation class EmployeeBankServlet
 */
public class EmployeeBankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeBankServlet() {
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
		String StrBankName=request.getParameter("bankname");
		String StrBankBranch=request.getParameter("bankbranch");
		String StrBankAcc=request.getParameter("bankacc");
		int bankid=0;
		
		Connection con=null;
		ResultSet rs=null;
        String StrQuery="select * from bank where Bank_Name='"+StrBankName+"'";
		
		try
        {
  	 		
        	con=Connectionutility.getconnection2();
			Statement stmt=con.createStatement();
			rs=stmt.executeQuery(StrQuery);
			while(rs.next())
			{
			bankid=rs.getInt(1);
			}
        }
		catch(Exception e)
		{
			e.printStackTrace();
		}
   	 
  	 	EmployeeBankDTO adto=new EmployeeBankDTO();
  	 	adto.setEmpid(Integer.parseInt(StrEmpid));
  	 	
  	 	adto.setBankid(bankid);
  	 	adto.setBankName(StrBankName);
  	 	adto.setBankBranch(StrBankBranch);
  	 	adto.setBankAcc(Long.parseLong(StrBankAcc));
        
  	 	
  	 	try {
     	 EmployeeBankDAO dao = new EmployeeBankDAO();
     	 
     	   int result = dao.insert(adto);

     	   if(result == 1) {
				
     		   response.sendRedirect("../payrolll2.0/EmpolyeeBank/EmployeeBankMaintainance.jsp?empid="+StrEmpid);
			   } else {
				   
				   response.sendRedirect("../payrolll2.0/ErrorPage/ErrorPage.jsp");
			    }
        }
        
        catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("../payrolll2.0/ErrorPage/ErrorPage.jsp");
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
