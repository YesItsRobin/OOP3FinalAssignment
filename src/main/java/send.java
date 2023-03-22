import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class send {
    public send(Message message, Session session) throws MessagingException {
        Address[] from = message.getFrom();
        String sender = from.length > 0 ? from[0].toString() : "";

        if (!sender.isEmpty()) {
            Message response = new MimeMessage(session);
            //Replace the value for me@example.com with the email address that you want to use as the sender
            response.setFrom(new InternetAddress("me@example.com"));
            response.setRecipient(Message.RecipientType.TO, new InternetAddress(sender));
            response.setSubject("Email status");

            if (message.isMimeType("multipart/encrypted")) {
                response.setText("Your email was encrypted but could not be decrypted.");
            } else {
                response.setText("Your email was received and could be decrypted if it was encrypted.");
            }

            Transport.send(response);
        }
    }
}
