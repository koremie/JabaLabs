package ua.lviv.iot.labs.second.models;

import java.util.Objects;

public abstract class Animal {
	protected String name;
	protected String species;
	protected String size;
	protected String age;
	protected int lifespanInYears;
	protected DangerLevel dangerLevel;
	protected String diet;
	protected float daysNotFed;

	public Animal(String name, String species, String size, String age, 
			int lifespanInYears, DangerLevel dangerLevel,
			String diet, float daysNotFed) {
		this.name = name;
		this.species = species;
		this.size = size;
		this.age = age;
		this.lifespanInYears = lifespanInYears;
		this.dangerLevel = dangerLevel;
		this.diet = diet;
		this.daysNotFed = daysNotFed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public int getLifespanInYears() {
		return lifespanInYears;
	}

	public void setLifespanInYears(int lifespanInYears) {
		this.lifespanInYears = lifespanInYears;
	}

	public DangerLevel getDangerLevel() {
		return dangerLevel;
	}

	public void setDangerLevel(DangerLevel dangerLevel) {
		this.dangerLevel = dangerLevel;
	}

	public String getDiet() {
		return diet;
	}

	public void setDiet(String diet) {
		this.diet = diet;
	}

	public float getDaysNotFed() {
		return daysNotFed;
	}

	public void setDaysNotFed(float daysNotFed) {
		this.daysNotFed = daysNotFed;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, dangerLevel, daysNotFed, diet, lifespanInYears, name, size, species);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return Objects.equals(age, other.age) && dangerLevel == other.dangerLevel
				&& Float.floatToIntBits(daysNotFed) == Float.floatToIntBits(other.daysNotFed)
				&& Objects.equals(diet, other.diet) && lifespanInYears == other.lifespanInYears
				&& Objects.equals(name, other.name) && Objects.equals(size, other.size)
				&& Objects.equals(species, other.species);
	}

	@Override
	public String toString() {
		return "Name: " + name + ", species: " + species + ", size: " + size + ", age: " + age
				+ ", lifespanInYears: " + lifespanInYears + ", dangerLevel: " + dangerLevel + ", diet: " + diet
				+ ", daysNotFed: " + daysNotFed;
	}

}
