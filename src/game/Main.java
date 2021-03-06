package game;

import java.io.File;

import org.lwjgl.LWJGLUtil;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {

	public static void main(String[] args) throws SlickException {
		System.setProperty("org.lwjgl.librarypath", new File(new File(System.getProperty("user.dir"), "native"), LWJGLUtil.getPlatformName()).getAbsolutePath());
		
		try{
			AppGameContainer app = new AppGameContainer(new Game("Duality"));
			app.setDisplayMode(800, 600, false);
			app.setTargetFrameRate(60);
			app.setShowFPS(true);
			app.start();
		}catch (SlickException e){
			e.printStackTrace();
		}
	}

}
