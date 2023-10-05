package register2;

import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static Scanner scan = new Scanner(System.in);
    public static  Customer[] customers = new Customer[15];
    public static int counter = 0;

    public static void main(String[] args) {
        run();
    }

    public static void run(){
        uploadData();

        while (true) {
            try {
                System.out.print("Command: ");
                String cmd = readUserCommand();

                switch (cmd) {
                    case "PRINT":
                        print();
                        break;
                    case "REGISTER":
                        register();
                        break;
                    case "REMOVE":
                        System.out.print("ID :" );
                        int index = scan.nextInt() - 1;
                        scan.nextLine();
                        remove(index);
                        break;
                    case "COUNT":
                        System.out.println("COUNTER : " + counter);
                        break;
                    case "EXIT":
                        saveData();
                        return;
                }
            }catch (RuntimeException exception){
                exception.printStackTrace();
                System.out.println("");
            }
        }
    }
    public static String readUserCommand(){
        String command = scan.nextLine().toUpperCase().trim();

        switch (command){
            case "REGISTER":
            case "REMOVE":
            case "PRINT":
            case "COUNT":
            case "EXIT":
                return command;
            default:
                throw new RuntimeException("Invalid command: " + command);
        }
    }

    public static void remove(int index){
        counter--;

        customers[index] = customers[counter];
        customers[counter] = null;
    }
    public static void uploadData(){
        String pathToFile = "C:\\Users\\Nurgazy\\IdeaProjects\\New Lesson\\data\\data.txt";
        File file = new File(pathToFile);

        try {
            Scanner scannerFileData = new Scanner(file);

                while (scannerFileData.hasNextLine()) {
                    customers[counter][0] = scannerFileData.next();
                    customers[counter][1] = scannerFileData.next();
                    customers[counter][2] = scannerFileData.next();
                    customers[counter][3] = scannerFileData.next();
                    customers[counter][4] = scannerFileData.nextLine();

                    counter++;
                }
            }catch(FileNotFoundException exception){
                exception.printStackTrace();
        }
    }
    public static void saveData(){
        String pathToFile = "C:\\Users\\Nurgazy\\IdeaProjects\\New Lesson\\data\\data.txt";
        File file = new File(pathToFile);

        try {
            if(!file.exists()){
                file.createNewFile();
            }

            PrintWriter out = new PrintWriter(new FileOutputStream(file, true));

            for (int i = 0; i < counter; i++) {
                out.print(customers[i][0] + "");
                out.print(customers[i][1] + "");
                out.print(customers[i][2] + "");
                out.print(customers[i][3] + "");
                out.println(customers[i][4] + "");
            }

            out.close();

        }catch (IOException exception){
            exception.printStackTrace();
        }
    }
    public static void register(){

        Customer customer = new Customer();
        System.out.print("First name: ");
        customer.firsName = scan.nextLine();

        System.out.print("Last name: ");
        customer.lastName = scan.nextLine();

        System.out.print("DOB: ");
        customer.dob = LocalDate.parse(scan.nextLine());

        System.out.print("Email: ");
        customer.email = scan.nextLine();

        System.out.print("Phone number: ");
        customer.phoneNumber = scan.nextLine();



        counter++;
    }

    public static void print(){
        for (int i = 0; i < counter; i++) {
            System.out.println(Arrays.toString(customers[i]));
        }
    }
}
