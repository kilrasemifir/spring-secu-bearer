package kira.formation.spring.security.utilisateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService service;

    @GetMapping("{id}")
    public Utilisateur findById(@PathVariable Long aLong) {
        return service.findById(aLong);
    }

    @GetMapping()
    public Iterable<Utilisateur> findAll() {
        return service.findAll();
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long aLong) {
        service.deleteById(aLong);
    }
}
