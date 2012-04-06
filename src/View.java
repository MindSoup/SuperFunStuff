import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class View extends JFrame {
	private static final long serialVersionUID = -8215973777232473220L;
	
	public View() {
		super("Super Fun Stuff");
		setBounds(Common.getCentered(800, 500));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con = this.getContentPane(); // inherit main frame
	    JPanel pane = new JPanel();
	    pane.setLayout(null);
	    con.add(pane); // add the panel to frame
	    setVisible(true);
	}
}
