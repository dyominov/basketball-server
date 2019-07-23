package com.dyominov.basketball.model;

import java.util.Objects;

public class DataGame {

    private Team homeTeam;
    private Team awayTeam;
    private Double totalScore;
    private Double homeScore;
    private Double awayScore;
    private Double handicape;
    private Double halfScore;
    private Double halfHandicape;

    public DataGame() {
    }

    public DataGame(Team homeTeam, Team awayTeam, Double totalScore, Double homeScore, Double awayScore, Double handicape, Double halfScore, Double halfHandicape) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.totalScore = totalScore;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.handicape = handicape;
        this.halfScore = halfScore;
        this.halfHandicape = halfHandicape;
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

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
    }

    public Double getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(Double homeScore) {
        this.homeScore = homeScore;
    }

    public Double getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(Double awayScore) {
        this.awayScore = awayScore;
    }

    public Double getHandicape() {
        return handicape;
    }

    public void setHandicape(Double handicape) {
        this.handicape = handicape;
    }

    public Double getHalfScore() {
        return halfScore;
    }

    public void setHalfScore(Double halfScore) {
        this.halfScore = halfScore;
    }

    public Double getHalfHandicape() {
        return halfHandicape;
    }

    public void setHalfHandicape(Double halfHandicape) {
        this.halfHandicape = halfHandicape;
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
                Objects.equals(handicape, dataGame.handicape) &&
                Objects.equals(halfScore, dataGame.halfScore) &&
                Objects.equals(halfHandicape, dataGame.halfHandicape);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeTeam, awayTeam, totalScore, homeScore, awayScore, handicape, halfScore, halfHandicape);
    }
}
