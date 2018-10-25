package lab16io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountriesFile {

	public static List<String> toList(List<Country> cList) {
		List<String> lines = new ArrayList<>();
		for (Country country : cList) {
			String[] parts = { country.getName(), Integer.toString(country.getPop()),
					Double.toString(country.getGdp()) };
			lines.add(parts[0] + "~~~" + parts[1] + "~~~" + parts[2]);
		}
		return lines;
	}


	public static List<Country> read(Path filePath) throws IOException {
		try {
			List<String> lines = Files.readAllLines(filePath);
			List<Country> countries = new ArrayList<>();
			for (String line : lines) {
				String[] parts = line.split("~~~");
				Country c = new Country();
				c.setName(parts[0]);
				c.setPop(Integer.parseInt(parts[1]));
				c.setGdp(Double.parseDouble(parts[2]));
				countries.add(c);
			}
			return countries;

		} catch (NoSuchFileException ex) {
			return new ArrayList<>();
		} catch (IOException ex) {
			ex.printStackTrace();
			return new ArrayList<>();
		}
	}

	public static void writeApp(Path filePath, Country c) throws IOException {
		if (Files.notExists(filePath)) {
			Files.createFile(filePath);
		}
		String line = c.getName()+ "~~~" + c.getPop() + "~~~" + c.getGdp();
		List<String> linesToAdd = Arrays.asList(line);
		Files.write(filePath, linesToAdd, StandardOpenOption.APPEND);
	}

	public void writeTrun(Path filePath, List<Country> cList) throws IOException {
		if (Files.notExists(filePath)) {
			Files.createFile(filePath);
		}
		List<String> linesToAdd = toList(cList);
		Files.write(filePath, linesToAdd, StandardOpenOption.TRUNCATE_EXISTING);

	}

}
