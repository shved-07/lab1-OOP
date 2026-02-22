package ua.lpnu.students.lab1;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Car {
    private int horsePower;
    private double engineVolume;
    
    // 5 додаткових полів
    private String brand;
    private String model;
    private int year;
    private String color;
    private boolean isElectric;
}