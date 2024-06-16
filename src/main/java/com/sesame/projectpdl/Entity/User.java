package com.sesame.projectpdl.Entity;

import com.sesame.projectpdl.Enum.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String password;
    private String mail;
    private int num;
    private Date date;
    @Enumerated(EnumType.STRING)
    private Type type;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Cart cart;

}

