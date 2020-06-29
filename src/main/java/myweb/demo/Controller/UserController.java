package myweb.demo.Controller;

import myweb.demo.Entity.User;
import myweb.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {
         @Autowired
    private UserService userService;
         @PostMapping
    public User  create(@RequestBody User user){
             return userService.create(user);
         }
         @GetMapping("{id}")
    public User getById (@PathVariable Long id){
             return userService.getById(id);
         }
         @GetMapping
    public List<User> getByLogin(@RequestHeader String login){
             return userService.getByLogin(login);
         }

}
