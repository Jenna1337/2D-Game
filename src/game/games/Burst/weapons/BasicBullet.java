package game.games.Burst.weapons;

import java.awt.Shape;
import java.awt.image.BufferedImage;

@SuppressWarnings("serial")
public class BasicBullet extends Bullet
{
	
	public BasicBullet(double x, double y, double direction, double speed, double damage, Shape hitbox)
	{
		super(x, y, direction, speed, damage, hitbox, 1, false);
	}

	@Override
	public BufferedImage getImage()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
}
