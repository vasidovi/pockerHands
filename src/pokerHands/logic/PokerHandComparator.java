package pokerHands.logic;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import pokerHands.models.Hand;
import pokerHands.models.HandCardGroup;

public class PokerHandComparator implements Comparator<Hand> {

	@Override
	public int compare(Hand o1, Hand o2) {
		if (o1.getRank() == o2.getRank()) {

			HandUtility handUtility = new HandUtility();

			List<HandCardGroup> hand1Group = handUtility.groupCardsByValue(o1);
			List<HandCardGroup> hand2Group = handUtility.groupCardsByValue(o2);

			Collections.sort(hand1Group);
			Collections.sort(hand2Group);

			int i = 0;
			while (hand1Group.get(i).getCount() > 1) {
				Integer handCardValue = hand1Group.get(i).getCardValue();
				Integer otherHandCardValue = hand2Group.get(i).getCardValue();

				if (handCardValue != otherHandCardValue) {
					return handCardValue < otherHandCardValue ? 1 : -1;
				}
				i++;
			}

			for (int j = i; j < o1.getCards().size(); j++) {

				Integer handCardValue = hand1Group.get(j).getCardValue();
				Integer otherHandCardValue = hand2Group.get(j).getCardValue();

				if (handCardValue != otherHandCardValue) {
					return handCardValue < otherHandCardValue ? 1 : -1;
				}
			}
			return 0;
		} else
			return o1.getRank() < o2.getRank() ? 1 : -1;
	}
}
