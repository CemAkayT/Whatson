package jon.whatson.iservice;

import jon.whatson.model.Event;

import java.util.List;

public interface IEventService extends ICrudService<Event,Long> {
    List<Event> findByOrderByTimestampAsc();

}
