package com.coolstuffhere.model;

public class Coin {
    private String side;
    private final double probabilityOfHeads;

    public Coin(double probabilityOfHeads) {
        this.probabilityOfHeads = probabilityOfHeads;
        this.side = "";
    }

    public void flip() {
        double randomNumber = Math.random();

        if (randomNumber < this.probabilityOfHeads) {
            this.side = "Heads";
        } else {
            this.side = "Tails";
        }
    }

    public String getSide() {
        return this.side;
    }

}
