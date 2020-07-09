package myweb.demo.Service;

import myweb.demo.Entity.UserRole;
import myweb.demo.Model.UserRoleModel;

import java.util.List;

public interface UserRoleService {
    List<UserRole> findAll();
    UserRole create (UserRole userRole);
    UserRole create (UserRoleModel userRoleModel);
}
