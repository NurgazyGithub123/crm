import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random rnd = new Random();
    private static final int SIZE = sizeIsNumber();//scanner.nextInt();
    private static final char[][] MAP = new char[SIZE][SIZE];
    private static final char DOT_EMPTY = '•';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';

    public static void turnGame(){
        boolean isTrue = true;
        while (isTrue){
            initMap();
            printMap();

            playGame();
            isTrue = GameEnd.isContinueGame();
        }
        System.out.println("Пока, ты загляни если что!!!");
    }

    private static void playGame() {
        while (true){
            fillUser();
            printMap();
            if(GameEnd.chekWin(MAP, DOT_X)){
                break;
            }

            aiTurn();
            printMap();
            if(GameEnd.chekWin(MAP, DOT_O)){
                break;
            }
        }
    }

    private static void initMap(){ // инициализация массива
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DOT_EMPTY;
            }
        }
    }
    private static void printMap(){ // вывод на консоль
        printHeaderMap();
        printBodyMap();
    }
    private static void printMapNumber(int i) { // указываем колонки
        System.out.print((i + 1) + " ");
    }
    private static void printHeaderMap() { // вывод шапки
        System.out.print("# ");
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
        }
        System.out.println();
    }
    private static void printBodyMap() { // вывод 1 колонки и значения массива
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static void fillUser(){ // ход человека
        System.out.println("Ход человека: ");

        int row = getRow() - 1;
        int col = getRow() - 1;
        if(isCellFree(row,col)){
            MAP[row][col] = DOT_X;
        }else {
            System.out.println("Не пустая ячейка, введите повторно!");
        }
    }



    private static void aiTurn(){
        System.out.println("Ход компьютера: ");
        boolean isTrue = true;
        while (isTrue) {
            int row = rnd.nextInt(SIZE);
            int col = rnd.nextInt(SIZE);
            if (isCellFree(row, col)) {
                MAP[row][col] = DOT_O;
                isTrue = false;
            }
        }
    }

    private static int getRow() { // вводим координаты
        int n = 0;
        do {
            System.out.print("Введите коордитаты : ");
            if(scanner.hasNextInt()){
                n =  scanner.nextInt();
                if(isNumberValid(n)){
                    return n;
                }System.out.println("Bведите число от 0 до " + SIZE);
            }else {
                System.out.println("Вводите целые числа! : ");
                scanner.next();
            }
        }while (true);
    }
    private static boolean isNumberValid(int n){ //проверка на диапозон
        return n > 0 && n <= SIZE;
    }
    private static boolean isCellFree(int row, int col){ // проверка на пустату
        return MAP[row][col] == DOT_EMPTY;
    }
    private static int sizeIsNumber(){
        int n = 0;
        while (true){
            if(scanner.hasNextInt()){
                n = scanner.nextInt();
                break;
            }
            System.out.println("Вводите целые числа! : ");
            scanner.next();
        }
        return n;
    }
}
