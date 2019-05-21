package pokerHands.models;

import java.util.Collections;
import java.util.List;

public class Hand implements Comparable<Hand> {

	List<Card> cards;
	Integer rank;

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}
	
	public Hand(List<Card> cards, Integer rank) {
		super();
		this.cards = cards;
		this.rank = rank;
	}
	
	

	@Override
	public String toString() {
		return "Hand [cards=" + cards + ", rank=" + rank + "]";
	}

	@Override
	public int compareTo(Hand otherHand) {

		if (this.rank == otherHand.rank) {

			List<Card> otherHandCards = otherHand.getCards();

			// sorts cards in hands
			// alternative is to sort out copies of hands
			Collections.sort(otherHandCards);
			Collections.sort(this.cards);
			
			
			for (int i = 0; i < this.cards.size(); i++) {

				Integer handCardValue = this.cards.get(i).getValue();
				Integer otherHandCardValue = otherHandCards.get(i).getValue();

				if (handCardValue != otherHandCardValue) {
					System.out.println("no macth");
					return handCardValue < otherHandCardValue ? 1 : -1;
				}
			}
			return 0;
			} else
			return this.rank < otherHand.rank ? 1 : -1;

	}

}
