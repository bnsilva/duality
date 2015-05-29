package components;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;

import entities.Entity;
import game.Constants;
import gameStates.MyBasicGameState;

public class Gravity implements Component {

	@Override
	public void update(GameContainer gc, MyBasicGameState sbg, int delta,
			Entity e) {
		if (!(e.getComponents().get("Collision").sendMsg().contains(1))) {
			e.setPosY(e.getPosY() + Constants.GRAVITY);
			e.getCollisionBox().setY(e.getPosY());
		}
	}

	@Override
	public ArrayList<Integer> sendMsg() {
		// TODO Auto-generated method stub
		return null;
	}

}
