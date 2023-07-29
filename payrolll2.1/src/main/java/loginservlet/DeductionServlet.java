package loginservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeductionDAO;
import dto.deductionDTO;
import utility.Connectionutility;

/**
 * Servlet implementation class AllowanceServlet
 */
public class DeductionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeductionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		String strDeductionId = request.getParameter("deduid"); 
		String strDeductionName = request.getParameter("deduname");
		String strDeductionDesc = request.getParameter("deducomment");
		
		deductionDTO adto = new deductionDTO();
	       adto.setdeductionId(Integer.parseInt(strDeductionId));
	       adto.setdeductionName(strDeductionName);
	       adto.setdeductionDesc(strDeductionDesc);
	       
	       
	       try
	        {
	     	 DeductionDAO dao = new DeductionDAO();
	     	 
	     	   int result = dao.insert(adto);

	     	   if(result == 1) {
					
	     		   response.sendRedirect("../payrolll2.0/Deduction/DeductionMaintaniance.jsp");
				   } else {
					   
					   out.print("Error Contact Admin");
//					   response.sendRedirect("../payrolll2.0/ErrorPage/SuccessPage.jsp");
				    }
	        }catch(Exception e) {
				e.printStackTrace();
				out.print("Error Contact Admin");
//				response.sendRedirect("../payrolll2.0/ErrorPage/SuccessPage.jsp");
			}	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		String strDeductionId = request.getParameter("deduid"); 
		String strDeductionName = request.getParameter("deduname");
		String strDeductionDesc = request.getParameter("deducomment");
		
		String strQuery = "insert into allowance values (" + strDeductionId + ", '" + strDeductionName + "','" + strDeductionDesc + "')";
		
		Connection con=null;
		try
		{
			con=Connectionutility.getconnection2();
			Statement stmt=con.createStatement();
			int result = stmt.executeUpdate(strQuery);
			
			if(result == 1) {
				
				out.println("Successfully inserted !! ");
			} else {
				out.println(" Not inserted !!!!! ");
			}
			 
			
		} catch(Exception e) {
			e.printStackTrace();
			out.println(" Not inserted !!!!! ");
		}	
		
	}

}
