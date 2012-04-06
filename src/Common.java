import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;


public class Common {
	private static boolean debug = true;
	
	public static void print(Object obj) { //makes it a little easier to give output
		System.out.println(obj.toString());
	}
	
	public static void debug(Object obj) { //easy access debugging, just change the static variable to false to turn off
		if(debug) {
			System.out.println(obj.toString());
		}
	}
	
	public static Rectangle getCentered(int width, int height) { //gets the specified rectangle dimensions centered on screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int w = screenSize.width / 2;
		int h = screenSize.height / 2;
		return new Rectangle(w-(width/2),h-(height/2),width,height);
	}
}
