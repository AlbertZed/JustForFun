
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;


public class FlappyBird extends JPanel implements KeyListener{
	private static final long serialVersionUID = 1L;
	Timer time;
	JPanel contentP;
	ActionEvent e;
	JFrame frame;

	boolean trigger = true;

	int score = 0;

	int groundCount = 0;
	int dirtW;


	final int birdYinitial = 300;
	final int birdXinitial = 100;

	int Rec1n2X = 0;
	int holeh1 = 0;
	int holeh2 = 0;

	int birdcounter = 0;
	boolean newGame = false;

	BufferedImage birdup;
	BufferedImage birdmiddle;
	BufferedImage birddown;
	BufferedImage tubeUp;
	BufferedImage tubeDown;
	BufferedImage dirt;
	BufferedImage background;


	private ArrayList bird = new ArrayList();

	Random randomNumber = new Random();
	int obstacleVelocity = 0;
	int holeStart = 0;
	int[] randomNumberArray = new int[100];

	int counter = 0;

	paintMeLikeOneOfYourFrenchGirls field;
	int Ybird;
	double gravity = 0;
	double verticalAcceleration = 0;
	int Vbackground = 0;
	int groundVelocity = 0;

	//fps
	long nextSecond = System.currentTimeMillis() + 1000;
	int frameInLastSecond = 0;
	int framesInNextSecond = 0;
	int lowFPSCounter = 0;
	int warningCounter = 0;

	public FlappyBird(){
		ImagePanel();
		Ybird = birdYinitial;
		time = new Timer(0,taskPerformer);
		time.setInitialDelay(100);
		time.start();

		frame = new JFrame("FlappyBird");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentP = new JPanel();
		contentP.setLayout(new GridLayout(1, 1, 10, 5));

		contentP.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		field = new paintMeLikeOneOfYourFrenchGirls();
		field.setSize(800,500);
		contentP.add(field);

		frame.setBounds(300, 100, 1000, 650);
		frame.setContentPane(contentP);
		frame.pack();
		frame.setVisible(true);
		frame.addKeyListener(this);
	}
	public void restartWindow(){
		Object[] options = {"Yes, I do!",   "No. I am tired."};
		int yesNoValue = JOptionPane.showOptionDialog(null, "Score: " + score/33 + "\nDo you want to play again?", "GAME OVER", JOptionPane.YES_NO_OPTION,	JOptionPane.WARNING_MESSAGE, null,   options,  options[0]); 
		if (yesNoValue == 0){
			frame.dispose();
			new FlappyBird();

		} else {
			System.exit(0);
		}
	}

	ActionListener taskPerformer = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			time.setDelay(15);
			verticalAcceleration += gravity*time.getDelay();
			Ybird+= verticalAcceleration;
			obstacleVelocity+= Vbackground;
			groundVelocity += 3;
			contentP.repaint();

			if (Ybird<holeh1||Ybird>holeh2){
				//where the bird dies
				time.stop();
				restartWindow();

			}
		}
	};

	private static void runGUI(){
		FlappyBird bird = new FlappyBird();
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				runGUI();
			}
		});
	}

	private void givemeFrenchRandomNumber(){
		for(int x =0; x<100; x++){
			if (x <10) {
				holeStart = randomNumber.nextInt(200) + 1;
			} else if (x <20){
				holeStart = randomNumber.nextInt(300) + 1;
			} else {
				holeStart = randomNumber.nextInt(400) + 1;
			}
			randomNumberArray[x] = holeStart;
		} 
	}

	public class paintMeLikeOneOfYourFrenchGirls extends JPanel{


		public void paintComponent(Graphics g){
			int runOnce;
			int[] dirtArray = new int[100];
			super.paintComponent(g);
			ImagePanel();
			//this.setBackground(Color.CYAN);
			Color customColor = new Color(0,210,220);
			this.setBackground(customColor);

			g.setColor(Color.black);


			//fps
			long currentTime = System.currentTimeMillis();
			if (currentTime > nextSecond) {
				nextSecond += 1000;
				frameInLastSecond = framesInNextSecond;
				if (frameInLastSecond<25){
					lowFPSCounter++;
					if (lowFPSCounter >5 && warningCounter<2){
						lowFPSCounter = 0;
						warningCounter++;
						JOptionPane.showMessageDialog (null, "Current system should be upgraded in order to run this program smoothly.");
					}
				}


				framesInNextSecond = 0;
			}
			framesInNextSecond++;

			g.drawString(frameInLastSecond + "", 950, 10);


			if (counter<10){
				givemeFrenchRandomNumber();
			}

			runOnce = 0;

			for(int x =0; x<100; x++){
				Rec1n2X = 1000 + 300*x - obstacleVelocity;
				if (Rec1n2X<150 && Rec1n2X>50){
					holeh1 = randomNumberArray[x];

					if (x <10) {
						holeh2 = 300 + randomNumberArray[x] - 35;
					} else if (x <20){
						holeh2 = 200 + randomNumberArray[x] - 35;
					} else {
						holeh2 = 150 + randomNumberArray[x] - 35;
					}
					runOnce++;
				} else if (runOnce == 0){
					holeh1 = 0;
					holeh2 = 555;

				}

				//put a condition to only draw the tubes that are in player's reach
				if (Rec1n2X>-100 && Rec1n2X <1000){
					g.drawImage(tubeDown,Rec1n2X,randomNumberArray[x]-437,null);

					if (x <10) {
						g.drawImage(tubeUp,Rec1n2X,300+randomNumberArray[x],null);
					} else if (x <20){
						g.drawImage(tubeUp,Rec1n2X,200+randomNumberArray[x],null);
					} else {
						g.drawImage(tubeUp,Rec1n2X,150+randomNumberArray[x],null);
					}
				}

				counter++;
			}

			if (runOnce == 1){
				score++;
			}
			if(birdcounter%9==0)
				birdcounter=0;

			g.drawImage((Image) bird.get(birdcounter), birdXinitial, Ybird, null);
			birdcounter++;

			for(int x = 0; x<100; x++){ 
				dirtArray[x] = x;
				if ((dirtArray[x]*(dirt.getWidth()-5))-groundVelocity>-2000 && (dirtArray[x]*(dirt.getWidth()-5))-groundVelocity <2000){

					g.drawImage(dirt,(dirtArray[x]*(dirt.getWidth()-5))-groundVelocity,595, null);
				}
			}

			frame.setSize(1000,670);
		}
	}

	public void ImagePanel() {
		try {
			birdup = ImageIO.read(new File("Pictures/flappyup.png"));
			birdmiddle = ImageIO.read(new File("Pictures/flappymiddle.png"));
			birddown = ImageIO.read(new File("Pictures/flappydown.png"));
			tubeUp = ImageIO.read(new File("Pictures/TubeUp.png"));
			tubeDown = ImageIO.read(new File("Pictures/TubeDown.png"));
			dirt = ImageIO.read(new File("Pictures/ground.png"));

			bird.add(birdup);
			bird.add(birdup);
			bird.add(birdup);
			bird.add(birdmiddle);
			bird.add(birdmiddle);
			bird.add(birdmiddle);
			bird.add(birddown);
			bird.add(birddown);
			bird.add(birddown);
		} catch (IOException ex) {
			System.out.println("image error");
		}
	}

	public void keyPressed(KeyEvent e) {

		if(e.getKeyCode() == 38){

			if(trigger){
				gravity = 0.0185;
				Vbackground = 3;

				trigger = false;
			}
			verticalAcceleration = -7;
		}
		contentP.repaint();
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == 38){
		}
	}

	public void keyTyped(KeyEvent arg0) {}
}