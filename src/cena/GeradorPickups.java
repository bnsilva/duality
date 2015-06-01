package cena;

import java.util.Random;

import entities.Pickup;
import gameStates.MyBasicGameState;

public class GeradorPickups {
	static float[] groundPosX;
	static float[] groundPosY;
	
	private int numOfElements;

	public GeradorPickups(int numOfElements) {
		this.numOfElements = numOfElements;
		
		groundPosX = new float[numOfElements];
		groundPosY = new float[numOfElements];
		
	}
	
	public void gerarPickups(MyBasicGameState sbg, int numOfPickups){
		
		Random rand = new Random();
		
		for (int i = 0; i < numOfPickups; i++){
			int randIndex = rand.nextInt(numOfElements);
			int randPosX = rand.nextInt(100);
			
			System.out.println("randIndex: " + randIndex);
			System.out.println("randPosX: " + randPosX);
			sbg.addEntity(new Pickup(groundPosX[randIndex] + 10 + randPosX, groundPosY[randIndex] - 10));
		}
		
	}

}
