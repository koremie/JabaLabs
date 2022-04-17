package ua.lviv.iot.labs.second.models;

public abstract class Arthropoda extends Animal {

	public Arthropoda(String name, String species, String size, String age, String lifespan, DangerLevel dangerLevel,
			String diet, float daysNotFed) {
		super(name, species, size, age, lifespan, dangerLevel, diet, daysNotFed);
	}
}
