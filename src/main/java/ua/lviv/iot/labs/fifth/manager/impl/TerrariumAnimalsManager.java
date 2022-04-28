package ua.lviv.iot.labs.fifth.manager.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import ua.lviv.iot.labs.fifth.manager.ITerrariumAnimalsManager;
import ua.lviv.iot.labs.fifth.models.Animal;
import ua.lviv.iot.labs.fifth.models.DangerLevel;
import ua.lviv.iot.labs.fifth.models.SortingOrder;

public class TerrariumAnimalsManager implements ITerrariumAnimalsManager {
    private List<Animal> animalsList = new LinkedList<>();

    public List<Animal> getAnimalsList() {
        return new LinkedList<>(animalsList);
    }

    @Override
    public void addAnimals(List<Animal> animals) {
        animals.forEach(animal -> {
            if (animalsList.contains(animal) == false)
                animalsList.add(animal);
        });
    }

    @Override
    public List<Animal> findByDangerLevel(DangerLevel dangerLevel) {
        List<Animal> result = animalsList.stream().filter(animal -> dangerLevel.equals(animal.getDangerLevel()))
                .collect(Collectors.toList());
        if (result.isEmpty())
            System.out.println("No " + dangerLevel + " danger level animals found TwT");
        return result;
    }

    @Override
    public List<Animal> findByDaysNotFed(float daysNotFed) {
        List<Animal> result = animalsList.stream().filter(animal -> daysNotFed == animal.getDaysNotFed())
                .collect(Collectors.toList());
        if (result.isEmpty())
            System.out.println("No animals fed " + daysNotFed + " days before found TwT");
        return result;
    }

    @Override
    public void sortByLifespan(SortingOrder sortOrder) {
        switch (sortOrder) {
        case ASCENDING:
            animalsList.sort(Comparator.comparing(Animal::getLifespanInYears));
            break;
        case DESCENDING:
            animalsList.sort(Collections.reverseOrder(Comparator.comparing(Animal::getLifespanInYears)));
            break;
        }
    }
}
