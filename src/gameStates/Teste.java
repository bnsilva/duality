package gameStates;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import cena.CenaAleatorio;
import cena.GeradorPickups;
import entities.Entity;
import entities.Ground;
import entities.Player;
import game.Camera;
import game.Constants;

public class Teste extends MyBasicGameState {
	CenaAleatorio ca;
	GeradorPickups gp;
	
	private int numOfElements = 30;
	private int numOfPickups = 3;

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		cam = new Camera();

		entities = new ArrayList<Entity>();

		int delta = 0;

		entities.add(new Ground(0, Constants.HEIGHT / 2, 800, 0));
		
		gp = new GeradorPickups(numOfElements);
		ca = new CenaAleatorio();
		
		ca.gerarCenario(gc, this, delta, numOfElements);
		gp.gerarPickups(this, numOfPickups);

		entities.add(new Player());
		cam.setTarget(entities.get(entities.size() - 1));		

//		for (Entity e : entities) {
//			System.out.println(e.toString());
//		}
//		System.out.println("" + entities.size());
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		cam.translate(gc, sbg, g);

		for (Entity e : entities) {
			// renderizar outros elementos que não sejam personagem
			if (!(e.toString() == "Player")) {
				e.render(gc, this, g);
				// linhas debug
				g.setColor(Color.red);
				g.draw(e.getCollisionBox());
			}
		}
		for (Entity e : entities) {
			// rederizar personagem por ultimo
			if (e.toString() == "Player") {
				e.render(gc, this, g);
				// linhas debug
				g.setColor(Color.red);
				g.draw(e.getCollisionBox());
				break;
			}
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {

		for (Entity e : entities) {
			e.update(gc, this, delta);
		}

		if (gc.getInput().isKeyPressed(Input.KEY_L)) {
			if (cam.hasTarget()) {
				cam.setTarget(null);
			} else {
				cam.setTarget(entities.get(0));
			}
		}
	}

	@Override
	public int getID() {
		return 0;
	}
}
