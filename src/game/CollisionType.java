package game;

public enum CollisionType
{
	CORNER_UP_LEFT   ( true,false, true,false),
	CORNER_DOWN_LEFT (false, true, true,false),
	CORNER_UP_RIGHT  ( true,false,false, true),
	CORNER_DOWN_RIGHT(false, true,false, true),
	WALL_UP          ( true,false,false,false),
	WALL_DOWN        (false, true,false,false),
	WALL_LEFT        (false,false, true,false),
	WALL_RIGHT       (false,false,false, true),
	END_OPEN_UP      (false, true, true, true),
	END_OPEN_DOWN    ( true,false, true, true),
	END_OPEN_LEFT    ( true, true,false, true),
	END_OPEN_RIGHT   ( true, true, true,false),
	TUNNEL_VERTICAL  (false,false, true, true),
	TUNNEL_HORIZONTAL( true, true,false,false)
	
	;
	private final boolean coll_UP, coll_DOWN, coll_LEFT, coll_RIGHT;
	
	private CollisionType(boolean UP, boolean DOWN, boolean LEFT, boolean RIGHT)
	{
		coll_UP = UP;
		coll_DOWN = DOWN;
		coll_LEFT = LEFT;
		coll_RIGHT= RIGHT;
	}

	public boolean isCollideUP()
	{
		return coll_UP;
	}
	public boolean isCollideDOWN()
	{
		return coll_DOWN;
	}
	public boolean isCollideLEFT()
	{
		return coll_LEFT;
	}
	public boolean isCollideRIGHT()
	{
		return coll_RIGHT;
	}
}
