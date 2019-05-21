package test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import pokerHands.methods.GameController;
import pokerHands.methods.InputParser;
import pokerHands.models.Card;
import pokerHands.models.Hand;
import pokerHands.models.Player;

public class determineRoundWinnerTest {
	
	
	InputParser parser = new InputParser();
	Card aceD = parser.convertToCard("AD");
	Card twoD = parser.convertToCard("2D");
	Card threeD = parser.convertToCard("3D");
	Card fourD = parser.convertToCard("4D");
	Card fiveD = parser.convertToCard("5D");
	Card sixD = parser.convertToCard("6D");
	
	Card aceC = parser.convertToCard("AC");
	Card twoC = parser.convertToCard("2C");
	Card threeC = parser.convertToCard("3C");
	Card fourC = parser.convertToCard("4C");
	Card fiveC = parser.convertToCard("5C");
	Card sixC= parser.convertToCard("6C");
	
	Card twoS = parser.convertToCard("2S");
	Card twoH = parser.convertToCard("2H");
	
	List<Card> cardHi = new ArrayList<>();
	List<Card> cardLow = new ArrayList<>();
		
	for (int i= 0; i < 5; i++) {	
    cardHi.add(aceD);
	cardLow.add(twoD);
	
	}
	
	Hand handHi = new Hand(cardHi, 2);
	Hand handLow = new Hand(cardLow,2);
	
	Hand rankHi = new Hand(cardLow, 10);
	Hand rankLow = new Hand(cardHi, 1);
	
	Player player1 = new Player("player1", new ArrayList<>());
	Player player2 = new Player("player2", new ArrayList<>());
	
	GameController controller = new GameController();
	
	
	@Test
	void test1() {
		
		controller.determineRoundWinner(round);
		Map<Player, Hand> roundRankEqual = new HashMap<>();
		
		roundRankEqual.put(player1, handHi);
		roundRankEqual.put(player2, handLow);
	
		Player expectedW

		List<Currency> expectedResult1 = new ArrayList<>();
		
		expectedResult1.add(new Currency("name", AUD, 1.622, startDay1.minusDays(1)));
		expectedResult1.add(new Currency("name", AUD, 1.6273, endDay1.minusDays(1)));
		expectedResult1.add(new Currency("name", AUD, 1.6287, endDay1));
		expectedResult1.add(new Currency("name", TRY, 6.0588, startDay1.minusDays(1)));
		expectedResult1.add(new Currency("name", TRY, 6.113, endDay1.minusDays(1)));
		expectedResult1.add(new Currency("name", TRY, 6.2248, endDay1));

		List<Currency> resultList = retriever.getRatesByPeriod(startDay1, endDay1, codes1);

		for (Currency result : resultList) {
			System.out.println(result.toString());
		}

		for (Currency expected : expectedResult1) {
			assertTrue(resultList.stream().anyMatch(c -> c.equals(expected)));
		}
	}

}
