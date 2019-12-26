package com.function;


public enum Score {
    Love(0),
    Fifteen(15),
    Thirty(30),
    Fourty(40);

    private int value;
     Score(int value){
        this.value=value;
    }
    public int getValue(){
        return value;
    }
}