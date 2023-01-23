import java.util.Scanner;

public class URI1044 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        int b = scan.nextInt();

        if(a < b){
            int t = a;
            a = b;
            b = t;
        }
        System.out.println(a % b == 0 ? "Sao Multiplos" : "Nao sao Multiplos");
    }
}
