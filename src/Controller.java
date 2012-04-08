import java.util.ArrayList;


public class Controller { //connects view and model, manages game
	private final View view = new View(this); //create a view to display stuff
	private final Model model = new Model(); //create a model to store stuff
	
	public Controller() { //sets the three starting cards
		ArrayList<Card> hand = model.getPlayer().getHand(); //get the player's already delt hand
		for(int i=0; i<hand.size(); i++) {
			Card c = hand.get(i);
			view.setCard(i, c); //set the card
		}
	}

	public void cardClick(int id) { //should be called by the view when a card is clicked with the id of the clicked card (0-2)
		Card[] move = model.getPlayer().playCard(id); //play the card
		//TODO use move[0] to play card
		view.setCard(id, move[1]); //set the view to reflect the new card
	}
}
