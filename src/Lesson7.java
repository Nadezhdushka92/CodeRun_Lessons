import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Lesson7 {
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
        Set<String> uniqueWords = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;

            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                //Разделяем строку на слова и добавляем их в множество
                String[] words = line.trim().split("\\s");
                for (String word: words) {
                    if (!word.isEmpty()) {
                        uniqueWords.add(word);
                    }
                }
            }
            //Вывод результата количества уникальных слов
            System.out.println(uniqueWords.size());

        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}