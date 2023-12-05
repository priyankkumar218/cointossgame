package com.coolstuffhere.utils;

import com.coolstuffhere.model.Coin;
import com.coolstuffhere.model.Player;

import java.util.Scanner;

public class CoinTossUtils {

    private static final Scanner scanner = new Scanner(System.in);

    public static void playGame(Player player1, Player player2, int numRounds, double probabilityOfHeads) {

        if (numRounds <= 0) {
            System.err.println("Invalid number of rounds. Please enter a positive integer.");
            return;
        }

        for (int i = 0; i < numRounds; i++) {
            getPlayerGuess(player1);
            switchCoinForPlayer2(player1, player2);

            Coin coin = new Coin(probabilityOfHeads);
            coin.flip();
            String coinSide = coin.getSide();

            determineWinner(player1, player2, coin);
            System.out.println("The coin landed on: " + coinSide);

            System.out.println(player1.getName() + "'s Score: " + player1.getWins());
            System.out.println(player2.getName() + "'s Score: " + player2.getWins());
        }
    }

    private static void getPlayerGuess(Player player) {
        String guess = "";
        while (guess.isEmpty()) {
            System.out.print("\n" + player.getName() + ", please choose Heads or Tails: ");
            guess = scanner.nextLine();
            if (guess.isEmpty()) {
                System.out.println("Please enter a valid guess.");
            }
        }
        player.setGuess(guess);
    }

    private static void switchCoinForPlayer2(Player player1, Player player2) {
        if (player1.getGuess().equalsIgnoreCase("Heads")) {
            player2.setGuess("Tails");
        } else if (player1.getGuess().equalsIgnoreCase("Tails")) {
            player2.setGuess("Heads");
        }
    }

    private static void determineWinner(Player player1, Player player2, Coin coin) {
        System.out.println(player1.getName() + "'s guess: " + player1.getGuess());
        System.out.println(player2.getName() + "'s guess: " + player2.getSide(coin));

        if (player1.isCorrectGuess(coin)) {
            player1.incrementWins();
            System.out.println(player1.getName() + " guessed correctly!");
        } else {
            player2.incrementWins();
            System.out.println(player2.getName() + " guessed correctly!");
        }
    }

    public static String validateGuess(String guess) {
        if(!guess.equalsIgnoreCase("heads") && !guess.equalsIgnoreCase("tails")) {
            throw new IllegalArgumentException("Guess must be heads or tails");
        }
        return guess;
    }
}
