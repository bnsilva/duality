package componentsPlayerStates;

import entities.Entity;
import game.Constants;
import gameStates.MyBasicGameState;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

import components.Component;

public class StateJumping implements Component{
	int timeJumping;

	@Override
	public void update(GameContainer gc, MyBasicGameState sbg, int delta,
			Entity e) {
		if(gc.getInput().isKeyDown(Input.KEY_UP) && timeJumping <= Constants.MAX_TIME_JUMPING){
			if(!(e.getComponents().get("Collision").sendMsg().contains(2))){
				e.setPosY(e.getPosY() + Constants.JUMP_VELOCITY);
				e.getCollisionBox().setY(e.getPosY());
			}
			timeJumping++;
		} else{
			e.replaceComponent("State", new StateFalling());
		}
	}

}
