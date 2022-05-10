package ua.lviv.iot.labs.second.models;

public abstract class Animal {
	protected String name;
	protected String species;
	protected String size;
	protected String age;
	protected String lifespan;
	protected DangerLevel dangerLevel;
	protected String diet;
	protected float daysNotFed;
	public Animal(String name, String species, String size, String age, 
					String lifespan, DangerLevel dangerLevel, 
					String diet, float daysNotFed) {
		this.name = name;
		this.species = species;
		this.size = size;
		this.age = age;
		this.lifespan = lifespan;
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
	public String getLifespan() {
		return lifespan;
	}
	public void setLifespan(String lifespan) {
		this.lifespan = lifespan;
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
	public String toString() {
		return "name: " + name + ", species: " + species + ", size: " + size + 
				", age: " + age + ", lifespan: " + lifespan + ", dangerLevel: " + dangerLevel + 
				", preferedFood: " + diet + ", daysNotFed: " + daysNotFed;
	}
	
}
