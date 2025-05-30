package org.example.saysthbackendwebfordbaccess.model;
import com.github.f4b6a3.ulid.UlidCreator;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, updatable = false)
    private String ulid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    public User() {
        this.ulid = UlidCreator.getUlid().toString();
    }

    public User(String name, String email, String encodedPassword) {
        this.ulid = UlidCreator.getUlid().toString();
        this.name = name;
        this.email = email;
        this.password = encodedPassword;
    }

    public Long getId() { return id; }
    public String getUlid() { return ulid; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
}
