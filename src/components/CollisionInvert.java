package components;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;

import entities.Entity;
import gameStates.MyBasicGameState;

public class CollisionInvert implements Component {
	ArrayList<Integer> msg;

	// Colisao para o estado invertido do personagem
	// m=0 => não teve colisao
	// m=1 => colidiu com o chão
	// m=2 => colidiu com o teto
	// m=3 => colidiu parede esquerda
	// m=4 => colidiu parede direita
	// m=5 => colidiu com um pickup

	public CollisionInvert() {
		msg = new ArrayList<Integer>();
	}

	@Override
	public void update(GameContainer gc, MyBasicGameState sbg, int delta,
			Entity e) {
		msg.clear();
		for (Entity entity : sbg.getEntities()) {

			if (entity.toString() == "Ground") {
				if (e.getCollisionBox().intersects(entity.getCollisionBox())) {
					if (e.getPosY() <= entity.getPosY()
							+ entity.getCollisionBox().getHeight()
							&& e.getPosY() + 2 >= entity.getPosY()
									+ entity.getCollisionBox().getHeight()) {
						msg.add(1);

					} else if (e.getPosY() + e.getCollisionBox().getHeight() >= entity
							.getPosY()
							&& e.getPosY() + e.getCollisionBox().getHeight() <= entity
									.getPosY() + 2) {
						msg.add(2);

					}
				}

			} else if (entity.toString() == "Wall") {
				if (e.getCollisionBox().intersects(entity.getCollisionBox())) {
					if (e.getPosX() <= entity.getPosX()
							+ entity.getCollisionBox().getWidth()
							&& e.getPosX() + 5 >= entity.getPosX()
									+ entity.getCollisionBox().getWidth()) {
						msg.add(3);

					} else if (e.getPosX() + e.getCollisionBox().getWidth() >= entity
							.getPosX()
							&& e.getPosX() + e.getCollisionBox().getWidth() <= entity
									.getPosX() + 5) {
						msg.add(4);

					}
				}
			}
		}
		
		for (Entity entity : sbg.getEntities()){
			if (entity.toString() == "Pickup"){
				if (e.getCollisionBox().intersects(entity.getCollisionBox())){
					msg.add(5);
				}
			}
		}
	}

	@Override
	public ArrayList<Integer> sendMsg() {
		return msg;
	}
}