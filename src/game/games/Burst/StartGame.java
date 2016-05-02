package game.games.Burst;

import game.Game;
import game.GameWindow;
import game.games.Burst.player.Legacy;

public class StartGame extends Game
{
	public static final GameWindow game = new GameWindow();
	public StartGame()
	{
		game.add(new Legacy());
		//TODO
	}
}
