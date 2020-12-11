/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Lama
 */
public class EmailClass {

    public EmailClass() {

    }

    //Used to send emails to a specified email address
    public void sendFromGmail(String[] to, String subject, String body, String path, String from, String pass) throws MessagingException {
        Properties props = System.getProperties();

        if (from == null) {
            from = "thejobsearchapp@gmail.com";
        }
        if (pass == null) {
            pass = "jobsearch123";
        }
        String host = "smtp.live.com";
        if(from.equals("thejobsearchapp@gmail.com")){
            host = "smtp.gmail.com";
        }
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

            if (!path.equals("")) {
                BodyPart messageBodyPart = new MimeBodyPart();
                messageBodyPart.setContent(body, "text/html");

                Multipart multipart = new MimeMultipart();

                MimeBodyPart attachmentPart = new MimeBodyPart();
                try {
                    attachmentPart.attachFile(new File(path));
                    multipart.addBodyPart(messageBodyPart);
                    multipart.addBodyPart(attachmentPart);
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                            message.setContent(multipart, "text/html");
            } else {
                message.setContent(body, "text/html");
            }

            message.setSubject(subject);


            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (AddressException ae) {
            System.out.println(ae.getMessage());
        }
    }

}
