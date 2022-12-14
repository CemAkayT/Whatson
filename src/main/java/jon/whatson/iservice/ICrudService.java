package jon.whatson.iservice;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ICrudService<T,ID> {
    List<T> findAll();
    T save(T object);
    boolean existsById(ID id);
    void deleteById(ID id);
    Optional<T> findById(ID id);
}