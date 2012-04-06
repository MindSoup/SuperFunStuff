import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class View extends JFrame {
	private static final long serialVersionUID = -8215973777232473220L;
	private JButton[] cards = new JButton[3];
	
	public View(final Controller controller) {
		super("Super Fun Stuff");
		setBounds(Common.getCentered(715, 500));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con = this.getContentPane(); // inherit main frame
	    JPanel pane = new JPanel();
	    pane.setLayout(null);
	    con.add(pane); // add the panel to frame
	    
	    cards[0] = new JButton("Card One");
	    cards[0].setBounds(85, 250, 125, 175);
	    pane.add(cards[0]);
	    cards[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.cardClick(0);
			}});
	    
	    cards[1] = new JButton("Card Two");
	    cards[1].setBounds(295, 250, 125, 175);
	    pane.add(cards[1]);
	    cards[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.cardClick(1);
			}});
	    
	    cards[2] = new JButton("Card Three");
	    cards[2].setBounds(505, 250, 125, 175);
	    pane.add(cards[2]);
	    cards[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.cardClick(2);
			}});
	    
	    setVisible(true);
	}
	
	public void setCard(int cardId, String name) {
		cards[cardId].setText(name);
	}
}
