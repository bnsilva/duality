package cena;

import entities.Ground;
import entities.Wall;
import game.Constants;
import gameStates.MyBasicGameState;

import org.newdawn.slick.GameContainer;

import java.util.Random;

public class CenaAleatorio {
	private float posX;
	private float posY;

	public CenaAleatorio() {
		//posiçao inicial
		posX = 800; 
		posY = Constants.HEIGHT / 2;
	}

	public void gerarCenario(GameContainer gc, MyBasicGameState sbg, int delta) {
		Random r = new Random();
		float tamX = r.nextFloat() * Constants.WIDTH;
		float tamY = r.nextFloat() * Constants.HEIGHT;

		sbg.addEntity(new Ground(posX + 1, posY, tamX - 1, 0));
		posX += tamX;

		if (posY > tamY) {
			sbg.addEntity(new Wall(posX, tamY - 1, 0, posY - tamY));
		} else {
			sbg.addEntity(new Wall(posX, posY + 1, 0, tamY - posY));
		}
		posY = tamY;
	}
}
