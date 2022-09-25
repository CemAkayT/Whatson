package jon.whatson.service;

import jon.whatson.iservice.IVenueService;
import jon.whatson.model.Venue;
import jon.whatson.repository.VenueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class VenueService implements IVenueService {
    private VenueRepository venueRepository;

    public VenueService(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    @Override
    public List<Venue> findAll() {
        return null;
    }

    @Override
    public Venue save(Venue object) {
        return null;
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<Venue> findById(Long aLong) {
        return venueRepository.findById(aLong);
    }
}
