package ua.lviv.iot.labs.second;

import ua.lviv.iot.labs.second.models.*;

public class Main {

	public static void main(String[] args) {
		Animal webFootedGecko = new Reptilia("Renny", "Pachydactylus rangei", "14cm", "2.3y", 
				"5 years", DangerLevel.LOW, "Insects", 1);
		Animal mourningGecko = new Reptilia("Sandy", "Lepidodactylus lugubris", "9cm", "2y", 
				"8+ years", DangerLevel.LOW, "Insects", 1.6f);
		Animal poisonDartFrog = new Amphibia("Spook", "Dendrobatidae", "5cm", "7y", 
				"10-15 years", DangerLevel.MODERATE, "Insects", 2);
		Animal pacmanFrog = new Amphibia("Sam", "Chacoan horned frog", "10cm", "4y", 
				"6-10 years", DangerLevel.MODERATE, "Insects, small mammals", 3.2f);
		Animal europeanTreeFrog = new Amphibia("Jumpy", "Hyla arborea", "32mm", "11mnth", 
				"20+ years", DangerLevel.LOW, "Insects", 2.3f);
		Animal tarantula = new Arachnida("Grey", "Tarantula", "43cm", "5y", 
				"15-25 years", DangerLevel.EXTREME, "Insects", 5, false);
		Animal scorpion = new Arachnida("Lol", "Heterometrus", "7cm", "8mnth", 
				"8 years", DangerLevel.HIGH, "Insects", 4, false);
		Animal millipede = new Diplopoda("Ash", "Anadenobolus monilicornis", "3cm", "6mnth", 
				"6 years", DangerLevel.CONSIDERABLE, "plants, insects", 8);
		Animal isopoda = new Malacostraca("UwU", "Armadillidium vulgare", "15mm", "3mnth", 
				"2-5 years", DangerLevel.LOW, "plants, animal wastes", 6);
		Animal mantis = new Insecta("Fighty", "European mantis", "9cm", "4y", 
				"12 years", DangerLevel.MODERATE, "Insects", 7, true);
	}
}
