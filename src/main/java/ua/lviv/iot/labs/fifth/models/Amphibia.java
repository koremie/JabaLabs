package ua.lviv.iot.labs.fifth.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Amphibia extends Chordata {
	private Boolean producesSlime;

	public Amphibia(String name, String species, String size, String age, int lifespanInYears, DangerLevel dangerLevel,
			String diet, float daysNotFed, Boolean producesSlime) {
		super(name, species, size, age, lifespanInYears, dangerLevel, diet, daysNotFed);
		this.producesSlime = producesSlime;
	}

	public String getHeaders() {
		return super.getHeaders() + ", producesSlime";
	}

	public String toCSV() {
		return super.toCSV() + "," + producesSlime;
	}

	@Override
	public String toString() {
		return super.toString() + ", producesSlime: " + producesSlime;
	}
}
