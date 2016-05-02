package rendering;

import game.AnimatedObject;
import game.Tile;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Renderer extends JPanel implements PropertyChangeListener, HierarchyListener
{
	public final int TILE_WIDTH  = 10;
	public final int TILE_HEIGHT = 10;
	protected ArrayList<Tile> tiles = new ArrayList<Tile>();
	protected ArrayList<AnimatedObject> anims = new ArrayList<AnimatedObject>();
	
	public Renderer(){}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		for(Tile t : tiles)
			drawTile(t, g);
		for(AnimatedObject ano : anims)
			drawAnimatedObject(ano, g);
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
	public void add(AnimatedObject ao)
	{
		this.anims.add(ao);
		ao.addHierarchyListener(this);
	}
	public void drawAnimatedObject(AnimatedObject aniob, Graphics g)
	{
		((Graphics2D)g).drawRenderedImage(aniob.getImage(), aniob.getTransform());
	}
	public void propertyChange(PropertyChangeEvent arg0)
	{
		this.repaint();
	}

	@Override
	public void hierarchyChanged(HierarchyEvent arg0)
	{
		this.anims.remove(arg0);
	}
}
