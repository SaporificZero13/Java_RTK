import java.util.Arrays;
import java.util.Objects;

public class Person {
    private String name;            // Имя покупателя
    private double money;          // Количество денег
    private Product[] products;     // Массив купленных продуктов
    private int productCount;      // Счётчик купленных продуктов

    // Конструктор класса Person
    public Person(String name, double money) {
        // Проверяем, что имя не пустое и не короче 3 символов
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (name.length() < 3) {
            throw new IllegalArgumentException("Имя не может быть короче 3 символов");
        }
        // Проверяем, что деньги не отрицательные
        if (money < 0) {
            throw new IllegalArgumentException("Деньги не могут быть отрицательными");
        }

        this.name = name;
        this.money = money;
        this.products = new Product[10]; // Начальный размер массива - 10
        this.productCount = 0;           // Пока купленных продуктов нет
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        // Проверки при изменении имени
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (name.length() < 3) {
            throw new IllegalArgumentException("Имя не может быть короче 3 символов");
        }
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        // Проверка при изменении количества денег
        if (money < 0) {
            throw new IllegalArgumentException("Деньги не могут быть отрицательными");
        }
        this.money = money;
    }

    // Метод для добавления продукта в корзину
    public void addProduct(Product product) {
        // Проверяем, хватает ли денег на продукт
        if (product.getPrice() > this.money) {
            System.out.printf("%s не может позволить себе %s%n", this.name, product.getName());
            return;
        }

        // Если массив заполнен, увеличиваем его размер
        if (productCount == products.length) {
            products = Arrays.copyOf(products, products.length * 2);
        }

        // Добавляем продукт и уменьшаем деньги
        products[productCount++] = product;
        this.money -= product.getPrice();
    }

    // Метод для получения списка купленных продуктов
    public Product[] getProducts() {
        return Arrays.copyOf(products, productCount);
    }

    // Переопределение toString
    @Override
    public String toString() {
        // Если продуктов нет, выводим соответствующее сообщение
        if (productCount == 0) {
            return name + " Ничего не куплено";
        }

        // Собираем информацию о купленных продуктах
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" купил: ");
        for (int i = 0; i < productCount; i++) {
            sb.append(products[i].getName());
            if (i < productCount - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    // Переопределение equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Double.compare(person.money, money) == 0 &&
                productCount == person.productCount &&
                Objects.equals(name, person.name) &&
                Arrays.equals(products, person.products);
    }

    // Переопределение hashCode
    @Override
    public int hashCode() {
        int result = Objects.hash(name, money, productCount);
        result = 31 * result + Arrays.hashCode(products);
        return result;
    }
}
