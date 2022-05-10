package ua.lviv.iot.labs.second;

import java.util.*;

import ua.lviv.iot.labs.second.manager.impl.TerrariumAnimalsManager;
import ua.lviv.iot.labs.second.models.*;

public class Main {

	public static void main(String[] args) {
		List<Animal> animalsList = new LinkedList<>();
		TerrariumAnimalsManager manager = new TerrariumAnimalsManager();

		Animal webFootedGecko = new Reptilia("Renny", "Pachydactylus rangei", "14cm", "2.3y", 5, DangerLevel.LOW,
				"Insects", 1);
		Animal mourningGecko = new Reptilia("Sandy", "Lepidodactylus lugubris", "9cm", "2y", 8, DangerLevel.LOW,
				"Insects", 1.6f);
		Animal poisonDartFrog = new Amphibia("Spook", "Dendrobatidae", "5cm", "7y", 13, DangerLevel.MODERATE, "Insects",
				2);
		Animal pacmanFrog = new Amphibia("Sam", "Chacoan horned frog", "10cm", "4y", 7, DangerLevel.MODERATE,
				"Insects, small mammals", 3.2f);
		Animal europeanTreeFrog = new Amphibia("Jumpy", "Hyla arborea", "32mm", "11mnth", 20, DangerLevel.LOW,
				"Insects", 2.3f);
		Animal tarantula = new Arachnida("Grey", "Tarantula", "43cm", "5y", 20, DangerLevel.EXTREME, "Insects", 5,
				false);
		Animal scorpion = new Arachnida("Lol", "Heterometrus", "7cm", "8mnth", 8, DangerLevel.HIGH, "Insects", 4,
				false);
		Animal millipede = new Diplopoda("Ash", "Anadenobolus monilicornis", "3cm", "6mnth", 6,
				DangerLevel.CONSIDERABLE, "plants, insects", 8);
		Animal isopoda = new Malacostraca("UwU", "Armadillidium vulgare", "15mm", "3mnth", 2, DangerLevel.LOW,
				"plants, animal wastes", 6);
		Animal mantis = new Insecta("Fighty", "European mantis", "9cm", "4y", 12, DangerLevel.MODERATE, "Insects", 7,
				true);

		animalsList.add(webFootedGecko);
		animalsList.add(mourningGecko);
		animalsList.add(poisonDartFrog);
		animalsList.add(pacmanFrog);
		animalsList.add(europeanTreeFrog);
		animalsList.add(tarantula);
		animalsList.add(scorpion);
		animalsList.add(millipede);
		animalsList.add(mantis);
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
		manager.sortByLifespan(true);
		manager.getAnimalsList().forEach(System.out::println);
	}
}
