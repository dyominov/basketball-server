package com.dyominov.basketball.service;

import com.dyominov.basketball.model.Game;
import com.dyominov.basketball.model.Result;
import com.dyominov.basketball.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;


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
    public List<Game> getAllByHomeTeamAndAwayTeam(final String homeTeam, final String awayTeam) {
        return gameRepository.getAllByGameName(homeTeam + " - " + awayTeam);
    }

    @Override
    public Result getResult(String homeTeam, String awayTeam, Double totalScore, Double homeScore, Double awayScore, Double handicape, Double firstQuarterScore, Double secondQuarterScore, Double thirdQuarterScore, Double fourthQuarterScore) {
        List<Game> games = getAllByHomeTeamAndAwayTeam(homeTeam, awayTeam);

        double size = games.size();
        double handicap = games.stream().filter(g -> g.getFullScoreTeam1() + handicape > g.getFullScoreTeam2()).count() / size;
        double firstQuart = games.stream().filter(g -> (g.getFirstQuarterTeam1() + g.getFirstQuarterTeam2()) > firstQuarterScore).count() / size;
        double secondQuart = games.stream().filter(g -> (g.getSecondQuarterTeam1() + g.getSecondQuarterTeam2()) > secondQuarterScore).count() / size;
        double threeQuart = games.stream().filter(g -> (g.getThreeQuarterTeam1() + g.getThreeQuarterTeam2()) > thirdQuarterScore).count() / size;
        double fourQuart = games.stream().filter(g -> (g.getFourQuarterTeam1() + g.getFourQuarterTeam2()) > fourthQuarterScore).count() / size;
        double average = games.stream().filter(g -> (g.getFullScoreTeam1() + g.getFullScoreTeam2()) > totalScore).count() / size;
        double percentHome = games.stream().filter(g -> g.getFullScoreTeam1() >= homeScore).count() / size;
        double percentAway = games.stream().filter(g -> g.getFullScoreTeam2() >= awayScore).count() / size;
        Result res = new Result(percentHome, percentAway, firstQuart, secondQuart, threeQuart, fourQuart, average, handicap);
        System.out.println(res);
        return res;
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
