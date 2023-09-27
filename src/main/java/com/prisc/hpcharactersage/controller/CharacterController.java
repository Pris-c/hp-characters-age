package com.prisc.hpcharactersage.controller;

import com.prisc.hpcharactersage.model.CharacterAPI;
import com.prisc.hpcharactersage.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping("/{name}")
    public ResponseEntity<List<CharacterAPI>> getCharacterByName(@PathVariable String name){
        return ResponseEntity.ok(characterService.getCharacter(name));
    }

}
