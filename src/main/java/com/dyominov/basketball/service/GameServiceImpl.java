package com.dyominov.basketball.service;

import com.dyominov.basketball.model.Game;
import com.dyominov.basketball.model.Result;
import com.dyominov.basketball.model.Team;
import com.dyominov.basketball.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {
    private GameRepository gameRepository;


    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public List<Game> getAll() {
        return gameRepository.findAll();
    }

    @Override
    public Game getGameById(String id) {
        return gameRepository.findById(id).get();
    }

    @Override
    public List<Game> getAllByHomeTeamAndAwayTeam(final Team homeTeam, final Team awayTeam) {
        return gameRepository.getAllByHomeTeamNameAndAwayTeamName(homeTeam.getName(), awayTeam.getName());
    }

    @Override
    public Result getResult(final Team homeTeam, final Team awayTeam, final Double score, final Double homeScore, final Double awayScore,final Double handicape) {
        List<Game> games = getAllByHomeTeamAndAwayTeam(homeTeam, awayTeam);
        double size = games.size();
        double handicap = games.stream().filter(g -> g.getHomeTeam().getScore() + handicape > g.getAwayTeam().getScore()).count() / size;
        double average = games.stream().filter(g -> g.getTotalScore() > score).count() / size;
        double minTotal = games.stream().filter(g -> g.getTotalScore() > score - 3).count() / size;
        double maxTotal = games.stream().filter(g -> g.getTotalScore() > score + 3).count() / size;
        double percentHome = games.stream().filter(g -> g.getHomeTeam().getScore() >= homeScore).count() / size;
        double averageHome = games.stream().mapToDouble(game -> game.getHomeTeam().getScore()).sum() / size;
        double percentAway = games.stream().filter(g -> g.getAwayTeam().getScore() >= awayScore).count() / size;
        double averageAway = games.stream().mapToDouble(game -> game.getAwayTeam().getScore()).sum() / size;
        return new Result(percentHome, averageHome, percentAway, averageAway, minTotal, average, maxTotal, handicap);
    }

    @Override
    public Game create(final Game game) {
        return gameRepository.save(game);
    }

    @Override
    public void deleteById(String id) {
        gameRepository.deleteById(id);
    }
}
