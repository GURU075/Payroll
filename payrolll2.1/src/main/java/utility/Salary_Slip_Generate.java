package utility;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;

/**
 * Servlet implementation class Salary_Slip_Generate
 */
public class Salary_Slip_Generate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Salary_Slip_Generate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		//session getting
	      HttpSession session = request.getSession();
	      Object Name = session.getAttribute("Username");
	      
	    //Getting Current Date And Month
	      LocalDate currentdate = LocalDate.now();
	      Month currentMonth = currentdate.getMonth();
		
	      
	      String employeeid = null;
	      String employeename = null,EmployeePan = null,EMPDateOJ = null,EmpDepartment = null;
	      String EmpDesignation = null,EmpBankAcc = null,EmpBankName = null;
	      
	      String StrQuery="select * from employee where employeename='"+Name+"'";
	      
	      try
	      {
	    	  Connection con=Connectionutility.getconnection2();
	    	  Statement stmt=con.createStatement();
	    	  ResultSet rs=stmt.executeQuery(StrQuery);
	    	  if(rs.next())
	    	  {
	    		  employeeid=rs.getString(1);
	    		  employeename=rs.getString(2);
	    		  EmployeePan=rs.getString(8);
	    		  EMPDateOJ=rs.getString(9);
	    		  EmpDepartment=rs.getString(10);
	    		  EmpDesignation=rs.getString(11);
	    		  EmpBankAcc=rs.getString(12);
	    		  EmpBankName=rs.getString(13);
	    	  }
	      }
	      catch(Exception e)
	      {
	    	  e.printStackTrace();
	      }
	      
	      int Professional_Tax = 0,Advance = 0,Other_Deductions = 0;
	      int Basic = 0,HRA = 0,DA = 0,Medical_Allowance=0,Special_Allowance=0,Performance_Bonus=0;
	      
	      String StrQuery1="select * from empallowance where empid="+employeeid;
	      String StrQuery2="select * from empdeduction where empid="+employeeid;
	      
	      try 
	      {
	    	  Connection con=Connectionutility.getconnection2();
	    	  Statement stmt1=con.createStatement();
	    	  ResultSet rs1=stmt1.executeQuery(StrQuery1);
	    	  while(rs1.next())
	    	  {
	    		  int alloid=rs1.getInt(2);
	    		  if(alloid==1)
	    		  {
	    			  Basic=rs1.getInt(4);
	    		  }
	    		  if(alloid==2)
	    		  {
	    			  HRA=rs1.getInt(4);
	    		  }
	    		  if(alloid==3)
	    		  {
	    			  DA=rs1.getInt(4);
	    		  }
	    		  if(alloid==4)
	    		  {
	    			  Medical_Allowance=rs1.getInt(4);
	    		  }
	    		  if(alloid==5)
	    		  {
	    			  Special_Allowance=rs1.getInt(4);
	    		  }
	    		  if(alloid==6)
	    		  {
	    			  Performance_Bonus=rs1.getInt(4);
	    		  }
	    	  }
	    	  
	    	  Statement stmt3=con.createStatement();
	    	  ResultSet rs3=stmt3.executeQuery(StrQuery2);
	    	  while(rs3.next())
	    	  {
	    		  int dedid=rs3.getInt(2);
	    		  if(dedid==1)
	    		  {
	    			  Professional_Tax=rs3.getInt(4);
	    		  }
	    		  if(dedid==2)
	    		  {
	    			  Advance=rs3.getInt(4);
	    		  }
	    		  if(dedid==3)
	    		  {
	    			  Other_Deductions=rs3.getInt(4);
	    		  }
	    	  }
	      }
	      catch(Exception e)
	      {
	    	  e.printStackTrace();
	      }
		// Creating a PdfWriter       
	      String dest = "D://SalarySlip_"+Name+"_"+currentdate+".pdf";       
	      PdfWriter writer = new PdfWriter(dest);           
	      
	      // Creating a PdfDocument       
	      PdfDocument pdf = new PdfDocument(writer);  
	      
	      
	      
	      // Creating a Document        
	      Document doc = new Document(pdf);              
	     
	      
	      float [] pointColumnWidths = {1000f};
	      Table table = new Table(pointColumnWidths);
	      Cell cell10 = new Cell();              
//	       Creating an ImageData object       
	      String imageFile = "file:///D:/PROJECTS/payrolll2.1/src/main/java/utility/Header.jpeg";       
	      ImageData data = ImageDataFactory.create(imageFile);        

	      Image img = new Image(data);              

//	      // Adding image to the cell10       
	      cell10.add(img.setAutoScale(true));        

//	      // Adding cell110 to the table       
	      table.addCell(cell10);                         
//	      
//	      // Adding Table to document        
	      doc.add(table); 
	       
	      Paragraph p1= new Paragraph("hello");
	      
	      
	      float [] pointColumnWidths1 = {250F, 250F};       
	      Table t1 = new Table(pointColumnWidths1);
	      
	      Cell c1 = new Cell();
	      Paragraph h1= new Paragraph("Ref. No: ");
	      c1.add(h1); 
	     
	      c1.setBorder(Border.NO_BORDER);  
	      t1.addCell(c1);
	      
	      
	      Cell c2 = new Cell();
	      Paragraph h2= new Paragraph("Date: ");
	      c2.add(h2);
	      c2.setBorder(Border.NO_BORDER);
	      c2.setTextAlignment(TextAlignment.RIGHT);
	      c2.setPaddingBottom(20);
	      t1.addCell(c2);
	      doc.add(t1);
	      
	      
	      
	      Table t2 = new Table(pointColumnWidths);
	      Cell c3 = new Cell();
	      Paragraph payslip=new Paragraph("Payslip");
	      c3.add(payslip);
	      c3.setBorder(Border.NO_BORDER);
	      c3.setTextAlignment(TextAlignment.CENTER);
	      c3.setFontSize(25);
	      c3.setPaddingBottom(20);
	      t2.addCell(c3);
	      doc.add(t2);
	      
	      float [] pointColumnWidths2 = {137.5F,412.5F}; 
	      Table t3 = new Table(pointColumnWidths2);
	      Cell c4 = new Cell();
	      Paragraph month=new Paragraph("For the month of");
	      c4.setBackgroundColor(null);
	      c4.add(month);
	      t3.addCell(c4);
	      
	      Paragraph month1=new Paragraph(""+currentMonth);
	      Cell c5 = new Cell();
	      c5.add(month1);
	      t3.addCell(c5);
	      
	      doc.add(t3);
	    //*****************************************************************
	      float [] pointColumnWidths3 = {137.5F,137.5F,115f,160f}; 
	      Table t4 = new Table(pointColumnWidths3);
	      
	      
	      Cell c6 = new Cell();
	      Paragraph EmpID=new Paragraph("Emp ID");
	      c6.add(EmpID);
	      t4.addCell(c6);
	      
	      Cell c7 = new Cell();
	      EmpID=new Paragraph(""+employeeid);
	      c7.add(EmpID);
	      t4.addCell(c7);
	      
	      Cell c8 = new Cell();
	      Paragraph Department=new Paragraph("Department");
	      c8.add(Department);
	      t4.addCell(c8);
	      
	      Cell c9 = new Cell();
	      Department=new Paragraph(""+EmpDepartment);
	      c9.add(Department);
	      t4.addCell(c9);
	      
	    //*****************************************************************
	      
	      Cell c10 = new Cell();
	      Paragraph EmpName=new Paragraph("Emp Name:");
	      c10.add(EmpName);
	      t4.addCell(c10);
	      
	      Cell c11 = new Cell();
	      EmpName=new Paragraph(""+employeename);
	      c11.add(EmpName);
	      t4.addCell(c11);
	      
	      Cell c12 = new Cell();
	      Paragraph Designation=new Paragraph("Designation:");
	      c12.add(Designation);
	      t4.addCell(c12);
	      
	      Cell c13 = new Cell();
	      Designation=new Paragraph(""+EmpDesignation);
	      c13.add(Designation);
	      t4.addCell(c13);
	      
	    //*****************************************************************
	      Cell c14 = new Cell();
	      Paragraph EmpPan=new Paragraph("Emp Pan No:");
	      c14.add(EmpPan);
	      t4.addCell(c14);
	      
	      Cell c15 = new Cell();
	      EmpPan=new Paragraph(""+EmployeePan);
	      c15.add(EmpPan);
	      t4.addCell(c15);
	      
	      Cell c16 = new Cell();
	      Paragraph BankAcc=new Paragraph("Bank Account No :");
	      c16.add(BankAcc);
	      t4.addCell(c16);
	      
	      Cell c17 = new Cell();
	      BankAcc=new Paragraph(""+EmpBankAcc);
	      c17.add(BankAcc);
	      t4.addCell(c17);
	      
	    //*****************************************************************
	      
	      Cell c18 = new Cell();
	      Paragraph EMPDOJ1=new Paragraph("DOJ :");
	      c18.add(EMPDOJ1);
	      t4.addCell(c18);
	      
	      Cell c19 = new Cell();
	      EMPDOJ1=new Paragraph(""+EMPDateOJ);
	      c19.add(EMPDOJ1);
	      t4.addCell(c19);
	      
	      Cell c20 = new Cell();
	      Paragraph BankName=new Paragraph("Bank Name:");
	      c20.add(BankName);
	      t4.addCell(c20);
	      
	      Cell c21= new Cell();
	      BankName=new Paragraph(""+EmpBankName);
	      c21.add(BankName);
	      t4.addCell(c21);
	      //*****************************************************************
	      
	      Cell c22= new Cell();
	      Paragraph TWD=new Paragraph("Total Days:");
	      c22.add(TWD);
	      t4.addCell(c22);
	      
	      Cell c23= new Cell();
	      TWD=new Paragraph("31");
	      c23.add(TWD);
	      t4.addCell(c23);
	      
	      Cell c24 = new Cell();
	      Paragraph p11=new Paragraph("Days Present:");
	      c24.add(p11);
	      t4.addCell(c24);
	      
	      Cell c25= new Cell();
	      c25.add(p1);
	      t4.addCell(c25);
	      
	      doc.add(t4);
	      
	      ////////////////////////////////////////////////////////////
	      float [] pointColumnWidths4 = {275F,275F}; 
	      Table t5 = new Table(pointColumnWidths4);
	     
	      Cell cell1 = new Cell();
	      Paragraph s1=new Paragraph("Earnings");
	      cell1.setBackgroundColor(null);
	      cell1.add(s1);
	      t5.addCell(cell1);
	      
	      
	      Cell cell2 = new Cell();
	      Paragraph s2=new Paragraph("Deductions");
	      cell2.add(s2);
	      t5.addCell(cell2);
	      
	      doc.add(t5);
	      
	      //////////////////////////////////////////////////////////////
	      Table t6 = new Table(pointColumnWidths3);
	      
	      Cell cell3 = new Cell();
	      Paragraph Basicsal=new Paragraph("Basic");
	      cell3.add(Basicsal);
	      t6.addCell(cell3);
	      
	      Cell cell4 = new Cell();
	      cell4.setTextAlignment(TextAlignment.RIGHT);
	      Basicsal=new Paragraph(""+Basic);
	      cell4.add(Basicsal);
	      t6.addCell(cell4);
	      
	      Cell cell5 = new Cell();
	      Paragraph proftax=new Paragraph("Professional Tax");
	      cell5.add(proftax);
	      t6.addCell(cell5);
	      
	      Cell cell6 = new Cell();
	      cell6.setTextAlignment(TextAlignment.RIGHT);
	      proftax=new Paragraph(""+Professional_Tax);
	      cell6.add(proftax);
	      t6.addCell(cell6);
	      
	    //*****************************************************************
	      
	      Cell cell7 = new Cell();
	      Paragraph HRAAllowance=new Paragraph("HRA");
	      cell7.add(HRAAllowance);
	      t6.addCell(cell7);
    	  
	      Cell cell8= new Cell();
	      cell8.setTextAlignment(TextAlignment.RIGHT);
	      HRAAllowance=new Paragraph(""+HRA);
	      cell8.add(HRAAllowance);
	      t6.addCell(cell8);
    	  
	      Cell cell9= new Cell();
	      Paragraph advancepayment=new Paragraph("Advance (If Any)");
	      cell9.add(advancepayment);
	      t6.addCell(cell9);
	      
	      Cell cell11 = new Cell();
	      cell11.setTextAlignment(TextAlignment.RIGHT);
	      advancepayment=new Paragraph(""+Advance);
	      cell11.add(advancepayment);
	      t6.addCell(cell11);
	      
	    //*****************************************************************
	      Cell cell12 = new Cell();
	      Paragraph Dearness=new Paragraph("DA");
	      cell12.add(Dearness);
	      t6.addCell(cell12);
	      
	      Cell cell13  = new Cell();
	      cell13.setTextAlignment(TextAlignment.RIGHT);
	      Dearness=new Paragraph(""+DA);
	      cell13.add(Dearness);
	      t6.addCell(cell13);
	      
	      Cell cell14= new Cell();
	      Paragraph leavededuction=new Paragraph("Other Deductions");
	      cell14.add(leavededuction);
	      t6.addCell(cell14);
	      
	      Cell cell15= new Cell();
	      cell15.setTextAlignment(TextAlignment.RIGHT);
	      leavededuction=new Paragraph(""+Other_Deductions);
	      cell15.add(leavededuction);
	      t6.addCell(cell15);
	      
	    //*****************************************************************
	      
	      Cell cell16 = new Cell();
	      Paragraph medical=new Paragraph("Medical Allowance");
	      cell16.add(medical);
	      t6.addCell(cell16);
	      
	      Cell cell17 = new Cell();
	      cell17.setTextAlignment(TextAlignment.RIGHT);
	      medical=new Paragraph(""+Medical_Allowance);
	      cell17.add(medical);
	      t6.addCell(cell17);
	      
	      Cell cell18 = new Cell();
	      Paragraph s10=new Paragraph("");
	      cell18.add(s10);
	      t6.addCell(cell18);
	      
	      Cell cell19= new Cell();
	      cell19.add(s10);
	      t6.addCell(cell19);
	      //*****************************************************************
	      
	      Cell cell20= new Cell();
	      Paragraph specialA=new Paragraph("Special Allowance");
	      cell20.add(specialA);
	      t6.addCell(cell20);
	      
	      Cell cell21= new Cell();
	      cell21.setTextAlignment(TextAlignment.RIGHT);
	      specialA=new Paragraph(""+Special_Allowance);
	      cell21.add(specialA);
	      t6.addCell(cell21);
	      
	      Cell cell22 = new Cell();
	      cell22.add(s10);
	      t6.addCell(cell22);
	      
	      Cell cell23= new Cell();
	      cell23.add(s10);
	      t6.addCell(cell23);
	    //*****************************************************************
	      
	      Cell cell24= new Cell();
	      Paragraph performance=new Paragraph("Performance Bonus (If any)");
	      cell24.add(performance);
	      t6.addCell(cell24);
	      
	      Cell cell25= new Cell();
	      cell25.setTextAlignment(TextAlignment.RIGHT);
	      performance=new Paragraph(""+Performance_Bonus);
	      cell25.add(performance);
	      t6.addCell(cell25);
	      
	      
	      Cell cell26= new Cell();
	      cell26.add(s10);
	      t6.addCell(cell26);
	      
	      Cell cell27= new Cell();
	      cell27.add(s10);
	      t6.addCell(cell27);
	      
	      doc.add(t6);
	      
	      
	      
	      float [] pointColumnWidths5 = {137.5F,137.5F,275F}; 
	      Table t7 = new Table(pointColumnWidths5);
	      
	      int Total_Pay_Allowance=Basic+HRA+DA+Medical_Allowance+Special_Allowance+Performance_Bonus;
	      int Total_Pay_Deduction=Professional_Tax+Advance+Other_Deductions;
	      
	      Cell ct1 = new Cell();
	      Paragraph ctotal=new Paragraph("Total Pay");
	      ct1.setBackgroundColor(null);
	      ct1.add(ctotal);
	      t7.addCell(ct1);
	      
	      Cell ct2 = new Cell();
	      ct2.setBackgroundColor(null);
	      ct2.setTextAlignment(TextAlignment.RIGHT);
	      ctotal=new Paragraph(""+Total_Pay_Allowance);
	      ct2.add(ctotal);
	      t7.addCell(ct2);
	      
	      Cell ct3 = new Cell();
	      ct3.setBackgroundColor(null);
	      ct3.setTextAlignment(TextAlignment.RIGHT);
	      ctotal=new Paragraph(""+Total_Pay_Deduction);
	      ct3.add(ctotal);
	      t7.addCell(ct3);
	      
	      
	      doc.add(t7);
	      float [] pointColumnWidthss = {550f};
	      Table tb0 = new Table(pointColumnWidthss);
	      Cell blank= new Cell();
	      blank.add(s10);
	      blank.setPaddingBottom(20);
	      tb0.addCell(blank);
	      doc.add(tb0);
	      
	      Table t8 = new Table(pointColumnWidths2);
	      
	      int NetPay=Total_Pay_Allowance-Total_Pay_Deduction;
	      Cell ct4 = new Cell();
	      Paragraph Npay=new Paragraph("Net Pay");
	      ct4.setBackgroundColor(null);
	      ct4.add(Npay);
	      t8.addCell(ct4);
	      
	      Cell ct5 = new Cell();
	      ct5.setBackgroundColor(null);
	      Npay=new Paragraph(""+NetPay);
	      ct5.add(Npay);
	      t8.addCell(ct5);
	      
	      numbertostring ns=new numbertostring();
	      Cell ct6 = new Cell();
	      Paragraph NpayW=new Paragraph("Net Pay in Words :");
	      ct6.add(NpayW);
	      t8.addCell(ct6);
	      
	      Cell ct7 = new Cell();
	      String sw=ns.convertToWords(NetPay);
	      String Salaryinwords=sw.substring(0,1).toUpperCase()+sw.substring(1);
	      NpayW=new Paragraph(""+Salaryinwords+" only");
	      ct7.add(NpayW);
	      t8.addCell(ct7);
	      
	      ct7.setPaddingBottom(10);
	      
	      doc.add(t8);
	      
	      blank.setBorder(Border.NO_BORDER);
	      doc.add(tb0);
	      Cell cc = new Cell();
	      Paragraph note=new Paragraph("Note: This payslip is computer generated, hence no signature is required.");
	      cc.add(note);
	      tb0.addCell(cc);
	      doc.add(tb0);
	      
	      
	      float [] pointColumnWidths7 = {1000f};
	      Table table1 = new Table(pointColumnWidths7);
	      Cell cc1 = new Cell();   
	      cc1.setBorder(Border.NO_BORDER);
//	       Creating an ImageData object       
	      String imageFile1 = "file:///D:/PROJECTS/payrolll2.1/src/main/java/utility/Footer.jpeg";       
	      ImageData data1 = ImageDataFactory.create(imageFile1);        

	      Image img1 = new Image(data1);              

//	      // Adding image to the cell10       
	      cc1.add(img1.setAutoScale(true));        
	      cc1.setFixedPosition(34f, 10f, 600f);
//	      // Adding cell110 to the table       
	      table1.addCell(cc1);                         
//	      
//	      // Adding Table to document        
	      doc.add(table1); 
	      
	      // Closing the document       
	      doc.close();             
	      response.sendRedirect("../payrolll2.0/ErrorPage/SuccessPage.jsp");
	      
	     out.print("Hello");
	      
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
