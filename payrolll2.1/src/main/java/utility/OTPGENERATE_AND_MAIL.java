package utility;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

/**
 * itcuties mail example
 * 
 * @author itcuties
 *
 */
public class OTPGENERATE_AND_MAIL {
	
	//public static int num=(int)(10000*Math.random());
	public void sendEmail(int num) {
		
		//log4j
		final Logger logger=Logger.getLogger(OTPGENERATE_AND_MAIL.class);
		
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
			message.setFrom(new InternetAddress("java88pro@gmail.com"));
			// Set the recipients
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("madhavlonkar2@gmail.com"));
			// Set message subject
			message.setSubject("Please Check My Mail");
			// Set message text
			message.setText("\nYour Pin Is :<b>"+num+"</b>");
			
			
			
		   Transport.send(message);	   
		   logger.info("Sending Message.....");
		   logger.debug("sen!");
//			System.out.print("Sending message...");
			// Send the message
//			Transport.send(message);
			
		   logger.info("Done!");
		   logger.debug("Done!");
//			System.out.println("done!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		// Send email
//		OTPGENERATE_AND_MAIL obj=new OTPGENERATE_AND_MAIL();
//		obj.sendEmail(1);
		//BasicConifiguration.configre();
		 
	}
	
	/**
	 * Send the email via SMTP using TLS and SSL
	 */
	
}