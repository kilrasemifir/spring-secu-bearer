package kira.formation.spring.security.utilisateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
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
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return service.findAll();
    }

    @Secured("ADMIN")
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long aLong) {
        service.deleteById(aLong);
    }
}
