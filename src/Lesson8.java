import java.io.*;

public class Lesson8 {
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
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] arrStr = reader.readLine().split("\\s");
            int[] arr = new int[arrStr.length];

            for (int i = 0; i < arrStr.length; i++) {
                arr[i] = Integer.parseInt(arrStr[i]);
            }

            if (isIncreasing(arr)) {
                //Вывод результата количества уникальных слов
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private static boolean isIncreasing(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= arr[i-1]) {
                return false;
            }
        }
        return true;
    }
}