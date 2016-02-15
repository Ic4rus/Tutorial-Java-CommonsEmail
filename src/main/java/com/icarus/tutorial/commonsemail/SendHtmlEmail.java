package com.icarus.tutorial.commonsemail;

import java.net.URL;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.HtmlEmail;

public class SendHtmlEmail {
	
	public static void main(String[] args) {
		try {
			// Create an HTML email object
			HtmlEmail email = new HtmlEmail();
			
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
			email.setSubject("Test Sending HTML formatted email");
			
			// Embed image and get ID of content (Content-ID)
			URL url = new URL("http://www.apache.org/images/asf_logo_wide.gif");
			String cid = email.embed(url, "Apache logo");
			
			// Setup email content which has HTML formatted
			email.setHtmlMsg("<html><h2>The apache logo</h2> <img src=\"cid:"
					+ cid + "\"></html>");
			
			// Setup alternate notifications
			email.setTextMsg("Your email client does not support HTML messages");
			
			// Send email
			email.send();
			
			System.out.println("Sent!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
