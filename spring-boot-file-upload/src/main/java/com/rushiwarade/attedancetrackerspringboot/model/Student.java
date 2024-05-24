package com.rushiwarade.attedancetrackerspringboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity(name = "file_upload")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;
    String file;
}
