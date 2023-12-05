package com.coolstuffhere.model;

import com.coolstuffhere.utils.CoinTossUtils;

public class Player {
    private final String name;
    private String guess;
    private int wins;

    public Player(String name) {
        this.name = name;
        this.guess = "";
        this.wins = 0;
    }

    public void setGuess(String guess) {
        this.guess = CoinTossUtils.validateGuess(guess);
    }

    public String getGuess() {
        return this.guess;
    }

    public String getName() {
        return this.name;
    }

    public boolean isCorrectGuess(Coin coin) {
        return this.guess.equalsIgnoreCase(coin.getSide());
    }

    public String getSide(Coin coin) {
        return coin.getSide();
    }

    public void incrementWins() {
        this.wins++;
    }

    public int getWins() {
        return this.wins;
    }
}
