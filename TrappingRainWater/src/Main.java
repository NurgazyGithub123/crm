import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}; // 6

        int[] height2 = {4, 2, 0, 3, 2, 5}; // 9

        System.out.println(soulution(height));
        System.out.println(soulution(height2));

        System.out.println(soulution(height));
        System.out.println(soulution(height2));

    }
    public static int soulution(int[] height) {
        int sum = 0;
        int count = maxHeight(height);

        for (int i = 0; i < count; i++) {
            int start = getStart(height);
            int end = getEnd(height);

            for (int j = start; j <= end; j++) {
                if(height[j] == 0){
                    sum++;
                }else {
                    height[j] -= 1;
                }
            }
        }
        return sum;
    }
    private static int maxHeight(int[] max) {
        int maxNumber = max[0];
        for (int i = 1; i < max.length; i++) {
            if (maxNumber < max[i]) {
                maxNumber = max[i];
            }
        }
        return maxNumber;
    }
    public static int getStart(int[] heightStart){
        int start = 0;
        for (int j = 0; j <heightStart.length; j++) {
            if (heightStart[j] != 0) {
                start = j;
                break;
            }
        }return start;
    }
    private static int getEnd(int[] heightEnd) {
        int end = 0;
        for (int j = heightEnd.length - 1; j > 0; j--) {
            if (heightEnd[j] != 0) {
                end = j;
                break;
            }
        }return end;
    }
}
