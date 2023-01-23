import java.util.Scanner;

public class URI1037 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double a = scan.nextDouble();

        if(a >= 0 && a <= 100.0){
            if(0 <= a && a< 25.00001){
                System.out.println("Intervalo (0,25]");
            } else if (25.00001 <= a && a < 50.00000001) {
                System.out.println("Intervalo (25,50]");
            } else if (50.00000001 <= a && a < 75.00000001) {
                System.out.println("Intervalo (50,75]");
            } else if (75.00000001 <= a && a < 100.00000001) {
                System.out.println("Intervalo (75,100]");
            }
        }else
        System.out.println("Fora de intervalo");
    }
}
