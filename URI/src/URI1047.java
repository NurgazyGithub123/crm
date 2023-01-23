import java.util.Scanner;

public class URI1047 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int startHour = scan.nextInt();
        int startMinutes = scan.nextInt();
        int endHour = scan.nextInt();
        int endMinutes = scan.nextInt();

        int durationMinutes = 0;
        int durationHour = 0;

        if(startHour > endHour){
            durationHour = 24 + endHour - startHour;
        }else if(startHour == endHour) {
            durationHour = 24;
        }else durationHour = endHour - startHour;

        if(startMinutes > endMinutes){
            durationMinutes = 60 + endMinutes - startMinutes;
            durationHour --;
        }else {
            durationMinutes = endMinutes - startMinutes;
        }
        System.out.printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)%n",durationHour, durationMinutes);
    }
}
