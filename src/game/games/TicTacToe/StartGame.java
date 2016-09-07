package game.games.TicTacToe;

import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JSpinner;
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
		final JSpinner spinplrs = new JSpinner(new SpinnerNumberModel(1,0,2,1));
		final JSpinner spindiff = new JSpinner(new SpinnerNumberModel(9,1,9,1));
		ActionMenuItem ngb=new ActionMenuItem("New Game", new Thread(){public void run(){
			boar.setValues(((Integer)spinplrs.getValue()).byteValue(), ((Integer)spindiff.getValue()).byteValue());
		}});
		mb.add(ngb);
		mb.add(spinplrs);
		mb.add(spindiff);
		window.setJMenuBar(mb);
		window.setContentPane(boar);
	}
}
