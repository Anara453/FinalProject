package myweb.demo.Repository;

import myweb.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <User,Long> {
        List<User> findAllByLoginIgnoringCase(String login);
}
