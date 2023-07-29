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

import dao.EmployeeDAO;
import dao.UserDAO;
import dto.EmployeeDTO;
import dto.UserDTO;
import utility.Connectionutility;

/**
 * Servlet implementation class AddUserServlet
 */
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String StrUser=request.getParameter("user");
		String strUserName = request.getParameter("usrname");
        String strUserPassword = request.getParameter("usrpwd");
        String strUserPosition = request.getParameter("usrpos");
        int employeeid = 0;
        
        
       String StrQuery="select * from employee where employeename='"+StrUser+"'";
       try
       {
       Connection con=Connectionutility.getconnection2();
       Statement stmt=con.createStatement();
       ResultSet rs=stmt.executeQuery(StrQuery);
       
       while(rs.next())
       {
       employeeid=rs.getInt(1);
       }
       
       }catch(Exception e)
       {
    	   e.printStackTrace();
       }
       
		
		 	 
        UserDTO adto = new UserDTO();
//        adto.setUserid(Integer.parseInt(strAllowanceID));
        adto.setUserid(employeeid);
        adto.setUser(StrUser);
        adto.setUserName(strUserName);
        adto.setUserPassword(strUserPassword);
        adto.setUserPosition(strUserPosition);
        
         try
         {
      	 UserDAO dao = new UserDAO();
      	 
      	   int result = dao.insert(adto);

      	   if(result == 1) {
 				
      		   response.sendRedirect("../payrolll2.0/Users/UserMaintanaince.jsp");
 			   } else {
 				   
 				   out.print("Error Contact Admin");
// 				   response.sendRedirect("../payrolll2.0/ErrorPage/SuccessPage.jsp");
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
