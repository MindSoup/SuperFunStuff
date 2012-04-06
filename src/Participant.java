import java.util.ArrayList;


public abstract class Participant {
	private final ArrayList<Card> deck = new ArrayList<Card>(); //pile belonging to participant
	private final ArrayList<Card> hand = new ArrayList<Card>(3); //currently delt hand
	
	public abstract void turn();
	
	public void giveCard(Card card) { //adds a single card to held deck
		deck.add(card);
	}
	
	public void giveCards(ArrayList<Card> cards) { //adds several cards to held deck
		deck.addAll(cards);
	}
	
	public Card drawTopCard() {
		Card top = null;
		for(Card c : deck) {
			if(c == null) {
				break;
			}
			top = c;
		}
		deck.remove(top);
		addToHand(top);
		Common.debug("Just drew " + top);
		return top;
	}
	
	private void addToHand(Card card) {
		Common.debug("Hand size is: " + hand.size());
		int size = hand.size();
		if(size >= 3) {
			for(int i=0; i<size; i++) {
				if(hand.get(i) == null) {
					hand.add(i, card);
					Common.debug("Added " + card + " to hand at " + i);
					break;
				}
			}
		} else {
			hand.add(card);
		}
	}
	
	public ArrayList<Card> drawTopCards(int amount) {
		Common.debug("Drawing top " + amount + " cards.");
		ArrayList<Card> rt = new ArrayList<Card>(amount);
		for(int i=0; i<amount; i++) {
			rt.add(drawTopCard());
		}
		return rt;
	}
	
	public ArrayList<Card> getHand() {
		return this.hand;
	}
	
	public Card[] playCard(int id) { //array has length of two. 0=card played, 1=replacement card
		Card played = hand.remove(id);
		Card replacement = drawTopCard();
		return new Card[] {played, replacement};
	}
}
