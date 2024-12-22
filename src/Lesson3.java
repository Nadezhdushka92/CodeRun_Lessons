import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Lesson3 {

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

            long[] nums = new long[args.length];
            for (int i = 0; i < args.length; i++) {
                nums[i] = Long.parseLong(reader.readLine());
                if (i == 4) {
                    reader.close();
                }
            }
            //последовательность слов в строке
            String[] parts = reader.readLine().split(" ");

            //Вычисление и сравнение текущего числа и соседних:
            long sum = 0;
            long num_prev = 0;
            long num_next = 0;
            for (int i = 0; i < parts.length; i++) {
                if ( i> 0) {
                    num_prev = Long.parseLong(parts[i - 1]);
                }

                if (i < parts.length-1) {
                    num_next = Long.parseLong(parts[i + 1]);
                }

                long num = Long.parseLong(parts[i]);

                if ((i > 0 && num > num_prev) && (i < parts.length && num > num_next)) {
                    sum += 1;
                }
            }
            writer.write(String.valueOf(sum));
        }
        catch (IOException e) {
            throw new RuntimeException();
        }
    }

}
