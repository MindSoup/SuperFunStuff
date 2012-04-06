import java.util.ArrayList;


public class Card {
	private final Suit suit;
	private final int value; //2-14, 11-13 being face cards, 14 being ace
	
	public Card(Suit suit, int value) {
		this.suit = suit;
		this.value = value;
	}
	
	public Suit getSuit() {
		return this.suit;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public static ArrayList<Card> getDeck() {
		ArrayList<Card> deck = new ArrayList<Card>();
		deck.addAll(getSuit(Suit.CLUBS));
		deck.addAll(getSuit(Suit.DIAMONDS));
		deck.addAll(getSuit(Suit.HEARTS));
		deck.addAll(getSuit(Suit.SPADES));
		return deck;
	}
	
	private static ArrayList<Card> getSuit(Suit suit) {
		ArrayList<Card> rt = new ArrayList<Card>();
		for(int i=2; i<15; i++) {
			rt.add(new Card(suit, i));
		}
		return rt;
	}
}
