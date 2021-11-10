package com.example.comics.models;

import lombok.Data;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Data
@Table(name="comics")
@Entity
public class Comic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String superpower;


}
