package com.dyominov.basketball.service;

import com.dyominov.basketball.model.Game;
import com.dyominov.basketball.model.Result;
import com.dyominov.basketball.model.Team;

import java.util.List;

public interface GameService {

    List<Game> getAll();

    Game getGameById(String id);

    List<Game> getAllByHomeTeamAndAwayTeam(String homeTeam, String awayTeam);

    Result getResult(
            String homeTeam, String awayTeam, Double totalScore, Double homeScore, Double awayScore, Double handicape, Double firstQuarterScore, Double secondQuarterScore, Double thirdQuarterScore, Double fourthQuarterScore
    );

    Game create(Game game);

    void deleteById(String id);
}


