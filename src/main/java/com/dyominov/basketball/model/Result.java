package com.dyominov.basketball.model;

import java.util.Objects;

public class Result {
    private Double percentHome;
    private Double averageHome;
    private Double percentAway;
    private Double averageAway;
    private Double minTotal;
    private Double averageTotal;
    private Double maxTotal;
    private Double handicape;

    public Result() {
    }

    public Result(Double percentHome, Double averageHome, Double percentAway, Double averageAway, Double minTotal, Double averageTotal, Double maxTotal, Double handicape) {
        this.percentHome = percentHome;
        this.averageHome = averageHome;
        this.percentAway = percentAway;
        this.averageAway = averageAway;
        this.minTotal = minTotal;
        this.averageTotal = averageTotal;
        this.maxTotal = maxTotal;
        this.handicape = handicape;
    }

    public Double getPercentHome() {
        return percentHome;
    }

    public void setPercentHome(Double percentHome) {
        this.percentHome = percentHome;
    }

    public Double getAverageHome() {
        return averageHome;
    }

    public void setAverageHome(Double averageHome) {
        this.averageHome = averageHome;
    }

    public Double getPercentAway() {
        return percentAway;
    }

    public void setPercentAway(Double percentAway) {
        this.percentAway = percentAway;
    }

    public Double getAverageAway() {
        return averageAway;
    }

    public void setAverageAway(Double averageAway) {
        this.averageAway = averageAway;
    }

    public Double getMinTotal() {
        return minTotal;
    }

    public void setMinTotal(Double minTotal) {
        this.minTotal = minTotal;
    }

    public Double getAverageTotal() {
        return averageTotal;
    }

    public void setAverageTotal(Double averageTotal) {
        this.averageTotal = averageTotal;
    }

    public Double getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(Double maxTotal) {
        this.maxTotal = maxTotal;
    }

    public Double getHandicape() {
        return handicape;
    }

    public void setHandicape(Double handicape) {
        this.handicape = handicape;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return Objects.equals(percentHome, result.percentHome) &&
                Objects.equals(averageHome, result.averageHome) &&
                Objects.equals(percentAway, result.percentAway) &&
                Objects.equals(averageAway, result.averageAway) &&
                Objects.equals(minTotal, result.minTotal) &&
                Objects.equals(averageTotal, result.averageTotal) &&
                Objects.equals(maxTotal, result.maxTotal) &&
                Objects.equals(handicape, result.handicape);
    }

    @Override
    public int hashCode() {
        return Objects.hash(percentHome, averageHome, percentAway, averageAway, minTotal, averageTotal, maxTotal, handicape);
    }
}
