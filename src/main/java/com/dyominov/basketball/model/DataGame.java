package com.dyominov.basketball.model;


public class DataGame {

    private String homeTeam;
    private String awayTeam;
    private Double totalScore;
    private Double homeScore;
    private Double awayScore;
    private Double handicape;
    private Double firstQuarterScore;
    private Double secondQuarterScore;
    private Double thirdQuarterScore;
    private Double fourthQuarterScore;

    public DataGame() {
    }

    public DataGame(String homeTeam, String awayTeam, Double totalScore, Double homeScore, Double awayScore, Double handicape, Double firstQuarterScore, Double secondQuarterScore, Double thirdQuarterScore, Double fourthQuarterScore) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.totalScore = totalScore;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.handicape = handicape;
        this.firstQuarterScore = firstQuarterScore;
        this.secondQuarterScore = secondQuarterScore;
        this.thirdQuarterScore = thirdQuarterScore;
        this.fourthQuarterScore = fourthQuarterScore;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
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

    public Double getHandicape() {
        return handicape;
    }

    public Double getFirstQuarterScore() {
        return firstQuarterScore;
    }

    public Double getSecondQuarterScore() {
        return secondQuarterScore;
    }

    public Double getThirdQuarterScore() {
        return thirdQuarterScore;
    }

    public Double getFourthQuarterScore() {
        return fourthQuarterScore;
    }
}
