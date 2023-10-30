package com.example.Neo3week.models;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable

public class UsersInfo {
        private String name;
        private String sureName;
        private Integer age;
        private String gender;
        private String telNumber;
        private String address;
}
