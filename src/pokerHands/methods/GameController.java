package pokerHands.methods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.stream.Stream;

import pokerHands.models.Card;
import pokerHands.models.Hand;
import pokerHands.models.Player;

public class GameController {

	/** Assumes there is one winning hand, and one player that plays it */
	public Player determineRoundWinner(Map<Player, Hand> round) {
		List<Hand> hands = new ArrayList<>(round.values());
		Collections.sort(hands);

		if (hands.size() < 2 || hands.get(0).compareTo(hands.get(1)) == 0) {
			System.err.print("Cannot determine winner");
			return null;
		}

		Hand winningHand = hands.get(0);

		Stream<Player> keyStream = keys(round, winningHand);
		Player winner = keyStream.findFirst().get();
		
		
		return winner;
	}

	public Map<Player, Integer> getPlayerVictoryCount(List<Player> players) {

		if (players == null || players.size() < 2) {
			System.err.print("Cannot determine players");
			return null;
		}
		// assumes that players played the same amount of games
		int size = players.get(0).getHands().size();

		Map<Player, Integer> playerVictoryCount = new HashMap<>();

		for (int i = 0; i < size; i++) {
			Map<Player, Hand> round = new HashMap<>();
			for (Player player : players) {
				round.put(player, player.getHands().get(i));
			}
			Player winner = determineRoundWinner(round);

			playerVictoryCount.put(winner, playerVictoryCount.getOrDefault(winner, 0) + 1);
		}

		return playerVictoryCount;
	}
	

	public void assignCardsToPlayers(Integer cardCount, List<Player> players, List<Card> cards) {

		ListIterator<Card> cardIterator = cards.listIterator();
		HandRanker handRanker = new HandRanker();

		for (int j = 0; j < cards.size(); j += cardCount * players.size()) {
			for (Player player : players) {

				List<Hand> playerHands = player.getHands();

				Hand hand = new Hand(new ArrayList<Card>(), 0);

				for (int i = 0; i < cardCount; i++) {

					Card card = cardIterator.next();
					hand.getCards().add(card);
				}
				
				handRanker.assignRank(hand);
				playerHands.add(hand);

			}
		}		
	}

	private <K, V> Stream<K> keys(Map<K, V> map, V value) {
		return map.entrySet().stream().filter(entry -> value.equals(entry.getValue())).map(Map.Entry::getKey);
	}

}
