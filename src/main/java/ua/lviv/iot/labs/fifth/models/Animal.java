package ua.lviv.iot.labs.fifth.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public abstract class Animal {
	private String name;
	private String species;
	private String size;
	private String age;
	private int lifespanInYears;
	private DangerLevel dangerLevel;
	private String diet;
	private float daysNotFed;

	public String getHeaders() {
		return "name, species, size, age, lifespanInYears, dangerLevel, diet, daysNotFed";
	}

	public String toCSV() {
		return name + "," + species + "," + size + "," + age + "," + lifespanInYears + "," + dangerLevel + "," + diet
				+ "," + daysNotFed;
	}

	@Override
	public String toString() {
		return "Name: " + name + ", species: " + species + ", size: " + size + ", age: " + age + ", lifespanInYears: "
				+ lifespanInYears + ", dangerLevel: " + dangerLevel + ", diet: " + diet + ", daysNotFed: " + daysNotFed;
	}
}
