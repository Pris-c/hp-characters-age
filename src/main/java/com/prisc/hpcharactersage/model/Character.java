package com.prisc.hpcharactersage.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Character {
    @Id
    private String id;
    private String name;
    private String species;
    private LocalDate dateOfBirth;
    private Integer yearOfBirth;
    private Integer age;

}
