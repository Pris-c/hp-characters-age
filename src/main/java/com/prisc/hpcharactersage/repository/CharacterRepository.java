package com.prisc.hpcharactersage.repository;

import com.prisc.hpcharactersage.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<Character, String> {
}
