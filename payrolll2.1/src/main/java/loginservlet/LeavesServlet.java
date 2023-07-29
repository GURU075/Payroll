package loginservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LeaveDAO;
import dto.LeaveDTO;

/**
 * Servlet implementation class LeavesServlet
 */
public class LeavesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeavesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		try {
		String StrEmpid=request.getParameter("emp_id");
		String StrLeaveFrom=request.getParameter("leave_from");
		System.out.println("Leavefrom >>>>  " + StrLeaveFrom);
		Date LeaveFrom=Date.valueOf(StrLeaveFrom);
		String StrLeaveTo=request.getParameter("leave_to");
		System.out.println("LeaveTo >>>>  " + StrLeaveTo);
		Date LeaveTo=Date.valueOf(StrLeaveTo);
		System.out.println("Date2 >>>>  "+LeaveTo.toString());
		String StrLeaveType=request.getParameter("leave_type");
		String StrLeaveComment=request.getParameter("leave_desc");
		
		LeaveDTO adto =new LeaveDTO ();
	    adto.setEmpid(Integer.parseInt(StrEmpid));
	    adto.setLeaveFrom(LeaveFrom);
	    adto.setLeaveTo(LeaveTo);
	    adto.setLeaveType(StrLeaveType);
	    adto.setLeaveDesc(StrLeaveComment);
		try
		{
	    LeaveDAO dao = new LeaveDAO();
    	 
  	   int result = dao.insert(adto);
		
		if(result==1)
		{
			response.sendRedirect("../payrolll2.0/Leaves/LeaveMaintainance.jsp?empid="+StrEmpid);
//			out.print("Successfully Inserted");
		}
		else
		{
			out.print("Not Inserted !!!");
		}
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		}catch(Exception e)
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
