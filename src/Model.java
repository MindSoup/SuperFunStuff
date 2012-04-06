import java.util.ArrayList;
import java.util.Collections;


public class Model {
	private final ArrayList<Card> playerCards = new ArrayList<Card>(); //cards in player's hand
	private final ArrayList<Card> playerPlayed = new ArrayList<Card>(); //cards played by player, still on "table"
	private final ArrayList<Card> computerCards = new ArrayList<Card>(); //cards in computer's hand
	private final ArrayList<Card> computerPlayed = new ArrayList<Card>(); //cards played by computer, still on "table"
	
	public Model() {
		this.deal();
	}
	
	public void deal() { //give half of deck to player, and half to computer
		ArrayList<Card> deck = Card.getDeck();
		Collections.shuffle(deck); //might want to research this more, not sure how random
		for(int i=0; i<deck.size(); i++) {
			Card c = deck.get(i);
			if(i % 2 == 1) {
				playerCards.add(c);
			} else {
				computerCards.add(c);
			}
		}
	}
}
