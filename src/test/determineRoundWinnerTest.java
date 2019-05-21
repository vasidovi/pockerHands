package test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import pokerHands.models.Card;
import pokerHands.models.Hand;
import pokerHands.models.Player;

public class determineRoundWinnerTest {
	
	List<Card> cards1 = new ArrayList<>();
	cards1.add(new Card(1, "1"));
	cards1.add(new Card(1, "1"));
	cards1.add(new Card(2, "2"));
	cards1.add(new Card(2, "2"));
	cards1.add(new Card(2,"2"));
	
	Integer rank = 
	
	Hand hand1 = new Hand
	
	@Test
	void test1() {
		
		
		
		
		Map<Player, Hand> round1
		RatesRetriever retriever = new RatesRetriever();

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
