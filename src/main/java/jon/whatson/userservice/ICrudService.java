package jon.whatson;

import java.util.Optional;
import java.util.Set;

public interface ICrudService<T,ID> {
    Set<T> findAll();
    T save(T object);
    boolean existsById(ID id);
    void delete(T object);
    void deleteById(ID id);
    Optional<T> findById(ID id);
}