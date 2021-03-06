package com.jonak.rnd.controller;

import com.jonak.rnd.config.JwtTokenProvider;
import com.jonak.rnd.entity.User;
import com.jonak.rnd.model.AuthenticationRequest;
import com.jonak.rnd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/*
Fahim created at 11/15/2020
*/
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/signin")
    public ResponseEntity signin(@RequestBody AuthenticationRequest data) {
        try {
            String username = data.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));

            User user = userRepository.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("Username " + username + "not found"));

            List<String> authorities = user.getRole().getAuthorities().stream().map(a -> a.getAuthority())
                    .map(String::new).collect(Collectors.toList());

            String token = jwtTokenProvider.createToken(username, authorities);

            Map<Object, Object> model = new HashMap<>();
            model.put("username", username);
            model.put("token", token);
            return ResponseEntity.ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }
}
