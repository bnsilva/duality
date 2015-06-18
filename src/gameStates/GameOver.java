package gameStates;

import entities.Player;
import game.Constants;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import uiElements.Button;

public class GameOver extends BasicGameState{
	private Image imgBG;
	private Image imgLogo;
	private Image imgVoltar;
	private Image imgSair;
	
	private String text;
	private String time;
	private String score;
	
	private int mouseX;
	private int mouseY;
	
	private Button btnVoltar;
	private Button btnSair;

	public GameOver() {
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		imgBG = new Image("res/img/ui/bg1.png");
		imgLogo = new Image("res/img/ui/Duality_logo_alt.png");
		
		imgVoltar = new Image("res/img/ui/button_menu.png");
		imgSair = new Image("res/img/ui/button_sair.png");
		
		btnVoltar = new Button(imgVoltar, Constants.WIDTH/2, Constants.HEIGHT/2 + 125);
		btnSair = new Button(imgSair, Constants.WIDTH/2, Constants.HEIGHT/2 + 200);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		//Renderiza o bg e o logo do jogo centralizados
		imgBG.drawCentered(Constants.WIDTH/2, Constants.HEIGHT/2);
		imgLogo.drawCentered(Constants.WIDTH/2, Constants.HEIGHT/2 - 150);
		
		btnVoltar.render();
		btnSair.render();
		
		g.setColor(Color.white);
		g.drawString(text, Constants.WIDTH/2 - 40, Constants.HEIGHT/2 - 25);
		g.drawString(time, Constants.WIDTH/2 - 210, Constants.HEIGHT/2);
		g.drawString(score, Constants.WIDTH/2 - 90, Constants.HEIGHT/2 + 25);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		mouseX = gc.getInput().getMouseX();
		mouseY = gc.getInput().getMouseY();
		
		text = "Game Over";
		time = ("Você sobreviveu por " + Teste.getMinutes() + " minuto(s) e " + Teste.getSeconds() + " segundo(s)");
		score = ("e obteve " + Teste.getScore() + " pontos");
		
		//Esmaecer as opções do menu para dar um efeito de "Highlight"
		imgVoltar.setAlpha(0.7f);
		imgSair.setAlpha(0.7f);
		
		if (isHovering(btnVoltar)){
			imgVoltar.setAlpha(1.0f);	//Highlight ou seleção da opção
			
			if (gc.getInput().isMousePressed(0)){
				gc.reinit();
				Constants.reset();
				Player.resetGame();
				sbg.enterState(0);
			}
		} else if (isHovering(btnSair)){
			imgSair.setAlpha(1.0f);
			
			if (gc.getInput().isMousePressed(0)){
				gc.exit();
			}
		}
	}

	@Override
	public int getID() {
		return 3;
	}
	
	public boolean isHovering(Button btn){
		//Verifica se o mouse está sobre o botão especificado
		if (mouseX >= (btn.getPosX() - btn.imgWidth()/2) && mouseX <= (btn.getPosX() + btn.imgWidth()/2)
			&& mouseY >= (btn.getPosY() - btn.imgHeight()/2) && mouseY <= (btn.getPosY() + btn.imgHeight()/2)){
			return true;
		}else
			return false;
	}
}
