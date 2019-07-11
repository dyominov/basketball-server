package com.dyominov.basketball.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Objects;

@Document(collection = "games")

public class Game {

    @Id
    private String id;
    private String date;
    @Field("home_team")
    private Team homeTeam;
    @Field("away_team")
    private Team awayTeam;
    @Field("half_score")
    private Double halfScore;
    @Field("total_score")
    private Double totalScore;

    public Game() {
    }

    public Game(String date, Team homeTeam, Team awayTeam, Double halfScore, Double totalScore) {
        this.date = date;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.halfScore = halfScore;
        this.totalScore = totalScore;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Double getHalfScore() {
        return halfScore;
    }

    public void setHalfScore(Double halfScore) {
        this.halfScore = halfScore;
    }

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(id, game.id) &&
                Objects.equals(date, game.date) &&
                Objects.equals(homeTeam, game.homeTeam) &&
                Objects.equals(awayTeam, game.awayTeam) &&
                Objects.equals(halfScore, game.halfScore) &&
                Objects.equals(totalScore, game.totalScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, homeTeam, awayTeam, halfScore, totalScore);
    }

    @Override
    public String toString() {
        return "Game{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", homeTeam=" + homeTeam +
                ", awayTeam=" + awayTeam +
                ", halfScore=" + halfScore +
                ", totalScore=" + totalScore +
                '}';
    }
}
