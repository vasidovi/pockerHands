package pokerHands.logic;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import pokerHands.models.PokerHand;
import pokerHands.models.HandCardGroup;

public class PokerHandComparator implements Comparator<PokerHand> {

	@Override
	public int compare(PokerHand o1, PokerHand o2) {
		if (o1.getRank() == o2.getRank()) {

			List<HandCardGroup> hand1Group = o1.groupCardsByValue();
			List<HandCardGroup> hand2Group = o2.groupCardsByValue();

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
