package pokerHands.enums;

public enum Suits {

	C("Clubs"),
    D("Diamonds"),
    H("Hearts"),
    S("Spades");

	private String title;

	Suits(String title) {
        this.title = title;
    }

    public String title() {
        return title;
    }
    
}
