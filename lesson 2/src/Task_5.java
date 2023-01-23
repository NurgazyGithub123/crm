import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task_5 {
    public static void min_max(int[] arrSorting){
        Random rnd = new Random();
        for (int i = 0; i < arrSorting.length; i++) {
            arrSorting[i] = rnd.nextInt(100);
        }

        Arrays.sort(arrSorting);
        System.out.println(Arrays.toString(arrSorting));
    }
}
