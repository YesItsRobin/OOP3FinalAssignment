import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;

public class Recieve {
    public Recieve(Store store) throws MessagingException, MessagingException {
        Folder folder = store.getFolder("INBOX");
        folder.open(Folder.READ_ONLY);

        Message[] messages = folder.getMessages();

        for (Message message : messages) {
            // Process each message here
            if (message.isMimeType("multipart/encrypted")) {
                // Decrypt the message here using an appropriate algorithm
            }
        }

        folder.close(false);
        store.close();
    }
}
