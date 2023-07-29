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

import dao.AllowanceDAO;
import dto.AllowanceDTO;
import utility.Connectionutility;

/**
 * Servlet implementation class AllowanceServlet
 */
public class AllowanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllowanceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		String strAllowanceID = request.getParameter("allowanceId");
        String strAllowanceName = request.getParameter("allowanceName");
        String strAllowanceDesc = request.getParameter("allowanceDesc");
        
       AllowanceDTO adto = new AllowanceDTO();
       adto.setAllowanceId(Integer.parseInt(strAllowanceID));
       adto.setAllowanceName(strAllowanceName);
       adto.setAllowanceDesc(strAllowanceDesc);
       
        try
        {
     	 AllowanceDAO dao = new AllowanceDAO();
     	 
     	   int result = dao.insert(adto);

     	   if(result == 1) {
				
     		   response.sendRedirect("../payrolll2.0/Allowance/AllowanceMaintaniance.jsp");
			   } else {
				   
				   out.print("Error Contact Admin");
//				   response.sendRedirect("../payrolll2.0/ErrorPage/SuccessPage.jsp");
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
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		String strAllowanceId = request.getParameter("allowanceId"); 
		String strAllowanceName = request.getParameter("allowanceName");
		String strAllowanceDesc = request.getParameter("allowanceDesc");
		
		String strQuery = "insert into allowance values (" + strAllowanceId + ", '" + strAllowanceName + "','" + strAllowanceDesc + "')";
		
		Connection con=null;
		try
		{
			con=Connectionutility.getconnection2();
			Statement stmt=con.createStatement();
			int result = stmt.executeUpdate(strQuery);
			
			if(result == 1) {
				
				response.sendRedirect("../payrolll2.0/AllowanceMaintaniance.jsp");
			} else {
				out.println(" Not inserted !!!!! ");
			}
			 
			
		} catch(Exception e) {
			e.printStackTrace();
			out.println(" Not inserted !!!!! ");
		}	
		
	}

}
