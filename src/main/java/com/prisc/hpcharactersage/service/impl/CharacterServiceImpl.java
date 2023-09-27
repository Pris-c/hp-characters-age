package com.prisc.hpcharactersage.service.impl;

import com.prisc.hpcharactersage.model.*;
import com.prisc.hpcharactersage.service.CharacterService;
import com.prisc.hpcharactersage.service.HpApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService{

    @Autowired
    private HpApiService hpApiService;

    @Override
    public List<CharacterAPI> getCharacter(String name) {
        return this.getCharacterApiList(name);
    }

    private List<CharacterAPI> getCharacterApiList(String name){
        List<CharacterAPI> charactersList =  hpApiService.getCharacterList();
        return charactersList
                .stream()
                .filter(ch -> ch.anyName(name))
                .toList();

        /*
        List<Character> charactersApiNameName = charactersApiName.stream()
                .map(c -> new Character(c.getId(), c.getName(), c.getSpecies(), c.getYearOfBirth()))
                .toList();
        return charactersApiName;
        */
    }




}
