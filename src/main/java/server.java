public class server {
    POP3Server popServer = new POP3Server() {
        @Override
        public void deliver(String recipient, InputStream data) throws IOException {
            // Process incoming email here
        }
    };

    SMTPServer smtpServer = new SMTPServer() {
        @Override
        public OutputStream deliver(String from, List<String> recipients) throws IOException {
            // Return an OutputStream that can be used to write the email data
        }
    };

    popServer.start();
    smtpServer.start();
}
