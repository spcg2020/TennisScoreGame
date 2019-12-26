package com.function;

import com.entity.Player;
import com.sports.Game;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TennisGameTest {

    @Test
    public void testWhenGameIsNotStartedYet() throws Exception {
        // assert for both players against love score
        Player playerA=new Player("X");
        Player playerB=new Player("Y");
        assertEquals(Score.Love,playerA.getScore());
        assertEquals(Score.Love,playerB.getScore());
    }

    // test to score the point-1st way
    @Test
    public void testWhenOpponentCouldNotHitBackTheBall() throws Exception {
        Player playerA=new Player("X");
        Player playerB=new Player("Y");
        Game game=new Tennis(playerA,playerB);
        game.getScore();
    }
}
