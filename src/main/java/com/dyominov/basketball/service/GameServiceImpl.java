package com.dyominov.basketball.service;

import com.dyominov.basketball.model.Game;
import com.dyominov.basketball.model.Result;
import com.dyominov.basketball.model.Team;
import com.dyominov.basketball.repository.GameRepository;
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
    public Result getResult(final Team homeTeam, final Team awayTeam, final Double score, final Double homeScore, final Double awayScore, final Double handicape, final Double halfScore, final Double halfHandicape) {
        List<Game> games = getAllByHomeTeamAndAwayTeam(homeTeam, awayTeam);

        double size = games.size();
        double handicap = games.stream().filter(g -> g.getHomeTeam().getScore() + handicape > g.getAwayTeam().getScore()).count() / size;
        double handicapHalf = games.stream().filter(g -> g.getHomeTeam().getHalfScore() + halfHandicape > g.getAwayTeam().getHalfScore()).count() / size;
        double average = games.stream().filter(g -> g.getTotalScore() > score).count() / size;
        double averageHalf = games.stream().filter(g -> g.getHalfScore() > halfScore).count() / size;
        double minTotal = games.stream().filter(g -> g.getTotalScore() > score - 3).count() / size;
        double maxTotal = games.stream().filter(g -> g.getTotalScore() > score + 3).count() / size;
        double percentHome = games.stream().filter(g -> g.getHomeTeam().getScore() >= homeScore).count() / size;
        double percentAway = games.stream().filter(g -> g.getAwayTeam().getScore() >= awayScore).count() / size;
        return new Result(percentHome, percentAway, handicapHalf, averageHalf,  minTotal, average, maxTotal, handicap);
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
            for (int i = 0; i < 2160; i++) {
                String date = in.nextLine();
                if (date.length() < 3){
                    date = in.nextLine();

                }
                String[] teams = in.nextLine().trim().split(" - ");
                String[] line = in.nextLine().trim().split("\t");
                String[] scoreOne = line[3].trim().split(":");
                String[] scoreTwo = line[4].trim().split(":");
                String[] score = line[line.length - 1].trim().split(":");
                Game game = new Game(date,
                        new Team(teams[0], Double.parseDouble(scoreOne[0]) + Double.parseDouble(scoreTwo[0]), Double.valueOf(score[0])),
                        new Team(teams[1], Double.parseDouble(scoreOne[1]) + Double.parseDouble(scoreTwo[1]), Double.valueOf(score[1].replace("(ОТ)", ""))),
                        Double.parseDouble(scoreOne[0]) + Double.parseDouble(scoreTwo[0]) + Double.parseDouble(scoreOne[1]) + Double.parseDouble(scoreTwo[1]),
                        Double.parseDouble(score[0]) + Double.parseDouble(score[1].replace("(ОТ)", "")));
                games.add(game);
            }
            gameRepository.saveAll(games);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
