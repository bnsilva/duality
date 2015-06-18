package cena;

import java.util.Random;

import entities.Pickup;
import gameStates.MyBasicGameState;

public class GeradorPickups {
	
	private int numOfElements;

	public GeradorPickups(int numOfElements) {
		this.numOfElements = numOfElements;
		
		CenaAleatorio.groundPosX = new float[numOfElements];
		CenaAleatorio.groundPosY = new float[numOfElements];
		
	}
	
	public void gerarPickups(MyBasicGameState sbg, int numOfPickups){
		
		Random rand = new Random();
		
		for (int i = 0; i < numOfPickups; i++){
			int randIndex = rand.nextInt(numOfElements);
			int randPosX = rand.nextInt(200 - 10);
			boolean randInvert = rand.nextBoolean();
			
			if (!randInvert){
				sbg.addEntity(new Pickup(CenaAleatorio.groundPosX[randIndex] + 10 + randPosX, CenaAleatorio.groundPosY[randIndex] - 12));
			} else
				sbg.addEntity(new Pickup(CenaAleatorio.groundPosX[randIndex] + 10 + randPosX, CenaAleatorio.groundPosY[randIndex] + 12));
			
//			System.out.println("randIndex " + i + ": " + randIndex);
//			System.out.println("randPosX " + i + ": " + randPosX);
		}
	}

}
