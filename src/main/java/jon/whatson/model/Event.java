package jon.whatson.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data // hashcode
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String venue;
    // Date kommer

    @ManyToOne
    @JsonBackReference
    @EqualsAndHashCode.Exclude // pga hashcode
    private Band band;


}
