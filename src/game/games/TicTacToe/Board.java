package game.games.TicTacToe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JPanel;
import game.games.TicTacToe.TicTacToe.Location;

@SuppressWarnings("serial")
public class Board extends JPanel
{
	public volatile TicTacToe ttt;
	private volatile BoardArea[] areas = getBoardAreas();
	private static byte plrs=(byte)1, diff=(byte)9;
	private static final int linewidth = 3;
	public Board()
	{
		super();
		GridLayout layout = new GridLayout(3, 3);
		layout.setHgap(linewidth);
		layout.setVgap(linewidth);
		this.setLayout(layout);
		this.setBackground(Color.BLACK); // the color of the grid
		System.out.println(java.util.Arrays.toString(areas));
		for(BoardArea a : areas)
			this.add(a);
		resetGame();
	}
	private static final class BoardArea extends JPanel
	{
		private static final int edgeDist = 5;
		Location l;
		public BoardArea(Location loc)
		{
			super();
			this.setBackground(Color.white); // Tile bg
			l=loc;
		}
		@Override
		public void paint(Graphics g)
		{
			super.paint(g);
			g.setColor(Color.BLACK); // shape color
			switch(l.getPlayer())
			{
				case 0:
					break;
				case 1: // X
					g.drawLine(0+edgeDist, 0+edgeDist, this.getWidth()-edgeDist, this.getHeight()-edgeDist);
					g.drawLine(0+edgeDist, this.getHeight()-edgeDist,  this.getWidth()-edgeDist, 0+edgeDist);
					break;
				case 2: // O
					g.drawOval(0+edgeDist, 0+edgeDist, this.getWidth()-edgeDist*2, this.getHeight()-edgeDist*2);
					break;
				default:
					break;
			}
		}
	}
	private static final BoardArea[] getBoardAreas()
	{
		BoardArea[] a = new BoardArea[9];
		int i=0;
		for(Location l : Location.values())
			a[i++]=new BoardArea(l);
		return a;
	}
	Thread gamethread;
	private final Board THIS = this;
	public void resetGame()
	{
		ttt=new TicTacToe(plrs, diff);
		if(gamethread!=null)
			gamethread.interrupt();
		gamethread=null;
		System.gc();
		gamethread=new Thread(){
			public void run(){
				byte winner=0;
				while(winner==0)
				{
					while(ttt.nextTurn())
						THIS.repaint();
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
