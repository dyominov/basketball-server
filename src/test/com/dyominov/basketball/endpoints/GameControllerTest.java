package com.dyominov.basketball.endpoints;

import com.dyominov.basketball.model.Game;
import com.dyominov.basketball.model.Team;
import com.dyominov.basketball.service.GameService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.mock.http.server.reactive.MockServerHttpRequest;
import org.springframework.test.web.servlet.ResultActions;

import static com.dyominov.basketball.JsonUtils.readFromJson;
import static com.dyominov.basketball.JsonUtils.writeValue;
import static com.dyominov.basketball.TestData.*;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class GameControllerTest extends AbstractControllerTest {

    @Autowired
    GameService gameService;
    @Autowired
    MongoTemplate mongoTemplate;

    private static Game newGame;
    private static Team newHomeTeam;
    private static Team newAwayTeam;

    @Before
    public void setUp() {
        if (mongoTemplate.collectionExists("games")) {
            mongoTemplate.dropCollection("games");
        }

        newGame = NEW_GAME;
        newHomeTeam = NEW_HOME_TEAM;
        newAwayTeam = NEW_AWAY_TEAM;
        mongoTemplate.save(newGame, "games");
    }


    @Test
    public void testCreateGameApi() throws Exception {
        ResultActions action = mvc.perform(post("/game")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writeValue(newGame)))
                .andExpect(status().isCreated())
                .andExpect(content().json(writeValue(gameService.getAll().get(0))))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
        assertEquals("game totalScore in json response", Double.valueOf(194.0), readFromJson(action, "$.totalScore"));
    }


}