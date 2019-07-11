package com.dyominov.basketball.service;

import com.dyominov.basketball.model.Game;
import com.dyominov.basketball.model.Result;
import com.dyominov.basketball.model.Team;
import com.dyominov.basketball.repository.GameRepository;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    public Result getResult(final Team homeTeam, final Team awayTeam, final Double score, final Double homeScore, final Double awayScore, final Double handicape) {
        List<Game> games = getAllByHomeTeamAndAwayTeam(homeTeam, awayTeam);
        List<Game> gamesHomeTeam = getAllByHomeTeam(homeTeam);
        List<Game> gamesAwayTeam = getAllByAwayTeam(awayTeam);
        double percentHomeH = gamesHomeTeam.stream().filter(g -> g.getHomeTeam().getScore() >= homeScore).count() / (gamesHomeTeam.size() + 0.0);
        double percentAwayA = gamesAwayTeam.stream().filter(g -> g.getAwayTeam().getScore() >= awayScore).count() / (gamesAwayTeam.size() + 0.0);

        double size = games.size();
        double handicap = games.stream().filter(g -> g.getHomeTeam().getScore() + handicape > g.getAwayTeam().getScore()).count() / size;
        double average = games.stream().filter(g -> g.getTotalScore() > score).count() / size;
        double minTotal = games.stream().filter(g -> g.getTotalScore() > score - 3).count() / size;
        double maxTotal = games.stream().filter(g -> g.getTotalScore() > score + 3).count() / size;
        double percentHome = games.stream().filter(g -> g.getHomeTeam().getScore() >= homeScore).count() / size;
        double averageHome = games.stream().mapToDouble(game -> game.getHomeTeam().getScore()).sum() / size;
        double percentAway = games.stream().filter(g -> g.getAwayTeam().getScore() >= awayScore).count() / size;
        double averageAway = games.stream().mapToDouble(game -> game.getAwayTeam().getScore()).sum() / size;
        return new Result(percentHome, percentHomeH, percentAway, percentAwayA, minTotal, average, maxTotal, handicap);
    }

    private List<Game> getAllByAwayTeam(Team awayTeam) {
        return gameRepository.getAllByAwayTeamName(awayTeam.getName());
    }

    private List<Game> getAllByHomeTeam(Team homeTeam) {
        return gameRepository.getAllByHomeTeamName(homeTeam.getName());
    }

    @Override
    public Game create(final Game game) {
        return gameRepository.save(game);
    }

    @Override
    public void deleteById(String id) {
        gameRepository.deleteById(id);
    }

    @Override
    public void parseData() {
        try (Scanner in = new Scanner(new File("input.txt"))) {
            List<Game> games = new ArrayList<>();
            for (int i = 0; i < 240; i++) {
                String date = in.nextLine();
                String[] teams = in.nextLine().trim().split(" - ");
                String[] line = in.nextLine().trim().split("\t");
                String[] scoreOne = line[3].trim().split(":");
                String[] scoreTwo = line[4].trim().split(":");
                String[] score = line[line.length - 1].trim().split(":");
                Game game = new Game(date,
                        new Team(teams[0], Double.valueOf(scoreOne[0]) + Double.valueOf(scoreTwo[0]), Double.valueOf(score[0])),
                        new Team(teams[1], Double.valueOf(scoreOne[1]) + Double.valueOf(scoreTwo[1]), Double.valueOf(score[1].replace("(ОТ)", ""))),
                        Double.valueOf(scoreOne[0]) + Double.valueOf(scoreTwo[0]) + Double.valueOf(scoreOne[1]) + Double.valueOf(scoreTwo[1]),
                        Double.valueOf(score[0]) + Double.valueOf(score[1].replace("(ОТ)", "")));
                games.add(game);
            }
            gameRepository.saveAll(games);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
