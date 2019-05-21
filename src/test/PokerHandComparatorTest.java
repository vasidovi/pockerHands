package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import pokerHands.logic.InputParser;
import pokerHands.logic.PokerHandComparator;
import pokerHands.models.Card;
import pokerHands.models.Hand;

public class PokerHandComparatorTest {

	InputParser parser = new InputParser();
	Card aceD = parser.convertToCard("AD");
	Card twoD = parser.convertToCard("2D");
	Card fiveD = parser.convertToCard("5D");

	List<Card> cardHi = new ArrayList<>();
	List<Card> cardLow = new ArrayList<>();
	List<Card> cardFullHouseHiTriplets = new ArrayList<>();
	List<Card> cardFullHouseHiPair = new ArrayList<>();

	@Test
	public void test1() {
		
	for(int i = 0;i<5;i++){
		cardHi.add(aceD);
		cardLow.add(twoD);
	}
	
	for(int i = 0;i<3;i++){
		cardFullHouseHiTriplets.add(fiveD);
		cardFullHouseHiPair.add(twoD);
	}
	
	for(int i = 0;i<2;i++){
		cardFullHouseHiTriplets.add(twoD);
		cardFullHouseHiPair.add(aceD);
	}
	

	Hand highCardValue = new Hand(cardHi, 0);
	Hand lowCardValue = new Hand(cardLow, 0);

	Hand highRank = new Hand(cardLow, 10);
	Hand lowRank = new Hand(cardHi, 1);
	
	Hand fullHouseHiTriplets = new Hand(cardFullHouseHiTriplets,7);
	Hand fullHoushHiPair = new Hand(cardFullHouseHiPair,7);

	PokerHandComparator comparator = new PokerHandComparator();
		
        // assert statements
        assertEquals(-1, comparator.compare(highCardValue, lowCardValue), "5 'ace' cards rank higher that 5 '2' cards");;
        assertEquals(-1, comparator.compare(highRank, lowRank), "Rank 10 hand with '2' higher than rank 1 with 'ace'");
        assertEquals(-1, comparator.compare(fullHouseHiTriplets, fullHoushHiPair), "For Full House '5' valued triplet take priority over 'ace' ranked pair");
		
	}
}

