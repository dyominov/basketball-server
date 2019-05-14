package com.dyominov.basketball.service;

import com.dyominov.basketball.model.Game;
import com.dyominov.basketball.model.Team;

import java.util.List;

public interface GameService {

    List<Game> getAll();

    Game getGameById(String id);

    List<Game> getAllByHomeTeamAndAwayTeam(Team homeTeam, Team awayTeam);

    Double overCurrentTotal(Team homeTeam, Team awayTeam, Double score);

    Game create(Game game);
}
