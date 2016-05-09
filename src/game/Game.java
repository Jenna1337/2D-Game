package game;

import java.util.Properties;
import input.InputAdapter;
import input.InputListenerThread;

public class Game
{
	public static GameWindow window = new GameWindow();
	public Game()
	{
		window.setVisible(true);
		InputListenerThread t = new InputListenerThread(window,
			InputAdapter.KeyMask|InputAdapter.MouseMask|InputAdapter.MouseWheelMask, 0){
			public void run(Properties ev)
			{
				System.out.println(ev.toString());
			}
		};
	}
	public String getGameName()
	{
		return this.getClass().getPackage().getName();
	}
}
