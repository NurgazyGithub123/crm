import java.util.Scanner;

public class URI1060 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int par = 0;
        int impar = 0;
        int positivo = 0;
        int negativo = 0;
        int counter = 0;

        while (++counter <= 5) {
            int number = scanner.nextInt();
            boolean imparPar = number % 2 == 0;
            boolean positivoNegativo = number > 0;

            int i = imparPar ? par++ : impar++;
            int j = positivoNegativo ? positivo++ : negativo++;
//            if(number % 2 == 0){
//                par++;
//            }else if (number % 2 != 0){
//                impar++;
//            }if (number > 0){
//                positivo ++;
//            }else
//                negativo++;
        }
        System.out.printf("%d valor(es) par(es)%n", par);
        System.out.printf("%d valor(es) impar(es)%n", impar);
        System.out.printf("%d valor(es) positivo(s)%n",positivo);
        System.out.printf("%d valor(es) negativo(s)%n",negativo);
    }
}
