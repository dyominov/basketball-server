package com.dyominov.basketball.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Objects;

@Document(collection = "games")

public class Game {

    @Id
    private String id;
    @Field("home_team")
    private Team homeTeam;
    @Field("away_team")
    private Team awayTeam;
    @Field("total_score")
    private Double totalScore;

    public Game() {
    }

    public Game(Team homeTeam, Team awayTeam, Double totalScore) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.totalScore = totalScore;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public Double getTotalScore() {
        return totalScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(homeTeam, game.homeTeam) &&
                Objects.equals(awayTeam, game.awayTeam) &&
                Objects.equals(totalScore, game.totalScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeTeam, awayTeam, totalScore);
    }
}
