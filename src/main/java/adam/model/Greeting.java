package adam.model;

import javax.persistence.*;

@Entity
public class Greeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String greeting1 = "Hello from REST service";

    public Greeting(){

    }
    public String getGreeting2() {
        return greeting2;
    }

    public void setGreeting2(String greeting2) {
        this.greeting2 = greeting2;
    }
    @Column
    private String greeting2 = "This is greeting 2";

    public String getGreeting3() {
        return greeting3;
    }

    public void setGreeting3(String greeting3) {
        this.greeting3 = greeting3;
    }
    @Column
    private String greeting3 = "This is greeting 3";


    public String getGreeting1() {
        return greeting1;
    }

    public void setGreeting1(String greeting1) {
        this.greeting1 = greeting1;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}

