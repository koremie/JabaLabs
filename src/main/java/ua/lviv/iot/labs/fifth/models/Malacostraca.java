package ua.lviv.iot.labs.fifth.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Malacostraca extends Arthropoda {
	private Boolean hasClaws;

	public Malacostraca(String name, String species, String size, String age, int lifespanInYears,
			DangerLevel dangerLevel, String diet, float daysNotFed, Boolean hasClaws) {
		super(name, species, size, age, lifespanInYears, dangerLevel, diet, daysNotFed);
		this.hasClaws = hasClaws;
	}

	public String getHeaders() {
		return super.getHeaders() + ", hasClaws";
	}

	public String toCSV() {
		return super.toCSV() + "," + hasClaws;
	}

	@Override
	public String toString() {
		return super.toString() + ", hasClaws: " + hasClaws;
	}
}
