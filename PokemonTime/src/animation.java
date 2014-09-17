import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import javax.swing.JPanel;


public class animation extends JPanel implements ActionListener, KeyListener{
	
	private static final long serialVersionUID = -4773272081424407158L;
	// Makes sure receiver and sender have the same class. Otherwise, will result in an InvalidClassException.

	int countMonsters= 15; 
	pokemon[] pokemons=new pokemon[countMonsters];
	pokemonBox box = new pokemonBox();
	double playSpeed = 1;
	Timer delayTimer = new Timer(10, this);

	public animation(){
		for (int i = 0; i < pokemons.length; i++) {
			pokemon monster = new pokemon();
			monster.displacementX = ((Math.random() * (box.resolution().width-210)))+15;
			monster.displacementY = ((Math.random() * (box.resolution().height-210)))+15;
			monster.constantAcc = playSpeed;	
			monster.xIncrement =  (Math.random() * 5) - 3;
			monster.yIncrement =  (Math.random() * 5) - 3;
			int[] keepMoving={1,-1};
			if(monster.xIncrement>-0.5 && monster.xIncrement<0.5){
				monster.xIncrement=keepMoving[(int) (Math.random()*2)];
			}
			if(monster.yIncrement>-0.5 && monster.yIncrement<0.5){
				monster.yIncrement=keepMoving[(int)(Math.random()*2)];
			}
			monster.image = box.selectPokemon();
			pokemons[i]=monster;
		}
	}

	long nextSecond = System.currentTimeMillis() + 1000;
	int frameInLastSecond = 0;
	int framesInNextSecond = 0;
	int lowFPSCounter = 0;
	int warningCounter = 0;

	public void paint(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.white);
		g.fillRect(0, 0, 3000, 2000);
		g.setColor(Color.black);
		g.drawString("Play Speed: "+playSpeed, box.resolution().width-120, box.resolution().height-100);

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
		
		g.drawString(frameInLastSecond + " fps", box.resolution().width-120, box.resolution().height-130);

		for (int i = 0; i < pokemons.length; i++) {
			g.drawImage(pokemons[i].image, (int)pokemons[i].displacementX,  (int)pokemons[i].displacementY, Color.white, this);
		}
		
		delayTimer.start();
	} 

	public void actionPerformed(ActionEvent event) {
		for (int i = 0; i < pokemons.length; i++) {
			pokemons[i].constantAcc = playSpeed;
			pokemons[i].move(); 
		}
		repaint();
	}

	public static void main(String[] args) {
		animation show = new animation();
		JFrame frame1 = new JFrame();
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setTitle("Art Project");
		frame1.setSize(pokemonBox.screenSize);
		frame1.addKeyListener(show);
		frame1.setVisible(true);
		frame1.add(show);
	}

	public void keyPressed(KeyEvent kEvent) {
		if(kEvent.getKeyCode() == kEvent.VK_ESCAPE){
			System.exit(0);
		}
		if (kEvent.getKeyCode() == kEvent.VK_LEFT){
			if(playSpeed> 0.25){
				playSpeed = playSpeed/2;
			}
		}
		if (kEvent.getKeyCode() == kEvent.VK_RIGHT){
			if (playSpeed < 4){
				playSpeed = playSpeed*2;
			}
		}
	}

	public void keyReleased(KeyEvent arg0) {}
	public void keyTyped(KeyEvent arg0) {}
}
