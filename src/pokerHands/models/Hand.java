package pokerHands.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import pokerHands.methods.HandUtility;

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
			
		    HandUtility handUtility = new HandUtility();
		    
		    List<HandCardGroup> hand1Group = handUtility.groupCardsByValue(this);
		    List<HandCardGroup> hand2Group = handUtility.groupCardsByValue(otherHand);
		    			
			Collections.sort(hand1Group);
			Collections.sort(hand2Group);
			
			int i = 0; 
			while( hand1Group.get(i).getCount() > 1) {
				Integer handCardValue = hand1Group.get(i).getCardValue();
				Integer otherHandCardValue = hand2Group.get(i).getCardValue();
            
				if ( handCardValue != otherHandCardValue) {
					return handCardValue < otherHandCardValue ? 1 : -1;
				}
				i++;
			}
			
			for (int j = i; j < this.cards.size(); j++) {

				Integer handCardValue = hand1Group.get(j).getCardValue();
				Integer otherHandCardValue = hand2Group.get(j).getCardValue();

				if (handCardValue != otherHandCardValue) {
					return handCardValue < otherHandCardValue ? 1 : -1;
				}
			}
			return 0;
			} else
			return this.rank < otherHand.rank ? 1 : -1;
	}

}
