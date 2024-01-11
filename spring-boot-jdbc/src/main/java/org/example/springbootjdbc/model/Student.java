package org.example.springbootjdbc.model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class Student {
    private int id ;
    private  String name;
    private String email;
    private String mobile;
}
