package ua.lviv.iot.labs.fifth.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Reptilia extends Chordata {
	private Boolean resetsSkin;

	public Reptilia(String name, String species, String size, String age, int lifespanInYears, DangerLevel dangerLevel,
			String diet, float daysNotFed, Boolean resetsSkin) {
		super(name, species, size, age, lifespanInYears, dangerLevel, diet, daysNotFed);
		this.resetsSkin = resetsSkin;
	}

	@Override
	public String toString() {
		return super.toString() + ", resetsSkin: " + resetsSkin;
	}
}
