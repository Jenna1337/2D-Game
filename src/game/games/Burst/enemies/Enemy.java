package game.games.Burst.enemies;

import java.awt.Shape;
import game.AnimatedObject;

@SuppressWarnings("serial")
public abstract class Enemy extends AnimatedObject
{
	double health;
	public Enemy(double xcoord, double ycoord, double direction, double speed, Shape hitbox, double health)
	{
		super(xcoord, ycoord, direction, speed, hitbox);
		this.health=health;
	}
	//TODO
}
