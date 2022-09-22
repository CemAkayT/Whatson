package jon.whatson.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Setter
@Getter
@Entity

public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String venue;
    private Timestamp timestamp;
    // Date kommer

    @ManyToOne // allows you to map FK in the child entity so it can reference its parent entity
    @JsonBackReference
    private Band band;


}
