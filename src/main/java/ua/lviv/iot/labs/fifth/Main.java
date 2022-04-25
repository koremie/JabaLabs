package ua.lviv.iot.labs.fifth;

import java.util.*;

import ua.lviv.iot.labs.fifth.manager.impl.TerrariumAnimalsManager;
import ua.lviv.iot.labs.fifth.models.*;

public class Main {

	public static void main(String[] args) {
		TerrariumAnimalsManager manager = new TerrariumAnimalsManager();

		List<Animal> animalsList = Arrays.asList(
				new Reptilia("Sandy", "Lepidodactylus lugubris", "9cm", "2y", 8, DangerLevel.LOW, "Insects", 1.6f,
						true),
				new Reptilia("Renny", "Pachydactylus rangei", "14cm", "2.3y", 5, DangerLevel.LOW, "Insects", 1, true),
				new Amphibia("Spook", "Dendrobatidae", "5cm", "7y", 13, DangerLevel.MODERATE, "Insects", 2, true),
				new Amphibia("Sam", "Chacoan horned frog", "10cm", "4y", 7, DangerLevel.MODERATE,
						"Insects, small mammals", 3.2f, true),
				new Amphibia("Jumpy", "Hyla arborea", "32mm", "11mnth", 20, DangerLevel.LOW, "Insects", 2.3f, true),
				new Arachnida("Grey", "Tarantula", "43cm", "5y", 24, DangerLevel.EXTREME, "Insects", 5, true),
				new Arachnida("Lol", "Heterometrus", "7cm", "8mnth", 9, DangerLevel.HIGH, "Insects", 4, false),
				new Diplopoda("Ash", "Anadenobolus monilicornis", "3cm", "6mnth", 6, DangerLevel.CONSIDERABLE,
						"plants, insects", 8, 160),
				new Malacostraca("UwU", "Armadillidium vulgare", "15mm", "3mnth", 2, DangerLevel.LOW,
						"plants, animal wastes", 6, false),
				new Insecta("Fighty", "European mantis", "9cm", "4y", 12, DangerLevel.MODERATE, "Insects", 7, true));

		manager.addAnimals(animalsList);
		System.out.println();
		manager.getAnimalsList().forEach(System.out::println);
		System.out.println("\nAll low dangerous animals: ");
		manager.findByDangerLevel(DangerLevel.LOW).forEach(System.out::println);
		System.out.println("-------------------------------------");
		System.out.println("All animals not fed for 5 days: ");
		manager.findByDaysNotFed(5).forEach(System.out::println);
		System.out.println("-------------------------------------");
		System.out.println("Animals sorted by their lifespan:");
		manager.sortByLifespan(SortingOrder.DESCENDING);
		manager.getAnimalsList().forEach(System.out::println);
	}
}
