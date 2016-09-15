package game.games.TicTacToe;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import components.ActionMenuItem;
import game.Game;

public class StartGame extends Game
{
	public StartGame()
	{
		super();
		final Board boar = new Board();
		JMenuBar mb=new JMenuBar();
		final LabeledSpinner spinplrs = new LabeledSpinner("Players",1,0,2,1);
		final LabeledSpinner spindiff = new LabeledSpinner("Difficulty",9,1,9,1);
		JMenu menu = new JMenu("Game");
		ActionMenuItem ngb=new ActionMenuItem("New Game", new Thread(){public void run(){
			boar.setValues(((Integer)spinplrs.getValue()).byteValue(), ((Integer)spindiff.getValue()).byteValue());
		}});
		menu.add(ngb);
		menu.add(spinplrs);
		menu.add(spindiff);
		mb.add(menu);
		window.setJMenuBar(mb);
		window.setContentPane(boar);
	}
}
class LabeledSpinner extends JSpinner
{
	public LabeledSpinner(String text, int val, int min, int max, int step)
	{
		super(new SpinnerNumberModel(val,min,max,step));
		this.setToolTipText(text);// That's as good as I can do.
	}
}
