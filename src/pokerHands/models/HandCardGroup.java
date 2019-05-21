package pokerHands.models;

public class HandCardGroup implements Comparable<HandCardGroup> {

		Integer cardValue;
		Integer count;
		
		public Integer getCardValue() {
			return cardValue;
		}
		public void setCardValue(Integer cardValue) {
			this.cardValue = cardValue;
		}
		public Integer getCount() {
			return count;
		}
		public void setCount(Integer count) {
			this.count = count;
		}
		
		public HandCardGroup(Integer cardValue, Integer count) {
			super();
			this.cardValue = cardValue;
			this.count = count;
		}
		
		/** Sorts in descending order, first by count than by value */
		@Override
		public int compareTo(HandCardGroup o) {
			
			if (this.getCount() == o.getCount()) {
				if (this.getCardValue() == o.getCardValue())
				return 0;
				else
			    return this.getCardValue() < o.getCardValue() ? 1 : -1;
			} else
				return this.getCount() < o.getCount() ? 1 : -1;
		}	
}
