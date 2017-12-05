package com.jaredscarito.jaredsplatformer;

import javax.swing.JFrame;

import com.jaredscarito.jaredsplatformer.main.JaredsPlatformer;

public class Main
{
	public static void main(String[] args)
	{
		JFrame gameFrame = new JFrame("Jared's platformer");
		gameFrame.setLayout(null);
		JaredsPlatformer game = new JaredsPlatformer();
		gameFrame.setContentPane(game);
		gameFrame.pack();
		gameFrame.setVisible(true);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.run();
	}
}