package com.jaredscarito.jaredsplatformer.objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.List;

public abstract class GameObject
{
	protected Rectangle position;
	private BufferedImage appearance;

	public GameObject(Rectangle position, BufferedImage appearance)
	{
		this.position = position;
		this.appearance = appearance;
	}

	public Rectangle getPosition()
	{
		return position;
	}

	public void paint(Graphics g)
	{
		g.drawImage(appearance, position.x, position.y, null);
	}

	public void tick(long delta, List<GameObject> worldObjects)
	{
	}
}
