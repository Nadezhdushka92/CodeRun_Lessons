import java.io.*;
import java.util.HashMap;

public class Lesson11 {
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

            //чтение числа N пар синонимов
            int N = Integer.parseInt(reader.readLine().trim());
            HashMap<String, String> synonyms = new HashMap<>();


            for (int i = 0; i < N; i++) {
                String line = reader.readLine();
                String[] words = line.split("\\s+");
                synonyms.put(words[0],words[1]);
                synonyms.put(words[1],words[0]);
            }

            //чтение слова, для которого нужен синоним
            String word = reader.readLine().trim();

            //Вывод синонима
            writer.write(synonyms.get(word));
            writer.newLine();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}