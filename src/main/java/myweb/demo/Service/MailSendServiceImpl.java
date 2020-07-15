package myweb.demo.Service;


import myweb.demo.Entity.User;
import myweb.demo.Model.UserAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSendServiceImpl implements MailSendService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private Environment environment;

    @Override
    public boolean send(String toEmail, String subject, String text) {
        User user = new User();
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject(subject);//Это тема сообщения
            message.setText("This is your password: " + user.getPassword());
            message.setTo(toEmail);
            message.setFrom(environment.getProperty("spring.mail.username"));
            javaMailSender.send(message);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
