package com.dyominov.basketball.repository;

import com.dyominov.basketball.model.Game;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface GameRepository extends MongoRepository<Game, String> {

    List<Game> getAllByGameName(String gameName);

    void deleteById(String id);
}
