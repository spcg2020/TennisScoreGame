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
        if (playerA.getPlayerType().equals(PlayerType.Server) &&  playerA.getPoint()>=3 && playerA.getScore().equals(Score.Fourty)){

            if(playerA.getPoint()-playerB.getPoint()>=2){
                playerA.winTheBall();
                playerA.setHasWonTheGame(true);
            }
           else if (playerA.getPoint()==playerB.getPoint()){
                    playerA.setIsDeuce(Boolean.TRUE);
                    playerB.setIsDeuce(Boolean.TRUE);
            }else {
                // playerA will have advantage
                playerA.setAdvantage(Boolean.TRUE);
            }
        }
        return this;
    }
    public Player getPlayerA(){
        return playerA;
    }
    public Player getPlayerB(){
        return playerB;
    }
}
