package entities;

import game.Constants;
import gameStates.MyBasicGameState;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

public class Ground extends Entity{
	private Rectangle r;
	
	public Ground(float posX, float posY, float tamX, float tamY){
		this.posX = posX;
		this.posY = posY;
		collisionBox = new Rectangle(posX, posY, tamX, tamY);
		r = new Rectangle(posX, posY, tamX, Constants.HEIGHT - posY + 500);
	}

	@Override
	public void onUpdate(GameContainer gc, MyBasicGameState sbg, int delta) {
		collisionBox.setLocation(posX, posY);
	}

	@Override
	public void onRender(GameContainer gc, MyBasicGameState sbg, Graphics g) {
		g.setColor(Color.white);
		g.fill(r);
	}

	@Override
	public String toString() {
		return "Ground";
	}

}
