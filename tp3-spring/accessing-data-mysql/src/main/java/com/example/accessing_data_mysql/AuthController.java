package com.example.accessing_data_mysql;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final TokenGenerator tokenGenerator;

    public AuthController(
            AuthenticationManager authenticationManager,
            TokenGenerator tokenGenerator
    ) {
        this.authenticationManager = authenticationManager;
        this.tokenGenerator = tokenGenerator;
    }

    @PostMapping("/login")
    public JwtDTO login(@RequestBody LoginDTO dto) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword())
        );

        String token = tokenGenerator.generateJwtToken(authentication.toString());

        String username = authentication.getName();
        List<String> roles = authentication.getAuthorities().stream()
                .map(a -> a.getAuthority())
                .toList();

        return new JwtDTO(token, username, roles);
    }
}