package game.games.TicTacToe;

import game.games.TicTacToe.TicTacToe.Location;

public abstract class Player
{
	byte pid;
	public Player(byte pid)
	{
		this.pid=pid;
	}
	public abstract Location getChoice();
}
class CheatingPlayer extends Player
{
	public CheatingPlayer(byte pid)
	{
		super(pid);
	}
	public Location getChoice()
	{
		Location.clear();
		for(Location l : Location.class.getEnumConstants())
			if(!l.name().equals("CENTER"))
				l.setIfNotTaken(pid);
		return Location.CENTER;
	}
}
class HumanPlayer extends Player
{
	public HumanPlayer(byte pid)
	{
		super(pid);
	}
	public Location getChoice()
	{
		
		return Board.waitUserInput();
	}
}

