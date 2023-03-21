package kira.formation.spring.security.auth;

import kira.formation.spring.security.auth.dto.RegisterRequestDto;
import kira.formation.spring.security.utilisateur.Utilisateur;
import kira.formation.spring.security.utilisateur.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UtilisateurRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public Utilisateur register(RegisterRequestDto dto){
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setUsername(dto.getUsername());
        String password = passwordEncoder.encode(dto.getPassword());
        utilisateur.setPassword(password);
        return this.repository.save(utilisateur);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur utilisateur = repository.findByUsername(username);
        if (utilisateur == null){
            throw new UsernameNotFoundException("Aucun utilisateur ne possède l'username "+username);
        }
        return new User(utilisateur.getUsername(), utilisateur.getPassword(), List.of());
    }


    @Autowired
    public void init(){
        this.register(new RegisterRequestDto("user","azerty"));
    }
}
