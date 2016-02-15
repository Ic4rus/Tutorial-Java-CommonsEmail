package com.icarus.tutorial.commonsemail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;

public class EmailWithAttachment {
	
	public static void main(String[] args) {
		try {
			// Create an attachment object
			EmailAttachment attachment = new EmailAttachment();
			attachment.setPath("/map-vietnam.png");
			attachment.setDisposition(EmailAttachment.ATTACHMENT);
			attachment.setDescription("Vietnam Map");
			attachment.setName("Map");
			
			// Create an email object
			MultiPartEmail email = new MultiPartEmail();
			
			// Configure
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setSSLOnConnect(true);
			email.setAuthenticator(new DefaultAuthenticator(Constants.MY_EMAIL, Constants.MY_PASSWORD));
			
			// Sender
			email.setFrom(Constants.MY_EMAIL, "A");
			
			// Receiver
			email.addTo(Constants.FRIEND_EMAIL, "B");
			
			// Subject
			email.setSubject("The Map");
			
			// Content
			email.setMsg("Here is the map you wanted");
			
			// Add attachment file
			email.attach(attachment);
			
			// Send email
			email.send();
			
			System.out.println("Sent!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}