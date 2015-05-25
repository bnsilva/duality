package components;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;

import entities.Entity;
import gameStates.MyBasicGameState;

public interface Component {
	//atualiza o component
	public void update(GameContainer gc, MyBasicGameState sbg, int delta, Entity e);
	
	//como default retorna um inteiro m que representa uma mensagem
	public default ArrayList<Integer> sendMsg(){
		return null;
	}

}
