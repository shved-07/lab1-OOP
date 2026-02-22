package ua.lpnu.students.lab1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        // === ЗАВДАННЯ 1: Магія Stream API ===
        System.out.println("=== Завдання 1 ===");
        
        // List.of створює незмінний список чисел. Це швидше, ніж додавати по одному.
        List<Integer> numbers = List.of(10, 20, 5, 2, 100, 50, 7, 3, 12, 4);

        // ЩО ТУТ ВІДБУВАЄТЬСЯ:
        // .stream() -> перетворює список на "конвеєр" даних.
        // .mapToInt() -> каже Java: "розглядай ці об'єкти як прості цілі числа (int), щоб можна було їх додавати".
        // .sum() -> кінцева операція: додай все, що прийшло по конвеєру.
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();

        // reduce (зменшення/згортання) -> це метод, який бере два числа, робить з ними дію, бере результат і наступне число...
        // 1 -> це стартове значення.
        // (a, b) -> a * b -> це формула: "помнож попередній результат (a) на поточне число (b)".
        int mult = numbers.stream().reduce(1, (a, b) -> a * b);

        System.out.println("Числа: " + numbers);
        System.out.println("Сума (Stream sum): " + sum);
        System.out.println("Добуток (Stream reduce): " + mult);


        // === ЗАВДАННЯ 2: Робота з текстом ===
        System.out.println("\n=== Завдання 2 ===");
        // String.join(" ", ...) -> дуже зручний метод.
        // Перший аргумент " " — це роздільник (пробіл). Він автоматично вставиться між словами.
        String sentence = String.join(" ", 
            "Java", "is", "a", "powerful", "library-rich", 
            "language", "that", "makes", "developers", "happy", "today"
        );
        System.out.println(sentence + ".");


        // === ЗАВДАННЯ 3: Генерація об'єктів ===
        System.out.println("\n=== Завдання 3 ===");
        
        // IntStream.range(0, 10) -> створює віртуальний цикл від 0 до 9.
        // .mapToObj(i -> new User(...)) -> для кожного числа 'i' створює нового User.
        // i використовується, щоб дані були різними (вік 20+0, 20+1...).
        // .collect(...) -> збирає всі створені об'єкти в готовий Список (List).
        List<User> users = IntStream.range(0, 10)
            .mapToObj(i -> new User(i, 20 + i, "Name" + i, "Surname" + i, 70.0 + i, 1.75 + (i * 0.01)))
            .collect(Collectors.toList());

        // ТУТ ГОЛОВНА ФІШКА:
        // User::getAge -> це коротка форма запису. Читається як "візьми вік у юзера".
        // Ми не пишемо цикл for. Ми кажемо: "Дай мені потік юзерів -> витягни з них вік -> просумуй".
        int totalAge = users.stream().mapToInt(User::getAge).sum();
        
        // Тут те саме, але для дробових чисел (Double)
        double totalWeight = users.stream().mapToDouble(User::getWeight).sum();
        double totalHeight = users.stream().mapToDouble(User::getHeight).sum();

        // %.2f означає "виведи число з плаваючою крапкою і обріж до 2 знаків після коми"
        System.out.printf("Сумарний вік: %d | Вага: %.2f | Зріст: %.2f\n", totalAge, totalWeight, totalHeight);


        // === ЗАВДАННЯ 4: Те саме для машин ===
        System.out.println("\n=== Завдання 4 ===");
        List<Car> cars = IntStream.range(0, 10)
            .mapToObj(i -> new Car(150 + (i * 10), 2.0 + (i * 0.1), "Brand" + i, "Model" + i, 2022, "White", false))
            .collect(Collectors.toList());

        double totalEngineVol = cars.stream().mapToDouble(Car::getEngineVolume).sum();
        int totalHP = cars.stream().mapToInt(Car::getHorsePower).sum();

        System.out.printf("Загальний об'єм: %.2f | Загальна потужність: %d\n", totalEngineVol, totalHP);


        // === ЗАВДАННЯ 5: Реверс числа ===
        System.out.println("\n=== Завдання 5 ===");
        int number = 412;
        
        // Трюк:
        // 1. String.valueOf(number) -> перетворює число 412 на текст "412".
        // 2. new StringBuilder(...) -> створює спеціальний об'єкт для редагування тексту.
        // 3. .reverse() -> перевертає текст задом наперед ("214").
        // 4. .toString() -> перетворює результат назад у звичайний текст.
        String reversedString = new StringBuilder(String.valueOf(number)).reverse().toString();
        
        // Integer.parseInt(...) -> перетворює текст "214" назад у число 214.
        int reversedNumber = Integer.parseInt(reversedString);

        System.out.printf("Вхідне: %d => Реверс (StringBuilder): %d\n", number, reversedNumber);
    }
}