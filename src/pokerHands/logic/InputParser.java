package pokerHands.logic;

import java.util.HashMap;
import java.util.Map;

import pokerHands.enums.Suits;
import pokerHands.models.Card;

public class InputParser {

	static Map<String, Integer> faceValues;

	static {
		faceValues = new HashMap<String, Integer>();

		for (int i = 2; i < 10; i++)
			faceValues.put("" + i, i);

		faceValues.put("T", 10);
		faceValues.put("J", 11);
		faceValues.put("Q", 12);
		faceValues.put("K", 13);
		faceValues.put("A", 14);
	}

	public Card convertToCard(String abbreviation) {

		if (abbreviation.length() != 2) {
			System.err.print("Failed to parse card from " + abbreviation);
			return null;
		}

		String valueKey = Character.toString(abbreviation.charAt(0));
		Suits suitKey = Suits.valueOf(Character.toString(abbreviation.charAt(1)));

		if (faceValues.containsKey(valueKey) && suitKey != null) {

			Integer value = faceValues.get(valueKey);
			String suit = suitKey.title();
			return new Card(value, suit);
		} else {
			System.err.print("Failed to parse card from " + abbreviation);
			return null;
		}
	}
}
