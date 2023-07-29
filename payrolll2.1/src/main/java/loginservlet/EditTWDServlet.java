package loginservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.Connectionutility;

/**
 * Servlet implementation class EditTWDServlet
 */
public class EditTWDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTWDServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String Year=request.getParameter("year");
		String TWD=request.getParameter("TWD");
		String Month=request.getParameter("months");
		
		System.out.print("Year="+Year);
		System.out.print("Year="+TWD);
		System.out.print("Year="+Month);
		
		try {
			String StrQuery="update totalworkdays set TotalWorkDays=? where year=? and month=?";
			Connection con=Connectionutility.getconnection2();
			PreparedStatement stmt=con.prepareStatement(StrQuery);
			stmt.setInt(2, Integer.parseInt(Year));
			stmt.setString(3, Month);
			stmt.setInt(1, Integer.parseInt(TWD));
			
			int result=stmt.executeUpdate();
			if(result==1)
			{
				response.sendRedirect("../payrolll2.0/TotalWorkDays/MonthMaintanince.jsp?aid="+Year);
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
