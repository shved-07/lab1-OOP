package ua.lpnu.students.lab1;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data // Генерує геттери, сеттери, toString
@AllArgsConstructor // Генерує конструктор з усіма полями
public class User {
    private int id;
    private int age;
    private String name;
    private String surname;
    private double weight;
    private double height;
}