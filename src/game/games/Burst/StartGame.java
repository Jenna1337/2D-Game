package game.games.Burst;

import game.Game;
import game.games.Burst.player.Legacy;

public class StartGame extends Game
{
	public StartGame()
	{
		super();
		window.add(new Legacy());
	}
	public static void main(String[] agrs)
	{
		new StartGame();
	}
}
