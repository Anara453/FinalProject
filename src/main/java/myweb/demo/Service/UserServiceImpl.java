package myweb.demo.Service;

import myweb.demo.Entity.User;
import myweb.demo.Entity.UserRole;
import myweb.demo.Model.UserAuth;
import myweb.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(User user) {
        String encodedPassword=passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user  = userRepository.save(user);
        UserRole userRole  = new UserRole();
        userRole.setName("ROLE_ADMIN");
        userRole.setUser(user);
        userRoleService.create(userRole);
        return user;
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public String getToken(UserAuth userAuth) {
        User user = getByLogin(userAuth.getLogin());
        if (user == null) return "Error";
        String rawPassword = userAuth.getPassword();
        String encodedPassword = user.getPassword();
        //Проверяет совпадают ли пароли
        if (passwordEncoder.matches(rawPassword,encodedPassword)){
            String loginPasswordPair = userAuth.getLogin() + ":" +userAuth.getPassword();
            //Принимает массив байтов нужно конвертировать в байт
            String token = Base64.getEncoder().encodeToString(loginPasswordPair.getBytes());
            return "Basic " + token;
        }
        return "Error"; //"Wrong login or Password";
    }

    @Override
    public User getByLogin(String login) {
        return userRepository.findAllByLoginIgnoringCase(login);
    }
}
