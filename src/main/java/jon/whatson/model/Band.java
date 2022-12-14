package jon.whatson.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.*;


@Getter
@Setter
@Entity
public class Band { // er på turné derfor 1-to-many

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "band_id")
    private Long id;

    String name;


    @OneToMany (mappedBy = "band")
    private List<Event> events = new ArrayList<>();

}
