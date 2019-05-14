package com.dyominov.basketball;


import com.dyominov.basketball.model.Game;
import com.dyominov.basketball.model.Team;

public class TestData {

    public static Game NEW_GAME;
    public static Team NEW_HOME_TEAM;
    public static Team NEW_AWAY_TEAM;


    static {
        Team homeTeam = new Team("Boston", 100d);
        Team awayTeam = new Team("Memphis", 94d);
        NEW_GAME = new Game(homeTeam, awayTeam, homeTeam.getScore() + awayTeam.getScore());
        NEW_HOME_TEAM = new Team("Boston");
        NEW_AWAY_TEAM = new Team("Memphis");
    }

}
