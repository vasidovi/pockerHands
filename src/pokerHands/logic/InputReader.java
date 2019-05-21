package pokerHands.logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pokerHands.models.Card;

public class InputReader {
	
	public List<Card> readInput(String path, InputParser inputParser) {

		String line = null;

		try {
			FileReader fileReader = new FileReader(path);

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			List<Card> cards = new ArrayList<>();

			while ((line = bufferedReader.readLine()) != null) {

				String[] abbreviationsInLine = line.split(" ");

				for (String abbreviation : abbreviationsInLine) {
					
					Card card = inputParser.convertToCard(abbreviation);
					cards.add(card);
				}
			}

			bufferedReader.close();
			return cards;
		}

		catch (FileNotFoundException e1) {
			System.err.println("Unable to open file '" + path + "'");
		} catch (IOException e2) {
			System.err.println("Error reading file '" + path + "'");
		}
		return null;
	}
}
