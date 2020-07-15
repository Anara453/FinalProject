package myweb.demo.Controller;


import myweb.demo.Entity.User;
import myweb.demo.Model.RegistrModel;
import myweb.demo.Service.MailSendService;
import myweb.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/login")
public class RegistrController {
         @Autowired
         private UserService userService;
         @Autowired
         private MailSendService mailSendService;
         @PostMapping("/registration")
    public ResponseEntity<String> create(@RequestBody RegistrModel registrModel){
             User user;
             user = userService.create(registrModel);
//             user.setEmail(registrModel.getEmail());
//             user.setPassword(registrModel.getPassword());
//             user.setName(registrModel.getName());
             if (user == null){
                 return new ResponseEntity<>("ERROR" , HttpStatus.BAD_REQUEST);
             }
             return new ResponseEntity<>("User created your password" + mailSendService.send(registrModel.getEmail(),"Sending", registrModel.getPassword()) , HttpStatus.OK);
         }

}
