/* import java.util.Scanner;

public class dz_3 {
    public static void main(String[] args) {
        // Создаём объект Scanner для чтения ввода
        Scanner scanner = new Scanner(System.in);

        // Запрашиваем имя пользователя
        System.out.print("Введите ваше имя: ");

        // Читаем введённое имя
        String userName = scanner.nextLine();

        // Выводим приветствие
        System.out.println("Привет, " + userName);

        // Закрываем Scanner (опционально)
        scanner.close();
    }
}
*/


import java.util.Random;

public class dz_3 {
    public static void main(String[] args) {
        Random random = new Random();

        // Генерация случайных выборов
        int vasyaChoice = random.nextInt(3); // 0-камень, 1-ножницы, 2-бумага
        int petyaChoice = random.nextInt(3);

        // Вывод выборов игроков
        System.out.println("Вася выбрал: " + getChoiceName(vasyaChoice));
        System.out.println("Петя выбрал: " + getChoiceName(petyaChoice));

        // Определение победителя
        if (vasyaChoice == petyaChoice) {
            System.out.println("Ничья!");
        } else if ((vasyaChoice == 0 && petyaChoice == 1) ||
                (vasyaChoice == 1 && petyaChoice == 2) ||
                (vasyaChoice == 2 && petyaChoice == 0)) {
            System.out.println("Вася победил!");
        } else {
            System.out.println("Петя победил!");
        }
    }

    public static String getChoiceName(int choice) {
        switch (choice) {
            case 0: return "камень";
            case 1: return "ножницы";
            case 2: return "бумага";
            default: return "неизвестно";
        }
    }
}