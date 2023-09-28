package com.prisc.hpcharactersage.model;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Getter
@Setter
public class CharacterResponse {

    private String name;
    private Integer age;

    public CharacterResponse() {
    }

    public CharacterResponse(String name, String dateOfBirth) {
        this.name = name;
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
