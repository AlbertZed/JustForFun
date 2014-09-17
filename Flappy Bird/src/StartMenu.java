import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;




/*
 * Image Reference
 * http://fliperamma.com/wp-content/uploads/2014/02/flappy1.png
 * http://lanica.co/wp-content/uploads/2014/02/Flappy-Graphics.png
 * http://media.giphy.com/media/xrDdo5kuHzwxG/giphy.gif
 */

public class StartMenu extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	JFrame frame;
	JFrame creditF;
	JPanel contentP1;
	JButton start;
	JButton credits;

	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

	public StartMenu(){
		contentP1 = new JPanel();
		start = new JButton("Play Flappy Bird");
		//start.setLocation(100, 100);
		start.addActionListener((ActionListener) this);
		start.setMaximumSize(new Dimension(500,500));
		start.setActionCommand("Play");

		credits = new JButton("Credits");
		credits.addActionListener((ActionListener) this);
		credits.setMaximumSize(new Dimension(200,200));
		credits.setActionCommand("credits");

		contentP1.add(start);
		contentP1.add(credits);

		JLabel background=new JLabel(new ImageIcon("Pictures/flappy1.png"));
		contentP1.add(background);

		frame = new JFrame("Welcome!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(contentP1);
		frame.setSize(500,570);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	private static void runGUI(){
		StartMenu start = new StartMenu();
	}

	public static void main(String[] args) throws MalformedURLException {
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				runGUI();
			}
		});
	}

	public void actionPerformed (ActionEvent event){

		String eventName = event.getActionCommand();

		if (eventName.equals("Play")){
			FlappyBird bird = new FlappyBird();
			frame.dispose();
		}
		if (eventName.equals("credits")){
			Credits cred = new Credits();
		} 
	}
}
