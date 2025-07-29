/*Задача 2. Задана последовательность, состоящая только из символов ‘>’, ‘<’ и ‘-‘.
Требуется найти количество стрел, которые спрятаны в этой последовательности.
Стрелы – это подстроки вида ‘>>-->’ и ‘<--<<’.
Входные данные: в первой строке входного потока записана строка, состоящая из символов ‘>’, ‘<’ и ‘-‘
(без пробелов). Строка может содержать до 106 символов.
Выходные данные: в единственную строку выходного потока нужно вывести искомое количество стрелок.*/


import java.util.Scanner;

public class ArrowCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Читаем входную строку
        String input = scanner.nextLine();

        int count = 0; // Счетчик найденных стрелок
        int n = input.length();

        // Проходим по строке, проверяя возможные стрелки
        for (int i = 0; i <= n - 5; i++) {
            // Проверяем стрелу вида ">>-->"
            if (input.charAt(i) == '>' &&
                    input.charAt(i+1) == '>' &&
                    input.charAt(i+2) == '-' &&
                    input.charAt(i+3) == '-' &&
                    input.charAt(i+4) == '>') {
                count++;
            }

            // Проверяем стрелу вида "<--<<"
            if (input.charAt(i) == '<' &&
                    input.charAt(i+1) == '-' &&
                    input.charAt(i+2) == '-' &&
                    input.charAt(i+3) == '<' &&
                    input.charAt(i+4) == '<') {
                count++;
            }
        }

        System.out.println(count);
        scanner.close();
    }
}