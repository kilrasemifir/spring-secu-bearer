package kira.formation.spring.security.utilisateur;

import jakarta.persistence.*;
import kira.formation.spring.security.auth.roles.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;

    @ManyToMany
    private List<Role> roles = new ArrayList<>();
    // autres props
}
