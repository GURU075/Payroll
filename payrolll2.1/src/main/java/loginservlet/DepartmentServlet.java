package loginservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DepartmentDAO;
import dto.DepartmentDTO;
import utility.Connectionutility;
/**
 * Servlet implementation class DesignationServlet
 */
public class DepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		String StrDepartmentId=request.getParameter("depid");
		String StrDepartmentName=request.getParameter("depname");
		String StrDepartmentLocation=request.getParameter("deplocation");
		String StrDepartmentDesc=request.getParameter("depcomment");
		DepartmentDTO adto = new DepartmentDTO();
		
		
	       adto.setDepartmentId(Integer.parseInt(StrDepartmentId));
	       adto.setDepartmentName(StrDepartmentName);
	       adto.setDepartmentLocation(StrDepartmentLocation);
	       adto.setDepartmentDesc(StrDepartmentDesc);
	       
	       try
	        {
	    	   DepartmentDAO dao = new DepartmentDAO();
	     	 
	     	   int result = dao.insert(adto);

	     	   if(result == 1) {
					
	     		   response.sendRedirect("../payrolll2.0/Department/DepartmentMaintaniance.jsp");
				   } else {
					   
					   out.print("Error Contact Admin");
//					   response.sendRedirect("../payrolll2.0/ErrorPage/SuccessPage.jsp");
				    }
	        }
	        catch(Exception e) {
				e.printStackTrace();
				out.print("Error Contact Admin");
//				response.sendRedirect("../payrolll2.0/ErrorPage/SuccessPage.jsp");
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
