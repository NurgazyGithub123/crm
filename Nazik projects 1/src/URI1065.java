import java.util.Scanner;

public class URI1065 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int counter = 0;
        int a = 0;
        while (counter < 5){
            if(scan.nextInt() % 2 == 0){
                a ++;
            }
            counter++;
        }

        System.out.println(a + " valores pares");
    }
}
