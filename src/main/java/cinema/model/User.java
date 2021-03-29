package cinema.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;
    private String password;
    @ManyToMany
    @Enumerated
    private Set<Role> userRole;

    public User(String email, String password, Set<Role> userRole) {
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }
}
