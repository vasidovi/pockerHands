package pokerHands.enums;

public enum PokerHandRanks {
	
	HIGH_CARD(1),
    ONE_PAIR(2),
    TWO_PAIRS(3),
    THREE_OF_A_KIND(4),
    STRAIGHT(5),
    FLUSH(6),
    FULL_HOUSE(7),
    FOUR_OF_A_KIND(8),
    STRAIGHT_FLUSH(9),
    ROYAL_FLUSH(10);

	private Integer rank;

	PokerHandRanks(Integer rank) {
        this.rank = rank;
    }

    public Integer rank() {
        return rank;
    }

}
