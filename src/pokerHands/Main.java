package pokerHands;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import pokerHands.logic.GameController;
import pokerHands.logic.InputParser;
import pokerHands.logic.InputReader;
import pokerHands.models.Card;
import pokerHands.models.Hand;
import pokerHands.models.Player;

public class Main {
	public static void main(String[] args) {

		String fileName = "poker.txt";
		InputReader inputReader = new InputReader();
		List<Card> cards = inputReader.readInput(fileName, new InputParser());

		if (cards != null) {

			GameController gameController = new GameController();

			List<Player> players = new ArrayList<>();
			Player player1 = new Player("Player 1", new ArrayList<Hand>());
			Player player2 = new Player("Player 2", new ArrayList<Hand>());

			players.add(player1);
			players.add(player2);

			gameController.assignCardsToPlayers(5, players, cards);

			Map<Player, Integer> victories = gameController.getPlayerVictoryCount(players);

			System.out.println("Games played : " + player1.getHands().size());
			System.out.println("Player 1 vicotries : " + victories.getOrDefault(player1, 0));
			System.out.println("Player 2 vicotries : " + victories.getOrDefault(player2, 0));
		}
	}
}
