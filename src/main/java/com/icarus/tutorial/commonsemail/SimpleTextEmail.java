package com.icarus.tutorial.commonsemail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

public class SimpleTextEmail {
	
	public static void main(String[] args) {
		try {
			Email email = new SimpleEmail();
			
			// Configure email server information
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator(Constants.MY_EMAIL, Constants.MY_PASSWORD));
			
			// Setup SSL on connection
			email.setSSLOnConnect(true);
			
			// Sender
			email.setFrom(Constants.MY_EMAIL);
			
			// Subject
			email.setSubject("Test email");
			
			// Content
			email.setMsg("This is a test email... :-)");
			
			// Receiver
			email.addTo(Constants.FRIEND_EMAIL);
			email.send();
			System.out.println("Sent!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
