package com.jaredscarito.jaredsplatformer.draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;

import javax.swing.JFrame;

import com.jaredscarito.jaredsplatformer.main.JaredsPlatformer;

public class GameBoard extends JFrame
{
	private static final long serialVersionUID = 1L;
	private Color backgroundColor;
	private boolean gameStarted = false;
	private JaredsPlatformer gamePanel;
	private int boardWidth;
	private int boardHeight;
	private boolean appletPaint;
	private KeyHandler keyBoard;
	private Image mImage;

	public void repaint(boolean paint)
	{
		if (paint)
		{
			this.repaint();
		}
	}

	public void draw(Graphics g)
	{
//		this.gamePanel.draw(g);
	}

	public GameBoard(JaredsPlatformer ge, String windowTitle, int boardWidthLocal, int boardHeightLocal)
	{
		super(windowTitle);
		this.backgroundColor = Color.pink;
		this.appletPaint = false;
		this.keyBoard = new KeyHandler();
		this.gamePanel = ge;
		this.boardWidth = boardWidthLocal;
		this.boardHeight = boardHeightLocal;
		this.setBackground(this.backgroundColor);
		this.setLayout((LayoutManager) null);
		this.setDefaultCloseOperation(3);
		this.setSize(this.boardWidth + 122, this.boardHeight + 5);
		this.setLocation(100, 100);
		this.addKeyListener(this.keyBoard);
	}

	public GameBoard(JaredsPlatformer ge, String windowTitle)
	{
		this(ge, windowTitle, 500, 500);
	}

	public void update(Graphics g)
	{
		this.paint(g);
	}

	public void paint(Graphics g)
	{
		if (this.appletPaint)
		{
			super.paint(g);
		}

		this.checkOffScreenImage();
		Graphics offG = this.mImage.getGraphics();
		offG.setColor(this.getBackground());
		offG.fillRect(4, 30, this.boardWidth, this.boardHeight);
		this.draw(this.mImage.getGraphics());
		g.drawImage(this.mImage, 0, 0, (ImageObserver) null);
		this.appletPaint = true;
	}

	private void checkOffScreenImage()
	{
		if (this.mImage == null || this.mImage.getWidth((ImageObserver) null) != this.boardWidth
				|| this.mImage.getHeight((ImageObserver) null) != this.boardHeight + 30)
		{
			this.mImage = this.createImage(this.boardWidth, this.boardHeight + 30);
		}
	}

	class KeyHandler extends KeyAdapter
	{
		public void keyPressed(KeyEvent e)
		{
			char c = KeyEvent.getKeyText(e.getKeyCode()).charAt(0);
			GameBoard.this.gamePanel.keyStruck(c);
			GameBoard.this.appletPaint = false;
			GameBoard.this.repaint();
		}
	}
}
