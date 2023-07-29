package loginservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BankDAO;
import dto.BankDTO;
import utility.Connectionutility;
/**
 * Servlet implementation class DesignationServlet
 */
public class BankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		String StrBankId=request.getParameter("bankid");
		String StrBankName=request.getParameter("bankname");
		String StrBankBranch=request.getParameter("bankbranch");
		String StrBrankDesc=request.getParameter("bankcomment");
		
		BankDTO adto = new BankDTO();
	       adto.setBankId(Integer.parseInt(StrBankId));
	       adto.setBankName(StrBankName);
	       adto.setBankBranch(StrBankBranch);
	       adto.setBankDesc(StrBrankDesc);
	       
	        try
	        {
	     	 BankDAO dao = new BankDAO();
	     	 
	     	   int result = dao.insert(adto);

	     	   if(result == 1) {
					
	     		   response.sendRedirect("../payrolll2.0/Bank/BankMaintaniance.jsp");
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
