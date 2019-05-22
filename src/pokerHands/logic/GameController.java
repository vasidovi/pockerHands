package pokerHands.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import pokerHands.models.PokerCard;
import pokerHands.models.PokerHand;
import pokerHands.models.Player;

public class GameController {
	
	/** Assumes there is one winning hand, and one player that plays it */
	public Player determineRoundWinner(Map<Player, PokerHand> round) {
		List<PokerHand> hands = new ArrayList<>(round.values());
		
		PokerHandComparator comparator = new PokerHandComparator();
		Collections.sort(hands, comparator);

		if (hands.size() < 2 || comparator.compare(hands.get(0), hands.get(1)) == 0) {
			System.err.print("Need at least two players to determine winners");
			return null;
		}

		PokerHand winningHand = hands.get(0);

		Player winner = round.entrySet().stream().filter(entry -> winningHand.equals(entry.getValue()))
				.map(Map.Entry::getKey).findFirst().get();

		return winner;
	}

	/** Assumes that players played the same amount of games */
	public Map<Player, Integer> getPlayerVictoryCount(List<Player> players) {

		if (players == null || players.size() < 2) {
			System.err.print("Need at least two players to determine winners");
			return null;
		}

		int size = players.get(0).getHands().size();

		Map<Player, Integer> playerVictoryCount = new HashMap<>();

		for (int i = 0; i < size; i++) {
			Map<Player, PokerHand> round = new HashMap<>();
			
			for (Player player : players) {
				round.put(player, player.getHands().get(i));
			}
			
			Player winner = determineRoundWinner(round);
			playerVictoryCount.put(winner, playerVictoryCount.getOrDefault(winner, 0) + 1);
		}

		return playerVictoryCount;
	}

	public void assignCardsToPlayers(Integer cardCount, List<Player> players, List<PokerCard> cards) {

		ListIterator<PokerCard> cardIterator = cards.listIterator();

		for (int j = 0; j < cards.size(); j += cardCount * players.size()) {

			for (Player player : players) {

				List<PokerHand> playerHands = player.getHands();
				PokerHand hand = new PokerHand(new ArrayList<PokerCard>(),0);

				for (int i = 0; i < cardCount; i++) {

					PokerCard card = cardIterator.next();
					hand.getCards().add(card);
				}
				hand.assignRank();
				playerHands.add(hand);
			}
		}
	}
}
