package pokerHands.logic;

import java.util.Collections;
import java.util.List;

import pokerHands.enums.PokerHandRanks;
import pokerHands.models.Card;
import pokerHands.models.Hand;
import pokerHands.models.HandCardGroup;

public class HandRanker {

	public void assignRank(Hand hand) {

		Collections.sort(hand.getCards());
		boolean isFlush = isHandFlush(hand);
		boolean isConsecutive = areCardValuesConsecutive(hand);

		if (isFlush && isConsecutive) {
			boolean hasAce = (hand.getCards().get(0).getValue() == 14);

			if (hasAce)
				hand.setRank(PokerHandRanks.ROYAL_FLUSH.rank());
			else
				hand.setRank(PokerHandRanks.STRAIGHT_FLUSH.rank());
		} else if (isFlush) {
			hand.setRank(PokerHandRanks.FLUSH.rank());
		} else if (isConsecutive) {
			hand.setRank(PokerHandRanks.STRAIGHT.rank());
		} else {

			HandUtility handUtility = new HandUtility();
			List<HandCardGroup> groupedSameValueCards = handUtility.groupCardsByValue(hand);

			Collections.sort(groupedSameValueCards);

			Integer highestCount = groupedSameValueCards.get(0).getCount();
			Integer secondHighestCount = groupedSameValueCards.get(1).getCount();

			if (highestCount == 4) {

				hand.setRank(PokerHandRanks.FOUR_OF_A_KIND.rank());
			} else if (highestCount == 3) {
				if (secondHighestCount == 2) {
					hand.setRank(PokerHandRanks.FULL_HOUSE.rank());
				} else {
					hand.setRank(PokerHandRanks.THREE_OF_A_KIND.rank());
				}
			} else if (highestCount == 2) {
				if (secondHighestCount == 2) {
					hand.setRank(PokerHandRanks.TWO_PAIRS.rank());
				} else {
					hand.setRank(PokerHandRanks.ONE_PAIR.rank());
				}
			} else {
				hand.setRank(PokerHandRanks.HIGH_CARD.rank());
			}
		}
	}

	private boolean isHandFlush(Hand hand) {
		List<Card> cards = hand.getCards();

		String suit = cards.get(0).getSuit();

		for (Card card : cards) {
			if (!card.getSuit().equals(suit))
				return false;
		}
		return true;
	}
/**  a regular straight, you can have an ace either high (A-K-Q-J-T) or low (5-4-3-2-1) cards */
	private boolean areCardValuesConsecutive(Hand hand) {

		List<Card> cards = hand.getCards();
		Collections.sort(cards);

		for (int i = 0; i < cards.size() - 1; i++) {

			Integer higherValue = cards.get(i).getValue();
			Integer lowerValue = cards.get(i + 1).getValue();

			if (higherValue - 1 != lowerValue && !(higherValue == 14 && lowerValue == 5)) {
				return false;
			}
		}
		return true;
	}

}
