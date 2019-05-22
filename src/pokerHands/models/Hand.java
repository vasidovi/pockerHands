package pokerHands.models;

import java.util.List;

public class Hand {
	
	List<PokerCard> cards;
	
	public List<PokerCard> getCards() {
		return cards;
	}

	public void setCards(List<PokerCard> cards) {
		this.cards = cards;
	}

	public Hand(List<PokerCard> cards) {
		super();
		this.cards = cards;
	}
	
}
