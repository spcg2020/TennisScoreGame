package com.function;

import com.entity.Player;
import com.sports.Game;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class TennisGameTest {

    @Test
    public void testWhenGameIsNotStartedYet() throws Exception {
        // assert for both players against love score
        Player playerA=Player.builder().name("X").playerType(PlayerType.Server).score(Score.Love).build();
        Player playerB=Player.builder().name("Y").playerType(PlayerType.Receiver).score(Score.Love).build();
        assertEquals(Score.Love,playerA.getScore());
        assertEquals(Score.Love,playerB.getScore());
    }

    // test for not null
    @Test
    public void testForNotNullWhenPlayTheGame() throws Exception {
        Player playerA=Player.builder().name("X").playerType(PlayerType.Server).build();
        Player playerB=Player.builder().name("Y").playerType(PlayerType.Receiver).build();
        Game<Tennis> game=new Tennis(playerA,playerB);
        Tennis result=game.playTheGame();
        assertNotNull(result);
    }
    // test to score the point-1st way
    @Test
    public void testWhenOpponentCouldNotHitTheBallBack() throws Exception {
        Player playerA=Player.builder().name("X").playerType(PlayerType.Server).score(Score.Fifteen).point(1).build();
        Player playerB=Player.builder().name("Y").playerType(PlayerType.Receiver).score(Score.Love).point(0).build();

        Game<Tennis> game=new Tennis(playerA,playerB);
        Tennis result=game.playTheGame();
        assertEquals(Score.Fifteen,playerA.getScore());
        assertEquals(Score.Love,playerB.getScore());
    }

    // test to score the point-2nd way
    @Test
    public void testWhenBallHad2BounceBeforeReturnedBackToServer() throws Exception {
        Player playerA=Player.builder().name("X").playerType(PlayerType.Server).score(Score.Fifteen).point(1).build();
        Player playerB=Player.builder().name("Y").playerType(PlayerType.Receiver).score(Score.Love).point(0).build();

        Game<Tennis> game=new Tennis(playerA,playerB);
        Tennis result=game.playTheGame();
        assertEquals(Score.Fifteen,playerA.getScore());
        assertEquals(Score.Love,playerB.getScore());
    }

    // test for deuce condition
    @Test
    public void testWhenBothPlayersScoredThreePoints_deuce_condition() throws Exception {
        Player playerA=Player.builder().name("X").playerType(PlayerType.Server).score(Score.Fourty).point(3).build();
        Player playerB=Player.builder().name("Y").playerType(PlayerType.Receiver).score(Score.Fourty).point(3).build();

        Game<Tennis> game=new Tennis(playerA,playerB);
        Tennis  gameResult=game.playTheGame();
        assertEquals(Boolean.TRUE,gameResult.getPlayerA().isDeuce());
        assertEquals(Boolean.TRUE,gameResult.getPlayerB().isDeuce());
    }
}
