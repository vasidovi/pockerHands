package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import pokerHands.logic.InputParser;
import pokerHands.logic.PokerHandComparator;
import pokerHands.models.PokerCard;
import pokerHands.models.PokerHand;

public class PokerHandComparatorTest {

	InputParser parser = new InputParser();
	PokerCard aceD = parser.convertToCard("AD");
	PokerCard twoD = parser.convertToCard("2D");
	PokerCard fiveD = parser.convertToCard("5D");

	List<PokerCard> cardHi = new ArrayList<>();
	List<PokerCard> cardLow = new ArrayList<>();
	List<PokerCard> cardFullHouseHiTriplets = new ArrayList<>();
	List<PokerCard> cardFullHouseHiPair = new ArrayList<>();

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
	

	PokerHand highCardValue = new PokerHand(cardHi, 0);
	PokerHand lowCardValue = new PokerHand(cardLow, 0);

	PokerHand highRank = new PokerHand(cardLow, 10);
	PokerHand lowRank = new PokerHand(cardHi, 1);
	
	PokerHand fullHouseHiTriplets = new PokerHand(cardFullHouseHiTriplets,7);
	PokerHand fullHoushHiPair = new PokerHand(cardFullHouseHiPair,7);

	PokerHandComparator comparator = new PokerHandComparator();
		
        // assert statements
        assertEquals(-1, comparator.compare(highCardValue, lowCardValue), "5 'ace' cards rank higher that 5 '2' cards");;
        assertEquals(-1, comparator.compare(highRank, lowRank), "Rank 10 hand with '2' higher than rank 1 with 'ace'");
        assertEquals(-1, comparator.compare(fullHouseHiTriplets, fullHoushHiPair), "For Full House '5' valued triplet take priority over 'ace' ranked pair");
		
	}
}

