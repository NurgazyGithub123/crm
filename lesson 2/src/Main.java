import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);;

        while (true){

            System.out.print("answers on questions: ");

            switch (scan.nextInt()){
                case 1:
                    System.out.println(" Задать целочисленный массив, состоящий из элементов 0 и 1. " +
                            "Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. " +
                            "С помощью цикла и условия заменить 0 на 1, 1 на 0;");
                    Task_1.replacement();
                    break;
                case 2:
                    System.out.println("Задать пустой целочисленный массив размером 8. " +
                            "С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;");
                    Task_2.filling();
                    break;
                case 3:
                    System.out.println("Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, " +
                            "и числа меньшие 6 умножить на 2;");
                    Task_3.numberLess();
                    break;
                case 4:
                    System.out.println("Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое)," +
                            " и с помощью цикла(-ов) заполнить его диагональные элементы единицами;");
                    System.out.print("Длина массива, количество строк и столбцов: ");
                    int i_and_j = scan.nextInt();

                    Task_4.diagonal(i_and_j);
                    break;
                case 5:
                    System.out.println("Задать одномерный массив и найти в нем минимальный и " +
                            "максимальный элементы (без помощи интернета);");
                    System.out.print("Длина массива: ");
                    int[] arrSorting = new int[scan.nextInt()];
                    Task_5.min_max(arrSorting);
                    break;
                case 6:
                    System.out.println("Написать метод, в который передается не пустой одномерный целочисленный массив," +
                            " метод должен вернуть true, если в массиве есть место, в котором сумма левой и " +
                            "правой части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2,  10, 1]) → " +
                            "true, checkBalance([1, 1, 1,  2, 1]) → true, граница показана символами ||, " +
                            "эти символы в массив не входят.");
                    System.out.print("Длина массива: ");
                    int[] arr3 = new int[scan.nextInt()];
                    Task_6.booleanArray(arr3);

                    break;
                case 7:
                    System.out.println(" Написать метод, которому на вход подается одномерный массив и число n " +
                            "(может быть положительным, или отрицательным), при этом метод должен сместить все " +
                            "элементымассива на n позиций. Для усложнения задачи нельзя пользоваться " +
                            "вспомогательными массивами.");
//                    System.out.print("Длина массива: ");
//                    int[] arr4 = {0,1,2,3,4,5,6}; //new int[scan.nextInt()];
//                    System.out.print("Число n: ");
//                    int n = scan.nextInt();

                    Task_7.shiftN();
                    break;
            }
        }
    }


}