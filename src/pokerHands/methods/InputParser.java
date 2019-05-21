package pokerHands.methods;

import java.util.HashMap;
import java.util.Map;

import pokerHands.models.Card;

public class InputParser {

	static Map<String, Integer> faceValues;
	static Map<String, String> suits;
	
	static {
		 faceValues = new HashMap<String, Integer>();

	for(int i = 2;i<10;i++)
		faceValues.put("" + i, i);
	
	faceValues.put("T",10);
	faceValues.put("J",11);
	faceValues.put("Q",12);
	faceValues.put("K",13);
	faceValues.put("A",14);

	    suits = new HashMap<>();

	    suits.put("C","Clubs");
	    suits.put("D","Diamonds");
	    suits.put("H","Hearts");
	    suits.put("S","Spades");
	}

	public Card convertToCard(String abbreviation) {
		 
		 if ( abbreviation.length() != 2) {
		     System.err.print("Failed to parse card from " + abbreviation);
			 return null;
		 }
		 
		 String valueKey = Character.toString(abbreviation.charAt(0));
		 String suitKey = Character.toString(abbreviation.charAt(1));
		 		 
		 if (faceValues.containsKey(valueKey) && suits.containsKey(suitKey)) {
 
			 Integer value = faceValues.get(valueKey);
			 String suit = suits.get(suitKey);
			 return new Card(value, suit); 
		 } else {		 
	     System.err.print("Failed to parse card from " + abbreviation);
		 return null;
		 }
	 }
}

