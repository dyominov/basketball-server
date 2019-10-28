package com.dyominov.basketball.model;


public class Result {
    private Double percentHome;
    private Double percentAway;
    private Double firstQuart;
    private Double secondQuart;
    private Double threeQuart;
    private Double fourQuart;
    private Double average;
    private Double handicap;

    public Result() {
    }

    public Result(Double percentHome, Double percentAway, Double firstQuart, Double secondQuart, Double threeQuart, Double fourQuart, Double average, Double handicap) {
        this.percentHome = percentHome;
        this.percentAway = percentAway;
        this.firstQuart = firstQuart;
        this.secondQuart = secondQuart;
        this.threeQuart = threeQuart;
        this.fourQuart = fourQuart;
        this.average = average;
        this.handicap = handicap;
    }

    public Double getPercentHome() {
        return percentHome;
    }

    public void setPercentHome(Double percentHome) {
        this.percentHome = percentHome;
    }

    public Double getPercentAway() {
        return percentAway;
    }

    public void setPercentAway(Double percentAway) {
        this.percentAway = percentAway;
    }

    public Double getFirstQuart() {
        return firstQuart;
    }

    public void setFirstQuart(Double firstQuart) {
        this.firstQuart = firstQuart;
    }

    public Double getSecondQuart() {
        return secondQuart;
    }

    public void setSecondQuart(Double secondQuart) {
        this.secondQuart = secondQuart;
    }

    public Double getThreeQuart() {
        return threeQuart;
    }

    public void setThreeQuart(Double threeQuart) {
        this.threeQuart = threeQuart;
    }

    public Double getFourQuart() {
        return fourQuart;
    }

    public void setFourQuart(Double fourQuart) {
        this.fourQuart = fourQuart;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public Double getHandicap() {
        return handicap;
    }

    public void setHandicap(Double handicap) {
        this.handicap = handicap;
    }

    @Override
    public String toString() {
        return "Result{" +
                "percentHome=" + percentHome +
                ", percentAway=" + percentAway +
                ", firstQuart=" + firstQuart +
                ", secondQuart=" + secondQuart +
                ", threeQuart=" + threeQuart +
                ", fourQuart=" + fourQuart +
                ", average=" + average +
                ", handicap=" + handicap +
                '}';
    }
}
