package kira.formation.spring.security.utilisateur;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UtilisateurService {

    private final UtilisateurRepository repository;

    public UtilisateurService(UtilisateurRepository repository) {
        this.repository = repository;
    }

    public Utilisateur findById(Long aLong) {
        return repository.findById(aLong).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Iterable<Utilisateur> findAll() {
        return repository.findAll();
    }

    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
