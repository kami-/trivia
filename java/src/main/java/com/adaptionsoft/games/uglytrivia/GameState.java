package com.adaptionsoft.games.uglytrivia;

import java.util.*;
import java.util.stream.Collectors;

public class GameState {
    private final Map<String, Integer> playerPurses = new HashMap<>();

    public GameState(List<String> players) {
        players.forEach(player -> {
            playerPurses.put(player, 0);
        });
    }

    public void giveGoldCoinToPlayer(String name) {
        playerPurses.compute(name, (key, currentCoins) -> Optional.of(currentCoins)
                .map(c -> c + 1)
                .get());
    }

    public Integer getPlayerCoins(String name) {
        return playerPurses.get(name);
    }

    public List<String> getLeaders() {
        Integer maxCoins = Collections.max(playerPurses.values());
        return playerPurses.keySet().stream()
                .filter(player -> playerPurses.get(player).equals(maxCoins))
                .collect(Collectors.toList());
    }
}
