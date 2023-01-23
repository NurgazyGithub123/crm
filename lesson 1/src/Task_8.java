import java.util.Scanner;

public class Task_8 {

    public static void leapYear(int year){
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
            System.out.println("Год : " + year + " высокосный");
        }else
        System.out.println("Год : " + year + " не высокосный");
    }
}
