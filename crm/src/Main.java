import dao.*;
import model.Address;
import model.Student;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        MentorDao mentorDao = MentorDaoImpl.getMentorSQL();
    }
}