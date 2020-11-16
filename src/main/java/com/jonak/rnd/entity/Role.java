package com.jonak.rnd.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*
Fahim created at 11/16/2020
*/
@Entity
@Table(name = "roles")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotEmpty
    private String roleName;

    private String description;

    @OneToMany(mappedBy="role", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Authority> authorities;

    public Role(@NotEmpty String roleName, String description) {
        this.roleName = roleName;
        this.description = description;
    }
}
