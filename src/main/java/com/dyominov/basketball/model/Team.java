package com.dyominov.basketball.model;

import java.util.Objects;

public class Team {
    private String name;
    private Double score;

    public Team() {
    }

    public Team(String name) {
        this.name = name;
    }

    public Team(String name, Double score) {
        this.name = name;
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public Double getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(name, team.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
