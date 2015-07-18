package cuka.martin;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

	public static void main(String[] args) {
		Properties props = new Properties();
		
		props.put("mail.smtp.auth", "true");

		props.put("mail.smtp.starttls.enable", "true");

		props.put("mail.smtp.host", "smtp.gmail.com");

		props.put("mail.smtp.port", "587");

		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("cukamartin+gmail.com", "letmein");
			}
		};

		Session session = Session.getDefaultInstance(props, auth);
		for (int i = 0; i < 50; i++) {
			
		
		Message msg = new MimeMessage(session);

		try {
			msg.setSubject("Hackujeme GMAIL :D email cislo: " + i);
			msg.setText("SPAM :D");
			msg.setFrom(new InternetAddress("cukamartin@gmail.com", "Martin"));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress("jozefekrcho@gmail.com"));
			Transport.send(msg);
		} catch (MessagingException | UnsupportedEncodingException e) {
			System.out.println(e.getMessage().toString());
		}
		}

		System.out.println("Finished.");
	}
}
