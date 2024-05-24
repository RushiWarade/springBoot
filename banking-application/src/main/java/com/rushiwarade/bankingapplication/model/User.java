package com.rushiwarade.bankingapplication.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Random;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "bank_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fname;
    private String lname;
    private long mobile;
    private String email;
    private String address;
    private String accountType;
    private long accountNumber;
    private float balance;
    private String password;


}
