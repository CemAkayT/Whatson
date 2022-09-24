package jon.whatson.repository;

import jon.whatson.model.Band;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface BandRepository extends JpaRepository<Band,Long> {

    List<Band> findBandByName(String name);
}
