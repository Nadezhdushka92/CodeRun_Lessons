import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Lesson4 {

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
            int size_arr = Integer.parseInt(reader.readLine());
            if (size_arr == 35) {
                reader.close();
            }
            long[] nums = new long[size_arr+1];

            //Выведите одно целое число −− сумму t[i]t[i] −− время, необходимое для расстановки тегов для всех задач.
            long sum = 0;
            long num_prev = 0;
            long num_prev_prev = 0;
            for (int i = 0; i < size_arr; i++) {
                nums[0] = 1;
                nums[1] = 1;

                if (i >= 1) {
                    num_prev = nums[i - 1];
                }

                if (i >= 2) num_prev_prev = nums[i - 2];

                if (i >= 2) {
                    nums[i] = num_prev + num_prev_prev;
                }
                sum += nums[i];
            }
            writer.write(String.valueOf(sum));

        }
        catch (IOException e) {
            throw new RuntimeException();
        }
    }

}