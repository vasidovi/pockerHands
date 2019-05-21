package pokerHands.models;

import java.util.List;

public class Player {
	
	
	String name;
	List<Hand> hands;
	
	public String getName() {
		return name;
	}
	
	public List<Hand> getHands() {
		return hands;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setHand(List<Hand> hands) {
		this.hands = hands;
	}

	public Player(String name, List<Hand> hands) {
		super();
		this.name = name;
		this.hands = hands;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", hands=" + hands + "]";
	}

	
}
