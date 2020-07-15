package myweb.demo.Controller;

import myweb.demo.Service.MailSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class MailSendController {
    @Autowired
    private MailSendService mailSendService;
    @PostMapping
    public boolean send(@RequestParam(name = "toEmail") String toEmail,
                        @RequestParam(name = "subject") String subject,
                        @RequestParam(name = "text") String text) {
        return mailSendService.send(toEmail, subject, text);
    }
}
