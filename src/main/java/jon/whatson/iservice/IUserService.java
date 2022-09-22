package jon.whatson.iservice;

import jon.whatson.model.User;

import java.util.List;

public interface IUserService extends ICrudService<User, Long> {
    List<User> findUserByName(String name);

}
