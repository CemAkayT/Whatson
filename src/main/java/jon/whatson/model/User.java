package jon.whatson.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter// laver getter, setter, toString(), hashCode()
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Timestamp timestamp;


    @ManyToMany
    @JoinTable(
            name = "venue_like",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "venue_id")
    )
    @JsonBackReference
    private Set<Venue> venuesLiked = new HashSet<>();

}
