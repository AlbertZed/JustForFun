import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class pokemonBox {
	static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	BufferedImage image1, image2, image3, image4, image5, image6, image7, image8, image9,
	image10, image11, image12, image13, image14, image15;

	/*
	 * Work Cited
	 * All images are downloaded from Google Image
	 * Here are the urls
	http://th09.deviantart.net/fs70/150/f/2013/362/8/0/dec__pokeddexy_challenge_29__scariest_pokemon_by_slider_chan-d6zu80q.png
	http://th09.deviantart.net/fs71/150/f/2012/019/5/c/pokemon_challenge_day_20__baby_pokemon___togepi_by_sliverlynx-d4mzfo8.png
	http://th05.deviantart.net/fs71/150/f/2013/347/b/7/pokemon_pikachu_png_by_bloomsama-d6xsubn.png
	http://cdn.bulbagarden.net/upload/thumb/3/30/130Gyarados-Mega.png/150px-130Gyarados-Mega.png
	http://th02.deviantart.net/fs71/150/f/2013/145/1/b/wailord_skitty_pokemon_fusion_by_dragon260-d66lfwf.jpg
	http://th00.deviantart.net/fs46/150/i/2010/311/e/1/pokemon__gengar_by_kirbydrawer-d25self.jpg
	http://86bb71d19d3bcb79effc-d9e6924a0395cb1b5b9f03b7640d26eb.r91.cf1.rackcdn.com/wp-content/uploads/2010/01/manaphy-legendary-pokemon-artwork-150x150.jpg
	http://fc08.deviantart.net/fs70/f/2010/108/6/e/Pokemon___Pokeball_by_ElderKain.png
	http://suresuta.jp/wp-content/uploads/2013/10/102313-150x150.jpg
	http://livedoor.blogimg.jp/mc_matome_complate/imgs/0/6/062b646f.png
	http://amd.c.yimg.jp/im_sigg_p6y1lIWLA67Vh132nQSaw---x150-y150-q90/amd/20131219-00000015-isd-000-0-thumb.jpg
	http://livedoor.blogimg.jp/mc_matome_complate/imgs/5/6/56dd7b1e.png
	http://livedoor.blogimg.jp/mc_matome_complate/imgs/1/d/1de6af00.png
	http://suresuta.jp/wp-content/uploads/2013/10/102107-150x150.jpg
	 */

	public pokemonBox(){
		try {                
			image1 = ImageIO.read(new File("pictures/01.jpg"));
			image2 = ImageIO.read(new File("pictures/02.png"));
			image3 = ImageIO.read(new File("pictures/03.jpg"));
			image4 = ImageIO.read(new File("pictures/04.png"));
			image5 = ImageIO.read(new File("pictures/05.jpg"));
			image6 = ImageIO.read(new File("pictures/06.png"));
			image7 = ImageIO.read(new File("pictures/07.png"));
			image8 = ImageIO.read(new File("pictures/08.png"));
			image9 = ImageIO.read(new File("pictures/09.png"));
			image10 = ImageIO.read(new File("pictures/10.png"));
			image11 = ImageIO.read(new File("pictures/11.jpg"));
			image12 = ImageIO.read(new File("pictures/12.jpg"));
			image13 = ImageIO.read(new File("pictures/13.jpg"));
			image14 = ImageIO.read(new File("pictures/14.png"));
			image15 = ImageIO.read(new File("pictures/15.png"));
			System.out.println(image1.toString());
		} catch (IOException ex) {
			JOptionPane.showMessageDialog (null, "image is not found");
		}
	}

	public Image selectPokemon (){
		Image[] pokemonBox = { image1, image2, image3, image4, image5, image6, image7, image8, image9, 
				image10, image11, image12, image13, image14, image15 };
		int randomInt = (int) (Math.random() * 15);
		return pokemonBox[randomInt];
	}

	public Dimension resolution (){
		return screenSize;
	}


}
