package com.dyominov.basketball;


import com.dyominov.basketball.model.DataGame;
import com.dyominov.basketball.model.Game;
import com.dyominov.basketball.model.Team;

import java.util.Date;

public class TestData {

    public static Game NEW_GAME;
    public static Team NEW_HOME_TEAM;
    public static Team NEW_AWAY_TEAM;


    static {
        Team homeTeam = new Team("Boston", 53d, 100d);
        Team awayTeam = new Team("Memphis", 45d, 94d);
        NEW_GAME = new Game(new Date().toString(), homeTeam, awayTeam, homeTeam.getHalfScore() + awayTeam.getHalfScore(), homeTeam.getScore() + awayTeam.getScore());
        NEW_HOME_TEAM = new Team("Boston");
        NEW_AWAY_TEAM = new Team("Memphis");
    }

}
