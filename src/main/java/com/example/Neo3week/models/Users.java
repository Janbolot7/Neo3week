package com.example.Neo3week.models;

import com.example.Neo3week.models.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class Users {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id", insertable=false, updatable=false)
        private Long id;
        @Embedded
        private UsersInfo info;
        @Enumerated(EnumType.STRING)
        private Role role;
        @Column(unique = true)
        private String userName;
        private String password;
        @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REFRESH}, mappedBy = "user")
        private Set<Orders> orders;
}
