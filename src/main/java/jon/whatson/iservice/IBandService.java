package jon.whatson.iservice;

import jon.whatson.model.Band;

import java.util.List;
import java.util.Set;

public interface IBandService  extends ICrudService<Band,Long> {
    List<Band> findBandByName(String name);
}
