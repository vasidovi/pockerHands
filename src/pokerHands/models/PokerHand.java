package pokerHands.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pokerHands.enums.PokerHandRanks;

public class PokerHand extends Hand {
	Integer rank;
	
	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public PokerHand(List<PokerCard> cards, Integer rank) {
		super(cards);
		this.rank = rank;
	}

	public void assignRank() {

		Collections.sort(getCards());
		boolean isFlush = isHandFlush();
		boolean isConsecutive = areCardValuesConsecutive();

		if (isFlush && isConsecutive) {
			boolean hasAce = (getCards().get(0).getValue() == 14);

			if (hasAce)
				setRank(PokerHandRanks.ROYAL_FLUSH.rank());
			else
				setRank(PokerHandRanks.STRAIGHT_FLUSH.rank());
		} else if (isFlush) {
			setRank(PokerHandRanks.FLUSH.rank());
		} else if (isConsecutive) {
			setRank(PokerHandRanks.STRAIGHT.rank());
		} else {

			List<HandCardGroup> groupedSameValueCards = groupCardsByValue();

			Collections.sort(groupedSameValueCards);

			Integer highestCount = groupedSameValueCards.get(0).getCount();
			Integer secondHighestCount = groupedSameValueCards.get(1).getCount();

			if (highestCount == 4) {

				setRank(PokerHandRanks.FOUR_OF_A_KIND.rank());
			} else if (highestCount == 3) {
				if (secondHighestCount == 2) {
					setRank(PokerHandRanks.FULL_HOUSE.rank());
				} else {
					setRank(PokerHandRanks.THREE_OF_A_KIND.rank());
				}
			} else if (highestCount == 2) {
				if (secondHighestCount == 2) {
					setRank(PokerHandRanks.TWO_PAIRS.rank());
				} else {
					setRank(PokerHandRanks.ONE_PAIR.rank());
				}
			} else {
				setRank(PokerHandRanks.HIGH_CARD.rank());
			}
		}
	}

	private boolean isHandFlush() {

		String suit = cards.get(0).getSuit();

		for (PokerCard card : cards) {
			if (!card.getSuit().equals(suit))
				return false;
		}
		return true;
	}

	public List<HandCardGroup> groupCardsByValue() {

		Map<Integer, Integer> valueCountMap = new HashMap<>();

		for (PokerCard card : getCards()) {

			Integer value = card.getValue();
			Integer count = valueCountMap.getOrDefault(value, 0) + 1;

			valueCountMap.put(value, count);
		}

		List<HandCardGroup> handCardGroups = new ArrayList<>();

		for (Integer value : valueCountMap.keySet()) {

			HandCardGroup handCardGroup = new HandCardGroup(value, valueCountMap.get(value));
			handCardGroups.add(handCardGroup);
		}

		return handCardGroups;
	}

	/**
	 * a regular straight, you can have an ace either high (A-K-Q-J-T) or low
	 * (5-4-3-2-1) cards
	 */
	private boolean areCardValuesConsecutive() {

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
