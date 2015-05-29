package components;

import java.util.ArrayList;

import entities.Entity;
import game.Constants;
import gameStates.MyBasicGameState;

import org.newdawn.slick.GameContainer;

public class VelocityX implements Component{

	@Override
	public void update(GameContainer gc, MyBasicGameState sbg, int delta,
			Entity e) {
		if(!(e.getComponents().get("Collision").sendMsg().contains(4))){
			e.setPosX(e.getPosX()+Constants.SPEED_X);
			e.getCollisionBox().setX(e.getPosX());
		}
	}

	@Override
	public ArrayList<Integer> sendMsg() {
		// TODO Auto-generated method stub
		return null;
	}

}
