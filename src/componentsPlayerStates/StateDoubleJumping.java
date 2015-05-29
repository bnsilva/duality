package componentsPlayerStates;

import java.util.ArrayList;

import entities.Entity;
import game.Constants;
import gameStates.MyBasicGameState;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

import components.Component;

public class StateDoubleJumping implements Component{
	int timeDoubleJump;

	@Override
	public void update(GameContainer gc, MyBasicGameState sbg, int delta,
			Entity e) {
		if(gc.getInput().isKeyDown(Input.KEY_UP) && timeDoubleJump <= Constants.MAX_TIME_DOUBLE_JUMPING){
			if(!(e.getComponents().get("Collision").sendMsg().contains(2))){
				e.setPosY(e.getPosY() + Constants.JUMP_VELOCITY);
				e.getCollisionBox().setY(e.getPosY());
			}
			timeDoubleJump++;
		} else{
			e.replaceComponent("State", new StateDoubleFalling());
		}
	}

	@Override
	public ArrayList<Integer> sendMsg() {
		// TODO Auto-generated method stub
		return null;
	}

}
