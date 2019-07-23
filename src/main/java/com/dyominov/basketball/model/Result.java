package com.dyominov.basketball.model;

import java.util.Objects;

public class Result {
    private Double percentHome;
    private Double handicapHalf;
    private Double percentAway;
    private Double averageHalf;
    private Double minTotal;
    private Double averageTotal;
    private Double maxTotal;
    private Double handicape;

    public Result() {
    }

    public Result(Double percentHome, Double percentAway, Double handicapHalf, Double averageHalf, Double minTotal, Double averageTotal, Double maxTotal, Double handicape) {
        this.percentHome = percentHome;
        this.handicapHalf = handicapHalf;
        this.percentAway = percentAway;
        this.averageHalf = averageHalf;
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

    public Double getHandicapHalf() {
        return handicapHalf;
    }

    public void setHandicapHalf(Double handicapHalf) {
        this.handicapHalf = handicapHalf;
    }

    public Double getPercentAway() {
        return percentAway;
    }

    public void setPercentAway(Double percentAway) {
        this.percentAway = percentAway;
    }

    public Double getAverageHalf() {
        return averageHalf;
    }

    public void setAverageHalf(Double averageHalf) {
        this.averageHalf = averageHalf;
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
                Objects.equals(handicapHalf, result.handicapHalf) &&
                Objects.equals(percentAway, result.percentAway) &&
                Objects.equals(averageHalf, result.averageHalf) &&
                Objects.equals(minTotal, result.minTotal) &&
                Objects.equals(averageTotal, result.averageTotal) &&
                Objects.equals(maxTotal, result.maxTotal) &&
                Objects.equals(handicape, result.handicape);
    }

    @Override
    public int hashCode() {
        return Objects.hash(percentHome, handicapHalf, percentAway, averageHalf, minTotal, averageTotal, maxTotal, handicape);
    }

    @Override
    public String toString() {
        return "Result{" +
                "percentHome=" + percentHome +
                ", handicapHalf=" + handicapHalf +
                ", percentAway=" + percentAway +
                ", averageHalf=" + averageHalf +
                ", minTotal=" + minTotal +
                ", averageTotal=" + averageTotal +
                ", maxTotal=" + maxTotal +
                ", handicape=" + handicape +
                '}';
    }
}
