package entities;

import game.Constants;
import gameStates.MyBasicGameState;
import components.CollisionNormal;
import components.Gravity;
import components.VelocityX;
import componentsPlayerStates.StateStanding;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Player extends Entity {
	private Image i;
	
	public Player(){
		try {
			i = new Image("res/img/Char.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
		posX = Constants.WIDTH/2;
		posY = Constants.HEIGHT/2 - i.getHeight();
		collisionBox = new Rectangle(posX, posY, i.getWidth(), i.getHeight());
		
		components.put("Gravity", new Gravity());
		components.put("Collision", new CollisionNormal());
		components.put("State", new StateStanding());
		components.put("VelocityX", new VelocityX());
	}

	@Override
	public void onUpdate(GameContainer gc, MyBasicGameState sbg, int delta) {
		if(gc.getInput().isKeyDown(Input.KEY_RIGHT)){
			if(!(components.get("Collision").sendMsg().contains(4))){
				posX += 2;
				collisionBox.setX(posX);
			}
		}
		if(gc.getInput().isKeyDown(Input.KEY_LEFT)){
			if(!(components.get("Collision").sendMsg().contains(3))){
				posX -= 2;
				collisionBox.setX(posX);
			}
		}
	}

	@Override
	public void onRender(GameContainer gc, MyBasicGameState sbg, Graphics g) {
		if(Constants.GRAVITY>0){
			g.drawImage(i, posX, posY);
		}else{
			g.drawImage(i.getFlippedCopy(false, true), posX, posY);
		}
	}

	@Override
	public String toString() {
		return "Player";
	}
}
