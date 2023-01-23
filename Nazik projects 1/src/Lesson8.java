import java.util.Scanner;

public class Lesson8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Year: ");
        int year = scan.nextInt();

        scan.nextLine();

        System.out.print("Month: ");
        String month = scan.nextLine().trim();

        month = month.substring(0,1).toUpperCase() + month.substring(1).toLowerCase();

        boolean isLeap = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;

            switch (month) {
                case "January":
                case "March":
                case "May":
                case "Jule":
                case "August":
                case "October":
                case "December":
                    System.out.println(31);
                    break;
                case "April":
                case "June":
                case "September":
                case "November":
                    System.out.println(30);
                    break;
                case "February":
                    System.out.println(isLeap ? 29 : 28);
                    break;
                default:
                    System.out.println("Invalid month");
            }
    }
}
