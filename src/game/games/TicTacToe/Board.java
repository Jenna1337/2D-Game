package game.games.TicTacToe;

import javax.swing.JPanel;
import game.games.TicTacToe.TicTacToe.Location;

@SuppressWarnings("serial")
public class Board extends JPanel
{
	public volatile TicTacToe ttt;
	private static byte plrs=(byte)1, diff=(byte)9;
	public Board()
	{
		//resetGame();
	}
	Thread gamethread;
	public void resetGame()
	{
		ttt=new TicTacToe(plrs, diff);
		if(gamethread!=null)
			gamethread.interrupt();
		gamethread=new Thread(){
			public void run(){
				byte winner=0;
				while(winner==0)
				{
					while(ttt.nextTurn())
						System.out.println(ttt);
					;
					System.out.println("Winner: Player "+(int)(winner=ttt.getWinner()));
					ttt.reset();
					System.out.flush();
				}
				System.out.println("Winner: Player "+(int)winner);
			}
		};
		gamethread.start();
	}
	public void setValues(byte newplrs, byte newdiff)
	{
		plrs=newplrs;
		diff=newdiff;
		resetGame();
	}
	public volatile static Location userChoose;
	public static Location waitUserInput()
	{
		while(userChoose==null);
		Location temp=userChoose;
		userChoose=null;
		return temp;
	}
}
