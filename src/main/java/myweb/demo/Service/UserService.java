package myweb.demo.Service;
import myweb.demo.Entity.User;
import myweb.demo.Model.UserAuth;

import java.util.List;


public interface UserService {
    List<User> getAll();
    User create(User user);
    User getById (Long id);
   String getToken(UserAuth userAuth);
    User getByLogin(String login);
}
