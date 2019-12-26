package com.entity;

import com.function.PlayerType;
import com.function.Score;
import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class Player {
    private String name;
    private PlayerType playerType;
    private Score score;
    private int point;
    private boolean leadPlayer;
    private boolean hasWonTheMatch;
    private boolean deuce;

    public boolean isLeadPlayer() {
        return leadPlayer;
    }
    public void winTheBall(){
        this.point=this.point+1;
    }

    public void hasWonTheMatch(Boolean hasWonTheMatch) {
         hasWonTheMatch = hasWonTheMatch;
    }
    public boolean isDeuce(){
        return deuce;
    }
    public void setIsDeuce(Boolean deuce){
        this.deuce=deuce;
    }
}
