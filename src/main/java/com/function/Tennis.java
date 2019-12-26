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

    // if anyone won he game, his scores and points will be increased , then need to check if
    public Tennis  playTheGame() {
        if (playerA.getPoint()>=3 && playerA.getScore().equals(Score.Fourty)){
            if(playerA.getPoint()-playerB.getPoint()>=2){
                playerA.hasWonTheMatch(Boolean.TRUE);
            }
            if (playerA.getPoint()==playerB.getPoint()){
                    playerA.setIsDeuce(Boolean.TRUE);
                    playerB.setIsDeuce(Boolean.TRUE);
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
