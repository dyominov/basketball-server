package com.dyominov.basketball.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "games")

public class Game {

    @JsonProperty("competition_id")
    Long competitionId;
    @JsonProperty("game_name")
    String gameName;
    @JsonProperty("full_score_team1")

    Integer fullScoreTeam1;
    @JsonProperty("full_score_team2")

    Integer fullScoreTeam2;

    @JsonProperty("first_quarter_team1")

    Integer firstQuarterTeam1;
    @JsonProperty("first_quarter_team2")

    Integer firstQuarterTeam2;
    @JsonProperty("second_quarter_team1")

    Integer secondQuarterTeam1;
    @JsonProperty("second_quarter_team2")

    Integer secondQuarterTeam2;
    @JsonProperty("third_quarter_team1")

    Integer threeQuarterTeam1;
    @JsonProperty("third_quarter_team2")

    Integer threeQuarterTeam2;
    @JsonProperty("fourth_quarter_team1")

    Integer fourQuarterTeam1;
    @JsonProperty("fourth_quarter_team2")

    Integer fourQuarterTeam2;
    @JsonProperty("date")
    Long date;
    @JsonProperty("game_id")
    Long gameId;
    @JsonProperty("team1_id")
    Long team1Id;
    @JsonProperty("team1_name")
    String team1Name;
    @JsonProperty("team2_id")
    Long team2Id;
    @JsonProperty("team2_name")
    String team2Name;

    public Game() {
    }

    public Game(Long competitionId, String gameName, Integer fullScoreTeam1, Integer fullScoreTeam2, Integer firstQuarterTeam1, Integer firstQuarterTeam2, Integer secondQuarterTeam1, Integer secondQuarterTeam2, Integer threeQuarterTeam1, Integer threeQuarterTeam2, Integer fourQuarterTeam1, Integer fourQuarterTeam2, Long date, Long gameId, Long team1Id, String team1Name, Long team2Id, String team2Name) {
        this.competitionId = competitionId;
        this.gameName = gameName;
        this.fullScoreTeam1 = fullScoreTeam1;
        this.fullScoreTeam2 = fullScoreTeam2;
        this.firstQuarterTeam1 = firstQuarterTeam1;
        this.firstQuarterTeam2 = firstQuarterTeam2;
        this.secondQuarterTeam1 = secondQuarterTeam1;
        this.secondQuarterTeam2 = secondQuarterTeam2;
        this.threeQuarterTeam1 = threeQuarterTeam1;
        this.threeQuarterTeam2 = threeQuarterTeam2;
        this.fourQuarterTeam1 = fourQuarterTeam1;
        this.fourQuarterTeam2 = fourQuarterTeam2;
        this.date = date;
        this.gameId = gameId;
        this.team1Id = team1Id;
        this.team1Name = team1Name;
        this.team2Id = team2Id;
        this.team2Name = team2Name;
    }

    public String getGameName() {
        return gameName;
    }

    public Long getCompetitionId() {
        return competitionId;
    }

    public Integer getFullScoreTeam1() {
        return fullScoreTeam1;
    }

    public Integer getFullScoreTeam2() {
        return fullScoreTeam2;
    }

    public Integer getFirstQuarterTeam1() {
        return firstQuarterTeam1;
    }

    public Integer getFirstQuarterTeam2() {
        return firstQuarterTeam2;
    }

    public Integer getSecondQuarterTeam1() {
        return secondQuarterTeam1;
    }

    public Integer getSecondQuarterTeam2() {
        return secondQuarterTeam2;
    }

    public Integer getThreeQuarterTeam1() {
        return threeQuarterTeam1;
    }

    public Integer getThreeQuarterTeam2() {
        return threeQuarterTeam2;
    }

    public Integer getFourQuarterTeam1() {
        return fourQuarterTeam1;
    }

    public Integer getFourQuarterTeam2() {
        return fourQuarterTeam2;
    }

    public Long getDate() {
        return date;
    }

    public Long getGameId() {
        return gameId;
    }

    public Long getTeam1Id() {
        return team1Id;
    }

    public String getTeam1Name() {
        return team1Name;
    }

    public Long getTeam2Id() {
        return team2Id;
    }

    public String getTeam2Name() {
        return team2Name;
    }
}
