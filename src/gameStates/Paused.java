package gameStates;

import game.Audio;
import game.Constants;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import uiElements.Button;

public class Paused extends BasicGameState{
	private Audio audio;
	
	private Image imgBG;
	private Image imgLogo;
	private Image imgVoltar;
	private Image imgBGMOn;
	private Image imgBGMOff;
	private Image imgSair;
	
	private String text;
	
	private int mouseX;
	private int mouseY;
	
	private Button btnVoltar;
	private Button btnSair;
	private Button btnBGM;

	public Paused() {
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		imgBG = new Image("res/img/ui/bg1.png");
		imgLogo = new Image("res/img/ui/Duality_logo_alt.png");
		imgVoltar = new Image("res/img/ui/button_menu.png");
		imgBGMOn = new Image("res/img/ui/button_musica.png");
		imgBGMOff = new Image("res/img/ui/button_musica_off.png");
		imgSair = new Image("res/img/ui/button_sair.png");
		
		text = "Aperte ESPAÇO para voltar ao jogo";
		
		btnVoltar = new Button(imgVoltar, Constants.WIDTH/2, Constants.HEIGHT/2 + 50);
		btnBGM = new Button(imgBGMOn, Constants.WIDTH/2, Constants.HEIGHT/2 + 125);
		btnSair = new Button(imgSair, Constants.WIDTH/2, Constants.HEIGHT/2 + 200);
		
		audio = new Audio();
		audio.bgmLoop();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		//Renderiza o bg e o logo do jogo centralizados
		imgBG.drawCentered(Constants.WIDTH/2, Constants.HEIGHT/2);
		imgLogo.drawCentered(Constants.WIDTH/2, Constants.HEIGHT/2 - 150);
		
		g.setColor(Color.white);
		g.drawString(text, Constants.WIDTH/2 - 150, Constants.HEIGHT/2 - 25);

		btnVoltar.render();
		btnBGM.render();
		btnSair.render();
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		mouseX = gc.getInput().getMouseX();
		mouseY = gc.getInput().getMouseY();
		
		//Esmaecer as opções do menu para dar um efeito de "Highlight"
		imgVoltar.setAlpha(0.7f);
		imgBGMOn.setAlpha(0.7f);
		imgBGMOff.setAlpha(0.7f);
		imgSair.setAlpha(0.7f);
		
		if (gc.getInput().isKeyPressed(Input.KEY_SPACE)){
			sbg.enterState(1);
		}
		
		if (isHovering(btnVoltar)){
			imgVoltar.setAlpha(1.0f);	//Highlight ou seleção da opção
			
			if (gc.getInput().isMousePressed(0)){
				sbg.enterState(0);
			}
		} else if (isHovering(btnSair)){
			imgSair.setAlpha(1.0f);
			
			if (gc.getInput().isMousePressed(0)){
				gc.exit();
			}
		} else if (isHovering(btnBGM)){
			imgBGMOn.setAlpha(1.0f);
			imgBGMOff.setAlpha(1.0f);
			
			if (gc.getInput().isMousePressed(0)){
				if (audio.bgmPlaying()){	//Verifica se a musica está tocando e liga ou desliga-a
					audio.bgmStop();
				} else
					audio.bgmLoop();
			}
	}
		
		if (audio.bgmPlaying() && btnBGM.getImg() == imgBGMOff){
			//altera a img do botão para indicar se a música está tocando ou não
			btnBGM.changeImg(imgBGMOn);
		} else if (!audio.bgmPlaying() && btnBGM.getImg() == imgBGMOn)
			btnBGM.changeImg(imgBGMOff);
	}

	@Override
	public int getID() {
		return 2;
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
