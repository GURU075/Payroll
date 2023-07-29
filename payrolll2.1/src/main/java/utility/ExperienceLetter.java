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

public class ExperienceLetter {
	
	public void Expgenerate(String name,String Emp_no,String Designation,String DOJ,String DOL) throws Exception
	{

		// Creating a PdfWriter       
	      String dest = "D://Expericne.pdf";       
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
	       
//	      Paragraph p1= new Paragraph("hello");
	      
	      
	      
	      
	      
	      float [] pointColumnWidths1 = {250F, 250F};       
	      Table t1 = new Table(pointColumnWidths1);
	      
	      Cell c1 = new Cell();
	      Paragraph h1= new Paragraph("Ref. No: ");
	      c1.add(h1); 
	     c1.setPaddingTop(30);
	      c1.setBorder(Border.NO_BORDER);  
	      t1.addCell(c1);
	      
//	      Cell c11 = new Cell();
//	      Paragraph h11= new Paragraph("eDT/EL/2022/2022010002 ");
//	      c11.setTextAlignment(TextAlignment.LEFT);
//	      c11.add(h11); 
//	      c11.setPaddingTop(30);
//	      c11.setBorder(Border.NO_BORDER);  
//	      t1.addCell(c11);
//	      
	      Cell c2 = new Cell();
	      Paragraph h2= new Paragraph("Date: ");
	      c2.add(h2);
	      c2.setBorder(Border.NO_BORDER);
	      c2.setTextAlignment(TextAlignment.RIGHT);
	      c2.setPaddingTop(30);
	      c2.setPaddingBottom(30);
	      t1.addCell(c2);
	      doc.add(t1);
	      
	      PdfFont bold = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
	      
	      Table t2 = new Table(pointColumnWidths);
	      Cell c3 = new Cell();
	      Paragraph payslip=new Paragraph("Experience Letter");
	      payslip.setFont(bold);
	      c3.add(payslip);
	      c3.setBorder(Border.NO_BORDER);
	      c3.setTextAlignment(TextAlignment.CENTER);
	      c3.setFontSize(14);
	      c3.setPaddingBottom(35);
	      t2.addCell(c3);
	      doc.add(t2);
	      
	      Table t3 = new Table(pointColumnWidths);
	      Cell c4 = new Cell();
	      Paragraph Cocern=new Paragraph("TO WHOMSOEVER IT MAY CONCERN");
	      Cocern.setFont(bold);
	      c4.add(Cocern);
	      c4.setBorder(Border.NO_BORDER);
	      c4.setTextAlignment(TextAlignment.CENTER);
	      c4.setFontSize(11);
	      c4.setPaddingBottom(40);
	      t3.addCell(c4);
	      doc.add(t3);
	      
	      
	      PdfFont regular = PdfFontFactory.createFont(StandardFonts.HELVETICA);
	      
	      
	      
	      Paragraph par=new Paragraph(name);
	      par.setFont(bold);
	      
	      
	      String para1 = "This is to certify that "+name+" with Emp. No. "+Emp_no+"  was appointed in e-DEESHA "
	      		+ "Technologies as a "+Designation+" on "+DOJ+" and he has worked up to "+DOL+".";
	      
	      String para2="According to our knowledge "+name+" has an excellent track record and his work has been "
		      		+ "found satisfactory because of his sincerity, dedication and hard work. We have no problem with him joining"
		      		+ " any other company.";
	      
	      String para3="We wish him every success in his future.\n\n\n\n\n";
	      
	      String para4="With best wishes,\n\n";
	      
	      String para5="For, e-DEESHA Technologies,\nHR Manager";
	      
	      
	      String para6="Company Confidential - This communication is confidential between you and e-DEESHA Technologies.";
	      
	      Paragraph note1 = new Paragraph(para1);
	      note1.setFontSize(11);
	      doc.add(note1);  
	      
	      note1 = new Paragraph(para2);
	      note1.setFontSize(11);
	      doc.add(note1);
	      
	      note1 = new Paragraph(para3);
	      note1.setFontSize(11);
	      doc.add(note1);
	      
	      
	      note1 = new Paragraph(para4);
	      note1.setFontSize(11);
	      doc.add(note1);
	      
	      note1 = new Paragraph(para5);
	      note1.setFont(bold);
	      note1.setFontSize(11);
	      doc.add(note1);
	      
	      //Stamp
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
	      cc1.setFixedPosition(350f, 200f, 150f);
//	      // Adding cell110 to the table       
	      table11.addCell(cc1);                         
//	      
//	      // Adding Table to document        
	      doc.add(table11); 
	      
	      
	      
	      note1 = new Paragraph(para6);
	      note1.setFont(bold);
	      note1.setFontSize(9);
	      doc.add(note1);
//	      note2.setFont(regular);
	      
	    	      
	      
	      //Footer
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
	      System.out.println("Experience Letter generated.");
	}
	public static void main(String[] args) throws Exception
	{
		ExperienceLetter e =new ExperienceLetter();
		e.Expgenerate("Madhav Sandeep Lonkar","MT4522TGG", "Developer", "04/10/2002","04/11/2003");
		  //DT2022010002
		//Software Engineer
		//3-Jan-2022
		//05-Nov-2022
	}
}
