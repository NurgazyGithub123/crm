import java.util.Scanner;

public class URI1168 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        char x = scan.next().charAt(0);
        System.out.println(x);
        int test = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < test; i++) {
            String number = scan.nextLine();
            int sum = 0;

            for (int j = 0; j < number.length(); j++){
                switch (number.charAt(j)){
                    case '1' :
                        sum += 2;
                        break;
                    case '2':
                    case '3':
                    case '5':
                        sum += 5;
                        break;
                    case '4':
                        sum += 4;
                        break;
                    case '6':
                    case '9':
                    case '0':
                        sum += 6;
                        break;
                    case '7':
                        sum += 3;
                        break;
                    case '8':
                        sum += 7;
                        break;
                }
            }
            System.out.println(sum + " leds");
        }
    }
}
