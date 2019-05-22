package pokerHands;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import pokerHands.logic.GameController;
import pokerHands.logic.InputParser;
import pokerHands.logic.InputReader;
import pokerHands.models.PokerCard;
import pokerHands.models.PokerHand;
import pokerHands.models.Player;


/**
* The PokerHands solves Project Euler Problem 54 Poker hands 
* https://projecteuler.net/problem=54
*
* @author  Dovile Vasiliauskaite
* @version 1.0
* @since   2019-05-22 
*/
public class Main {
	
	private final static Integer HAND_CARD_COUNT = 5;

	public static void main(String[] args) {
					
		Scanner scanner = new Scanner(System.in);
		String fileName;
		System.out.println("Please enter path to file with game data. Skip, if data file is at the same location as jar.");
		String input = scanner.nextLine();
		scanner.close();
		
	    if (!(input.isEmpty() || input.equalsIgnoreCase("skip"))){
	    	fileName = input;
	    } else {
	    	fileName = "poker.txt";
	    }
	    
		InputReader inputReader = new InputReader();
		List<PokerCard> cards = inputReader.readInput(fileName, new InputParser());

		if (cards != null) {

			GameController gameController = new GameController();

			List<Player> players = new ArrayList<>();
			Player player1 = new Player("Player 1", new ArrayList<PokerHand>());
			Player player2 = new Player("Player 2", new ArrayList<PokerHand>());

			players.add(player1);
			players.add(player2);

			gameController.assignCardsToPlayers(HAND_CARD_COUNT, players, cards);

			Map<Player, Integer> victories = gameController.getPlayerVictoryCount(players);

			System.out.println("Games played : " + player1.getHands().size());
			System.out.println("Player 1 vicotries : " + victories.getOrDefault(player1, 0));
			System.out.println("Player 2 vicotries : " + victories.getOrDefault(player2, 0));
		}
	}
}
