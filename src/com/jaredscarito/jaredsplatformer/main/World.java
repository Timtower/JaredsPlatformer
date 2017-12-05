package com.jaredscarito.jaredsplatformer.main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import com.jaredscarito.jaredsplatformer.objects.GameObject;

public class World
{
	private JaredsPlatformer platformer;
	private Color backgroundColor;
	private List<GameObject> worldObjects = new ArrayList<GameObject>();

	public World(JaredsPlatformer platformer, Color backgroundColor)
	{
		this.platformer = platformer;
		this.backgroundColor = backgroundColor;
	}

	public void paint(Graphics g)
	{
		g.setColor(backgroundColor);
		g.fillRect(0, 0, platformer.getWidth(), platformer.getHeight());
		for (GameObject object : worldObjects)
		{
			object.paint(g);
		}
	}

	public void tick(long delta)
	{
		for (GameObject object : worldObjects)
		{
			object.tick(delta, worldObjects);
		}
	}
}
