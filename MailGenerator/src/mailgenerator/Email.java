/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailgenerator;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Email {
    private static MailGenerator instance = new MailGenerator();
    private static Properties props = new Properties();
    public static MailGenerator getInstance(){
        return instance;
    }

    public Email() {}

    public static Properties getProps() {
        /** Parâmetros de conexão com servidor Gmail */
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        return props;
    }

    public static void enviarEmail(String titulo, String corpo, String destinatario){
        Session session = Session.getDefaultInstance(getProps(),
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication()
                    {
                        return new PasswordAuthentication("luiz123jfmg@gmail.com",
                                "senhadoemail"); // acertar senha , email de quem vai disparar
                    }
                });

        /** Ativa Debug para sessão */
        session.setDebug(true);

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("luiz123jfmg@gmail.com"));
            //Remetente

            Address[] toUser = InternetAddress //Destinatário(s)
                    .parse(destinatario);

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject(titulo);//Assunto
            message.setText(corpo);
            /**Método para enviar a mensagem criada*/
            Transport.send(message);

            System.out.println("Enviado!");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}