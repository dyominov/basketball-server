package com.dyominov.basketball.service;

import com.dyominov.basketball.model.Game;
import com.dyominov.basketball.model.Result;
import com.dyominov.basketball.model.Team;

import java.util.List;

public interface GameService {

    List<Game> getAll();

    Game getGameById(String id);

    List<Game> getAllByHomeTeamAndAwayTeam(Team homeTeam, Team awayTeam);

    Result getResult(final Team homeTeam, final Team awayTeam, final Double score, final Double homeScore, final Double awayScore,final Double handicape);

    Game create(Game game);

    void deleteById(String id);
}
