import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Создаём массивы для хранения покупателей и продуктов
        Person[] people = new Person[10];
        Product[] products = new Product[10];
        int peopleCount = 0;
        int productCount = 0;

        // Ввод покупателей
        System.out.println("Введите информацию о покупателях (формат: Имя Сумма). Для завершения введите END:");
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("END")) break;

            // Разделяем имя и сумму (последнее число в строке)
            String[] moneyParts = input.split("[^0-9.]+");
            if (moneyParts.length == 0) {
                System.out.println("Не указана сумма");
                continue;
            }

            try {
                double money = Double.parseDouble(moneyParts[moneyParts.length-1]);
                String name = input.substring(0, input.lastIndexOf(moneyParts[moneyParts.length-1])).trim();

                if (name.isEmpty()) {
                    System.out.println("Не указано имя");
                    continue;
                }

                people[peopleCount++] = new Person(name, money);
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат числа для суммы денег");
            }
        }

        // Ввод продуктов
        System.out.println("Введите информацию о продуктах (формат: Название Цена). Для завершения введите END:");
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("END")) break;

            // Разделяем название и цену (последнее число в строке)
            String[] priceParts = input.split("[^0-9.]+");
            if (priceParts.length == 0) {
                System.out.println("Не указана цена");
                continue;
            }

            try {
                double price = Double.parseDouble(priceParts[priceParts.length-1]);
                String name = input.substring(0, input.lastIndexOf(priceParts[priceParts.length-1])).trim();

                if (name.isEmpty()) {
                    System.out.println("Не указано название продукта");
                    continue;
                }

                products[productCount++] = new Product(name, price);
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат числа для цены");
            }
        }

        // Процесс покупки с немедленным выводом результата
        System.out.println("Начинаем процесс покупки. Вводите в формате: 'Имя - Название продукта'. Для завершения введите END:");

        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("END")) break;

            if (!input.contains(" - ")) {
                System.out.println("Неверный формат. Используйте: 'Имя - Название продукта'");
                continue;
            }

            String[] parts = input.split(" - ", 2);
            String personName = parts[0].trim();
            String productName = parts[1].trim();

            // Находим покупателя
            Person person = null;
            for (int i = 0; i < peopleCount; i++) {
                if (people[i].getName().equalsIgnoreCase(personName)) {
                    person = people[i];
                    break;
                }
            }

            if (person == null) {
                System.out.println("Покупатель '" + personName + "' не найден");
                continue;
            }

            // Находим продукт
            Product product = null;
            for (int i = 0; i < productCount; i++) {
                if (products[i].getName().equalsIgnoreCase(productName)) {
                    product = products[i];
                    break;
                }
            }

            if (product == null) {
                System.out.println("Продукт '" + productName + "' не найден");
                continue;
            }

            // Сохраняем текущее количество продуктов для проверки
            int beforePurchase = person.getProducts().length;

            // Совершаем покупку
            person.addProduct(product);

            // Проверяем, была ли совершена покупка
            if (person.getProducts().length > beforePurchase) {
                System.out.println(person.getName() + " купил " + product.getName());
            } else {
                System.out.println(person.getName() + " не может позволить себе " + product.getName());
            }
        }

        // Выводим итоговую информацию
        System.out.println("\nИтоговая информация о покупках:");
        for (int i = 0; i < peopleCount; i++) {
            System.out.println(people[i]);
        }

        scanner.close();
    }
}
