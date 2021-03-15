package tech.tora.userlogindemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "_user", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name"),
        @UniqueConstraint(columnNames = "email")})
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "name")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "_user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User(String username, String email, String password) {




        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "{" + username + ", " + email + ", " + roles + "}";
    }
}
