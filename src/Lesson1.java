import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Lesson1 {

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
        //System.out.println("Введите два числа A и B (0≤A,B≤2∗1018)(0≤A,B≤2∗1018), разделённые пробелом. ");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));) {

            long[] nums = new long[args.length];
            for (int i = 0; i < args.length; i++) {
                nums[i] = Long.parseLong(reader.readLine());
                if (i == 1) {
                    reader.close();
                }
            }
            //последовательность слов в строке
            String[] parts = reader.readLine().split("\\s+");

            //writer.write("Cуммарное количество задач в сезоне:");
            //writer.newLine();

            //Вычисление суммы чисел в строке:
            long sum = 0;
            for (int i = 0; i < parts.length; i++) {
                long num = Long.parseLong(parts[i]);
                sum += num;
            }
            writer.write(String.valueOf(sum));
        }
        catch (IOException e) {
            throw new RuntimeException();
        }
    }

}
