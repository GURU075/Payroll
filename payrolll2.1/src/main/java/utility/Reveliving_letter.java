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
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;

public class Reveliving_letter {
	
	public void Revgenerate(String name,String Emp_id,String Designation,String DOL,String DOR) throws Exception
	{
		String dest = "D://Reliving.pdf";       
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
	      
	      
	      float [] pointColumnWidths1 = {250F, 250F};       
	      Table t1 = new Table(pointColumnWidths1);
	      
	      Cell c1 = new Cell();
	      Paragraph h1= new Paragraph("Ref. No: ");
	      c1.add(h1); 
	     c1.setPaddingTop(20);
	      c1.setBorder(Border.NO_BORDER);  
	      t1.addCell(c1);
	      
	      Cell c2 = new Cell();
	      Paragraph h2= new Paragraph("Date: ");
	      c2.add(h2);
	      c2.setBorder(Border.NO_BORDER);
	      c2.setTextAlignment(TextAlignment.RIGHT);
	      c2.setPaddingTop(20);
	      c2.setPaddingBottom(20);
	      t1.addCell(c2);
	      doc.add(t1);
	      
	      PdfFont bold = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
	      PdfFont regular = PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);
	      
	      Paragraph note1 = new Paragraph(name);
	      note1.setFont(bold);
	      note1.setFontSize(11);
	      doc.add(note1);
	      
	      note1 = new Paragraph(Designation);
	      note1.setFont(bold);
	      note1.setFontSize(11);
	      doc.add(note1);
	      
	      note1 = new Paragraph("Emp Id- "+Emp_id);
	      note1.setFont(bold);
	      note1.setFontSize(11);
	      doc.add(note1);
	      
	      
	      Table t2 = new Table(pointColumnWidths);
	      Cell c3 = new Cell();
	      Paragraph payslip=new Paragraph("Relieving Letter").setFont(bold).setUnderline();
	      payslip.setFont(bold);
	      c3.add(payslip);
	      c3.setBorder(Border.NO_BORDER);
	      c3.setTextAlignment(TextAlignment.CENTER);
	      c3.setFontSize(14);
	      c3.setPaddingBottom(25);
	      t2.addCell(c3);
	      doc.add(t2);
	      
	      
	      String para1="This has reference to your letter of resignation dated "+DOR+", wherein you have requested to be relieved from the "
	      		+ "services of the company on "+DOL+". We would like to inform you that your resignation is hereby accepted and you are "
	      		+ "being relieved from the services of the company after serving one month notice period, with effect from closing office "
	      		+ "hours of "+DOL+"\n\n\n"
	      		+ "We also certify that your full and final settlement of account has been cleared with the organization. \n\n"
	      		+ "Your contributions to the organization and its success will always be appreciated.\n\n"
	      		+ "Your contributions to the organization and its success will always be appreciated.";
	      
	      String para4="\n\n\nWith best wishes,";
	      		
	      
	      String para2="For, e-DEESHA Technologies,\nHR Manager";
	      String para3="Company Confidential - This communication is confidential between you and e-DEESHA Technologies.";
	      
	      Paragraph note11=new Paragraph(para1);
	      note11.setFont(regular);
	      note11.setFontSize(11);
	      doc.add(note11);
	      
	      note11=new Paragraph(para4);
	      note11.setFontSize(11);
	      doc.add(note11);
	      
	      note11=new Paragraph(para2);
	      note11.setFont(bold);
	      note11.setFontSize(11);
	      doc.add(note11);
	      
	      
	      
	      float [] pointColumnWidths7 = {100f};
	      Table table11 = new Table(pointColumnWidths7);
	      Cell cc1 = new Cell();   
	      cc1.setBorder(Border.NO_BORDER);
//	       Creating an ImageData object       
	      String imageFile11 = "file:///D:/PROJECTS/payrolll2.1/src/main/java/utility/Stamp.jpg";       
	      ImageData data11 = ImageDataFactory.create(imageFile11);        

	      Image img11 = new Image(data11);              

//	      // Adding image to the cell10       
	      cc1.add(img11.setAutoScale(true));        
	      cc1.setFixedPosition(300f, 150f, 150f);
//	      // Adding cell110 to the table       
	      table11.addCell(cc1);                         
//	      
//	      // Adding Table to document        
	      doc.add(table11); 
	      
	      
	      note1 = new Paragraph(para3);
	      note1.setFont(bold);
	      note1.setFontSize(9);
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
	      
	      // Closing the document       
	      doc.close();             
	      System.out.println("Releiving Letter generated.");
	}
	public static void main(String args[]) throws Exception
	{
		Reveliving_letter r=new Reveliving_letter();
		r.Revgenerate("Madhav Sandeep Lonkar", "DT3221SG4", "Software Engineer", "05/10/2022","10/11/2022");
	}
}
