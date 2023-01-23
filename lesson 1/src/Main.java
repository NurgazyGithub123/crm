import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Тест на вопрос от 1 до 8");
        Scanner scan = new Scanner(System.in);

        while (true) {

            System.out.print("Вопрос №: ");

            switch (scan.nextInt()) {
                case 1:
                    System.out.println("Тест 1. Создать пустой проект в IntelliJ IDEA и прописать метод main().");
                    System.out.println("Прописан метод main()");
                    break;
                case 2:
                    System.out.println("Tест 2. Создать переменные всех пройденных типов данных и инициализировать их значения.");
                    Task_2.primitiveVariables();
                    break;
                case 3:
                    System.out.println("Tест 3. Написать метод который возвращает число Float от функции a * (b + (c / d))");

                    System.out.print("a : ");
                    float a = scan.nextFloat();

                    System.out.print("b : ");
                    float b = scan.nextFloat();

                    System.out.print("c : ");
                    float c = scan.nextFloat();

                    System.out.print("d : ");
                    float d = scan.nextFloat();
                    System.out.println("Expression a * (b + (c / d)) = " + Task_3.expression(a, b, c, d));
                    break;
                case 4:
                    System.out.println("Tест 4. Написать метод, принимающий на вход два целых числа и проверяющий," +
                            " что их сумма лежит в пределах от 10 до 20");
                    System.out.print("Number 1 : ");
                    int number1 = scan.nextInt();

                    System.out.print("Number 2 : ");
                    int number2 = scan.nextInt();
                    System.out.println(Task_4.limit(number1, number2));
                    break;
                case 5:
                    System.out.println("Tест 5. Написать метод, которому в качестве параметра передается целое число," +
                            " метод должен напечатать в консоль, положительное ли число передали или отрицательное. " +
                            "Замечание: ноль считаем положительным числом.");
                    System.out.print("Number : ");
                    System.out.println(Task_5.positivelyNumber(scan.nextInt()));
                    break;
                case 6:
                    System.out.println("Тест 6. Написать метод, которому в качестве параметра передается целое число. " +
                            "Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.");
                    System.out.print("Number : ");
                    System.out.println(Task_6.positivelyNumber(scan.nextInt()));
                    break;
                case 7:
                    System.out.println("Тест 7. Написать метод, которому в качестве параметра передается строка, обозначающая имя." +
                            " Метод должен вывести в консоль сообщение «Привет, указанное_имя!»");
                    System.out.print("Имя : ");
                    scan.nextLine();
                    System.out.println(Task_7.name(scan.nextLine()));
                    break;
                case 8:
                    System.out.println("Тест 8. Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль." +
                            " Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.");
                    System.out.print("Year : ");
                    Task_8.leapYear(scan.nextInt());
                    break;
            }
        }
    }
}