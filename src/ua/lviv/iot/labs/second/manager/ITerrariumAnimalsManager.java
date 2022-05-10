package ua.lviv.iot.labs.second.manager;

import java.util.List;

import ua.lviv.iot.labs.second.models.Animal;
import ua.lviv.iot.labs.second.models.DangerLevel;

public interface ITerrariumAnimalsManager {
	void addAnimals(List<Animal> animals);
	List<Animal> getAnimalsList();
	List<Animal> findByDangerLevel(DangerLevel dangerLevel);
	List<Animal> findByDaysNotFed(float daysNotFed);
	void sortByLifespan(boolean reversed);
}
