package com.client;


import com.entity.Player;
import com.function.PlayerType;
import com.function.Score;
import com.function.Tennis;
import com.sports.Game;
import lombok.Builder;

import java.util.Arrays;
import java.util.List;
@Builder
public class GamePlayer {
    public static void main(String[] args) {
       List<Player> players= createPlayers();
        Game<Tennis> tennisGame=new Tennis(players.get(0),players.get(1));
        Tennis  gameResult=tennisGame.playTheGame();
        if (gameResult.getPlayerA().getIsLeadPlayer()==true)
            message("Steffi");
        else
            message("Monica");

    }

    private static void message(String player) {
        System.out.println(player+" is Leading the Match !!!");
    }

    private static List<Player> createPlayers() {
        Player steffi=Player.builder().name("Steffi graf").playerType(PlayerType.Server).point(2).score(Score.Thirty).build();
        Player monica=Player.builder().name("Monica Seles").playerType(PlayerType.Server).point(1).score(Score.Fifteen).build();
        return Arrays.asList(steffi,monica);
    }
}
