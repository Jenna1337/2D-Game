package game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import rendering.shapes.Point2D;
import rendering.shapes.Square;

@SuppressWarnings("serial")
public final class Tile extends Square
{
	private BufferedImage image;
	public Tile(Point2D location, String imagepath)
	{
		super(location);
		try
		{
			this.image = ImageIO.read(new File(imagepath));
		}
		catch(IOException ioe)
		{
			this.image = null;
			ioe.printStackTrace();
			System.exit(1);
		}
		
		// TODO Auto-generated constructor stub
	}
	public BufferedImage getImage()
	{
		return this.image;
	}
}
