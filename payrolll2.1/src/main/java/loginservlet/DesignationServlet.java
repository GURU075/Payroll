package loginservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AllowanceDAO;
import dao.DesignationDAO;
import dto.AllowanceDTO;
import dto.DesignationDTO;
import utility.Connectionutility;
/**
 * Servlet implementation class DesignationServlet
 */
public class DesignationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DesignationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		//desiid  desiname  desicomment
		
		String StrDesignationId=request.getParameter("desiid");
		String StrDesignationName=request.getParameter("desiname");
		String StrDesignationDesc=request.getParameter("desicomment");
		
		
		DesignationDTO adto = new DesignationDTO();
	       adto.setDesignationId(Integer.parseInt(StrDesignationId));
	       adto.setDesignationName(StrDesignationName);
	       adto.setDesignationDesc(StrDesignationDesc);
		
		
		try {
			
			DesignationDAO dao = new DesignationDAO();
	     	 
	     	   int result = dao.insert(adto);

						
			if(result==1)
			{
				response.sendRedirect("../payrolll2.0/Designation/DesignationMaintanaince.jsp");
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
