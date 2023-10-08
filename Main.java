import java.util.Random;
import java.util.Scanner;

class Player {
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void addToScore(int value) {
        score += value;
    }
}

class Dice {
    private Random random;

    public Dice() {
        random = new Random();
    }

    public int roll() {
        return random.nextInt(6) + 1;
    }
}

class Game {
    private Player playerA;
    private Player playerB;
    private Dice dice;

    public Game(String playerAName, String playerBName) {
        playerA = new Player(playerAName);
        playerB = new Player(playerBName);
        dice = new Dice();
    }

    public void playRound() {
        int diceA1 = dice.roll();
        int diceA2 = dice.roll();
        int diceB1 = dice.roll();
        int diceB2 = dice.roll();

        int totalA = diceA1 + diceA2;
        int totalB = diceB1 + diceB2;

        System.out.println(playerA.getName() + "의 주사위: " + diceA1 + ", " + diceA2 + " (합계: " + totalA + ")");
        System.out.println(playerB.getName() + "의 주사위: " + diceB1 + ", " + diceB2 + " (합계: " + totalB + ")");

        Player winner = determineWinner(totalA, totalB, diceA1, diceA2, diceB1, diceB2);
        if (winner != null) {
            winner.addToScore(1);
            System.out.println(winner.getName() + "가 이겼습니다!");
        } else {
            System.out.println("비겼습니다.");
        }

        System.out.println(winner.getName() + "가 승자입니다!");
    }

    public Player determineWinner(int totalA, int totalB, int diceA1, int diceA2, int diceB1, int diceB2) {
        if (totalA > totalB || (totalA == totalB && (diceA1 + diceA2) > (diceB1 + diceB2))) {
            return playerA;
        } else if (totalB > totalA || (totalA == totalB && (diceB1 + diceB2) > (diceA1 + diceA2))) {
            return playerB;
        } else {
            return null; // 비겼을 경우
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("주사위 게임을 시작합니다.");
        System.out.print("플레이어 A의 이름을 입력하세요: ");
        String playerAName = scanner.nextLine();
        System.out.print("플레이어 B의 이름을 입력하세요: ");
        String playerBName = scanner.nextLine();

        Game game = new Game(playerAName, playerBName);

        System.out.println("\n게임을 시작합니다.");
        game.playRound();

        scanner.close();
    }
}