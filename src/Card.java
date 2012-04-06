import java.util.ArrayList;


public class Card {
	private final Suit suit;
	private final int value; //2-14, 11-13 being face cards, 14 being ace
	private static final String[] names = new String[] {"Error", "Error", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"}; //mapping names of cards
	
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
	
	public static ArrayList<Card> getDeck() { //gets the whole deck
		ArrayList<Card> deck = new ArrayList<Card>();
		deck.addAll(getSuit(Suit.CLUBS));
		deck.addAll(getSuit(Suit.DIAMONDS));
		deck.addAll(getSuit(Suit.HEARTS));
		deck.addAll(getSuit(Suit.SPADES));
		return deck;
	}
	
	private static ArrayList<Card> getSuit(Suit suit) { //gets every card in the given suit
		ArrayList<Card> rt = new ArrayList<Card>();
		for(int i=2; i<15; i++) {
			rt.add(new Card(suit, i));
		}
		return rt;
	}
	
	@Override
	public String toString() {
		return names[value] + " of " + suit;
	}
}
