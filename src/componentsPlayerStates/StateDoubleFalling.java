package componentsPlayerStates;

import java.util.ArrayList;

import entities.Entity;
import gameStates.MyBasicGameState;

import org.newdawn.slick.GameContainer;

import components.Component;

public class StateDoubleFalling implements Component{

	@Override
	public void update(GameContainer gc, MyBasicGameState sbg, int delta,
			Entity e) {
		if(e.getComponents().get("Collision").sendMsg().contains(1)){
			e.replaceComponent("State", new StateStanding());
		}
	}

	@Override
	public ArrayList<Integer> sendMsg() {
		// TODO Auto-generated method stub
		return null;
	}

}
