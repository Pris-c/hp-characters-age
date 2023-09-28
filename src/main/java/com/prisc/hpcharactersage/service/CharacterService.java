package com.prisc.hpcharactersage.service;

import com.prisc.hpcharactersage.model.Character;
import com.prisc.hpcharactersage.model.CharacterResponse;

import java.util.List;


public interface CharacterService {
    public CharacterResponse getCharacter(String name);
}
