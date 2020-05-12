package com.food.fa.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

	public static String send(String email, String link, String name) {

		// Recipient's email ID needs to be mentioned.
		String to = "srinivasam1030@gmail.com";

		// Sender's email ID needs to be mentioned
		String from = email;

		// Assuming you are sending email from through gmails smtp
		String host = "smtp.gmail.com";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		// Get the Session object and pass User- Name and User-Password
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication("srinivasam1030@gmail.com", "13%$#@10");

			}

		});

		// Used to debug SMTP issues
		session.setDebug(true);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Set Subject: header field
			message.setSubject("E-mail verification from Food Basket");

			// Now set the actual message
			String body = "Hello " + name
					+ ", \n\nWe are excited to add a new face or more like another account ;) to our family tree. "
					+ "Please click on the link below to confirm your email"
					+ "\n\n" + link + "\n\nhave a good day\n\nNote:This link will expire in 10 min\n\n\n"
					+ "\n\nYour are getting this mail in response to your Sign-Up request from FoodBasket!"
					+ "\n\nIf this request was not made by you then "
					+ "don't click on the above link and take neccessary steps to secure your account!";
			
			message.setText(body);

			// Send message
			Transport.send(message);
			return "We have sent a OTP code or link to your E-mail: " + email + ". \nThe OTP code or link will expire wthin 10 Minutes!";
		} catch (MessagingException mex) {
			mex.printStackTrace();
			return "Something went Wrong!";
		}

	}
}
