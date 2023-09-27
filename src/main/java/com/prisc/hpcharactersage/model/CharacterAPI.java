package com.prisc.hpcharactersage.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CharacterAPI {



    private String id;
    private String name;
    private List<String> alternateNames;
    private String species;
    private String gender;
    private String house;
    private String dateOfBirth;
    private Integer yearOfBirth;
    private Boolean wizard;
    private String ancestry;
    private String eyeColour;
    private String hairColour;
    private Wand wand;
    private String patronus;
    private Boolean hogwartsStudent;
    private Boolean hogwartsStaff;
    private String actor;
    private List<Object> alternateActors;
    private Boolean alive;
    private String image;

    public boolean anyName(String name){
        return this.name.contains(name) ||
                isThere(name);
    }

    private boolean isThere(String name){
        boolean thereIs = false;
        if (this.alternateNames != null) {
            for (String n : alternateNames) {
                if (n.contains(name)) {
                    thereIs = true;
                    break;
                }
            }
        }
        return thereIs;
    }
}
