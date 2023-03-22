import javax.mail.*;
import java.util.Properties;

//Replace the values for mail.pop3.host, mail.pop3.port, username, and password
// with the corresponding values from the configuration file.

public class Store {
    private final javax.mail.Store store;

    public Store() throws MessagingException {
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "pop3");
        props.setProperty("mail.pop3.host", "pop3.example.com");
        props.setProperty("mail.pop3.port", "110");

        Session session = Session.getInstance(props);

        this.store = session.getStore("pop3");
        store.connect("username", "password");
    }

    public void close() throws MessagingException {
        this.store.close();
    }
}
