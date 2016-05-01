package game;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import rendering.Renderer;

@SuppressWarnings("serial")
public class GameWindow extends JFrame
{
	private Renderer renderer = new Renderer();
	public GameWindow()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(renderer, BorderLayout.CENTER);
		this.setMinimumSize(new Dimension(300, 200));
		this.pack();
		//this.setResizable(false);
	}
	public Renderer getRenderer()
	{
		return this.renderer;
	}
}
