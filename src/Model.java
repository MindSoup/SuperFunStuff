import java.util.ArrayList;
import java.util.Collections;


public class Model {
	private final Player player = new Player();
	private final Computer computer = new Computer();
	
	public Model() {
		deal();
		player.turn();
	}
	
	private void deal() { //give half of deck to player, and half to computer
		ArrayList<Card> deck = Card.getDeck();
		Collections.shuffle(deck);
		for(int i=0; i<deck.size(); i++) {
			Card c = deck.get(i);
			if(i % 2 == 1) {
				player.giveCard(c);
			} else {
				computer.giveCard(c);
			}
		}
		player.drawTopCards(3);
		computer.drawTopCards(3);
	}
	
	public Player getPlayer() {
		return this.player;
	}
}
