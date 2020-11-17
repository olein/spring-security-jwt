package com.jonak.rnd.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
Fahim created at 11/12/2020
*/
@RestController
@RequestMapping("/api")
@Log4j2
public class TestController {

    @GetMapping("/me")
    public ResponseEntity currentUser(@AuthenticationPrincipal UserDetails userDetails){
        Map<Object, Object> model = new HashMap<>();
        model.put("username", userDetails.getUsername());
        model.put("authorities", userDetails.getAuthorities()
                .stream()
                .map(a -> ((GrantedAuthority) a).getAuthority())
                .collect(Collectors.toList())
        );
        return ResponseEntity.ok(model);
    }

    @RequestMapping(path = "/getData", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('GET_DATA')")
    public ResponseEntity<String> geData(@AuthenticationPrincipal UserDetails userDetails) {
        log.info("Set data for " + userDetails.getUsername());
        return ResponseEntity.ok("Hello");
    }

    @RequestMapping(path = "/setData", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('SET_DATA')")
    public ResponseEntity<String> seData(@AuthenticationPrincipal UserDetails userDetails) {
        log.info("Set data for " + userDetails.getUsername());
        return ResponseEntity.ok("Data set");
    }
}
