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

import utility.Connectionutility;

/**
 * Servlet implementation class LeavesServlet
 */
public class TotalWorkDaysServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TotalWorkDaysServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   
        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String Year=request.getParameter("year");
		String TWD=request.getParameter("TWD");
		String Month=request.getParameter("months");
		
		try {
			String StrQuery="insert into totalworkdays values(?,?,?)";
			Connection con=Connectionutility.getconnection2();
			PreparedStatement stmt=con.prepareStatement(StrQuery);
			stmt.setInt(1, Integer.parseInt(Year));
			stmt.setString(2, Month);
			stmt.setInt(3, Integer.parseInt(TWD));
			
			int result=stmt.executeUpdate();
			if(result==1)
			{
				response.sendRedirect("../payrolll2.0/TotalWorkDays/TWDMaintanince.jsp");
			}
			else
			{
				response.sendRedirect("../payrolll2.0/ErrorPage/ErrorPage.jsp");
			}
			
		}
		catch(Exception e)
		{
			response.sendRedirect("../payrolll2.0/ErrorPage/ErrorPage.jsp");
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
