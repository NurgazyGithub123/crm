public class Mail {
    public static void main(String[] args) {

        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}; // 6

        int[] height2 = {4, 2, 0, 3, 2, 5}; // 9
        System.out.println(solution(height));
        System.out.println(solution(height2));

        System.out.println(solution(height));
        System.out.println(solution(height2));
    }
    private static int solution(int[] height) {
        int amountOfWater = 0;
        int probableAmountOfWater = 0;
        int maxHeight = height.length;

        boolean hasWall = false;
        for (int i = 0; i < maxHeight; i++) {
            if (maxHeight <= height.length && maxHeight < height[i]) {
                maxHeight = height[i];
            }
            for (int k : height) {
                if (k > i) {
                    if (probableAmountOfWater != 0 && hasWall) {
                        amountOfWater += probableAmountOfWater;
                        probableAmountOfWater = 0;
                    }
                    hasWall = true;
                } else if (hasWall) {
                    probableAmountOfWater++;
                }
            }
            probableAmountOfWater = 0;
            hasWall = false;
        }
        return amountOfWater;
    }
}
