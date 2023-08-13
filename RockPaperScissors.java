import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {

        int winCount = 0;
        int loseCount = 0;
        int tieCount = 0;
        System.out.println("Let's play Rock Paper Scissors.");
        System.out.println("When I say 'shoot', Choose: rock, paper, or scissors.\n");
        playRockPaperScissors(winCount, loseCount, tieCount);

    }

    // Task 1: See if the user wants to play.
    public static void playRockPaperScissors(int winCount, int loseCount, int tieCount) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Are you ready? Write 'yes' if you are.");
        String answer = scan.nextLine();

        /*
         * Task 2: Set up the game
         */
        if (answer.equals("yes")) {
            System.out.println("Great!\n");
            System.out.println("1. rock - 2. paper - 3. scissors, shoot!");
            int yourChoice;
            try {
                yourChoice = scan.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input: enter a number between 1 and 3.");
                scan.close();
                return;
            }
            int compChoice = computerChoice();
            int result = getResult(yourChoice, compChoice);
            System.out.println("\nYou chose:     " + yourChoice);
            System.out.println("Computer chose: " + compChoice);
            if (result == -1) {
                System.out.println("\nYou lose");
                loseCount++;
                System.out.println("\nWins: " + winCount);
                System.out.println("Losses: " + loseCount);
                System.out.println("Ties " + tieCount);
            } else if (result == 0) {
                System.out.println("You're tied");
                tieCount++;
                System.out.println("Wins: " + winCount);
                System.out.println("Losses: " + loseCount);
                System.out.println("Ties " + tieCount);
            } else {
                System.out.println("You win!");
                winCount++;
                System.out.println("Wins: " + winCount);
                System.out.println("Losses: " + loseCount);
                System.out.println("Ties " + tieCount);
            }
        } else {
            System.out.println("\nDarn, some other time");
        }

        System.out.println("\nDo you want to play another game?");
        scan.nextLine();
        String anotherGame = scan.nextLine();
        if (anotherGame.equals("yes")) {
            playRockPaperScissors(winCount, loseCount, tieCount);
        } else {
            System.out.println("Ok, goodbye.");
            System.exit(0);
        }
        scan.close();

    }
    // Task 3 – Write a function where the computer picks a random choice.

    public static int computerChoice() {
        int randomNumber = (int) (Math.random() * 3); // number between 0 and 0,99
        return randomNumber + 1;

    }

    public static int getResult(int yourChoice, int computerChoice) {
        if (yourChoice == computerChoice) {
            return 0;
        } else if (computerChoice > yourChoice && computerChoice - yourChoice != 2) {
            return -1;
        } else if (yourChoice > computerChoice && yourChoice - computerChoice == 2) {
            return -1;
        } else {
            return 1;
        }

    }

}
