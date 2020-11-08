/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Lama
 */
public class EmailClass {

    public EmailClass() {

    }

    public static String from = "thejobsearchapp@gmail.com";
    protected static String pass = "jobsearch123";

    //Used to send emails to a specified email address
    public void sendFromGmail(String[] to, String subject, String body) throws MessagingException {
        try {
            String content = new String(Files.readAllBytes(Paths.get("C:\\Users\\joelt\\Documents\\NetBeansProjects\\jobSearchApp\\src\\utilities\\Emailhtml.txt")));
            Properties props = System.getProperties();
            String host = "smtp.gmail.com";
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.user", from);
            props.put("mail.smtp.password", pass);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            
            Session session = Session.getDefaultInstance(props);
            MimeMessage message = new MimeMessage(session);
            
            try {
                message.setFrom(new InternetAddress(from));
                InternetAddress[] toAddress = new InternetAddress[to.length];
                
                // To get the array of addresses
                for (int i = 0; i < to.length; i++) {
                    toAddress[i] = new InternetAddress(to[i]);
                }
                
                for (InternetAddress toAddres : toAddress) {
                    message.addRecipient(Message.RecipientType.TO, toAddres);
                }
                
                message.setSubject(subject);
                message.setContent(content,"text/html");
                Transport transport = session.getTransport("smtp");
                transport.connect(host, from, pass);
                transport.sendMessage(message, message.getAllRecipients());
                transport.close();
            } catch (AddressException ae) {
                System.out.println(ae.getMessage());
            }
        } catch (IOException ex) {
            Logger.getLogger(EmailClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
