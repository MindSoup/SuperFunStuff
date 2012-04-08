import java.util.ArrayList;
import java.util.Collections;


public class Model { //keeps track of stuff, does things
	private final Player player = new Player();
	private final Computer computer = new Computer();
	
	public Model() {
		deal();
		player.turn(); //doesn't yet do anything
	}
	
	private void deal() { //give half of deck to player, and half to computer
		ArrayList<Card> deck = Card.getDeck(); //get a deck
		Collections.shuffle(deck); //nice method I found, eh?
		for(int i=0; i<deck.size(); i++) { //iterate through the deck
			Card c = deck.get(i); //get the current card
			if(i % 2 == 1) { //first card goes to player, second to computer, third to player, etc
				player.giveCard(c);
			} else {
				computer.giveCard(c);
			}
		}
		player.drawTopCards(3); //draws the top three cards into the hand
		computer.drawTopCards(3); //draws the top three cards into the hand
	}
	
	public Player getPlayer() { //used by controller
		return this.player;
	}
}
