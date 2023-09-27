package com.prisc.hpcharactersage.service;

import com.prisc.hpcharactersage.model.CharacterAPI;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "hp-api", url = "https://hp-api.onrender.com/api")
public interface HpApiService {

    @GetMapping("/characters")
    List<CharacterAPI> getCharacterList();

}
