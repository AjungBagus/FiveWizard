package org.games;
import java.util.Scanner;

public class Game {
    private Wizard player1;
    private Wizard player2;

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        // Pemilihan wizard untuk player 1
        System.out.println("Player 1, pilih wizard (Red, Blue, Green, Black, White): ");
        String wizardChoice1 = scanner.nextLine();
        player1 = createWizard(wizardChoice1);

        // Pemilihan wizard untuk player 2
        System.out.println("Player 2, pilih wizard (Red, Blue, Green, Black, White): ");
        String wizardChoice2 = scanner.nextLine();
        player2 = createWizard(wizardChoice2);

        // Menampilkan statistik
        displayStats(player1, player2);

        // Giliran menyerang
        while (player1.getHP() > 0 && player2.getHP() > 0) {
            playerTurn(player1, player2, scanner);
            if (player2.getHP() <= 0) {
                System.out.println("Player 2 kalah!");
                break;
            }

            playerTurn(player2, player1, scanner);
            if (player1.getHP() <= 0) {
                System.out.println("Player 1 kalah!");
                break;
            }
        }

        scanner.close();
    }

    private Wizard createWizard(String choice) {
        switch (choice.toLowerCase()) {
            case "red":
                return new RedWizard();
            case "blue":
                return new BlueWizard();
            case "green":
                return new GreenWizard();
            case "black":
                return new BlackWizard();
            case "white":
                return new WhiteWizard();
            default:
                System.out.println("Pilihan tidak valid, menggunakan WhiteWizard sebagai default.");
                return new WhiteWizard();
        }
    }

    private void displayStats(Wizard player1, Wizard player2) {
        System.out.println("Statistik Player 1: " + player1.getName() + " - HP: " + player1.getHP());
        System.out.println("Statistik Player 2: " + player2.getName() + " - HP: " + player2.getHP());
    }

    private void playerTurn(Wizard attacker, Wizard defender, Scanner scanner) {
        System.out.println(attacker.getName() + ", pilih skill untuk menyerang (1, 2, 3): ");
        int skillChoice = scanner.nextInt();
        
        switch (skillChoice) {
            case 1:
                attacker.skillAttack1(defender);
                break;
            case 2:
                attacker.skillAttack2(defender);
                break;
            case 3:
                attacker.skillAttack3(defender);
                break;
            default:
                System.out.println("Pilihan skill tidak valid, serangan dibatalkan.");
                break;
        }
        
        System.out.println(defender.getName() + " sekarang memiliki HP: " + defender.getHP());
    }
}