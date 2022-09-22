package jon.whatson.service;

import jon.whatson.iservice.IBandService;
import jon.whatson.model.Band;
import jon.whatson.repository.BandRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BandService implements IBandService {
    private BandRepository bandRepository;

    public BandService(BandRepository bandRepository) {
        this.bandRepository = bandRepository;
    }


    @Override
    public List<Band> findAll() {
        return new ArrayList<>(bandRepository.findAll());
    }

    @Override
    public Band save(Band object) {
        return bandRepository.save(object);
    }

    @Override
    public boolean existsById(Long aLong) {
        boolean found = false;
        if (!bandRepository.existsById(aLong)) {
            return found;
        } else {
            return !found;
        }
    }

    @Override
    public void delete(Band object) {
        bandRepository.delete(object);

    }

    @Override
    public void deleteById(Long aLong) {
        bandRepository.deleteById(aLong);
    }

    @Override
    public Optional<Band> findById(Long aLong) {
        return bandRepository.findById(aLong);
    }

    @Override
    public List<Band> findBandByName(String name) {
        return bandRepository.findBandByName(name);
    }
}
