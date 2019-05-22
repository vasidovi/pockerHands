package pokerHands.models;

import java.util.List;

public class Player {

	String name;
	List<PokerHand> hands;

	public String getName() {
		return name;
	}

	public List<PokerHand> getHands() {
		return hands;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHand(List<PokerHand> hands) {
		this.hands = hands;
	}

	public Player(String name, List<PokerHand> hands) {
		super();
		this.name = name;
		this.hands = hands;
	}
}
