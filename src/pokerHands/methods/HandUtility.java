package pokerHands.methods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pokerHands.models.Card;
import pokerHands.models.Hand;
import pokerHands.models.HandCardGroup;

public class HandUtility {

	
	 public List<HandCardGroup> groupCardsByValue(Hand hand){
			
			Map <Integer, Integer> valueCountMap = new HashMap<>();
			
			for ( Card card : hand.getCards()) {
				
		     Integer value  = card.getValue();
		     Integer count = valueCountMap.getOrDefault(value, 0) + 1;
		     
		     valueCountMap.put(value, count);
			}
			
			List<HandCardGroup> handCardGroups = new ArrayList<>();
			
			
			  for (Integer value : valueCountMap.keySet()) {  
		            
		      HandCardGroup handCardGroup = new HandCardGroup(value, valueCountMap.get(value));  
		      handCardGroups.add(handCardGroup);			  				
		    } 
			
			return handCardGroups;
		}

}
