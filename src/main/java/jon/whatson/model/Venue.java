package jon.whatson.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "venue_id")
    private Long id;
    @Column(name= "venue_name")
    private String name;

    @ManyToMany (mappedBy = "venuesLiked")
    @JsonBackReference (value = "userlikes-movement")
    private List<User> userLikes = new ArrayList<>();
}
