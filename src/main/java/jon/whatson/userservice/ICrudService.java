package jon.whatson.userservice;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ICrudService<T,ID> {
    List<T> findAll();
    T save(T object);
    boolean existsById(ID id);
    void delete(T object);
    void deleteById(ID id);
    Optional<T> findById(ID id);
}