package loginservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.ExperienceLetter;
import utility.Reveliving_letter;
import utility.offerletter;

/**
 * Servlet implementation class GenerateLetterServlet
 */
public class GenerateLetterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerateLetterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		String empid=request.getParameter("empid");
		String empname=request.getParameter("empname");
		String empbranch=request.getParameter("empbranch");
		String empdepartment=request.getParameter("empdepartment");
		String empdesignation=request.getParameter("empdesignation");
		String emppf=request.getParameter("emppf");
		String empbank=request.getParameter("empbank");
		String empbankno=request.getParameter("empbankno");
		String emppanno=request.getParameter("emppanno");
		String empUAN=request.getParameter("empUAN");
		String empoffer=request.getParameter("empoffer");
		String empDOJ=request.getParameter("empDOJ");
		String empoffersal=request.getParameter("empoffersal");
		String empaddress=request.getParameter("empaddress");
		String empmobile=request.getParameter("empmobile");
		String empemail=request.getParameter("empemail");
		String empincsal=request.getParameter("empincsal");
		String empincdate=request.getParameter("empincdate");
		String empexp=request.getParameter("empexp");
		String regdate=request.getParameter("regdate");
		String empLWD=request.getParameter("empLWD");
		
		ExperienceLetter e =new ExperienceLetter();
		offerletter o =new offerletter();
		Reveliving_letter r=new Reveliving_letter();
		try {
			r.Revgenerate(empname, empid, empdesignation, regdate,empLWD);
			o.Offergen(empname, "A/p Korhale B.k,Baramati,Pune\nDist-Pune\nPincode-412103\nPh:(91)9370548600", empoffer, empdesignation);
			e.Expgenerate(empname,empid, empdesignation, empDOJ,empLWD);
			response.sendRedirect("../payrolll2.0/ErrorPage/SuccessPage.jsp");
			
		} 
		catch (Exception e1) 
		{
			response.sendRedirect("../payrolll2.0/ErrorPage/ErrorPage.jsp");
			e1.printStackTrace();
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
