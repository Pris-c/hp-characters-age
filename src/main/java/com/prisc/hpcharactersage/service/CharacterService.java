package com.prisc.hpcharactersage.service;

import com.prisc.hpcharactersage.model.Character;
import com.prisc.hpcharactersage.model.CharacterResponse;

import java.util.List;


public interface CharacterService {
    public List<Character> getCharacterList(String name);

    public CharacterResponse getCharacter(String name);
    public Character save(Character c);
    public Character findCharacter(String name);

}
