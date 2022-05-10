package ua.lviv.iot.labs.second.models;

public class Insecta extends Arthropoda {
	private Boolean hasWings;
	
	public Insecta(String name, String species, String size, String age, String lifespan, DangerLevel dangerLevel,
			String preferedFood, float daysNotFed, Boolean hasWings) {
		super(name, species, size, age, lifespan, dangerLevel, preferedFood, daysNotFed);
		this.hasWings = hasWings;
	}
	
	public Boolean getHasWings() {
		return hasWings;
	}

	public void setHasWings(Boolean hasWings) {
		this.hasWings = hasWings;
	}

	@Override
	public String toString() {
		return super.toString() + "hasWings: " + hasWings;
	}
}
