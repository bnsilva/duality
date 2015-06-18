package game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame{

	public Game(String name) {
		super(name);
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.addState(new gameStates.Teste());
		this.addState(new gameStates.Menu());
		this.addState(new gameStates.Paused());
		this.addState(new gameStates.GameOver());
		
		this.enterState(0);
	}
	
	public static void enterState(StateBasedGame sbg, int id){
		sbg.enterState(id);
	}

}
