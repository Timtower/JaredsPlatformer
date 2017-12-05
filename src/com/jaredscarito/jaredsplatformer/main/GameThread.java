package com.jaredscarito.jaredsplatformer.main;

public class GameThread extends Thread
{
	private JaredsPlatformer platformer;

	public GameThread(JaredsPlatformer jaredsPlatformer)
	{
		this.platformer = jaredsPlatformer;
	}

	public void run()
	{
		long lastRun = System.currentTimeMillis();
		long delta = 0;
		while (true)
		{
			platformer.getWorld().tick(delta);
			platformer.repaint();
			lastRun = System.currentTimeMillis();
			delta = System.currentTimeMillis() - lastRun;
		}
	}
}
