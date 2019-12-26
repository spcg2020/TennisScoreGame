package com.function;


public enum Score {
    Love(0),
    Fifteen(15),
    Thirty(30),
    Fourty(40);

    private int score;
     Score(int score){
        this.score=score;
    }
}