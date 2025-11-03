import java.util.Scanner;
import java.util.Random;

public class Rock_Paper_Scissors {
    
    private static Random rand = new Random();
    private static Scanner scan = new Scanner(System.in); 

    public static void main(String[] args) {
        rpsGame();
        System.out.println("Good games!");
    }

    public static void rpsGame() {
        System.out.println("Let's play! What hand would you like to play?");
        System.out.println("Please type the 1: Rock, 2: Paper, 3: Scissors");

        int handPlayed = 0;

        while (handPlayed == 0) {

            try {

                handPlayed = Integer.parseInt(scan.nextLine());

                if (handPlayed > 3 || handPlayed < 1) {
                    throw new Exception();
                }
            } catch (Exception e) {
                handPlayed = 0;
                System.out.println("Please enter a number representing the hand you want to play: ");
            }

        }

        int aiPlayed = rand.nextInt(3) + 1;
        
        String userHand;
        String aiHand;

        switch (handPlayed) {
            
            case 3:
                userHand = "Scissors";
                break;
            
            case 2:
                userHand = "Paper";
                break;

            default:
                userHand = "Rock";
        }

        switch (aiPlayed) {
            
            case 3:
                aiHand = "Scissors";
                break;
            
            case 2:
                aiHand = "Paper";
                break;

            default:
                aiHand = "Rock";
        }

        System.out.println("I played " + aiHand + " and you played " + userHand);

        int diff = (handPlayed - aiPlayed + 3) % 3;

        if (diff == 0) {
            System.out.println("It's a draw!");
        } 
        else if (diff == 1) {
            System.out.println("You win!");
        } 
        else {
            System.out.println("I win!");
        }

        System.out.println("Would you like to play again? (Please type y/n for yes/no)");

        if (scan.nextLine().equals("y")) {
            rpsGame();
        }

    }

}
