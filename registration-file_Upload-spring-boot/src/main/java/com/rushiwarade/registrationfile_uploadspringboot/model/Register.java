package com.rushiwarade.registrationfile_uploadspringboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity(name = "register_upload")
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String fname;
    private String lname;
    private String email;
    private String gender;
    private String mobile;
    private String fileName;
    private String password;
}
