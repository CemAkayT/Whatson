package jon.whatson.service;

import jon.whatson.iservice.IUserService;
import jon.whatson.model.User;
import jon.whatson.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service  // gør at Spring "ser" denne klasse
public class UserService implements IUserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(userRepository.findAll());
    }

    @Override
    public User save(User object) {
        return userRepository.save(object);
    }

    @Override
    public boolean existsById(Long aLong) {
        boolean found = false;
        if (!userRepository.existsById(aLong)){
            return found;
        } else {
            return !found;
        }
    }

    @Override
    public void deleteById(Long aLong) {
        userRepository.deleteById(aLong);

    }

    @Override
    public Optional<User> findById(Long aLong) {
        return userRepository.findById(aLong);
    }

    @Override
    public List<User> findUserByName(String name) {
        return userRepository.findUserByName(name);
    }

}
