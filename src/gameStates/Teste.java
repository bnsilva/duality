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
import game.Game;

public class Teste extends MyBasicGameState {
	CenaAleatorio ca;
	GeradorPickups gp;
	
	private int numOfElements = 10;
	private int numOfPickups = 10;
	
	private String timeStr;
	private int timer;
	private int timerX = 720;
	private int timerY = 60;
	private int scoreX = 720;
	private int scoreY = 80;
	private int count = 0;
	private float bonus = 0;
	
	private Entity player;
	
	private static int hours = 0;
	private static int minutes = 0;
	private static int seconds = 0;
	private static int score = 0;
	private static int timeElapsed;

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
		
		timeStr = "00:00:00";
		
		player = entities.get(entities.size() - 1);
		
		cam.setTarget(player);
		
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
			// renderizar outros elementos que nÃ£o sejam personagem
			if (!(e.toString() == "Player")) {
				e.render(gc, this, g);
				// linhas debug
//				g.setColor(Color.red);
//				g.draw(e.getCollisionBox());
			}
		}
		for (Entity e : entities) {
			// rederizar personagem por ultimo
			if (e.toString() == "Player") {
				e.render(gc, this, g);
				// linhas debug
//				g.setColor(Color.red);
//				g.draw(e.getCollisionBox());
				break;
			}
		}
		
		g.setColor(Color.white);
		g.drawString("Aperte ESPAÇO para pausar o jogo", 500, 100);
		
		g.setColor(Color.red);
		g.drawString(timeStr, timerX, timerY);
		g.drawString("" + score, scoreX, scoreY);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		
		count++;
		if (count % (5 * 60) == 0){
			//A cada 5 segundos gera uma nova parte do cenário e novos pickups;
			ca.gerarCenario(gc, this, delta, numOfElements);
			gp.gerarPickups(this, numOfPickups);
		}
		
		if (gc.getInput().isKeyPressed(Input.KEY_SPACE)){
			sbg.enterState(2);
		}

		for (Entity e : entities) {
			e.update(gc, this, delta);
		}

		if (gc.getInput().isKeyPressed(Input.KEY_L)) {
			if (cam.hasTarget()) {
				cam.setTarget(null);
			} else {
				cam.setTarget(player);
			}
		}
		
		timer += delta;
		timeElapsed += delta;
		
		//sincroniza a pos do timer e do score na tela com a pos do personagem
		timerX = (int) player.getPosX() + 320;
		timerY = (int) player.getPosY() - 190;
		scoreX = (int) player.getPosX() + 325;
		scoreY = (int) player.getPosY() - 170;
		
		calcTime();
		calcScore();
		
		if (Player.isGameOver()){
			Game.enterState(sbg, 3);
		}
	}

	@Override
	public int getID() {
		return 1;
	}
	
	public void calcTime(){
		//timer  = delta; 1000 delta = 1 seg
		seconds = timer / 1000;

		timeStr = (hours + ":" + minutes + ":" + seconds);
		
		if (seconds > 59){
			timer = 0;
			minutes++;
		}
		
		if (minutes > 59){
			minutes = 0;
			hours++;
		}
	}
	
	public void calcScore(){
		bonus+= 0.2f;
		score = (int) ((timeElapsed/1000 * 10) * (minutes + 1) + bonus);
	}
	
	public static int getScore(){
		return score;
	}
	
	public static void resetScore(){
		score = 0;
		timeElapsed = 0;
	}
	
	public static int getMinutes(){
		return minutes;
	}
	
	public static int getSeconds(){
		return seconds;
	}
}
