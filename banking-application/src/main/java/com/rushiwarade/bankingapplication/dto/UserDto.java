package com.rushiwarade.bankingapplication.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class UserDto {
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
