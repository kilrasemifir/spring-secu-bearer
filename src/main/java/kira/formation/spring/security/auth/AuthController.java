package kira.formation.spring.security.auth;

import kira.formation.spring.security.auth.dto.RegisterRequestDto;
import kira.formation.spring.security.auth.dto.RequestLoginDto;
import kira.formation.spring.security.utilisateur.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AuthService service;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("register")
    public Utilisateur register(@RequestBody RegisterRequestDto dto){
        return service.register(dto);
    }

    @PostMapping("login")
    public String login(@RequestBody RequestLoginDto loginDto){
        try{
            manager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDto.getUsername(),
                            loginDto.getPassword()
                    )
            );
        } catch (BadCredentialsException e){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        return jwtTokenUtil.generateToken(loginDto.getUsername(), Map.of());
    }
}
