package jon.whatson.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;
    private int rating;



    @ManyToOne
    @JsonBackReference(value = "event-movement")
    private Event event;

    @ManyToOne
    @JsonBackReference(value="user-movement")
    private User user;





}

