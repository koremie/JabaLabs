package ua.lviv.iot.labs.fifth.writer;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.labs.fifth.models.*;

class AnimalWriterTest {
	private List<Animal> happyPathScenario;
	private List<Animal> arachnidaOnlyList;

	@BeforeEach
	void setUp() throws Exception {
		happyPathScenario = Arrays.asList(
				new Reptilia("Sandy", "Lepidodactylus lugubris", "9cm", "2y", 8, DangerLevel.LOW, "Insects", 1.6f,
						true),
				new Reptilia("Renny", "Pachydactylus rangei", "14cm", "2.3y", 5, DangerLevel.LOW, "Insects", 1, true),
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
				new Insecta("Fighty", "European mantis", "9cm", "4y", 12, DangerLevel.MODERATE, "Insects", 7, true),
				new Insecta("Cutie", "European mantis", "10cm", "3y", 12, DangerLevel.MODERATE, "Insects", 6.5f, true));
		arachnidaOnlyList = Arrays.asList(
				new Arachnida("Grey", "Tarantula", "43cm", "5y", 24, DangerLevel.EXTREME, "Insects", 5, true),
				new Arachnida("Lol", "Heterometrus", "7cm", "8mnth", 9, DangerLevel.HIGH, "Insects", 4, false),
				new Arachnida("Spidey", "Tarantula", "43cm", "4y", 24, DangerLevel.EXTREME, "Insects", 5, true));
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void writeGeneralAnimalCSVTest() throws IOException {
		AnimalWriter.writeToFile(happyPathScenario);

		try (FileReader expectedReader = new FileReader(
				"C:\\Users\\Lenovo\\eclipse-workspace\\TerrariumAnimal\\src\\test\\resources\\expectedTerrariumAnimals.csv");
				BufferedReader expectedBR = new BufferedReader(expectedReader);
				FileReader actualReader = new FileReader("TerrariumAnimals.csv");
				BufferedReader actualBR = new BufferedReader(actualReader)) {
			String expectedLine;
			while ((expectedLine = expectedBR.readLine()) != null) {
				assertEquals(expectedLine, actualBR.readLine());
			}
		}
	}

	@Test
	void writeArachnidaOnlyCSVTest() throws IOException {
		AnimalWriter.writeToFile(arachnidaOnlyList);

		try (FileReader expectedReader = new FileReader(
				"C:\\Users\\Lenovo\\eclipse-workspace\\TerrariumAnimal\\src\\test\\resources\\expectedArachnidaOnly.csv");
				BufferedReader expectedBR = new BufferedReader(expectedReader);
				FileReader actualReader = new FileReader("TerrariumAnimals.csv");
				BufferedReader actualBR = new BufferedReader(actualReader)) {
			String expectedLine;
			while ((expectedLine = expectedBR.readLine()) != null) {
				assertEquals(expectedLine, actualBR.readLine());
			}
		}
	}
	
	@Test
	void writeEmptyCSVTest() throws IOException {
		AnimalWriter.writeToFile(new LinkedList<>());

		try (FileReader expectedReader = new FileReader(
				"C:\\Users\\Lenovo\\eclipse-workspace\\TerrariumAnimal\\src\\test\\resources\\expectedEmpty.csv");
				BufferedReader expectedBR = new BufferedReader(expectedReader);
				FileReader actualReader = new FileReader("TerrariumAnimals.csv");
				BufferedReader actualBR = new BufferedReader(actualReader)) {
				assertEquals(expectedBR.readLine(), actualBR.readLine());
		}
	}
}
