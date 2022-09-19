package jon.whatson.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Band {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    String name;

    @OneToMany(mappedBy = "band")
    private Set<Event> events = new HashSet<>();

}
