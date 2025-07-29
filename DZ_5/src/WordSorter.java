/*Задача 3*. Задана строка, состоящая из букв английского алфавита, разделенных одним пробелом.
Необходимо каждую последовательность символов упорядочить по возрастанию и вывести слова в нижнем регистре.
Входные данные: в единственной строке последовательность символов представляющее два слова.
Выходные данные: упорядоченные по возрастанию буквы в нижнем регистре.*/



import java.util.Arrays;
import java.util.Scanner;

public class WordSorter {
    public static void main(String[] args) {
        // Создаем Scanner для чтения ввода
        Scanner scanner = new Scanner(System.in);

        // Читаем всю строку ввода
        System.out.print("Введите два слова, разделенные пробелом: ");
        String input = scanner.nextLine();

        // Разделяем строку на слова по пробелу
        String[] words = input.split(" ");

        // Проверяем, что введено ровно два слова
        if (words.length != 2) {
            System.out.println("Ошибка: нужно ввести ровно два слова, разделенные одним пробелом");
            return;
        }

        // Обрабатываем каждое слово
        for (int i = 0; i < words.length; i++) {
            // Приводим слово к нижнему регистру
            words[i] = words[i].toLowerCase();

            // Преобразуем слово в массив символов
            char[] chars = words[i].toCharArray();

            // Сортируем символы по возрастанию
            Arrays.sort(chars);

            // Преобразуем отсортированный массив обратно в строку
            words[i] = new String(chars);
        }

        // Выводим результат
        System.out.println("Результат: " + words[0] + " " + words[1]);

        // Закрываем Scanner
        scanner.close();
    }
}