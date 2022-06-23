package com.grupo3.consumer.services.classes;

import javax.mail.MessagingException;

import com.grupo3.consumer.aws.CredentialsAws;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ses.SesClient;
import software.amazon.awssdk.services.ses.model.Body;
import software.amazon.awssdk.services.ses.model.Content;
import software.amazon.awssdk.services.ses.model.Destination;
import software.amazon.awssdk.services.ses.model.Message;
import software.amazon.awssdk.services.ses.model.SendEmailRequest;
import software.amazon.awssdk.services.ses.model.SendEmailResponse;
import software.amazon.awssdk.services.ses.model.SesException;

public class ServiceSES {

	public static String sendMessage(String userName, String message, String recipient) {
		SesClient client = SesClient.builder()
				.region(Region.US_EAST_1)
				.credentialsProvider(CredentialsAws.getCredentials())
				.build();

		String htmlBody = "<html>" +
				"<body>" +
				"<h1>Olá " + userName + "!</h1>" +
				"<p>Seu pedido foi realizado com sucesso</p>" +
				"<p>" + message + "</p>" +
				"</body>" +
				"</html>";
		try {
			SendEmailResponse response = send(client, System.getenv("EMAIL_SENDER"), recipient,
					"Pedido - Grupo 3", htmlBody);
			client.close();
			return response.messageId();
		} catch (MessagingException e) {
			e.getStackTrace();
			return null;
		}
	}

	public static SendEmailResponse send(SesClient client, String sender, String recipient, String subject,
			String bodyHTML)
			throws MessagingException {

		Destination destination = Destination.builder()
				.toAddresses(recipient)
				.build();

		Content content = Content.builder()
				.data(bodyHTML)
				.build();
		Content sub = Content.builder()
				.data(subject)
				.build();

		Body body = Body.builder()
				.html(content)
				.build();

		Message msg = Message.builder()
				.subject(sub)
				.body(body)
				.build();

		SendEmailRequest emailRequest = SendEmailRequest.builder()
				.destination(destination)
				.message(msg)
				.source(sender)
				.build();

		try {
			SendEmailResponse response = client.sendEmail(emailRequest);
			System.out.println(response.messageId());
			return response;
		} catch (SesException e) {
			System.err.println(e.awsErrorDetails().errorMessage());
			return null;
		}
	}

}
