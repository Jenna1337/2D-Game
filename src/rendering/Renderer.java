package rendering;

import game.Tile;

import java.awt.Graphics;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Renderer extends JPanel implements PropertyChangeListener
{
	public final int TILE_WIDTH  = 10;
	public final int TILE_HEIGHT = 10;
	protected ArrayList<Tile> tiles = new ArrayList<Tile>();
	
	public Renderer(){}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		for(Tile t : tiles)
			drawTile(t, g);
	}
	
	public void add(Tile t)
	{
		this.tiles.add(t);
		t.addPropertyChangeListener(this);
	}
	public void drawTile(Tile tile, Graphics g)
	{
		g.drawImage(tile.getImage(), tile.getX(), tile.getY(), null);
	}
	public void propertyChange(PropertyChangeEvent arg0)
	{
		this.repaint();
	}
}
