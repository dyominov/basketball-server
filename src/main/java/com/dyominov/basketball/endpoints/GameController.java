package com.dyominov.basketball.endpoints;

import com.dyominov.basketball.model.Game;
import com.dyominov.basketball.model.Team;
import com.dyominov.basketball.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Game createGame(@RequestBody final Game game) {
        return gameService.create(game);
    }

    @PutMapping("/over")
    @ResponseStatus(HttpStatus.CREATED)
    public Double overCurrentTotal(@RequestBody final Game game) {
        Team home = game.getHomeTeam();
        Team away = game.getAwayTeam();
        Double score = game.getTotalScore();
        return gameService.overCurrentTotal(home, away, score);
    }
}
