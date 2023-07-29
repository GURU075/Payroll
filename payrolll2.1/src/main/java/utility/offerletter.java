package utility;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;

public class offerletter {
	
	public void Offergen(String name,String Address,String DOJ,String Designation) throws Exception
	{
		
		
//		String name="Madhav Sandeep Lonkar";
//		String Address="Korhale B.k ,Baramati,Pune \n 412103";
//		String DOJ="20-11-2002";
//		String Designation="Software Developer";
		// Creating a PdfWriter       
	      String dest = "D://Offer Letter.pdf";       
	      PdfWriter writer = new PdfWriter(dest);           
	      
	      // Creating a PdfDocument       
	      PdfDocument pdf = new PdfDocument(writer);  
	      
	      
	      
	      // Creating a Document        
	      Document doc = new Document(pdf);              
	     
	      float [] pointColumnWidths = {1200f};
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
	      
	      
	      PdfFont bold = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
	      PdfFont regular = PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);
	      
	      
	      float [] pointColumnWidths1 = {250F, 250F};       
	      Table t1 = new Table(pointColumnWidths1);
	      
	      Cell c1 = new Cell();
	      Paragraph h1= new Paragraph("Ref. No: ");
	      c1.setFont(bold);
	      c1.setFontSize(10);
	      c1.add(h1); 
	     c1.setPaddingTop(20);
	      c1.setBorder(Border.NO_BORDER);  
	      t1.addCell(c1);
	      
	      Cell c2 = new Cell();
	      Paragraph h2= new Paragraph("Date: ");
	      c2.setFont(bold);
	      c2.setFontSize(10);
	      c2.add(h2);
	      c2.setBorder(Border.NO_BORDER);
	      c2.setTextAlignment(TextAlignment.RIGHT);
	      c2.setPaddingTop(20);
	      c2.setPaddingBottom(10);
	      t1.addCell(c2);
	      doc.add(t1);
	      
	      
	      
	      Paragraph note1 = new Paragraph(name).setFont(bold).setFontSize(10);
	      doc.add(note1);
	      
	      note1 = new Paragraph(Address).setFontSize(10);
	      doc.add(note1);
	      
	      note1 = new Paragraph("Subject: Offer of Employment").setUnderline().setFont(bold).setFontSize(10);
	      doc.add(note1);
	      
	      note1 = new Paragraph("\nDear "+name+",").setFont(bold).setFontSize(10);
	      doc.add(note1);
	      
	      note1 = new Paragraph("Welcome to e-DEESHA Technologies! \n\nCongratulations! We are delighted to make you an offer as ‘Software Engineer’\n\nHere are the terms and conditions of our offer:").setFontSize(10);
	      doc.add(note1);
	      
	      note1 = new Paragraph("1. Joining date :").setFont(bold).setFontSize(10);
	      doc.add(note1);
	      
	      note1 = new Paragraph("Your scheduled date of employment with us will be "+DOJ).setFontSize(10);
	      note1.setPaddingLeft(12);
	      doc.add(note1);
	      
	      note1 = new Paragraph("2. Your Role  Position:").setFont(bold).setFontSize(10);
	      doc.add(note1);
	      
	      note1 = new Paragraph("You will be employed on the terms and conditions in this agreement, in the role of "+Designation+".\n"
	      		+ "In addition to any duties allocated by the employer from time to time, your position will involve the duties set out "
	      		+ "below,\n"
	      		+ "").setFontSize(10);
	      note1.setPaddingLeft(12);
	      doc.add(note1);
	      
	      List list = new List().setSymbolIndent(12) .setListSymbol("\u2022").setFontSize(10).setPaddingLeft(12);
	      list.add(new ListItem("Software Development."));
	      list.add(new ListItem("Unit Testing."));
	      list.add(new ListItem("Peer Review."));
	      doc.add(list);
	      
	      note1 = new Paragraph("3. Location:").setFont(bold).setFontSize(10);
	      doc.add(note1);
	      
	      note1 = new Paragraph("You will be based at the address shown below, you may be asked to relocate to any of our units, departments or the "
	      		+ "offices of our affiliates* and/or the offices of our customers, depending on business requirements.").setFontSize(10);
	      note1.setPaddingLeft(12);
	      doc.add(note1);
	      
	      note1 = new Paragraph("Office address: ").setFont(bold).setFontSize(10).setPaddingLeft(12);
	      doc.add(note1);
	      
	      note1 = new Paragraph("e-DEESHA Technologies, \r\n"
	      		+ "Lane no. 3, Opp. K. K. Market, \r\n"
	      		+ "Punyaenagar, Dhankawadi,\r\n"
	      		+ "Pune – 411043.")
	      		.setFontSize(10);
	      note1.setPaddingLeft(30);
	      doc.add(note1);
	    	      
	      
	      float [] pointColumnWidths71 = {1000f};
	      Table table111 = new Table(pointColumnWidths71);
	      Cell cc11 = new Cell();   
	      cc11.setBorder(Border.NO_BORDER);
//	       Creating an ImageData object       
	      String imageFile111 = "file:///D:/PROJECTS/payrolll2.1/src/main/java/utility/Footer.jpeg";       
	      ImageData data111 = ImageDataFactory.create(imageFile111);        

	      Image img111 = new Image(data111);              

//	      // Adding image to the cell10       
	      cc11.add(img111.setAutoScale(true));        
	      cc11.setFixedPosition(34f, 10f, 600f);
//	      // Adding cell110 to the table       
	      table111.addCell(cc11);                         
//	      
//	      // Adding Table to document        
	      doc.add(table111); 
	      AreaBreak aB = new AreaBreak();
	      doc.add(aB);
	      
	      
	      //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!//Page2!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	      //-----------------------------------------Page2------------------------------------------------------------
	                 

//	      // Adding Table to document        
	      doc.add(table); 
	      
	      note1 = new Paragraph("4. Leave:").setFont(bold).setFontSize(10).setPaddingTop(30);
	      doc.add(note1);
	      
	      note1 = new Paragraph("You are entitled to Earned Leave, right from your date of joining. You will be eligible for 15 working days of leave "
	      		+ "annually, during probation. On confirmation, you will be eligible for 20 working days of leave annually. The Company's "
	      		+ "Policies also provide for Maternity, Paternity and Bereavement Leave. Further details will be provided to you at the"
	      		+ "time of joining.")
	      		.setFontSize(10);
		      note1.setPaddingLeft(12).setTextAlignment(TextAlignment.JUSTIFIED);
		      doc.add(note1);
	      
		      
		   note1 = new Paragraph("\n5. Probation & Confirmation:").setFont(bold).setFontSize(10);
		   doc.add(note1); 
		   
		   note1 = new Paragraph("You will be on probation for a period of six months from the date of joining us. On successful completion of your"
		   		+ "probation, you will be confirmed as a permanent employee of e-DEESHA Technologies. During the probationary "
		   		+ "period your employment may be terminated by either you or the employer upon providing 1 month notice. ")
		      		.setFontSize(10);
			      note1.setPaddingLeft(12).setTextAlignment(TextAlignment.JUSTIFIED);
			      doc.add(note1);
	      
			      
			note1 = new Paragraph("\n6.Notice period:").setFont(bold).setFontSize(10);
			doc.add(note1);
			
			note1 = new Paragraph("During probation, your services can be terminated with one month's notice or salary thereof by either parties. On \r "
					+ "confirmation, you will be required to give three months' notice or salary thereof in case you decide to leave our \r"
					+ "services, subject to the Company's discretion. Where circumstances make it necessary, the Company will have the \r"
					+ "discretion to relieve you only at the end of the three months' notice period. Similarly, the Company can terminate \r"
					+ "your services by giving three months' notice or salary thereof.")
					
			      		.setFontSize(10);
				      note1.setPaddingLeft(12).setTextAlignment(TextAlignment.JUSTIFIED);
				      doc.add(note1);
			
		    note1 = new Paragraph("\n 7.Background checks:").setFont(bold).setFontSize(10);
			doc.add(note1);
		
			note1 = new Paragraph("The Company may, at its discretion, conduct background checks prior to or after your scheduled date of joining. You "
					+ "expressly consent to the Company conducting such background checks. \r\n"
					+ "\nThe Company, at its discretion, may request further validation of the details provided by you. If the outcome of the "
					+ "background check is found to be unsatisfactory, we reserve the right, in our sole discretion, to withdraw this offer "
					+ "without notice nor compensation or to take any appropriate action against you, including, but not limited to "
					+ "termination of your :employment.\r\n"
					+ "\nWhen a background check raises any concerns regarding any of the details furnished by you and the Company feels "
					+ "the need to further validate such facts, we may at our sole discretion, ask you for further information, to substantiate"
					+ "the details that you have earlier provided to us, before initiating appropriate action. Please note that e-DEESHA "
					+ "Technologies requires you to furnish a copy of your passport at the time of joining. If you are unable to do so, the "
					+ "Company will initiate a criminal background check, the cost of which will need to be borne by you")
					
			      		.setFontSize(10);
				      note1.setPaddingLeft(12).setTextAlignment(TextAlignment.JUSTIFIED);
				      doc.add(note1);
				     
	      doc.add(table111); 
	      doc.add(aB);
	      
	      
	      //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!//Page3!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	      //-----------------------------------------Page3------------------------------------------------------------
	          
	      doc.add(table); 
	      
	      note1 = new Paragraph("Other terms and conditions:").setFont(bold).setFontSize(10).setPaddingTop(15);
	      doc.add(note1);
	      
	      list = new List().setSymbolIndent(12) .setListSymbol("\u2022").setFontSize(10).setPaddingLeft(30).setTextAlignment(TextAlignment.JUSTIFIED);
	      list.add(new ListItem("You agree not to undertake employment, whether full-time or part-time, as the Director / Partner / Member"
	      		+ "/ Employee of any other organization / entity engaged in any form of business activity without the consent "
	      		+ "of e-DEESHA Technologies. The consent may be given subject to any terms and conditions that the Company "
	      		+ "may think fit and may be withdrawn at any time at the discretion of the Company. "));
	      
	      list.add(new ListItem("You hereby acknowledge and agree to abide by all internal Policies of the Company."));
	      
	      list.add(new ListItem("These Policies cover various human resources and administrative topics and procedures. "));
	      
	      list.add(new ListItem("The Company reserves the right to change these Policies at any time in its absolute discretion."));
	      
	      list.add(new ListItem("You shall be required to sign certain mandatory agreements, including but not limited to the Confidentiality,"
	      		+ "Intellectual Property Rights, the Code of Business Conduct and Ethics and your employment shall be governed"
	      		+ "by all the rules and regulations, as amended from time to time, of the Company as applicable to your "
	      		+ "employment with us."));
	      
	      list.add(new ListItem("This offer of employment constitutes the entire agreement between you and the Company regarding the"
	      		+ "terms of your employment and it is the complete, final, and exclusive embodiment of your agreement with "
	      		+ "regard to this subject matter and supersedes any other promises, warranties, representations or agreements,"
	      		+ "whether written or oral. "));
	      
	      list.add(new ListItem("It is entered into without reliance on any promise or representation other than those expressly contained"
	      		+ "herein, and it cannot be modified or amended except in writing signed by an authorized officer of the"
	      		+ "Company. "));
	      
	      list.add(new ListItem("If any of the terms or conditions of this offer are found to be illegal or unenforceable, such terms shall be"
	      		+ "treated as severable from the rest of the terms and conditions of this offer and the remaining terms and"
	      		+ "conditions shall continue in force. "));
	      
	      doc.add(list);
	      
	      
	      note1 = new Paragraph("As a token of your acceptance of this offer, please bring a duly signed duplicate copy of the letter and all the"
	      		+ "accompanying annexures, on the date of joining. "
	      		+ "We welcome you to the e-DEESHA family and wish you a rewarding career over the years to come."
	      		+ "\n\nYours sincerely,\r\n\n"
	      		+ "I have read, understood and agree to the terms and conditions as set forth in this offer letter. "
	      		+ "\n\nDate-_____________________,20___________"
	      		+ "\n\n\nSign Your Name :__________________\nLocation:___________________\nEnclosure:\nANNEXUR I - COMPENSATION DETAILS")
					
			      		.setFontSize(10);
				      note1.setPaddingLeft(12).setTextAlignment(TextAlignment.JUSTIFIED);
				      doc.add(note1);
				      
				float [] pointColumnWidths7 = {100f};
				Table table11 = new Table(pointColumnWidths7);
				Cell cc1 = new Cell();   
				cc1.setBorder(Border.NO_BORDER);
//				creating an ImageData object       
				String imageFile11 = "file:///D:/PROJECTS/payrolll2.1/src/main/java/utility/Stamp.jpg";       
				ImageData data11 = ImageDataFactory.create(imageFile11);        

				Image img11 = new Image(data11);              

//				 // Adding image to the cell10       
				cc1.add(img11.setAutoScale(true));        
				cc1.setFixedPosition(320f, 100f, 150f);
//				// Adding cell110 to the table       
				table11.addCell(cc1);                         
//				  
//				// Adding Table to document        
				doc.add(table11); 
	      
				
	      doc.add(table111);
	      doc.add(aB);
	      
	      
	      //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!//Page4!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	      //-----------------------------------------Page4------------------------------------------------------------
	          
	      doc.add(table); 
	      
	      Table t2 = new Table(pointColumnWidths);
	      Cell c3 = new Cell();
	      Paragraph payslip=new Paragraph("ANNEXURE I");
	      c3.add(payslip);
	      c3.setBorder(Border.NO_BORDER);
	      c3.setTextAlignment(TextAlignment.CENTER);
	      c3.setFontSize(10);
	      c3.setPaddingBottom(70);
	      c3.setBold();
	      c3.setPaddingTop(40);
	      t2.addCell(c3);
	      doc.add(t2);
	      
	      
	      float [] pointColumnWidths2 = {250.5F,412.5F}; 
	      Table t3 = new Table(pointColumnWidths2);
	      Cell c4 = new Cell();
	      Paragraph month=new Paragraph("Name");
	      c4.setBackgroundColor(null);
	      c4.add(month);
	      t3.addCell(c4);
	      Paragraph month1=new Paragraph("Mr.Madhav Sandeep Lonkar");
	      Cell c5 = new Cell();
	      c5.add(month1);
	      t3.addCell(c5);
	      doc.add(t3);
	      
	      

	       
	      t3 = new Table(pointColumnWidths2);
	      c4 = new Cell();
	      month=new Paragraph("Title");
	      c4.setBackgroundColor(null);
	      c4.add(month);
	      t3.addCell(c4);
	      month1=new Paragraph("Software Engineer");
	      c5 = new Cell();
	      c5.add(month1);
	      t3.addCell(c5);
	      doc.add(t3);
	      
	      //Component
	      float [] pointColumnWidths22 = {250.5F,209F,209F}; 
	      Table tb3 = new Table(pointColumnWidths22);
	      Cell cl3 = new Cell().setBold();
	      Paragraph Text1=new Paragraph("Components");
	      cl3.setBackgroundColor(null);
	      cl3.add(Text1);
	      tb3.addCell(cl3);
	      Paragraph Text2=new Paragraph("Per Month(RS)");
	      Cell cl4 = new Cell().setBold();
	      cl4.add(Text2);
	      tb3.addCell(cl4);
	      Paragraph Text3=new Paragraph("Per Year(RS)");
	      Cell cl5 = new Cell().setBold();
	      cl5.add(Text3);
	      tb3.addCell(cl5);
	      doc.add(tb3);
	      
	      //Basic
	      float [] pointColumnWidths3 = {258F,215F,209F};
	       tb3 = new Table(pointColumnWidths3);
	       cl3 = new Cell();
	      Text1=new Paragraph("Basic");
	      cl3.setBackgroundColor(null);
	      cl3.add(Text1);
	      tb3.addCell(cl3);
	       Text2=new Paragraph("5000");
	       cl4 = new Cell();
	      cl4.add(Text2);
	      tb3.addCell(cl4);
	       Text3=new Paragraph("10000");
	       cl5 = new Cell();
	      cl5.add(Text3);
	      tb3.addCell(cl5);
	      doc.add(tb3);
	      
	      //HRA
	      float [] pointColumnWidths4 = {257F,215F,209F};
	       tb3 = new Table(pointColumnWidths4);
	       cl3 = new Cell();
	       Text1=new Paragraph("HRA");
	      cl3.setBackgroundColor(null);
	      cl3.add(Text1);
	      tb3.addCell(cl3);
	      Text2=new Paragraph("500");
	       cl4 = new Cell();
	      cl4.add(Text2);
	      tb3.addCell(cl4);
	       Text3=new Paragraph("1000");
	       cl5 = new Cell();
	      cl5.add(Text3);
	      tb3.addCell(cl5);
	      doc.add(tb3);
	      
	      //DA
	      float [] pointColumnWidths5 = {257F,213F,209F};
	       tb3 = new Table(pointColumnWidths5);
	       cl3 = new Cell();
	       Text1=new Paragraph("DA");
	      cl3.setBackgroundColor(null);
	      cl3.add(Text1);
	      tb3.addCell(cl3);
	       Text2=new Paragraph("500");
	       cl4 = new Cell();
	      cl4.add(Text2);
	      tb3.addCell(cl4);
	       Text3=new Paragraph("900");
	       cl5 = new Cell();
	      cl5.add(Text3);
	      tb3.addCell(cl5);
	      doc.add(tb3);
	      
	      //Medical Allowance
	      float [] pointColumnWidths6 = {249F,218F,209F};
	       tb3 = new Table(pointColumnWidths6);
	       cl3 = new Cell();
	       Text1=new Paragraph("Medical Allowance");
	      cl3.setBackgroundColor(null);
	      cl3.add(Text1);
	      tb3.addCell(cl3);
	       Text2=new Paragraph("600");
	       cl4 = new Cell();
	      cl4.add(Text2);
	      tb3.addCell(cl4);
	       Text3=new Paragraph("54333");
	       cl5 = new Cell();
	      cl5.add(Text3);
	      tb3.addCell(cl5);
	      doc.add(tb3);
	      
	      //Special Allowance
	      float [] pointColumnWidths8 = {246F,215F,209F};
	       tb3 = new Table(pointColumnWidths8);
	       cl3 = new Cell();
	       Text1=new Paragraph("Special Allowance");
	      cl3.setBackgroundColor(null);
	      cl3.add(Text1);
	      tb3.addCell(cl3);
	       Text2=new Paragraph("700");
	       cl4 = new Cell();
	      cl4.add(Text2);
	      tb3.addCell(cl4);
	      Text3=new Paragraph("8000");
	       cl5 = new Cell();
	      cl5.add(Text3);
	      tb3.addCell(cl5);
	      doc.add(tb3);
	      
	      //Performance Allowance
	      float [] pointColumnWidths9 = {243F,215F,209F};
	       tb3 = new Table(pointColumnWidths9);
	       cl3 = new Cell();
	       Text1=new Paragraph("Performance Allowance");
	      cl3.setBackgroundColor(null);
	      cl3.add(Text1);
	      tb3.addCell(cl3);
	       Text2=new Paragraph("5000");
	       cl4 = new Cell();
	      cl4.add(Text2);
	      tb3.addCell(cl4);
	       Text3=new Paragraph("50000");
	       cl5 = new Cell();
	      cl5.add(Text3);
	      tb3.addCell(cl5);
	      doc.add(tb3);
	      
	      //Total Pay
	      float [] pointColumnWidths10 = {266F,217F,209F};
	       tb3 = new Table(pointColumnWidths10);
	       cl3 = new Cell();
	       Text1=new Paragraph("Total Pay");
	      cl3.setBackgroundColor(null);
	      cl3.add(Text1);
	      tb3.addCell(cl3);
	       Text2=new Paragraph("10000");
	       cl4 = new Cell();
	      cl4.add(Text2);
	      tb3.addCell(cl4);
	       Text3=new Paragraph("1000000");
	       cl5 = new Cell();
	      cl5.add(Text3);
	      tb3.addCell(cl5);
	      doc.add(tb3);
	      
	      
	      
	      
//	      float [] pointColumnWidths78 = {100f};
			 table11 = new Table(pointColumnWidths7);
			 cc1 = new Cell();   
			cc1.setBorder(Border.NO_BORDER);
//			creating an ImageData object       
			 imageFile11 = "file:///D:/PROJECTS/payrolll2.1/src/main/java/utility/Stamp.jpg";       
			 data11 = ImageDataFactory.create(imageFile11);        

			 img11 = new Image(data11);              

//			 // Adding image to the cell10       
			cc1.add(img11.setAutoScale(true));        
			cc1.setFixedPosition(220f, 200f, 150f);
//			// Adding cell110 to the table       
			table11.addCell(cc1);                         
//			  
//			// Adding Table to document        
			doc.add(table11); 
			
			
	      
	      doc.add(table111);
	      
	      // Closing the document       
	      doc.close();             
	      System.out.println("Offer Letter generated.");
	}
	public static void main(String[] args) throws Exception
	{
		offerletter o =new offerletter();
		o.Offergen("Madhav Sandeep Lonkar", "A/p Korhale B.k,Baramati,Pune\nDist-Pune\nPincode-412103\nPh:(91)9370548600", "04/10/2002", "Software Engineer");
//		o.Offergen();
	}
}
