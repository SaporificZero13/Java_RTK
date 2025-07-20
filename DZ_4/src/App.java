import java.util.Scanner;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        // Создаем несколько телевизоров
        Television tv1 = new Television("Samsung", 55, true);
        Television tv2 = new Television("LG", 42, false);

        // Работаем с первым телевизором
        tv1.powerOn();
        tv1.changeChannel(5);
        tv1.volumeUp();
        tv1.volumeUp();
        tv1.displayInfo();

        // Работаем со вторым телевизором
        tv2.powerOn();
        tv2.changeChannel(10);
        tv2.volumeDown();
        tv2.displayInfo();

        // Дополнительно: создаем телевизор с параметрами с клавиатуры
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nСоздаем новый телевизор:");
        System.out.print("Введите бренд: ");
        String brand = scanner.nextLine();

        System.out.print("Введите размер экрана (дюймы): ");
        int size = scanner.nextInt();

        System.out.print("Это Smart TV? (1 - Да, 0 - Нет): ");
        boolean isSmart = scanner.nextInt() == 1;

        Television tv3 = new Television(brand, size, isSmart);
        tv3.randomSetup(); // Настраиваем случайным образом
        tv3.displayInfo();

        // Дополнительно: создаем телевизор со случайными параметрами
        Television tv4 = createRandomTV();
        tv4.powerOn();
        tv4.displayInfo();
    }

    // Метод для создания телевизора со случайными параметрами
    private static Television createRandomTV() {
        Random random = new Random();
        String[] brands = {"Sony", "Panasonic", "Philips", "Toshiba", "Sharp"};
        String randomBrand = brands[random.nextInt(brands.length)];
        int randomSize = random.nextInt(30) + 32; // от 32 до 62 дюймов
        boolean randomSmart = random.nextBoolean();

        return new Television(randomBrand, randomSize, randomSmart);
    }
}