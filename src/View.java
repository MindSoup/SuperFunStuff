import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class View extends JFrame {
	private static final long serialVersionUID = -8215973777232473220L;
	private JButton[] cards = new JButton[3];
	
	public View(final Controller controller) {
		super("Super Fun Stuff"); //let's make the title "Super Fun Stuff"
		setBounds(Common.getCentered(715, 500)); //715x500 in the middle of the screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //yeah, we could exit on close
		Container con = this.getContentPane(); // inherit main frame
	    JPanel pane = new JPanel(); //fills entire window
	    pane.setLayout(null); //I hate layouts
	    con.add(pane); // add the panel to frame
	    
	    cards[0] = new JButton(); //first card
	    cards[0].setBounds(85, 250, 125, 175);
	    pane.add(cards[0]);
	    cards[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.cardClick(0);
			}});
	    
	    cards[1] = new JButton(); //second card
	    cards[1].setBounds(295, 250, 125, 175);
	    pane.add(cards[1]);
	    cards[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.cardClick(1);
			}});
	    
	    cards[2] = new JButton(); //third (last) card
	    cards[2].setBounds(505, 250, 125, 175);
	    pane.add(cards[2]);
	    cards[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.cardClick(2);
			}});
	    
	    setVisible(true); //yeah, I'd like to see the window
	}
	
	public void setCard(int cardId, Card info) { //sets the given jbutton (0-2) as the given card
		//cards[cardId].setText(info.toString());
		try {
			BufferedImage bi = ImageIO.read(new File("classic-playing-cards.png")); //gets the image with all the cards
			int x = 1; //will only stay at 1 if card is ace
			int v = info.getValue();
			if(v < 14) { //if not ace
				x = (v - 1) * 73;
			}
			BufferedImage card = resizeImage(bi.getSubimage(x, 1 + info.getSuit().ordinal() * 98, 72, 96), 125, 175); //the image I found online wasn't perfect, gotta resize a bit
			cards[cardId].setIcon(new ImageIcon(card)); //sets button's icon to that of the image of its card
		} catch (IOException e) {
			Common.print("Error in loading images of cards.");
		}
	}
	
	public static BufferedImage resizeImage(BufferedImage originalImage, int width, int height) { //resizes a bufferedimage with the given dimensions
		BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, width, height, null);
		g.dispose();
		return resizedImage;
	}
}
