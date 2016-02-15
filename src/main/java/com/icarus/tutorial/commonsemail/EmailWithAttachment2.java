package com.icarus.tutorial.commonsemail;

import java.net.URL;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;

public class EmailWithAttachment2 {

	public static void main(String[] args) {
		try {
			// Create an attachment object
			EmailAttachment attachment = new EmailAttachment();
			attachment.setURL(new URL("http://www.apache.org/images/asf_logo_wide.gif"));
			attachment.setDisposition(EmailAttachment.ATTACHMENT);
			attachment.setDescription("Apache logo");
			attachment.setName("Apache logo");
			
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
			email.addTo(Constants.MY_PASSWORD, "B");
			
			// Subject
			email.setSubject("The logo");
			
			// Content
			email.setMsg("Here is Apache's logo");
			
			// Add an attachment file
			email.attach(attachment);
			
			// Send email
			email.send();
			
			System.out.println("Sent!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
