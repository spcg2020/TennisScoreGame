package com.sports;


public interface Game<T extends  Game> {

    T playTheGame();
}
