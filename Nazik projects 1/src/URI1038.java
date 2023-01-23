import java.util.Scanner;

public class URI1038 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int x = scan.nextInt();
        int y = scan.nextInt();

        switch (x){
            case 1:
                System.out.printf("Total: R$ %.2f\n", y * 4.00);
                break;
            case 2:
                System.out.printf("Total: R$ %.2f\n", y * 4.50);
                break;
            case 3:
                System.out.printf("Total: R$ %.2f\n", y * 5.00);
                break;
            case 4:
                System.out.printf("Total: R$ %.2f\n", y * 2.00);
                break;
            case 5:
                System.out.printf("Total: R$ %.2f\n", y * 1.50);
                break;
        }

//        if(x == 1){
//            System.out.printf("Total: R$ %.2f\n", y * 4.00);
//        }else if (x == 2) {
//            System.out.printf("Total: R$ %.2f\n", y * 4.50);
//        }else if (x == 3) {
//            System.out.printf("Total: R$ %.2f\n", y * 5.00);
//        } else if (x == 4) {
//            System.out.printf("Total: R$ %.2f\n", y * 2.00);
//        } else if (x == 5) {
//            System.out.printf("Total: R$ %.2f\n", y * 1.50);
//        }
    }
}
