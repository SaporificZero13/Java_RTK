import java.util.Objects;

public class Product {
    private String name;    // Название продукта
    private double price;   // Цена продукта

    // Конструктор класса Product
    public Product(String name, double price) {
        // Проверяем, что название не пустое
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        // Проверяем, что цена не отрицательная
        if (price < 0) {
            throw new IllegalArgumentException("Деньги не могут быть отрицательными");
        }
        this.name = name;
        this.price = price;
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        // Проверка при установке нового имени
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        // Проверка при установке новой цены
        if (price < 0) {
            throw new IllegalArgumentException("Деньги не могут быть отрицательными");
        }
        this.price = price;
    }

    // Переопределение метода toString для красивого вывода информации о продукте
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    // Переопределение equals для сравнения продуктов
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                Objects.equals(name, product.name);
    }

    // Переопределение hashCode
    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
