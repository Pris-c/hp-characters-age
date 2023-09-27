package com.prisc.hpcharactersage.service.impl;

import com.prisc.hpcharactersage.model.*;
import com.prisc.hpcharactersage.model.Character;
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
    public List<Character> getCharacter(String name) {
        return getCharacterApiList(name).stream()
                .map(c -> new Character(c.getId(), c.getName(), c.getDateOfBirth()))
                .toList();
    }

    private List<CharacterAPI> getCharacterApiList(String name){
        List<CharacterAPI> charactersList =  hpApiService.getCharacterList();
        return charactersList
                .stream()
                .filter(ch -> ch.anyName(name))
                .filter(CharacterAPI::isThereDateOfBirth)
                .toList();
    }




}
