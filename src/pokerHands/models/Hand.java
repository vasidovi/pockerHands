package pokerHands.models;

import java.util.List;

public class Hand {

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
}
