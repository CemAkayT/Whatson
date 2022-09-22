package jon.whatson.iservice;

import jon.whatson.model.Band;

import java.util.List;

public interface IBandService  extends ICrudService<Band,Long> {
    List<Band> findBandByName(String name);
}
