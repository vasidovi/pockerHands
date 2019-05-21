package pokerHands.methods;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import pokerHands.models.Card;
import pokerHands.models.Hand;

public class PokerHandComparator implements Comparator<Hand>{

	@Override
	public int compare(Hand o1, Hand o2) {
		// TODO To transfer comparTo logic from hand to here, because Hand generic and the sorting
		// logic is specific to Poker
		return 0;
	}



}
