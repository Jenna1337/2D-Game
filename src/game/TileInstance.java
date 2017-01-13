package game;

import java.awt.Image;
import rendering.shapes.Point2D;
import rendering.shapes.Square;

public class TileInstance extends Square
{
	TileType type;
	Point2D location;
	public TileInstance(Point2D pos, TileType type)
	{
		super(pos);
		// TODO Auto-generated constructor stub
	}
	public Image getImage()
	{
		return type.getImage();
	}
	
}
