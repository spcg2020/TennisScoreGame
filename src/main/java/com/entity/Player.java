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
    private boolean deuce;
    private boolean advantage;
    private boolean hasWonTheGame;

    public PlayerType getPlayerType(){
        return playerType;
    }

    public void winTheBall(){
        this.point=this.point+1;
    }


    public boolean isDeuce(){
        return deuce;
    }
    public void setIsDeuce(Boolean deuce){
        this.deuce=deuce;
    }

    public void setAdvantage(boolean advantage) {
        this.advantage=advantage;
    }
    public boolean getAdvantage(){
        return this.advantage;
    }

    public Boolean getHasWonTheGame() {
        return hasWonTheGame;
    }

    public void setHasWonTheGame(boolean hasWonTheGame) {
        this. hasWonTheGame=hasWonTheGame;
    }
}
