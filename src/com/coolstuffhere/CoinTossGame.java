package com.coolstuffhere;

import com.coolstuffhere.model.Player;
import com.coolstuffhere.utils.CoinTossUtils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CoinTossGame {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("╔═════════════════════════╗");
            System.out.println("║      Coin Toss Game     ║");
            System.out.println("╚═════════════════════════╝");

            System.out.print("Enter Player 1's name: ");
            String player1Name = scanner.nextLine();
            Player player1 = new Player(player1Name);

            System.out.print("Enter Player 2's name: ");
            String player2Name = scanner.nextLine();
            Player player2 = new Player(player2Name);

            System.out.print("Enter the number of rounds: ");
            int numRounds = scanner.nextInt();

            CoinTossUtils.playGame(player1, player2, numRounds, 0.5);
            
        } catch (InputMismatchException e) {
            System.out.println("Invalid input, please enter an integer for number of rounds.");
        } catch (Exception e) {
            System.out.println("Unexpected error occurred: " + e.getMessage());
        }
    }
}