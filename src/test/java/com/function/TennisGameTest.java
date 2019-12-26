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
        Player playerA=new Player("X");
        Player playerB=new Player("Y");
        assertEquals(Score.Love,playerA.getScore());
        assertEquals(Score.Love,playerB.getScore());
    }

    // test for not null
    @Test
    public void testForNotNullWhenPlayTheGame() throws Exception {
        Player playerA=new Player("X");
        Player playerB=new Player("Y");
        Game game=new Tennis(playerA,playerB);
        String score=game.getScore();
        assertNotNull(score);
    }
    // test to score the point-1st way
    @Test
    public void testWhenOpponentCouldNotHitBackTheBall() throws Exception {
        Player playerA=new Player("X");
        Player playerB=new Player("Y");
        Game game=new Tennis(playerA,playerB);
        String score=game.getScore();
        //assertThat(score);
    }
}
