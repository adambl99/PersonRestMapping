package adam.model;

import javax.persistence.*;
import java.util.*;

@Entity(name = "Course")
@Table(name = "course")
public class Course {
    @Column
    private String name;
    @Column
    private Date startDate;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Course(){
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }



}
