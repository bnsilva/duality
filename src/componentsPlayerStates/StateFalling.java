package componentsPlayerStates;

import entities.Entity;
import gameStates.MyBasicGameState;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

import components.Component;

public class StateFalling implements Component{

	@Override
	public void update(GameContainer gc, MyBasicGameState sbg, int delta,
			Entity e) {
		if(gc.getInput().isKeyPressed(Input.KEY_UP)){
			e.replaceComponent("State", new StateJumping());
		}
		
		if(e.getComponents().get("Collision").sendMsg().contains(1)){
			e.replaceComponent("State", new StateStanding());
		}
	}

}
