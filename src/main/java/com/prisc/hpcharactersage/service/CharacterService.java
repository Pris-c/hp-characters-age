package com.prisc.hpcharactersage.service;

import com.prisc.hpcharactersage.model.CharacterAPI;

import java.util.List;


public interface CharacterService {
    public List<CharacterAPI> getCharacter(String name);

}
