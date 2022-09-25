package jon.whatson.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "event_id")
    private Long id;
    @Column(name= "event_venue")
    private String venue;
    private Timestamp timestamp;


    @ManyToOne // allows you to map FK in the child entity so it can reference its parent entity
    @JsonBackReference(value = "band-movement")
    private Band band;

    @OneToMany (mappedBy = "event")
    private List<Review> reviews = new ArrayList<>();



}
