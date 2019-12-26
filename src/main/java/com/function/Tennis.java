package com.function;

import com.entity.Player;
import com.sports.Game;


public class Tennis  implements Game<Tennis>{
    private Player playerA;
    private Player playerB;

    public Tennis(Player playerA, Player playerB) {
        this.playerA=playerA;
        this.playerB=playerB;
    }

    // if anyone won he game, his scores and points will be increased
    public Tennis  playTheGame() {
        if (playerA.getPlayerType().equals(PlayerType.Server)){

            if (playerA.getPoint() >= 3 && playerA.getScore().equals(Score.Fourty)) {

                if (playerA.getPoint() - playerB.getPoint() >= 2) {
                    playerA.setHasWonTheGame(true);
                } else if (playerA.getPoint() == playerB.getPoint()) {
                    playerA.setIsDeuce(Boolean.TRUE);
                    playerB.setIsDeuce(Boolean.TRUE);
                } else {
                    // playerA will have advantage
                    playerA.setAdvantage(Boolean.TRUE);
                }
            }
           else if (playerA.getPoint() > playerB.getPoint()) {

                playerA.setIsLeadPlayer(true);
            }
           else if( playerA.getPoint()==playerB.getPoint()){
                setScoreBasedOnPoint();
            }
          else  if( playerA.getScore()==playerB.getScore()){
                setPointBasedOnScore();
            }

    }

        return this;
    }

    private void setPointBasedOnScore() {
        switch (playerA.getScore().getValue()){
            case 0:
                playerA.setPoint(0);
                playerB.setPoint(0);
                break;
            case 1:
                playerA.setPoint(15);
                playerB.setPoint(15);
                break;
            case 2:
                playerA.setPoint(30);
                playerB.setPoint(30);
                break;
            case 3:
                playerA.setPoint(45);
                playerB.setPoint(45);
                break;
        }
    }

    private void setScoreBasedOnPoint() {
        switch (playerA.getPoint()){
            case 0:
                playerA.setScore(Score.Love);
                playerB.setScore(Score.Love);
                break;
            case 1:
                playerA.setScore(Score.Fifteen);
                playerB.setScore(Score.Fifteen);
                break;
            case 2:
                playerA.setScore(Score.Thirty);
                playerB.setScore(Score.Thirty);
                break;
            case 3:
                playerA.setScore(Score.Fourty);
                playerB.setScore(Score.Fourty);
                break;
        }
    }

    public Player getPlayerA(){
        return playerA;
    }
    public Player getPlayerB(){
        return playerB;
    }
}
