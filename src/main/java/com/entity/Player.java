package com.entity;

import com.function.Score;

public class Player {

    private String name;
    private Score score;
   public Player(String name){
       this.name=name;
       this.score=Score.Love;
   }
    public String  getName(){
        return  name;
    }
    public Score getScore(){
        return score;
    }
}
