package ua.lviv.iot.labs.fifth.manager;

import java.util.List;

import ua.lviv.iot.labs.fifth.models.Animal;
import ua.lviv.iot.labs.fifth.models.DangerLevel;
import ua.lviv.iot.labs.fifth.models.SortingOrder;

public interface ITerrariumAnimalsManager {
    void addAnimals(List<Animal> animals);

    List<Animal> getAnimalsList();

    List<Animal> findByDangerLevel(DangerLevel dangerLevel);

    List<Animal> findByDaysNotFed(float daysNotFed);

    void sortByLifespan(SortingOrder sortOrder);
}
