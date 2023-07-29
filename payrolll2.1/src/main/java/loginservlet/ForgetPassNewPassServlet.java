package loginservlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.Connectionutility;
import utility.Encryption_Decryption;

/**
 * Servlet implementation class ForgetPassNewPassServlet
 */
public class ForgetPassNewPassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetPassNewPassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String StrUser=request.getParameter("txtUser");
		String StrPass=request.getParameter("txtPwd");
		
		Encryption_Decryption ee=new Encryption_Decryption();
     	String Encryped=ee.encrypt(StrPass,"Maddy");
     	 
		String StrQuery="UPDATE loginid SET PASSWORD = ? WHERE USERNAME = ?";
		try
		{
			Connection con=Connectionutility.getconnection2();
			PreparedStatement stmt = con.prepareStatement(StrQuery);
			stmt.setString(1, Encryped);
			stmt.setString(2, StrUser);
			
			int result = stmt.executeUpdate();
			
			if(result==1)
			{
				response.sendRedirect("../payrolll2.0/login/login.jsp");
			}
			else
			{
				response.sendRedirect("../payrolll2.0/ErrorPage/ErrorPage.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
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
