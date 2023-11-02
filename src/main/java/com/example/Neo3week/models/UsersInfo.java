package com.example.Neo3week.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class UsersInfo {
        @Column
        private String name;
        @Column
        private String sureName;
        @Column
        private Integer age;
        @Column
        private String gender;
        @Column
        private String telNumber;
        @Column
        private String address;
}
