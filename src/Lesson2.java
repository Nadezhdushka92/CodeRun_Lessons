import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Lesson2 {

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
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));) {
            long a = Long.parseLong(reader.readLine());
            long b = Long.parseLong(reader.readLine());
            long c = Long.parseLong(reader.readLine());

            if ((a+b) > c && (a+c) > b && (c+b) > a) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
        catch (IOException e) {
            throw new RuntimeException();
        }
    }

}
