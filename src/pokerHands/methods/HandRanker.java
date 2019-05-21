package pokerHands.methods;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pokerHands.models.Card;
import pokerHands.models.Hand;
import pokerHands.models.HandCardGroup;

public class HandRanker {
	
	static Map<String, Integer> ranks;
	
	static {
		ranks = new HashMap<String, Integer>();
		
		ranks.put("High Card", 1);
		ranks.put("One Pair", 2);
		ranks.put("Two Pairs", 3);
		ranks.put("Three of a Kind", 4);
		ranks.put("Straight", 5);
		ranks.put("Flush", 6);
		ranks.put("Full House", 7);
		ranks.put("Four of a Kind", 8);
		ranks.put("Straight Flush", 9);
		ranks.put("Royal Flush", 10);
		
	}

	public void assignRank(Hand hand) {

		Collections.sort(hand.getCards());
		boolean isFlush = isHandFlush(hand);
		boolean isConsecutive = areCardValuesConsecutive(hand);

		if (isFlush && isConsecutive) {
				 boolean hasAce = (hand.getCards().get(0).getValue() == 14);

				if (hasAce) 
					hand.setRank(ranks.get("Royal Flush"));
				else
					hand.setRank(ranks.get("Straight Flush"));
			} else if (isFlush) {
                hand.setRank(ranks.get("Flush"));
			} else if (isConsecutive) {
				hand.setRank(ranks.get("Straight"));
			} else {
		
			HandUtility handUtility = new HandUtility();
			List<HandCardGroup> groupedSameValueCards = handUtility.groupCardsByValue(hand);
			
			Collections.sort(groupedSameValueCards);
			
			Integer highestCount = groupedSameValueCards.get(0).getCount();
			Integer secondHighestCount = groupedSameValueCards.get(1).getCount();
			 
			 if (highestCount == 4) {
				 
				 hand.setRank(ranks.get("Four of a Kind"));
			 } else if (highestCount == 3) {
				 if (secondHighestCount == 2) {
					 hand.setRank(ranks.get("Full House"));
				 } else {
					 hand.setRank(ranks.get("Three of a Kind"));
				 }
			 } else if ( highestCount == 2) {
				 if (secondHighestCount == 2) {
					 hand.setRank(ranks.get("Two Pairs"));
				 } else {
					 hand.setRank(ranks.get("One Pair"));
				 }			 
			 } else {
				 hand.setRank(ranks.get("High Card"));
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

	private boolean areCardValuesConsecutive(Hand hand) {

		List<Card> cards = hand.getCards();
		Collections.sort(cards);
		
			
		for (int i = 0; i < cards.size()-1; i++) {
			
			Integer higherValue = cards.get(i).getValue();
			Integer lowerValue = cards.get(i+1).getValue();

			if (higherValue - 1 != lowerValue && !(higherValue == 14 && lowerValue == 5)){
			return false;
		}
		}

		return true;
	}

}
