package com.dyominov.basketball.service;

import com.dyominov.basketball.model.Game;
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
    public List<Game> getAllByHomeTeamAndAwayTeam(final Team homeTeam,final Team awayTeam) {
        return gameRepository.getAllByHomeTeamNameAndAwayTeamName(homeTeam.getName(), awayTeam.getName());
    }

    @Override
    public Double overCurrentTotal(final Team homeTeam, final Team awayTeam, final Double score) {
        List<Game> games = getAllByHomeTeamAndAwayTeam(homeTeam, awayTeam);
        return (games.stream().filter(g -> g.getTotalScore() > score).count() / (games.size() + 0D));
    }

    @Override
    public Game create(final Game game) {
        return gameRepository.save(game);
    }
}
