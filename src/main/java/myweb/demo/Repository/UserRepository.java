package myweb.demo.Repository;

import myweb.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User,Long> {
        User findAllByEmailIgnoringCase(String email);
}
