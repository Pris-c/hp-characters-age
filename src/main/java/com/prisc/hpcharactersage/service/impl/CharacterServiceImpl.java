package com.prisc.hpcharactersage.service.impl;

import com.prisc.hpcharactersage.model.*;
import com.prisc.hpcharactersage.model.Character;
import com.prisc.hpcharactersage.repository.CharacterRepository;
import com.prisc.hpcharactersage.service.CharacterService;
import com.prisc.hpcharactersage.service.HpApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ExecutionException;

@Service
public class CharacterServiceImpl implements CharacterService{

    @Autowired
    private HpApiService hpApiService;
    @Autowired
    private CharacterRepository characterRepository;

    public CharacterResponse getCharacter(String name){
        Character character = findCharacter(name);
        CharacterResponse characterResponse = new CharacterResponse();
        if (character != null){
            characterResponse = new CharacterResponse(character.getName(), character.getDateOfBirth());
        } else {
            List<Character> list = getCharacterList(name);
            if (!list.isEmpty()) {
                for (Character c : list) {
                    this.save(c);
                }
                character = list.getFirst();
                characterResponse = new CharacterResponse(character.getName(), character.getDateOfBirth());
            }
        }
        return characterResponse;
    }

    private List<Character> getCharacterList(String name) {
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

    private Character save(Character c){
        return characterRepository.save(c);
    }

    private Character findCharacter(String name){
        return characterRepository.findByName(name).orElse(null);
    }

}
