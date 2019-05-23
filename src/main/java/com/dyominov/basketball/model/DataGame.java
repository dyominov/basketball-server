package com.dyominov.basketball.model;

import java.util.Objects;

public class DataGame {

    private Team homeTeam;
    private Team awayTeam;
    private Double totalScore;
    private Double homeScore;
    private Double awayScore;
    private Double handicape;

    public DataGame(Team homeTeam, Team awayTeam, Double totalScore, Double homeScore, Double awayScore, Double handicape) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.totalScore = totalScore;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.handicape = handicape;
    }

    public DataGame() {
    }

    public Double getHandicape() {
        return handicape;
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

    public Double getHomeScore() {
        return homeScore;
    }

    public Double getAwayScore() {
        return awayScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataGame dataGame = (DataGame) o;
        return Objects.equals(homeTeam, dataGame.homeTeam) &&
                Objects.equals(awayTeam, dataGame.awayTeam) &&
                Objects.equals(totalScore, dataGame.totalScore) &&
                Objects.equals(homeScore, dataGame.homeScore) &&
                Objects.equals(awayScore, dataGame.awayScore) &&
                Objects.equals(handicape, dataGame.handicape);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeTeam, awayTeam, totalScore, homeScore, awayScore, handicape);
    }
}
