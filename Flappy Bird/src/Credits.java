import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.InsetsUIResource;


public class Credits implements ActionListener{
	JFrame frame1;
	JLabel Credits;
	JLabel thanks;
	JPanel contentP2;
	JButton LOL;
	public Credits() {

		contentP2 = new JPanel();
		contentP2.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.gridx = 0;
		c.gridy = 3;

		Credits = new JLabel("Game Created by: © 2014 Zhang Bros. Entertainment Inc. All rights reserved");
		c.insets = new Insets(15, 0, 0, 0);
		contentP2.add(Credits, c);
		c.insets = new Insets(65, 0, 0, 0);
		thanks = new JLabel("Special thanks to Maxl Dale");
		contentP2.add(thanks, c);


		LOL = new JButton("Hate Flappy Bird? Click Here");
		contentP2.add(LOL);
		LOL.addActionListener(this);
		LOL.setActionCommand("lulz");




		frame1 = new JFrame("Credits");

		frame1.add(contentP2);
		frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame1.setSize(500,500);
		frame1.setVisible(true);
		frame1.setLocationRelativeTo(null);
	}
	private static void runGUI(){
		Credits cred = new Credits();
	}

	public static void main(String[] args) throws MalformedURLException {
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				runGUI();
			}
		});
	}
	public void actionPerformed (ActionEvent e){

		String eventName = e.getActionCommand();
		if (eventName.equals("lulz")){
			try {
				frame1.dispose();
				Animated LOL = new Animated();
			} catch (MalformedURLException e1) {

				e1.printStackTrace();
			}
		} 
	}
}
