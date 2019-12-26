package com.function;

import com.entity.Player;
import com.sports.Game;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TennisGameTest {

    @Test
    public void testWhenGameIsNotStartedYet() throws Exception {
        // assert for both players against love score
        Player playerA=Player.builder().name("X").playerType(PlayerType.Server).score(Score.Love).build();
        Player playerB=Player.builder().name("Y").playerType(PlayerType.Receiver).score(Score.Love).build();
        Game<Tennis> game=new Tennis(playerA,playerB);
        Tennis result=game.playTheGame();
        assertEquals(0,result.getPlayerA().getPoint());
        assertEquals(0,result.getPlayerB().getPoint());
    }

    // test for not null
    @Test
    public void testForNotNullWhenPlayTheGame() throws Exception {
        Player playerA=Player.builder().name("X").playerType(PlayerType.Server).point(0).build();
        Player playerB=Player.builder().name("Y").playerType(PlayerType.Receiver).point(0).build();
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
        assertEquals(Score.Fifteen,result.getPlayerA().getScore());
        assertEquals(Score.Love, result.getPlayerB().getScore());
        assertTrue(result.getPlayerA().getIsLeadPlayer());

    }

    // test to score the point-2nd way
    @Test
    public void testWhenBallHad2BounceBeforeReturnedBackToServer() throws Exception {
        Player playerA=Player.builder().name("X").playerType(PlayerType.Server).score(Score.Fifteen).point(1).build();
        Player playerB=Player.builder().name("Y").playerType(PlayerType.Receiver).score(Score.Love).point(0).build();

        Game<Tennis> game=new Tennis(playerA,playerB);
        Tennis result=game.playTheGame();
        assertEquals(Score.Fifteen,result.getPlayerA().getScore());
        assertEquals(Score.Love,result.getPlayerB().getScore());
        assertTrue(result.getPlayerA().getIsLeadPlayer());
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

    // test for advantage condition
    @Test
    public void testWhenDeuceAndPlayerXWonTheBallIn1stHitAndGotAdvantage() throws Exception {
        Player playerA=Player.builder().name("X").playerType(PlayerType.Server).score(Score.Fourty).point(3).build();
        Player playerB=Player.builder().name("Y").playerType(PlayerType.Receiver).score(Score.Fourty).point(3).build();
        playerA.winTheBall();

        Game<Tennis> game=new Tennis(playerA,playerB);
        Tennis  gameResult=game.playTheGame();
        assertEquals(Boolean.TRUE,gameResult.getPlayerA().getAdvantage());
        assertNotEquals(Boolean.TRUE, gameResult.getPlayerA().isDeuce());
        assertNotEquals(Boolean.TRUE, gameResult.getPlayerB().isDeuce());
    }

    // test for deuce condition arise again after taking advantage player the  lost game
    @Test
    public void testWhenDeuceAndPlayerXWonTheBallIn1stHitGotAdvantageButLostTheBallIn2ndHit() throws Exception {
        Player playerA=Player.builder().name("X").playerType(PlayerType.Server).score(Score.Fourty).point(3).build();
        Player playerB=Player.builder().name("Y").playerType(PlayerType.Receiver).score(Score.Fourty).point(3).build();
        playerA.winTheBall();
        Game<Tennis> firstGame=new Tennis(playerA,playerB);
        Tennis  firstGameResult=firstGame.playTheGame();
        assertEquals(Boolean.TRUE,firstGameResult.getPlayerA().getAdvantage());

        // PlayerA lost the game after getting Advantage and therefor both players are in deduce
        playerB.winTheBall();
        Game<Tennis> SecondGame=new Tennis(playerA,playerB);
        Tennis  secondGameResult=SecondGame.playTheGame();
        assertEquals(Boolean.TRUE,secondGameResult.getPlayerA().isDeuce());
        assertEquals(Boolean.TRUE,secondGameResult.getPlayerB().isDeuce());
    }

    @Test
    public void testWhenDeuceAndPlayerXHavingAdvantageWonTheBall_X_Won_The_Game() throws Exception {
        Player playerA=Player.builder().name("X").playerType(PlayerType.Server).score(Score.Fourty).point(3).build();
        Player playerB=Player.builder().name("Y").playerType(PlayerType.Receiver).score(Score.Fourty).point(3).build();
        playerA.winTheBall();
        Game<Tennis> firstGame=new Tennis(playerA,playerB);
        Tennis  firstGameResult=firstGame.playTheGame();
        assertEquals(Boolean.TRUE,firstGameResult.getPlayerA().getAdvantage());

        // PlayerA won the ball after getting Advantage and finally won the match
        playerA.winTheBall();
        Game<Tennis> SecondGame=new Tennis(playerA,playerB);
        Tennis  secondGameResult=SecondGame.playTheGame();
        assertNotEquals(Boolean.TRUE, secondGameResult.getPlayerA().isDeuce());
        assertNotEquals(Boolean.TRUE, secondGameResult.getPlayerB().isDeuce());
        assertEquals(Boolean.TRUE, secondGameResult.getPlayerA().getHasWonTheGame());
    }


}