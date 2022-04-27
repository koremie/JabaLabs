package ua.lviv.iot.labs.fifth.writer;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.List;

import ua.lviv.iot.labs.fifth.models.Animal;

public class AnimalWriter {
	public static void writeToFile(final List<Animal> terrariumAnimals) throws IOException {
		try (FileWriter writer = new FileWriter("TerrariumAnimals.csv", Charset.defaultCharset())) {
			terrariumAnimals.sort(Comparator.comparing(dwelling -> dwelling.getClass().getName()));
			String previousClassName = "";
			for (Animal animal : terrariumAnimals) {
				if (!animal.getClass().getSimpleName().equals(previousClassName)) {
					writer.write(animal.getHeaders());
					writer.write("\r\n");
					previousClassName = animal.getClass().getSimpleName();
				}
				writer.write(animal.toCSV());
				writer.write("\r\n");
			}
		}
	}
}
