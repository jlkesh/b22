package uz.jl.blogpost.backend.services.mail;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import uz.jl.blogpost.backend.configs.BaseConfigurations;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.function.Supplier;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MailService {
    private static MailService instance;

    private static final String EMAIL_FROM = "etm.uz@gmail.com";
    private static final Properties PROPERTIES = BaseConfigurations.getSMTPConfiguration();


    public void sendEmail(Map<String, String> body) {
        Session session = Session.getInstance(PROPERTIES, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        PROPERTIES.getProperty("username"),
                        PROPERTIES.getProperty("password"));
            }
        });

        Message msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(EMAIL_FROM));
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(body.get("email"),
                            false));
            msg.setSubject(body.get("subject"));
            msg.setText(body.get("content"));
            msg.setSentDate(new Date());

            CompletableFuture.runAsync(()->{
                try {
                    Transport.send(msg);
                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }
            }, Executors.newCachedThreadPool());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static MailService getInstance() {
        if (instance == null) {
            instance = new MailService();
        }
        return instance;
    }


}
