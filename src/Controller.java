import java.util.ArrayList;


public class Controller {
	private final View view = new View(this);
	private final Model model = new Model();
	
	public Controller() {
		ArrayList<Card> hand = model.getPlayer().getHand();
		Common.debug("Size: " + hand.size());
		for(int i=0; i<hand.size(); i++) {
			Common.debug(i);
			Card c = hand.get(i);
			view.setCard(i, c.toString());
		}
	}

	public void cardClick(int id) {
		Card[] move = model.getPlayer().playCard(id);
		//TODO use move[0] to play card
		view.setCard(id, move[1].toString());
	}
}
