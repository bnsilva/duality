package gameStates;

import java.util.ArrayList;

import org.newdawn.slick.state.BasicGameState;

import entities.Entity;
import game.Camera;

public abstract class MyBasicGameState extends BasicGameState{
	protected Camera cam;
	
	public ArrayList<Entity> entities;

	public ArrayList<Entity> getEntities() {
		return entities;
	}
	
	public void addEntity(Entity e){
		entities.add(e);
	}

}
