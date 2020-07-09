package myweb.demo.Service;

import myweb.demo.Entity.User;
import myweb.demo.Entity.UserRole;
import myweb.demo.Model.UserRoleModel;
import myweb.demo.Repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private UserService userService;

    @Override
    public List<UserRole> findAll() {
        return userRoleRepository.findAll();
    }

    @Override
    public UserRole create(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public UserRole create(UserRoleModel userRoleModel) {
        User user = userService.getById(userRoleModel.getUserId());
        if (user == null) return null;
        UserRole userRole = new UserRole();
        userRole.setName(userRoleModel.getRoleName());
        userRole.setUser(user);
        return userRoleRepository.save(userRole);
    }
}
