public class Task_4 {
    public static void diagonal(int arr1) {
        int[][] arrTwo = new int[arr1][arr1];
        int count = 0;

        for (int i = 0; i < arrTwo.length; i++) {
            for (int j = 0; j < arrTwo[i].length; j++) {

                if (i == count && j == count || j == arrTwo[i].length - (count + 1)) {
                        arrTwo[i][j] = 1;
                } else arrTwo[i][j] = 0;
            }
            count++;
        }

        for (int i = 0; i < arrTwo.length; i++) {
            for (int j = 0; j < arrTwo[i].length; j++) {
                System.out.print(arrTwo[i][j]);
            }
            System.out.println();
        }
    }
}
