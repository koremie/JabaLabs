package ua.lviv.iot.labs.fifth.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Diplopoda extends Arthropoda {
	private int legCount;

	public Diplopoda(String name, String species, String size, String age, int lifespanInYears, DangerLevel dangerLevel,
			String diet, float daysNotFed, int legCount) {
		super(name, species, size, age, lifespanInYears, dangerLevel, diet, daysNotFed);
		this.legCount = legCount;
	}

	@Override
	public String toString() {
		return super.toString() + ", legCount: " + legCount;
	}
}
