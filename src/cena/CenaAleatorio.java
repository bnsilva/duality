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
	private float tamX;
	private float tamY;

	public CenaAleatorio() {
		//posiçao inicial
		posX = Constants.WIDTH; 
		posY = Constants.HEIGHT / 2;
	}

	public void gerarCenario(GameContainer gc, MyBasicGameState sbg, int delta, int numOfElements) {
		for (int i = 0; i < numOfElements; i++) {
			Random r = new Random();
			tamX = r.nextFloat() * Constants.WIDTH;
			tamY = r.nextFloat() * Constants.HEIGHT;
			
			while (tamX < Constants.MIN_GROUND_WIDTH || tamX > Constants.MAX_GROUND_WIDTH){
				tamX = r.nextFloat() * Constants.WIDTH;
			}
			
			while (tamY < Constants.MIN_GROUND_HEIGHT || tamY > Constants.MAX_GROUND_HEIGHT){
				tamY = r.nextFloat() * Constants.HEIGHT;
			}
	
			sbg.addEntity(new Ground(posX, posY, tamX, 0));
			posX += tamX;
	
			if (posY > tamY) {
				sbg.addEntity(new Wall(posX, tamY + 2, 0, posY - tamY - 2));
			} else {
				sbg.addEntity(new Wall(posX, posY + 2, 0, tamY - posY - 2));
			}
			posY = tamY;
			
			GeradorPickups.groundPosX[i] = posX;
			GeradorPickups.groundPosY[i] = posY;
		}
	}
	
}
