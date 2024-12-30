import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Lesson6 {
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

            //чтение доступных кнопок в последовательности слов в строке
            String[] btns = reader.readLine().split(" ");
            int x = Integer.parseInt(btns[0]);
            int y = Integer.parseInt(btns[1]);
            int z = Integer.parseInt(btns[2]);

            //чтение числа N
            int N = Integer.parseInt(reader.readLine());

            //преобразование числа N в строку для проверки каждой цифры
            String numberToStr = String.valueOf(N);

            Set<Integer> availableBtns = new HashSet<>();
            availableBtns.add(x);
            availableBtns.add(y);
            availableBtns.add(z);

            Set<Character> neededBtns = new HashSet<>();

            //проверка каждой цифры в числе N
            for (char digitToChar: numberToStr.toCharArray()) {
                int digitNumber = Character.getNumericValue(digitToChar);
                if (!availableBtns.contains(digitNumber)) {
                    neededBtns.add(digitToChar);
                }
            }

            //Вывод результата
            System.out.println(neededBtns.size());

        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}