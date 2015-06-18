package game;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

public class Audio {
	private  static Music bgm;

	public Audio() throws SlickException{
		init();
	}
	
	public void init() throws SlickException{
		bgm = new Music ("res/bgm/Duality.ogg");
		bgm.loop();
	}
	
	public boolean bgmPlaying(){
		return bgm.playing();
	}
	
	public void bgmLoop(){
		bgm.loop();
	}
	
	public void bgmStop(){
		bgm.stop();
	}

}
