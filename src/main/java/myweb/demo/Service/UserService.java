package myweb.demo.Service;
import myweb.demo.Entity.User;
import myweb.demo.Model.RegistrModel;
import myweb.demo.Model.UserAuth;

import java.util.List;


public interface UserService {
    List<User> getAll();
    User create(RegistrModel registrModel);
    User getById (Long id);
   String getToken(UserAuth userAuth);
    User getByEmail(String email);
    User deleteById(Long id);
}
