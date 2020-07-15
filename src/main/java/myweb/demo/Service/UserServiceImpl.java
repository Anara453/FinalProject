package myweb.demo.Service;

import myweb.demo.Entity.User;
import myweb.demo.Entity.UserRole;
import myweb.demo.Model.RegistrModel;
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
    public User create(RegistrModel registrModel) {
        User user = new User();
        String encodedPassword = passwordEncoder.encode(registrModel.getPassword());
        user.setPassword(encodedPassword);
        user.setEmail(registrModel.getEmail());
        user.setName(registrModel.getName());
        user.setPhoneNum(registrModel.getPhoneNum());
        user.setIsActive(registrModel.getIsActive());
        User createUser = userRepository.save(user);
        UserRole userRole = new UserRole();
        userRole.setName("ROLE_ADMIN");
        userRole.setName(registrModel.getName());
        userRole.setUser(createUser);
        userRoleService.create(userRole);
        return user;
    }
    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public String getToken(UserAuth userAuth) {
        User user = getByEmail(userAuth.getEmail());
        if (user == null) return "Error";
        String rawPassword = userAuth.getPassword();
        String encodedPassword = user.getPassword();
        //Проверяет совпадают ли пароли
        if (passwordEncoder.matches(rawPassword,encodedPassword)){
            String loginPasswordPair = userAuth.getEmail() + ":" +userAuth.getPassword();
            //Принимает массив байтов нужно конвертировать в байт
            String token = Base64.getEncoder().encodeToString(loginPasswordPair.getBytes());
            return "Basic " + token;
        }
        return "Error"; //"Wrong login or Password";
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findAllByEmailIgnoringCase(email);
    }

    @Override
    public User deleteById(Long id) {
        User user = getById(id);
        if(user != null){
            userRepository.deleteById(id);
        }
        return null;
    }

}
