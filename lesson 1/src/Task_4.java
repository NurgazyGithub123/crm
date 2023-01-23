import java.util.Scanner;

public class Task_4 {

    Scanner scan = new Scanner(System.in);
    public static boolean limit(int a, int b){
        if (10 <= a + b && a + b <= 20){
            System.out.println("10 <=" + (a + b) + "<= 20");
            return true;
        }
        System.out.println("10 <=" + (a + b) + "<= 20");
        return false;
    }
}
