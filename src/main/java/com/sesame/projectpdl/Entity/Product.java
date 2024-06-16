package com.sesame.projectpdl.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String nom;
    private double prix;
    private String categorie;
    private String image;
    private String dim;
    private String matriel;
    @ManyToOne
    private User user;
}
