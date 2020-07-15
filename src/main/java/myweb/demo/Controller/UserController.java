package myweb.demo.Controller;

import myweb.demo.Entity.User;
import myweb.demo.Model.RegistrModel;
import myweb.demo.Model.UserAuth;
import myweb.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@RestController
@RequestMapping("/users")
public class UserController {
         @Autowired
    private UserService userService;
         @PostMapping
    public User create(@RequestBody RegistrModel registrModel) {
                 return userService.create(registrModel);
         }
         @GetMapping("{id}")
    public User getById (@PathVariable Long id){
             return userService.getById(id);
         }

    @PostMapping("/auth")
    public ResponseEntity<String> getToken (@RequestBody UserAuth userAuth){
        String result = userService.getToken(userAuth);
        if (result.equals("Error")) return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
    @GetMapping("/byToken")
    public User getByToken(Principal principal){
             String userEmail = principal.getName();
             return userService.getByEmail(userEmail);
    }
    @DeleteMapping("{id}")
    public User deleteById (@PathVariable Long id){
             return userService.deleteById(id);
    }
}
