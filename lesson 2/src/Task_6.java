import java.util.Arrays;
import java.util.Random;

public class Task_6 {
    public static boolean booleanArray(int[] arr3) {
        Random rnd = new Random();

        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = rnd.nextInt(5);
        }
        System.out.println("Random значение --> " + Arrays.toString(arr3));

        int count = 1;
        boolean isTrue = true;

        while (isTrue){
            int sum = 0;
            int sum1 = 0;
            for (int i = 0; i < arr3.length - count; i++) {
                sum += arr3[i];
            }
            count++;
            for (int i = arr3.length - 1; i > arr3.length - count; i--) {
                sum1 += arr3[i];
            }
            if (sum == sum1) {
                System.out.println("после  Array[" + (arr3.length - count) + "] индекса сумма левой и правой стороны массива совпадают");
                return true;
            }else if(count == arr3.length){
                isTrue = false;
            }
        }
        System.out.println("Нет совподений суммы левой и правой стороны массива" + Arrays.toString(arr3));
        return false;
    }
}

