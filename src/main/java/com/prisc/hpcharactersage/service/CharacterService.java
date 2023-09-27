package com.prisc.hpcharactersage.service;

import com.prisc.hpcharactersage.model.Character;

import java.util.List;


public interface CharacterService {
    public List<Character> getCharacter(String name);

}
