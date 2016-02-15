package com.icarus.tutorial.commonsemail;

import java.net.URL;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;

public class SendHtmlEmbedImageEmail {
	
	public static void main(String[] args) {
		try {
			// Content template to send
			// Img has relative path
			String htmlEmailTemplate = "<h2>Hello</h2>"
					+ "This is Apache Logo <br/>"
					+ "<img src='proper/commons-email/images/commons-logo.png'/>";
			
			// Create an email object
			ImageHtmlEmail email = new ImageHtmlEmail();
			
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
			email.setSubject("Sending HTML formatted email with embedded image");
			
			// Define base URL to specify resource (img, ...)
			URL url = new URL("http://commons.apache.org");
			email.setDataSourceResolver(new DataSourceUrlResolver(url));
			
			// Setup email content
			email.setHtmlMsg(htmlEmailTemplate);
			
			// Setup alternate content
			email.setTextMsg("Your email client does not support HTML messages");
			
			// Send email
			email.send();
			
			System.out.println("Sent!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
