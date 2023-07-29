package utility;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class ContactUs
 */
public class ContactUs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactUs() {
        super();
        // TODO Auto-generated constructor stub
    }

public int sendEmail(String email,String Name,String Subject) {
		
		//log4j
		final Logger logger=Logger.getLogger(ContactUs.class);
		
		// Create all the needed properties
		Properties connectionProperties = new Properties();
		// SMTP host
		connectionProperties.put("mail.smtp.host", "smtp-relay.sendinblue.com");
		// Is authentication enabled
		connectionProperties.put("mail.smtp.auth", "true");
		// Is TLS enabled
		//connectionProperties.put("mail.smtp.starttls.enable", "true");
		// SSL Port
		connectionProperties.put("mail.smtp.socketFactory.port", "587");
		// SSL Socket Factory class
		connectionProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		// SMTP port, the same as SSL port :)
		connectionProperties.put("mail.smtp.port", "587");
		
		logger.info("Creating the session.....");
//		System.out.print("Creating the session...");
		
		// Create the session
		Session session = Session.getDefaultInstance(connectionProperties,
				new javax.mail.Authenticator() {	// Define the authenticator
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("vayavi6626@yasiok.com","ZDgPTAzQnXOcsESY");
					}
				});
		
//		System.out.println("done!");
		logger.info("Done!");
		// Create and send the message
		try {
			// Create the message 
			Message message = new MimeMessage(session);
			// Set sender
			message.setFrom(new InternetAddress(email));
			// Set the recipients
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("madhavlonkar2@gmail.com"));
			// Set message subject
			message.setSubject("Contact Us -"+Name);
			// Set message text
			message.setText("\n "+Subject);
			
			
			
		   Transport.send(message);	   
		   logger.info("Sending Message.....");  
//			System.out.print("Sending message...");
			// Send the message
//			Transport.send(message);
			
		   logger.info("Done!");
//			System.out.println("done!");
		   
		   
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("email");
		String Name=request.getParameter("username");
		String Subject=request.getParameter("message");
		
//		System.out.print("Email -"+email);
//		System.out.print("Email -"+Name);
//		System.out.print("Email -"+Subject);
//		
		ContactUs c =new ContactUs();
		int result=c.sendEmail(email,Name,Subject);
		
		if(result==1)
		{
			response.sendRedirect("http://../Homepage/ContactUsPage.html");
		}
		else
		{
			response.sendRedirect("http://../Homepage/Homepage.html");
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
