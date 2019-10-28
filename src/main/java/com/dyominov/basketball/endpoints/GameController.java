package com.dyominov.basketball.endpoints;

import com.dyominov.basketball.model.DataGame;
import com.dyominov.basketball.model.Game;
import com.dyominov.basketball.model.Result;
import com.dyominov.basketball.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping(value = "game")
public class GameController {
    private final GameService gameService;


    public GameController(final GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getAllGames() {
        return gameService.getAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Game getGameById(@PathVariable final String id) {
        return gameService.getGameById(id);
    }


    @PutMapping("/result")
    @ResponseStatus(HttpStatus.OK)
    public Result getResult(@RequestBody final DataGame game) {
        return gameService.getResult(
                game.getHomeTeam(),
                game.getAwayTeam(),
                game.getTotalScore(),
                game.getHomeScore(),
                game.getAwayScore(),
                game.getHandicape(),
                game.getFirstQuarterScore(),
                game.getSecondQuarterScore(),
                game.getThirdQuarterScore(),
                game.getFourthQuarterScore());
    }


    @PostMapping("/name")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getGamesByName(@RequestBody Map<String, String> map) {
        String team1 = map.get("team1");
        String team2 = map.get("team2");
        return gameService.getAllByHomeTeamAndAwayTeam(team1, team2);
    }


}
