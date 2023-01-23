import java.util.Scanner;

public class ArraysPractice {


    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();

        System.out.println(Sum(a,b));
    }
    public static int Sum(int a, int b){
        int sum = 0;
        for (int i = a; a < b; a++) {
            sum += a;
        }
        return sum;
    }

}
