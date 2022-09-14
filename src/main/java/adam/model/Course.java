package adam.model;

import lombok.Data;
import org.apache.catalina.User;

import javax.persistence.*;
import java.util.*;
@Data
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToMany(mappedBy = "course")
    private Set<Person> persons = new HashSet<>();

}
