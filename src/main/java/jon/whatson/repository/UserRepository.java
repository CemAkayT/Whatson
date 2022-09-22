package jon.whatson.repository;

import jon.whatson.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findUserByName(String name);

}
