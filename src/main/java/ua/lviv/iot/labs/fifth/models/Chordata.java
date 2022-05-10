package ua.lviv.iot.labs.fifth.models;

public abstract class Chordata extends Animal {
    public Chordata(String name, String species, String size, String age, int lifespanInYears, DangerLevel dangerLevel,
            String diet, float daysNotFed) {
        super(name, species, size, age, lifespanInYears, dangerLevel, diet, daysNotFed);
    }
}
