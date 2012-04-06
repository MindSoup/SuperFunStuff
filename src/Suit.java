
public enum Suit {
	SPADES(CardColor.BLACK),
	HEARTS(CardColor.RED),
	DIAMONDS(CardColor.RED),
	CLUBS(CardColor.BLACK);
	
	private final CardColor color;
	
	Suit(CardColor color) {
		this.color = color;
	}
	
	public CardColor getColor() {
		return this.color;
	}
}
