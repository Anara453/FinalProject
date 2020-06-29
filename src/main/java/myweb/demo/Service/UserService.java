package myweb.demo.Service;
import myweb.demo.Entity.User;

import java.util.List;


public interface UserService {
    List<User> getAll();
    User create(User user);
    User getById (Long id);
   // String getToken(UserAuth userAuth);
    List<User> getByLogin(String login);
}
