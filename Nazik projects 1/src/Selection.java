import java.util.Scanner;

public class Selection {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int d = scan.nextInt();

        if((b > c && d > a) && (c + d > a + b)&&(c > 0 && d > 0) && (a % 2 == 0)) {
            System.out.printf("%s\n", "Valores aceitos");
        }else
        System.out.printf("%s\n", "Valores nao aceitos");
    }
}
