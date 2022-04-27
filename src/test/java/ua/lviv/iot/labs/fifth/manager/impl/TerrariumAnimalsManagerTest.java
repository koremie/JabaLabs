package ua.lviv.iot.labs.fifth.manager.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import java.util.*;

import ua.lviv.iot.labs.fifth.models.*;

class TerrariumAnimalsManagerTest {
	private TerrariumAnimalsManager manager;
	private List<Animal> animalsList;

	@BeforeEach
	void setUp() throws Exception {
		manager = new TerrariumAnimalsManager();
		animalsList = Arrays.asList(
				new Reptilia("Renny", "Pachydactylus rangei", "14cm", "2.3y", 5, DangerLevel.LOW, "Insects", 1, true),
				new Reptilia("Sandy", "Lepidodactylus lugubris", "9cm", "2y", 8, DangerLevel.LOW, "Insects", 1.6f,
						true),
				new Amphibia("Spook", "Dendrobatidae", "5cm", "7y", 13, DangerLevel.MODERATE, "Insects", 2, true),
				new Amphibia("Sam", "Chacoan horned frog", "10cm", "4y", 7, DangerLevel.MODERATE,
						"Insects and small mammals", 3.2f, true),
				new Amphibia("Jumpy", "Hyla arborea", "32mm", "11mnth", 20, DangerLevel.LOW, "Insects", 2.3f, true),
				new Arachnida("Grey", "Tarantula", "43cm", "5y", 24, DangerLevel.EXTREME, "Insects", 5, true),
				new Arachnida("Lol", "Heterometrus", "7cm", "8mnth", 9, DangerLevel.HIGH, "Insects", 4, false),
				new Diplopoda("Ash", "Anadenobolus monilicornis", "3cm", "6mnth", 6, DangerLevel.CONSIDERABLE,
						"plants and insects", 8, 160),
				new Malacostraca("UwU", "Armadillidium vulgare", "15mm", "3mnth", 2, DangerLevel.LOW,
						"plants and animal wastes", 6, false),
				new Insecta("Fighty", "European mantis", "9cm", "4y", 12, DangerLevel.MODERATE, "Insects", 7, true));
		manager.addAnimals(animalsList);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void addAnimalsTest() {
		assertFalse(manager.getAnimalsList().isEmpty());
		assertEquals(10, manager.getAnimalsList().size());
		for (Animal animal : animalsList)
			assertTrue(manager.getAnimalsList().contains(animal));
	}

	@Test
	void findByDangerLevelNotNullTest() {
		List<Animal> lowDangerousLevelAnimals = manager.findByDangerLevel(DangerLevel.LOW);
		assertNotNull(lowDangerousLevelAnimals);
	}

	@Test
	void findByDangerLevelTest() {
		List<Animal> lowDangerousLevelAnimals = manager.findByDangerLevel(DangerLevel.LOW);
		assertEquals(4, lowDangerousLevelAnimals.size());
		assertTrue(lowDangerousLevelAnimals.contains(
				new Reptilia("Renny", "Pachydactylus rangei", "14cm", "2.3y", 5, DangerLevel.LOW, "Insects", 1, true)));
		assertTrue(lowDangerousLevelAnimals.contains(new Reptilia("Sandy", "Lepidodactylus lugubris", "9cm", "2y", 8,
				DangerLevel.LOW, "Insects", 1.6f, true)));
		assertTrue(lowDangerousLevelAnimals.contains(
				new Amphibia("Jumpy", "Hyla arborea", "32mm", "11mnth", 20, DangerLevel.LOW, "Insects", 2.3f, true)));
		assertTrue(lowDangerousLevelAnimals.contains(new Malacostraca("UwU", "Armadillidium vulgare", "15mm", "3mnth",
				2, DangerLevel.LOW, "plants and animal wastes", 6, false)));
	}

	@Test
	void findByDangerLevelNoResultTest() {
		TerrariumAnimalsManager emptyManager = new TerrariumAnimalsManager();
		assertTrue(emptyManager.findByDangerLevel(DangerLevel.EXTREME).isEmpty());
	}

	@Test
	void findByDaysNotFedNotNullTest() {
		List<Animal> animalsNotFedFor5Days = manager.findByDaysNotFed(5);
		assertNotNull(animalsNotFedFor5Days);
	}

	@Test
	void findByDaysNotFedTest() {
		List<Animal> animalsNotFedFor5Days = manager.findByDaysNotFed(5);
		assertEquals(1, animalsNotFedFor5Days.size());
		assertTrue(animalsNotFedFor5Days.contains(
				new Arachnida("Grey", "Tarantula", "43cm", "5y", 24, DangerLevel.EXTREME, "Insects", 5, false)));
	}

	@Test
	void findByDaysNotFedNoResultsTest() {
		TerrariumAnimalsManager emptyManager = new TerrariumAnimalsManager();
		assertTrue(emptyManager.findByDaysNotFed(0).isEmpty());
	}

	@Test
	void sortByLifespanAsc() {
		manager.sortByLifespan(SortingOrder.ASCENDING);
		assertEquals(
				"Name: UwU, species: Armadillidium vulgare, size: 15mm, age: 3mnth, lifespanInYears: 2, "
						+ "dangerLevel: LOW, diet: plants and animal wastes, daysNotFed: 6.0, hasClaws: false",
				manager.getAnimalsList().get(0).toString());
		assertEquals(
				"Name: Renny, species: Pachydactylus rangei, size: 14cm, age: 2.3y, lifespanInYears: 5, "
						+ "dangerLevel: LOW, diet: Insects, daysNotFed: 1.0, resetsSkin: true",
				manager.getAnimalsList().get(1).toString());
		assertEquals(
				"Name: Ash, species: Anadenobolus monilicornis, size: 3cm, age: 6mnth, lifespanInYears: 6, "
						+ "dangerLevel: CONSIDERABLE, diet: plants and insects, daysNotFed: 8.0, legCount: 160",
				manager.getAnimalsList().get(2).toString());
		assertEquals(
				"Name: Sam, species: Chacoan horned frog, size: 10cm, age: 4y, lifespanInYears: 7, "
						+ "dangerLevel: MODERATE, diet: Insects and small mammals, daysNotFed: 3.2, producesSlime: true",
				manager.getAnimalsList().get(3).toString());
		assertEquals(
				"Name: Sandy, species: Lepidodactylus lugubris, size: 9cm, age: 2y, lifespanInYears: 8, "
						+ "dangerLevel: LOW, diet: Insects, daysNotFed: 1.6, resetsSkin: true",
				manager.getAnimalsList().get(4).toString());
		assertEquals(
				"Name: Lol, species: Heterometrus, size: 7cm, age: 8mnth, lifespanInYears: 9, "
						+ "dangerLevel: HIGH, diet: Insects, daysNotFed: 4.0, weavesWeb: false",
				manager.getAnimalsList().get(5).toString());
		assertEquals(
				"Name: Fighty, species: European mantis, size: 9cm, age: 4y, lifespanInYears: 12, "
						+ "dangerLevel: MODERATE, diet: Insects, daysNotFed: 7.0, hasWings: true",
				manager.getAnimalsList().get(6).toString());
		assertEquals(
				"Name: Spook, species: Dendrobatidae, size: 5cm, age: 7y, lifespanInYears: 13, "
						+ "dangerLevel: MODERATE, diet: Insects, daysNotFed: 2.0, producesSlime: true",
				manager.getAnimalsList().get(7).toString());
		assertEquals(
				"Name: Jumpy, species: Hyla arborea, size: 32mm, age: 11mnth, lifespanInYears: 20, "
						+ "dangerLevel: LOW, diet: Insects, daysNotFed: 2.3, producesSlime: true",
				manager.getAnimalsList().get(8).toString());
		assertEquals(
				"Name: Grey, species: Tarantula, size: 43cm, age: 5y, lifespanInYears: 24, "
						+ "dangerLevel: EXTREME, diet: Insects, daysNotFed: 5.0, weavesWeb: true",
				manager.getAnimalsList().get(9).toString());
	}

	@Test
	void sortByLifespanDes() {
		manager.sortByLifespan(SortingOrder.DESCENDING);
		assertEquals(
				"Name: UwU, species: Armadillidium vulgare, size: 15mm, age: 3mnth, lifespanInYears: 2, "
						+ "dangerLevel: LOW, diet: plants and animal wastes, daysNotFed: 6.0, hasClaws: false",
				manager.getAnimalsList().get(9).toString());
		assertEquals(
				"Name: Renny, species: Pachydactylus rangei, size: 14cm, age: 2.3y, lifespanInYears: 5, "
						+ "dangerLevel: LOW, diet: Insects, daysNotFed: 1.0, resetsSkin: true",
				manager.getAnimalsList().get(8).toString());
		assertEquals(
				"Name: Ash, species: Anadenobolus monilicornis, size: 3cm, age: 6mnth, lifespanInYears: 6, "
						+ "dangerLevel: CONSIDERABLE, diet: plants and insects, daysNotFed: 8.0, legCount: 160",
				manager.getAnimalsList().get(7).toString());
		assertEquals(
				"Name: Sam, species: Chacoan horned frog, size: 10cm, age: 4y, lifespanInYears: 7, "
						+ "dangerLevel: MODERATE, diet: Insects and small mammals, daysNotFed: 3.2, producesSlime: true",
				manager.getAnimalsList().get(6).toString());
		assertEquals(
				"Name: Sandy, species: Lepidodactylus lugubris, size: 9cm, age: 2y, lifespanInYears: 8, "
						+ "dangerLevel: LOW, diet: Insects, daysNotFed: 1.6, resetsSkin: true",
				manager.getAnimalsList().get(5).toString());
		assertEquals(
				"Name: Lol, species: Heterometrus, size: 7cm, age: 8mnth, lifespanInYears: 9, "
						+ "dangerLevel: HIGH, diet: Insects, daysNotFed: 4.0, weavesWeb: false",
				manager.getAnimalsList().get(4).toString());
		assertEquals(
				"Name: Fighty, species: European mantis, size: 9cm, age: 4y, lifespanInYears: 12, "
						+ "dangerLevel: MODERATE, diet: Insects, daysNotFed: 7.0, hasWings: true",
				manager.getAnimalsList().get(3).toString());
		assertEquals(
				"Name: Spook, species: Dendrobatidae, size: 5cm, age: 7y, lifespanInYears: 13, "
						+ "dangerLevel: MODERATE, diet: Insects, daysNotFed: 2.0, producesSlime: true",
				manager.getAnimalsList().get(2).toString());
		assertEquals(
				"Name: Jumpy, species: Hyla arborea, size: 32mm, age: 11mnth, lifespanInYears: 20, "
						+ "dangerLevel: LOW, diet: Insects, daysNotFed: 2.3, producesSlime: true",
				manager.getAnimalsList().get(1).toString());
		assertEquals(
				"Name: Grey, species: Tarantula, size: 43cm, age: 5y, lifespanInYears: 24, "
						+ "dangerLevel: EXTREME, diet: Insects, daysNotFed: 5.0, weavesWeb: true",
				manager.getAnimalsList().get(0).toString());
	}
}
