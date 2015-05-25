package game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.state.StateBasedGame;

import entities.Entity;

public class Camera {
	private Point p;
	private Entity target = null;

	public Camera() {
		p = new Point(0, 0);
	}

	public boolean hasTarget() {
		return (!(target == null));
	}

	public void setTarget(Entity target) {
		this.target = target;
		if (target == null) {
			p.setLocation(0, 0);
		}
	}

	public void translate(GameContainer gc, StateBasedGame sbg, Graphics g) {
		if (hasTarget()) {
			// 400 e 192 são a posicao inicial do player
			p.setX(-target.getPosX() + 400);
			p.setY(-target.getPosY() + 192);
		} else {
			if (gc.getInput().isKeyDown(Input.KEY_D)) {
				p.setX(p.getX() - Constants.VEL_CAM);
			} else if (gc.getInput().isKeyDown(Input.KEY_A)) {
				p.setX(p.getX() + Constants.VEL_CAM);
			} else if (gc.getInput().isKeyDown(Input.KEY_W)) {
				p.setY(p.getY() + Constants.VEL_CAM);
			} else if (gc.getInput().isKeyDown(Input.KEY_S)) {
				p.setY(p.getY() - Constants.VEL_CAM);
			}
		}
		g.translate(p.getX(), p.getY());
	}

}
