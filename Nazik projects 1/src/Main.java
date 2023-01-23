import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double money = scan.nextDouble();

        int notas = (int) money;
        int moedas = (int)((money - notas) * 100);

        int notas100 = notas / 100;
        int remainder100 = notas % 100;

        int notas50 = remainder100 / 50;
        int remainder50 = remainder100 % 50;

        int notas20 = remainder50 / 20;
        int remainder20 = remainder50 % 20;

        int notas10 = remainder20 / 10;
        int remainder10 = remainder20 % 10;

        int notas5 = remainder10 / 5;
        int remainder5 = remainder10 % 5;

        int notas2 = remainder5 / 2;
        int remainder2 = remainder5 % 2;

        System.out.println("NOTAS: ");
        System.out.printf("%d nota(s) de R$ 100.00\n", notas100);
        System.out.printf("%d nota(s) de R$ 50.00\n", notas50);
        System.out.printf("%d nota(s) de R$ 20.00\n", notas20);
        System.out.printf("%d nota(s) de R$ 10.00\n", notas10);
        System.out.printf("%d nota(s) de R$ 5.00\n", notas5);
        System.out.printf("%d nota(s) de R$ 2.00\n", notas2);

        moedas += remainder2 * 100;

        int modeas100 = moedas / 100;
        int remainderM100 = moedas % 100;

        int modeas50 = remainderM100 / 50;
        int remainderM50 = remainderM100 % 50;

        int modeas25 = remainderM50 / 25;
        int remainderM25 = remainderM50 % 25;

        int modeas10 = remainderM25 / 10;
        int remainderM10 = remainderM25 % 10;

        int modeas5 = remainderM10 / 5;
        int remainderM5 = remainderM10 % 5;

        System.out.println("MOEDAS: ");
        System.out.printf("%d moeda(s) de R$ 1.00\n", modeas100);
        System.out.printf("%d moeda(s) de R$ 0.50\n", modeas50);
        System.out.printf("%d moeda(s) de R$ 0.25\n", modeas25);
        System.out.printf("%d moeda(s) de R$ 0.10\n", modeas10);
        System.out.printf("%d moeda(s) de R$ 0.05\n", modeas5);
        System.out.printf("%d moeda(s) de R$ 0.01\n", remainderM5);
    }
}
