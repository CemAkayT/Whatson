package jon.whatson.service;

import jon.whatson.iservice.IEventService;
import jon.whatson.model.Event;
import jon.whatson.repository.EventRepository;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class EventService implements IEventService {
    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> findAll() {
        return new ArrayList<>(eventRepository.findAll());
    }

    @Override
    public Event save(Event object) {
        return eventRepository.save(object);
    }

    @Override
    public boolean existsById(Long aLong) {
        boolean found = false;
        if (!eventRepository.existsById(aLong)) {
            return found;
        } else {
            return !found;
        }
    }

    @Override
    public void deleteById(Long aLong) {
        eventRepository.deleteById(aLong);
    }

    @Override
    public Optional<Event> findById(Long aLong) {
        return eventRepository.findById(aLong);
    }

    @Override
    public List<Event> findByOrderByTimestampAsc() {
        return eventRepository.findByOrderByTimestampAsc();
    }
}
