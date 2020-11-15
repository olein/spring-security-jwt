//package com.jonak.rnd.security;
//
//import com.jonak.rnd.entity.User;
//import com.jonak.rnd.repository.UserRepository;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//
///*
//Fahim created at 11/15/2020
//*/
//@Component
//@Log4j2
//public class DataInitializer implements CommandLineRunner {
//    //...
//    @Autowired
//    UserRepository users;
//
//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//    @Override
//    public void run(String... args) throws Exception {
//        //...
//        this.users.save(User.builder()
//                .username("user")
//                .password(this.passwordEncoder.encode("password"))
//                .roles(Arrays.asList("ROLE_USER"))
//                .build()
//        );
//        this.users.save(User.builder()
//                .username("admin")
//                .password(this.passwordEncoder.encode("password"))
//                .roles(Arrays.asList("ROLE_USER", "ROLE_ADMIN"))
//                .build()
//        );
//        log.debug("printing all users...");
//        this.users.findAll().forEach(v -> log.debug(" User :" + v.toString()));
//    }
//}
//
