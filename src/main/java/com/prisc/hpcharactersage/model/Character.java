package com.prisc.hpcharactersage.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Getter
@Setter
@Entity
public class Character {
    @Id
    private String id;
    private String name;
    private String dateOfBirth;
    private Integer age;

    public Character(String id, String name, String dateOfBirth) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.age = this.calculateAge(dateOfBirth);

    }

    private Integer calculateAge(String birth){
        DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date dateBirth = null;
        try {
            dateBirth = sdf.parse(birth);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Calendar dateOfBirth = new GregorianCalendar();
        dateOfBirth.setTime(dateBirth);

        Calendar today = Calendar.getInstance();

        int age = today. get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
        dateOfBirth.add(Calendar.YEAR, age);

        if (today.before(dateOfBirth)) {
            age--;
        }

        return age;
    }




}
