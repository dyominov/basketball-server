package com.dyominov.basketball.model;

import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Objects;

public class Team {
    private String name;
    @Field("half_score")
    private Double halfScore;
    private Double score;


    public Team() {
    }

    public Team(String name) {
        this.name = name;
    }

    public Team(String name, Double halfScore, Double score) {
        this.name = name;
        this.halfScore = halfScore;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getHalfScore() {
        return halfScore;
    }

    public void setHalfScore(Double halfScore) {
        this.halfScore = halfScore;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(name, team.name) &&
                Objects.equals(halfScore, team.halfScore) &&
                Objects.equals(score, team.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, halfScore, score);
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", halfScore=" + halfScore +
                ", score=" + score +
                '}';
    }


}
