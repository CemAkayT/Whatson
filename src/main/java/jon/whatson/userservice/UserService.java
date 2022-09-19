package jon.whatson.userservice;

import jon.whatson.model.User;
import jon.whatson.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service  // gør at Spring "ser" denne klasse
public class UserService implements IUserService{
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Set<User> findAll() {
        return new HashSet<>(userRepository.findAll());
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
    public void delete(User object) {
        userRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        userRepository.deleteById(aLong);

    }

    @Override
    public Optional<User> findById(Long aLong) {
        return Optional.empty();
    }

}
