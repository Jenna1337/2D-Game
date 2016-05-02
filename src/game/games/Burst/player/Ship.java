package game.games.Burst.player;

import java.awt.Shape;
import game.AnimatedObject;
import game.games.Burst.StartGame;

@SuppressWarnings("serial")
public abstract class Ship extends AnimatedObject
{
	private static final Shape defaulthitbox=new java.awt.Rectangle(10,5);//TODO
	
	public Ship()
	{
		this(StartGame.game.getWidth()/3, StartGame.game.getHeight()/2);
	}
	public Ship(double xcoord, double ycoord)
	{
		super(xcoord, ycoord, 0, 0, defaulthitbox);
	}
	
	@Override
	public void nextFrame()
	{
		// TODO Auto-generated method stub
		
	}
	//TODO
}
