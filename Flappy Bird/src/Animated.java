import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Animated {
	JLabel label;
	JFrame f;
	Icon icon;
	public Animated() throws MalformedURLException{

		icon = new ImageIcon("Pictures/giphy.gif");
		label = new JLabel(icon);
		f = new JFrame("Animation");
		f.getContentPane().add(label);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
	private static void runGUI() throws MalformedURLException{
		Animated flappyhate = new Animated();
	}

	public static void main(String[] args) throws MalformedURLException {
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				try {
					runGUI();
				} catch (MalformedURLException e) {
					System.out.println("mal");
				}
			}
		});
	}
}
