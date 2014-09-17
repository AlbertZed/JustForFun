import java.awt.*;


public class pokemon {
	double displacementX;
	double displacementY;
	double xIncrement;
	double yIncrement;
	Image image;
	double constantAcc;
	pokemonBox box = new pokemonBox();

	public void move() {
		displacementX += xIncrement*constantAcc;
		displacementY += yIncrement*constantAcc;

		if (displacementX > box.resolution().width - 5 - 150 || displacementX < 0) {
			xIncrement = xIncrement *(-1);
			this.image=box.selectPokemon();
		}

		if (displacementY >box.resolution().height - 30 - 150 || displacementY <0) {
			yIncrement = yIncrement*(-1);
			this.image=box.selectPokemon();
		}

	}

}
