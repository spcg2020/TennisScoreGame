package com.client;


import com.entity.Player;
import lombok.Builder;

import java.util.List;
@Builder
public class GamePlayer {
    public static void main(String[] args) {
        createPlayers();
    }

    private static List<Player> createPlayers() {
        //Player steffi=Player.builder().name("steffi graf").playerType(PlayerType.Server)
        return null;
    }
}
