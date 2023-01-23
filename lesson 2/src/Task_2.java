import java.lang.reflect.Array;
import java.util.Arrays;

public class Task_2 {
    public static void filling(){
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;
        }
        System.out.println(Arrays.toString(arr));
    }
}
