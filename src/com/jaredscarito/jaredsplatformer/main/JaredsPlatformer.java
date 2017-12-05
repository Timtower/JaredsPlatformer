package com.jaredscarito.jaredsplatformer.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class JaredsPlatformer extends JPanel
{
	private static final long serialVersionUID = 1L;
	private GameThread gameThread = null;
	private List<World> worlds = new ArrayList<World>();
	private int activeWorld = 0;

	public JaredsPlatformer()
	{
		this.setVisible(true);
		this.setPreferredSize(new Dimension(500, 500));
		loadWorlds();
		activeWorld = 0;
	}

	@Override
	public void paint(Graphics g)
	{
		if (activeWorld >= worlds.size())
		{
			System.out.println("Game finished");
			System.exit(0);
		}
		worlds.get(activeWorld).paint(g);
	}

	// Initialize worlds here
	private void loadWorlds()
	{
		worlds.add(new World(this, Color.red));
	}
	
	public void run()
	{
		gameThread = new GameThread(this);
		gameThread.start();
	}

	public World getWorld()
	{
		return worlds.get(activeWorld);
	}
}
