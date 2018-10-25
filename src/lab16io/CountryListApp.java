package lab16io;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class CountryListApp {
	static String done = "\nAre you finished using the Country Adder?";
	static boolean finished = false;
	private static Path filePath = Paths.get("Countries.txt");
		static Scanner read = new Scanner(System.in);
	public static void main(String[] args) throws IOException {


		System.out.println("Welcome to our Country List Maker App Thing!");
		do {
			System.out.println("\nCountry Adder App Menu");
			System.out.println("======================");
			System.out.println("1. List\nChoose this to display a list of the Countries saved to the file.");
			System.out.println("2. Add\nChoose this to enter a country's name to our file of countries.");
			System.out.println("3. Replace\nChoose this to completely replace the current file with your own countries.");
			System.out.println("4. Quit\nQuit, natch.");
			String choice = read.nextLine();

			if (choice.equalsIgnoreCase("1") || choice.equalsIgnoreCase("list")) {
				list();
				finished = Vali.checkYes(Vali.getString(read, done));
			}

			else if (choice.equalsIgnoreCase("4") || choice.equalsIgnoreCase("quit")) {
				finished = Vali.checkYes(Vali.getString(read, done));
			}

			else if (choice.equalsIgnoreCase("2")) {
				String country = Vali.getString(read, "What country would you like to add?");
				if (country.matches("[A-Za-z]+[.]?(\\s[A-Za-z]+)?")) {
					listAdd(country);
				}

			} else if (choice.matches("[A-Za-z]+[.]?(\\s[A-Za-z]+)?")) {
				listAdd(choice);
			} else {
				System.out.println("Sorry, we didn't quite get that. Let's try again. \n");
			}
		} while (!finished);
System.out.println("Thank you for using our Country Adder App. \n\n'Later.");
read.close();
	}

	private static void listAdd(String country) throws IOException {
		Country newC = new Country();
		newC.setName(country);
		newC.setPop(Vali.getInt(read, "What is the population of " + country + "?"));
		newC.setGdp(Vali.getDouble(read, "What is the Gross Domestic Product of " + country + "?"));
		CountriesFile.writeApp(filePath, newC);

	}

	private static void list() throws IOException {
		List<Country> cList = CountriesFile.read(filePath);
		for (Country country : cList) {
			System.out.println(country);
		}
	}

}
