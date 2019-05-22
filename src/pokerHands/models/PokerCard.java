package pokerHands.models;

public class PokerCard implements Comparable<PokerCard> {

	Integer value;
	String suit;

	public Integer getValue() {
		return value;
	}

	public String getSuit() {
		return suit;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public PokerCard(Integer value, String suit) {
		super();
		this.value = value;
		this.suit = suit;
	}

	/** Sorts in descending order */
	@Override
	public int compareTo(PokerCard otherCard) {

		if (this.getValue() == otherCard.getValue())
			return 0;
		else
			return this.getValue() < otherCard.getValue() ? 1 : -1;
	}

}
