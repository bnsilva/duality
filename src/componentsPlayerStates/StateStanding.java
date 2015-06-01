package componentsPlayerStates;

import java.util.ArrayList;

import entities.Entity;
import game.Constants;
import gameStates.MyBasicGameState;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

import components.CollisionInvert;
import components.CollisionNormal;
import components.Component;

public class StateStanding implements Component {

	@Override
	public void update(GameContainer gc, MyBasicGameState sbg, int delta,
			Entity e) {
		if (gc.getInput().isKeyPressed(Input.KEY_UP)) {
			e.replaceComponent("State", new StateJumping());
		}

		if (gc.getInput().isKeyPressed(Input.KEY_DOWN)) {
			Constants.GRAVITY *= -1;
			Constants.JUMP_VELOCITY *= -1;

			e.replaceComponent("State", new StateFalling());

			if (Constants.GRAVITY < 0) {
				e.replaceComponent("Collision", new CollisionInvert());
				e.setPosY(e.getPosY() + e.getCollisionBox().getHeight());
				e.getCollisionBox().setY(e.getPosY());
			} else {
				e.replaceComponent("Collision", new CollisionNormal());
				e.setPosY(e.getPosY() - e.getCollisionBox().getHeight());
				e.getCollisionBox().setY(e.getPosY());
			}
		}
	}

	@Override
	public ArrayList<Integer> sendMsg() {
		// TODO Auto-generated method stub
		return null;
	}

}
