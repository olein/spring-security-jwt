package com.jonak.rnd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/*
Fahim created at 11/16/2020
*/
@Entity
@Table(name = "authority")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotEmpty
    private String authority;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public Authority(@NotEmpty String authority, Role role) {
        this.authority = authority;
        this.role = role;
    }
}
