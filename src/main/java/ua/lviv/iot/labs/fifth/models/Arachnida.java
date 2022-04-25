package ua.lviv.iot.labs.fifth.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Arachnida extends Arthropoda {
	private Boolean weavesWeb;

	public Arachnida(String name, String species, String size, String age, int lifespanInYears, DangerLevel dangerLevel,
			String diet, float daysNotFed, Boolean weavesWeb) {
		super(name, species, size, age, lifespanInYears, dangerLevel, diet, daysNotFed);
		this.weavesWeb = weavesWeb;
	}

	@Override
	public String toString() {
		return super.toString() + ", weavesWeb: " + weavesWeb;
	}
}
