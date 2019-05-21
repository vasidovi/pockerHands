package pokerHands;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import pokerHands.methods.GameController;
import pokerHands.methods.InputParser;
import pokerHands.models.Card;
import pokerHands.models.Hand;
import pokerHands.models.Player;

public class Main {
	 public static void main(String [] args) {
		 // poker.txt at root location need to change that
	 String fileName = "poker.txt";

     // This will reference one line at a time
     String line = null;

     try {
         // FileReader reads text files in the default encoding.
         FileReader fileReader = 
             new FileReader(fileName);

         BufferedReader bufferedReader = 
             new BufferedReader(fileReader);
         
         InputParser inputParser = new InputParser();
         
         List<Card> cards = new ArrayList<>();

         while((line = bufferedReader.readLine()) != null) {

        	 String[] abbreviationsInLine = line.split(" ");
        	 
        	 for (String abbreviation : abbreviationsInLine) {
        		 
              Card card = inputParser.convertToCard(abbreviation);
              cards.add(card);              
        	 }
         }         
         
         bufferedReader.close();
         GameController  gameController =  new GameController();
         
        List <Player> players = new ArrayList<>();
        Player player1 = new Player("Player 1", new ArrayList<Hand>());
        Player player2 = new Player("Player 2", new ArrayList<Hand>());
        
        players.add(player1);
        players.add(player2);
        
        gameController.assignCardsToPlayers(5, players, cards);
        
        Map<Player,Integer> victories = gameController.getPlayerVictoryCount(players);
                 
        System.out.println("Games played : " + player1.getHands().size()); 
        System.out.println("Player 1 vicotries : " + victories.getOrDefault(player1, 0));
        System.out.println("Player 2 vicotries : " + victories.getOrDefault(player2, 0));
     
     }
     
     catch(FileNotFoundException e1) {
         System.err.println(
             "Unable to open file '" + 
             fileName + "'");                
     }
     catch(IOException e2) {
         System.err.println(
             "Error reading file '" 
             + fileName + "'");                  
     }
 }

}
