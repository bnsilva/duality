package uiElements;

import org.newdawn.slick.Image;

public class Button {
	
	private Image img;
	private int posX;
	private int posY;

	public Button(Image img, int posX, int posY) {
		this.img = img;
		this.posX = posX;
		this.posY = posY;
	}
	
	public void render(){
		img.drawCentered(posX, posY);
	}

	public int getPosX(){
		return posX;
	}
	
	public int getPosY(){
		return posY;
	}
	
	public int imgWidth(){
		return img.getWidth();
	}
	
	public int imgHeight(){
		return img.getHeight();
	}
	
	public void changeImg(Image img){
		this.img = img;
	}
	
	public Image getImg(){
		return img;
	}

}
