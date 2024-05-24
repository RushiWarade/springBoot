package com.rushiwarade.apidemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  int id;
    private  String productName;
    private  String productCategory;
    private  String productDescription;
    private  float productPrice;
    private  float productStar;

}
