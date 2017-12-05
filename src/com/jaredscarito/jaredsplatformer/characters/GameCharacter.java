package com.jaredscarito.jaredsplatformer.characters;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.jaredscarito.jaredsplatformer.objects.GameObject;

public abstract class GameCharacter extends GameObject
{
	public GameCharacter(Rectangle position, BufferedImage appearance)
	{
		super(position, appearance);
	}
}
