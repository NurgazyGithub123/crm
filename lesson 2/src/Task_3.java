import java.util.Arrays;

public class Task_3 {
    public static void numberLess(){
        int[] arr ={1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6){
                System.out.print("Array[" + i + "] = " + arr[i] + " less than 6 ");
                arr[i] *= 2;
                System.out.println("multiply * 2 = " + arr[i]);
            }else System.out.println("Array[" + i + "] " + arr[i] + " more than 6");
        }
        System.out.println("Ultimate Array[] = " + Arrays.toString(arr));
    }
}
