package myweb.demo.Service;

public interface MailSendService {
    boolean send (String toEmail,String subject ,String text);
}
