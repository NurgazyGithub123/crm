import java.util.Scanner;

public class URI1061 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        scan.next();
        int dayStart = scan.nextInt();
        int hourStart = scan.nextInt();

        scan.next();
        int minutesStart = scan.nextInt();

        scan.next();
        int secondStart = scan.nextInt();

        scan.next();

        int dayEnd = scan.nextInt();
        int hourEnd = scan.nextInt();

        scan.next();
        int minutesSEnd = scan.nextInt();

        scan.next();
        int secondEnd = scan.nextInt();

        int secondDay = 24 * 3600 * dayStart;
        int secondHours = 3600 * hourStart;
        int secondMinutes = 60 * minutesStart;
        int startSeconds = secondDay + secondHours + secondMinutes + secondStart;

        int secondDayEnd = 24 * 3600 * dayEnd;
        int secondHoursEnd = 3600 * hourEnd;
        int secondMinutesEnd = 60 * minutesSEnd;
        int endSeconds = secondDayEnd + secondHoursEnd + secondMinutesEnd + secondEnd;

        int secondsAll = endSeconds - startSeconds;

        int day = secondsAll / (24 * 3600);
        int remainderDay = secondsAll % (24 * 3600);

        int hour = remainderDay / 3600;
        int remainderHour = remainderDay % 3600;

        int minutes = remainderHour / 60;
        int seconds = remainderHour % 60;

        System.out.println(day + " dia(s)");
        System.out.println(hour + " hora(s)");
        System.out.println(minutes + " minuto(s)");
        System.out.println(seconds + " segundo(s)");

    }
}
