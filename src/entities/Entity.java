package entities;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import gameStates.MyBasicGameState;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

import components.Component;

public abstract class Entity {
	protected float posX;
	protected float posY;
	protected float tamX;
	protected float tamY;
	protected Rectangle collisionBox;
	protected Map<String, Component> components = new HashMap<String, Component>();

	public float getPosX() {
		return posX;
	}

	public void setPosX(float posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(float posY) {
		this.posY = posY;
	}

	public Map<String, Component> getComponents() {
		return components;
	}

	public void setComponents(Map<String, Component> components) {
		this.components = components;
	}

	public Rectangle getCollisionBox() {
		return collisionBox;
	}

	public void addComponents(String key, Component c) {
		components.put(key, c);
	}

	public void removeComponent(String key) {
		components.remove(key);
	}

	public void replaceComponent(String key, Component c) {
		components.put(key, c);
	}

	public final void update(GameContainer gc, MyBasicGameState sbg, int delta) {
		Set<String> set = components.keySet();
		Iterator<String> i = set.iterator();
		while (i.hasNext()) {
			String s = i.next();
			components.get(s).update(gc, sbg, delta, this);
		}

		onUpdate(gc, sbg, delta);
	}

	public void render(GameContainer gc, MyBasicGameState sbg, Graphics g) {
		onRender(gc, sbg, g);
	}

	public abstract void onUpdate(GameContainer gc, MyBasicGameState sbg,
			int delta);

	public abstract void onRender(GameContainer gc, MyBasicGameState sbg,
			Graphics g);
}
