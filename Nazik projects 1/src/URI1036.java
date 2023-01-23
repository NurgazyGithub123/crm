import java.util.Scanner;

public class URI1036 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double a = scan.nextDouble();
        double b = scan.nextDouble();
        double c = scan.nextDouble();

        if (b != 0) {
            double roots = Math.pow(b, 2) - (4 * a * c);

            if (roots >= 0 && a != 0 ) {
                double x = Math.sqrt(roots);
                double r1 = (-b + x) / (2 * a);
                double r2 = (-b - x) / (2 * a);
                System.out.printf("R1 = %.5f\n", r1);
                System.out.printf("R2 = %.5f\n", r2);
            } else
                System.out.println("Impossivel calcular");
        }
    }
}
