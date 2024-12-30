import java.io.*;

import static java.lang.Math.sqrt;

public class Lesson5 {
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

            //последовательность слов в строке
            String[] parts = reader.readLine().split(" ");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            int c = Integer.parseInt(parts[2]);

            double D = (b * b) - (4.0 * a * c);

            if (D == 0) {
                double x1 = -b / (2.0 * a);

                writer.write("1\n");
                writer.write(String.format("%.6f\n", x1));
            } else if (D > 0) {
                double x1 = (-b - sqrt(D)) / (2.0 * a);
                double x2 = (-b + sqrt(D)) / (2.0 * a);
                if (x1 > x2) {
                    double x = x1;
                    x1 = x2;
                    x2 = x;
                }

                writer.write("2\n");
                writer.write(String.format("%.6f %.6f\n", x1, x2));
            } else {
                writer.write("0\n");
            }

        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}