package game;

public class Game
{
	protected String gameTitle;
	
	public Game()
	{
		GameWindow window = new GameWindow();
		window.setVisible(true);
	}
}
