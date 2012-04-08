
public enum Suit { //referring to the suit of a card
	CLUBS(CardColor.BLACK), //order is important - it matches that in the png with the cards' images
	SPADES(CardColor.BLACK),
	HEARTS(CardColor.RED),
	DIAMONDS(CardColor.RED);
	
	private final CardColor color; //still not sure why color is relevant. but it gives this enum something interesting to have in it
	
	Suit(CardColor color) {
		this.color = color;
	}
	
	public CardColor getColor() {
		return this.color;
	}
}
