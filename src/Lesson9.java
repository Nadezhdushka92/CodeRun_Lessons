import java.io.*;

public class Lesson9 {
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

            //чтение данных матриц A и B
            String[] nmk = reader.readLine().split("\\s+");
            int n = Integer.parseInt(nmk[0]);
            int m = Integer.parseInt(nmk[1]);
            int k = Integer.parseInt(nmk[2]);

            //чтение матрицы A n-строк, m-столбцов
            int[][] A = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] row = reader.readLine().split("\\s+");
                for (int j = 0; j < m; j++) {
                    A[i][j] = Integer.parseInt(row[j]);
                }
            }

            //чтение матрицы B m-строк, k-столбцов
            int[][] B = new int[m][k];
            for (int i = 0; i < m; i++) {
                String[] row = reader.readLine().split("\\s+");
                for (int j = 0; j < k; j++) {
                    B[i][j] = Integer.parseInt(row[j]);
                }
            }

            //умножение матриц A и B
            int[][] C = mulMatrixes(A, B, n, m, k);

            //транспонирование матриц A и B
            int[][] transpositionC = transpositionMatrix(C, n, k);

            //Вывод результата
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < n; j++) {
                    writer.write(transpositionC[i][j] + " ");
                }
                writer.newLine();
            }
            writer.flush();

        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private static int[][] mulMatrixes(int[][] A, int[][] B, int n, int m, int k) {
        int[][] C = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                for (int l = 0; l < m; l++) {
                    C[i][j] += A[i][l] * B[l][j];
                }
            }
        }
        return C;
    }

    private static int[][] transpositionMatrix(int[][] C, int n, int k) {
        int[][] transpositionC = new int[k][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                transpositionC[j][i] = C[i][j];
            }
        }
        return transpositionC;
    }
}