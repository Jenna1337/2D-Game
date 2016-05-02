package game.games.Burst.weapons;

import game.AnimatedObject;
import java.awt.Shape;

@SuppressWarnings("serial")
abstract class Bullet extends AnimatedObject
{
	double damage;
	int pierce;
	boolean walls;
	/**direction
	 *     90
	 *      ^
	 *      |
	 *180<--+--> 0
	 *      |
	 *      v
	 *     -90
	 **/
	public Bullet(double x, double y, double direction, double speed, double damage, Shape hitbox, int pierce, boolean walls)
	{
		super(x,y,direction,speed,hitbox);
		this.damage=damage;
		this.pierce=pierce;
		this.walls=walls;
	}
	public void nextFrame()
	{
		double[] xy=getPointAtAngle(this.getDirection(), this.getSpeed(), false);
		this.setXcoords(xy[0]);
		this.setYcoords(xy[1]);
	}
	private static double[] getPointAtAngle(double angle, double radius, boolean radians)
	{
		if(!radians)
			angle *= Math.PI / 180;
		double x = (radius * Math.cos(angle))
			, y= (radius * Math.sin(angle));
		return new double[]{x, y};
	}
}

