import java.io.*;

public class Lesson10 {
    public static void main(String[] args) throws IOException {
        /*
        Для чтения входных данных необходимо получить их
        из стандартного потока ввода (System.in).
        Данные во входном потоке соответствуют описанному
        в условии формату. Обычно входные данные состоят
        из нескольких строк. Можно использовать более производительные
        и удобные классы BufferedReader, BufferedWriter, Scanner, PrintWriter.

        С помощью BufferedReader можно прочитать из стандартного потока:
        * строку -- reader.readLine()
        * число -- int n = Integer.parseInt(reader.readLine());
        * массив чисел известной длины (во входном потоке каждое число на новой строке) --
        */
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            //чтение данных натуральных чисел a и b
            String[] numbers = reader.readLine().split("\\s+");
            long a = Long.parseLong(numbers[0]);
            long b = Long.parseLong(numbers[1]);

            //вычисление НОД
            long gcdVal = gcd(a, b);

            //вычисление НОК
            long lcmVal = (a / gcdVal) * b;

            //Вывод результата
            writer.write(gcdVal + " " + lcmVal);

        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    //НОД
    //a = b * c + d
    private static long gcd(long a, long b) {
        while (b!=0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}