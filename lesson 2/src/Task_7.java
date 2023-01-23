import java.util.Arrays;
import java.util.Random;
public class Task_7 {
//    public static void shiftN(int[] arr4, int n) {
////        Random rnd = new Random();
////        for (int i = 0; i < arr4.length; i++) {
////            arr4[i] = rnd.nextInt(50);
////        }
//        System.out.print("Массив до: ");
//        System.out.println(Arrays.toString(arr4));
//
//        n %= arr4.length;
//        int count = 1;
//
//        if (0 > n){
//            n *= -1;
//            while ( n != 0) {
//                for (int i = n - 1; i < arr4.length - count; i++) {
//                    int t = arr4[i + 1];
//                    arr4[i + 1] = arr4[i];
//                    arr4[i] = t;
//                }
//                --n;
//                ++count;
//            }
//        }else
//            while ( n != 0){
//                for (int i = arr4.length - n; i >= count; i--) {
//                    int t = arr4[i];
//                    arr4[i] = arr4[i - 1];
//                    arr4[i - 1] = t;
//                }
//                --n;
//                ++count;
//            }
//
//        System.out.println("Массив после: " + Arrays.toString(arr4));
//    }




    public static void shiftN() {
        shiftArray(new int[]{1, 2, 3, 4, 5}, 0);
        shiftArray(new int[]{1, 2, 3, 4, 5}, 1);
        shiftArray(new int[]{1, 2, 3, 4, 5}, 2);
        shiftArray(new int[]{1, 2, 3, 4, 5}, 5);
        shiftArray(new int[]{1, 2, 3, 4, 5}, 2000000000);
        shiftArray(new int[]{1, 2, 3, 4, 5}, -1);
        shiftArray(new int[]{1, 2, 3, 4, 5}, -2);
        shiftArray(new int[]{1, 2, 3, 4, 5}, -5);
        shiftArray(new int[]{1, 2, 3, 4, 5}, -6);
        shiftArray(new int[]{0, 1, 2, 3, 4, 5, 6, 7}, 3);
    }


    private static void shiftArray(int[] array, int n) {
        int shiftNumber = n % array.length;
        if (shiftNumber < 0) {
            shiftLeft(array, shiftNumber);
        } else {
            shiftRight(array, shiftNumber);
        }
        System.out.println(Arrays.toString(array) + "; shiftNumber = " + n);
    }

    private static void shiftRight(int[] array, int n) {
        for (int i = 0; i < n; i++) {
            int lastValue = array[array.length - 1];
            for (int j = array.length - 1; j > 0; j--) {
                array[j] = array[j - 1];
            }
            array[0] = lastValue;
        }
    }

    private static void shiftLeft(int[] array, int n) {
        for (int i = 0; i < Math.abs(n); i++) {
            int firstValue = array[0];
            for (int j = 0; j < array.length - 1; j++) {
                array[j] = array[j + 1];
            }
            array[array.length - 1] = firstValue;
        }
    }
}
