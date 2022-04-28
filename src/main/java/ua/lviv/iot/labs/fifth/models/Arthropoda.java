package ua.lviv.iot.labs.fifth.models;

public abstract class Arthropoda extends Animal {

    public Arthropoda(String name, String species, String size, String age, int lifespanInYears,
            DangerLevel dangerLevel, String diet, float daysNotFed) {
        super(name, species, size, age, lifespanInYears, dangerLevel, diet, daysNotFed);
    }
}
