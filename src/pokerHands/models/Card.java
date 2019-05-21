package pokerHands.models;

public class Card implements Comparable<Card> {

	Integer value;
	String suit;

	// optional
	// "face || royal/ rank"
//	String type;
//	String title;

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
	
	public Card(Integer value, String suit) {
		super();
		this.value = value;
		this.suit = suit;
	}

	@Override
	public int compareTo(Card otherCard) {

		if (this.getValue() == otherCard.getValue())
			return 0;
		else
			return this.getValue() < otherCard.getValue() ? 1 : -1;
	}

	@Override
	public String toString() {
		return "Card [value=" + value + ", suit=" + suit + "]";
	}
	
	

}
