public class Task_2 {

    public static void primitiveVariables(){

        byte numberByte = 100;
        System.out.println("byte равно 1 байт = от -128 до 127. Например = " + numberByte);

        short numberShort = 1000;
        System.out.println("short равно 2 байт = от -32768 до 32767. Например = " + numberShort);

        int numberInt = 1000000000;
        System.out.println("int равно 4 байт = +- 2 -> 32 степени. Например = " + numberInt);

        long numberLong= 1000000000000L;
        System.out.println("long равно 8 байт = +- 2 -> 64 степени и после числа должны добавить 'L'. Например = " + numberLong);

        float numberFloat = 1000.121212F;
        System.out.println("float равно 4 байт .дробный . после числа должны добавить 'F'Например = " + numberFloat);

        double numberDouble = 1000.212;
        System.out.println("float равно 8 байт  дробный. Например = " + numberDouble);

        char a = 'a';
        System.out.println("char равно 2 байт  для символа. Например = " + a);

        boolean condition = true;
        System.out.println("логический тип данных хранит true или false. Например = " + condition);
    }
}
