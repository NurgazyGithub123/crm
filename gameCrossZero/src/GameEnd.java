import java.util.Scanner;

public class GameEnd {
    static Scanner in = new Scanner(System.in);
    public static boolean chekWin(char[][] map, char simbol){
        int count = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(map[i][j] == simbol){
                    count++;
                }
                if(count == map.length){
                    System.out.println("Поздравляю, вы победили!");
                    return true;
                }
            }
        }return false;
    }

    public static boolean isContinueGame(){
        boolean b = false;
        System.out.println("Хотите продолжить? y\\n");
        switch (in.next()){
            case  "y" :
            case "yes":
            case  "да":
            case  "д" :
                b = true;
                break;
            default :
                b = false;
                break;
        }
        return b;
    }
}
