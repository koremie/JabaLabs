package ua.lviv.iot.labs.second.manager.impl;

import java.util.*;

import ua.lviv.iot.labs.second.manager.ITerrariumAnimalsManager;
import ua.lviv.iot.labs.second.models.Animal;
import ua.lviv.iot.labs.second.models.DangerLevel;

public class TerrariumAnimalsManager implements ITerrariumAnimalsManager {

	private List<Animal> animalsList = new LinkedList<>();

	@Override
	public void addAnimals(List<Animal> animals) {
		animals.forEach(animal -> {
			if (animalsList.contains(animal) == false)
				animalsList.add(animal);
		});
	}

	@Override
	public List<Animal> getAnimalsList() {
		return animalsList;
	}

	@Override
	public List<Animal> findByDangerLevel(DangerLevel dangerLevel) {
		List<Animal> result = new LinkedList<>();
		for (Animal animal : animalsList) {
			if (dangerLevel.equals(animal.getDangerLevel()))
				result.add(animal);
		}
		if (result.isEmpty())
			System.out.println("No " + dangerLevel + " danger level animals found TwT");
		return result;
	}

	@Override
	public List<Animal> findByDaysNotFed(float daysNotFed) {
		List<Animal> result = new LinkedList<>();
		for (Animal animal : animalsList) {
			if (daysNotFed == animal.getDaysNotFed())
				result.add(animal);
		}
		if (result.isEmpty())
			System.out.println("No animals fed " + daysNotFed + " days before found TwT");
		return result;

	}

	@Override
	public void sortByLifespan(boolean reversed) {
		if (reversed)
			animalsList.sort(Collections.reverseOrder(Comparator.comparing(Animal::getLifespanInYears)));
		else
			animalsList.sort(Comparator.comparing(Animal::getLifespanInYears));
	}
}
