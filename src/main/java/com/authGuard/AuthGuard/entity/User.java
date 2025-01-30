package com.authGuard.AuthGuard.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true, nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;;

    @Column(nullable = false)
    private String roleName;

}
