package game.games.Burst.weapons;

import game.games.Burst.weapons.Bullet;
import game.games.Burst.weapons.BulletGroup;

public abstract class BulletGroup
{
	Bullet[] bullets;
	
	public abstract BulletGroup getBulletGroup(double origx, double origy, int bulletlevel);
	public void nextFrame()
	{
		for(Bullet bul : bullets)
			bul.nextFrame();
	}
}
