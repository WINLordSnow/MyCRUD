package CRUD.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(name = "last_name")
    private String lastName;

    public User() {}

    public User(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
}
