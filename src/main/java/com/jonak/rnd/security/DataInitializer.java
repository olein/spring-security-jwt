//package com.jonak.rnd.security;
//
//import com.jonak.rnd.entity.Authority;
//import com.jonak.rnd.entity.Role;
//import com.jonak.rnd.entity.User;
//import com.jonak.rnd.repository.AuthorityRepository;
//import com.jonak.rnd.repository.RoleRepository;
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
//    AuthorityRepository authorityRepository;
//
//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        Role role1 = new Role("ADMIN", "admin role");
//        Role role2 = new Role("USER", "user role");
//        Role role3 = new Role("DEV", "developer role");
//
//        Authority a1 = new Authority("GET_DATA", role1);
//        Authority a2 = new Authority("SET_DATA",role1);
//
//        Authority u1 = new Authority("GET_DATA", role2);
//
//        Authority d1 = new Authority("GET_DATA", role3);
//        Authority d2 = new Authority("SET_DATA",role3);
//
//        this.users.save(User.builder()
//                .username("admin")
//                .password(this.passwordEncoder.encode("password"))
//                .role(role1)
//                .build()
//        );
//
//        this.users.save(User.builder()
//                .username("user")
//                .password(this.passwordEncoder.encode("password"))
//                .role(role2)
//                .build()
//        );
//
//        this.users.save(User.builder()
//                .username("dev")
//                .password(this.passwordEncoder.encode("password"))
//                .role(role3)
//                .build()
//        );
//
//        authorityRepository.save(a1);
//        authorityRepository.save(a2);
//        authorityRepository.save(u1);
//        authorityRepository.save(d1);
//        authorityRepository.save(d2);
//
//        log.debug("printing all users...");
//        this.users.findAll().forEach(v -> log.debug(" User :" + v.toString()));
//    }
//}
//
