package ua.lpnu.students.lab1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        // === ЗАВДАННЯ 1: Магія Stream API ===
        System.out.println(" Завдання 1 ");
        List<Integer> numbers = List.of(10, 20, 5, 2, 100, 50, 7, 3, 12, 4);
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        long mult = numbers.stream()
        .mapToLong(Integer::longValue) //Перетворюємо кожне число з int на long
        .reduce(1L, (a, b) -> a * b);
        int diff = numbers.stream().reduce((a, b) -> a - b).orElse(0);
        double div = numbers.stream()
        .mapToDouble(Integer::doubleValue)
        .reduce((a, b) -> a / b)
        .orElse(0.0);
        System.out.println("Числа: " + numbers);
        System.out.println("Сума: " + sum);
        System.out.println("Добуток: " + mult);
        System.out.println("Різниця: " + diff);
        System.out.println("Частка: " + div);

        // === ЗАВДАННЯ 2: Робота з текстом ===
        System.out.println("\n Завдання 2 ");
        String sentence = String.join(" ", 
            "Java", "is", "a", "powerful", "library-rich", 
            "language", "that", "makes", "developers", "happy", "today"
        );
        System.out.println(sentence + ".");


        // === ЗАВДАННЯ 3: Генерація об'єктів ===
        System.out.println("\n Завдання 3 ");
        List<User> users = IntStream.range(0, 10)
            .mapToObj(i -> new User(i, 2 + i, "Name" + i, "Surname" + i, 4.0 + i, 15.75 + (i * 0.1)))
            .collect(Collectors.toList());
        int totalAge = users.stream().mapToInt(User::getAge).sum();
        double totalWeight = users.stream().mapToDouble(User::getWeight).sum();
        double totalHeight = users.stream().mapToDouble(User::getHeight).sum();
        System.out.printf("Сумарний вік: %d | Вага: %.2f | Зріст: %.2f\n", totalAge, totalWeight, totalHeight);

        // === ЗАВДАННЯ 4: Те саме для машин ===
        System.out.println("\n Завдання 4 ");
        List<Car> cars = IntStream.range(0, 10)
            .mapToObj(i -> new Car(150 + (i * 11), 2.0 + (i * 0.0001), "Brand" + i, "Model" + i, 2022, "White", false))
            .collect(Collectors.toList());

        double totalEngineVol = cars.stream().mapToDouble(Car::getEngineVolume).sum();
        int totalHP = cars.stream().mapToInt(Car::getHorsePower).sum();

        System.out.printf("Загальний об'єм: %.2f | Загальна потужність: %d\n", totalEngineVol, totalHP);


        // === ЗАВДАННЯ 5: Реверс числа ===
        System.out.println("\n Завдання 5 ");
        int number = 412;
        String reversedString = new StringBuilder(String.valueOf(number)).reverse().toString();
        int reversedNumber = Integer.parseInt(reversedString);

        System.out.printf("Вхідне: %d => Реверс: %d\n", number, reversedNumber);
    }
}