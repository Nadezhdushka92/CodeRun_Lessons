import java.io.*;

import static java.lang.Math.abs;

public class Lesson12 {
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

            //чтение числа N элементов масива
            int N = Integer.parseInt(reader.readLine().trim());
            int[] arr = new int[N];

            //чтение элементов
            String[] elements = reader.readLine().split("\\s+");
            //чтение элементов массива
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(elements[i]);
            }

            //чтение x
            int x = Integer.parseInt(reader.readLine().trim());

            writer.write(String.valueOf(searchClosest(arr, x)));
            writer.newLine();

        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private static int searchClosest(int[] arr, int x) {
        int closestToX = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (abs(arr[i] - x) < abs(closestToX - x)) {
                closestToX = arr[i];
            }
        }
        return closestToX;
    }
}