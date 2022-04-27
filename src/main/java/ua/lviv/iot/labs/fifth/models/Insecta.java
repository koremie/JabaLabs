package ua.lviv.iot.labs.fifth.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Insecta extends Arthropoda {
	private Boolean hasWings;

	public Insecta(String name, String species, String size, String age, int lifespanInYears, DangerLevel dangerLevel,
			String preferedFood, float daysNotFed, Boolean hasWings) {
		super(name, species, size, age, lifespanInYears, dangerLevel, preferedFood, daysNotFed);
		this.hasWings = hasWings;

	}

	public String getHeaders() {
		return super.getHeaders() + ", hasWings";
	}

	public String toCSV() {
		return super.toCSV() + "," + hasWings;
	}

	@Override
	public String toString() {
		return super.toString() + ", hasWings: " + hasWings;
	}
}
