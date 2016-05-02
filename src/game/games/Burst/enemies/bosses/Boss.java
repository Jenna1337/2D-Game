package game.games.Burst.enemies.bosses;

import java.awt.Shape;
import game.games.Burst.enemies.Enemy;

@SuppressWarnings("serial")
public abstract class Boss extends Enemy
{
	public Boss(double xcoord, double ycoord, double direction, double speed, Shape hitbox, double health, String name)
	{
		super(xcoord, ycoord, direction, speed, hitbox, health);
		this.name=name;
	}
	String name;
	//TODO
}
