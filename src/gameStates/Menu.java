package gameStates;

import game.Constants;
import uiElements.*;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Menu extends BasicGameState{
	
	private Image imgBG;
	private Image imgJogar;
	private Image imgSair;
	private Image imgBGMOn;
	private Image imgBGMOff;
	private Image imgLogo;
	
	private int mouseX;
	private int mouseY;
	
	private Button btnJogar;
	private Button btnSair;
	private Button btnBGM;
	
	static Music bgm;

	public Menu() {
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		imgBG = new Image("res/img/ui/bg1.png");
		imgLogo = new Image("res/img/ui/Duality_logo_alt.png");
		imgJogar = new Image("res/img/ui/button_jogar.png");
		imgBGMOn = new Image("res/img/ui/button_musica.png");
		imgBGMOff = new Image("res/img/ui/button_musica_off.png");
		imgSair = new Image("res/img/ui/button_sair.png");
		
		btnJogar = new Button(imgJogar, Constants.WIDTH/2, Constants.HEIGHT/2 + 50);
		btnBGM = new Button(imgBGMOn, Constants.WIDTH/2, Constants.HEIGHT/2 + 125);
		btnSair = new Button(imgSair, Constants.WIDTH/2, Constants.HEIGHT/2 + 200);
		
		bgm = new Music ("res/bgm/Duality.ogg");
		bgm.loop();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		//Renderiza o bg e o logo do jogo centralizados
		imgBG.drawCentered(Constants.WIDTH/2, Constants.HEIGHT/2);
		imgLogo.drawCentered(Constants.WIDTH/2, Constants.HEIGHT/2 - 150);
		
		btnJogar.render();
		btnSair.render();
		btnBGM.render();
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		mouseX = gc.getInput().getMouseX();
		mouseY = gc.getInput().getMouseY();
		
		//Esmaecer as opções do menu para dar um efeito de "Highlight"
		imgJogar.setAlpha(0.7f);
		imgBGMOn.setAlpha(0.7f);
		imgBGMOff.setAlpha(0.7f);
		imgSair.setAlpha(0.7f);
		
		if (isHovering(btnJogar)){
			imgJogar.setAlpha(1.0f);	//Highlight ou seleção da opção
			
			if (gc.getInput().isMousePressed(0)){
				sbg.enterState(1);
			}
		} else if (isHovering(btnSair)){
			imgSair.setAlpha(1.0f);
			
			if (gc.getInput().isMousePressed(0)){
				System.exit(0);
			}
		} else if (isHovering(btnBGM)){
			imgBGMOn.setAlpha(1.0f);
			imgBGMOff.setAlpha(1.0f);
			
			if (gc.getInput().isMousePressed(0)){
				if (bgm.playing()){		//Verifica se a musica está tocando e liga ou desliga-a
					bgm.stop();
				} else
					bgm.loop();
			}
		}
		
		if (bgm.playing() && btnBGM.getImg() == imgBGMOff){
			//altera a img do botão para indicar se a música está tocando ou não
			btnBGM.changeImg(imgBGMOn);
		} else if (!bgm.playing() && btnBGM.getImg() == imgBGMOn)
			btnBGM.changeImg(imgBGMOff);
		
	}

	@Override
	public int getID() {
		return 0;
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
