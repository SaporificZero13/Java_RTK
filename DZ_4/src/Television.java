import java.util.Random;
import java.util.Scanner;

public class Television {
    // Приватные поля класса
    private String brand;
    private int screenSize; // в дюймах
    private boolean isSmart;
    private int currentChannel;
    private int volume;
    private boolean isOn;

    // Конструктор класса
    public Television(String brand, int screenSize, boolean isSmart) {
        this.brand = brand;
        this.screenSize = screenSize;
        this.isSmart = isSmart;
        this.currentChannel = 1;
        this.volume = 50;
        this.isOn = false;
    }

    // Геттеры и сеттеры
    public String getBrand() {
        return brand;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public boolean isSmart() {
        return isSmart;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public int getVolume() {
        return volume;
    }

    public boolean isOn() {
        return isOn;
    }

    // Методы для работы с телевизором
    public void powerOn() {
        isOn = true;
        System.out.println("Телевизор " + brand + " включен");
    }

    public void powerOff() {
        isOn = false;
        System.out.println("Телевизор " + brand + " выключен");
    }

    public void changeChannel(int newChannel) {
        if (isOn) {
            currentChannel = newChannel;
            System.out.println("Переключили на канал " + newChannel);
        } else {
            System.out.println("Сначала включите телевизор!");
        }
    }

    public void volumeUp() {
        if (isOn && volume < 100) {
            volume++;
            System.out.println("Громкость увеличена до " + volume);
        }
    }

    public void volumeDown() {
        if (isOn && volume > 0) {
            volume--;
            System.out.println("Громкость уменьшена до " + volume);
        }
    }

    // Метод для случайной настройки телевизора
    public void randomSetup() {
        Random random = new Random();
        this.currentChannel = random.nextInt(100) + 1;
        this.volume = random.nextInt(101);
        System.out.println("Телевизор настроен случайным образом: канал " +
                currentChannel + ", громкость " + volume);
    }

    // Метод для вывода информации о телевизоре
    public void displayInfo() {
        System.out.println("\nИнформация о телевизоре:");
        System.out.println("Бренд: " + brand);
        System.out.println("Диагональ: " + screenSize + " дюймов");
        System.out.println("Smart TV: " + (isSmart ? "Да" : "Нет"));
        System.out.println("Состояние: " + (isOn ? "Включен" : "Выключен"));
        if (isOn) {
            System.out.println("Текущий канал: " + currentChannel);
            System.out.println("Громкость: " + volume);
        }
    }
}