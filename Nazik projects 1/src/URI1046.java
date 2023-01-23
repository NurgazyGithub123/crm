import java.util.Scanner;

public class URI1046 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int startGame = scan.nextInt();
        int endGame = scan.nextInt();

        int gameTime;
        if (startGame < endGame) {
            gameTime = endGame - startGame;
        } else if( startGame == endGame){
            gameTime = 24;
        }else {
            gameTime = (24 - startGame) + endGame;
        }
            System.out.printf("O JOGO DUROU %d HORA(S)", gameTime);
    }
}
