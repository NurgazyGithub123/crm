import java.util.Arrays;

public class Task_1 {

    public static void replacement(){
        int[] number ={1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < number.length; i++) {
            System.out.print("Array index " + i + " = " + number[i] + " replaced");
            if(number[i] == 0){
                number[i] = 1;
            }else {
                number[i] = 0;
            }
            System.out.println(" -> " + number[i]);
        }
    }
}
