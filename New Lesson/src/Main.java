import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Random rnd = new Random();

        int[] numbers = new int[100];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rnd.nextInt(100);
        }

        System.out.println(Arrays.toString(numbers));
        int maxNumber = 0;
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
            if(numbers[i] > maxNumber){
                maxNumber = numbers[i];
            }
        }
        System.out.println(maxNumber);
        System.out.println(sum/100);
    }
}