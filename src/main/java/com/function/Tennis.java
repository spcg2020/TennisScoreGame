package com.function;

import com.entity.Player;
import com.sports.Game;


public class Tennis  implements Game{
    private Player playerA;
    private Player playerB;

    public Tennis(Player playerA, Player playerB) {
        this.playerA=playerA;
        this.playerB=playerB;
    }


    // in case of fault, scores would be same for both
    // if anyone won he game, his scores and points will be increased , then need to check if
    public void getScore() {
        // A and B   scores, points
    }
}
