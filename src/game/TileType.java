package game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import javax.imageio.ImageIO;

@SuppressWarnings("serial")
public class TileType
{
	private final int id;
	private final BufferedImage image;
	private final CollisionType collision;
	public TileType(int id, CollisionType collision, String imagepath)
	{
		this.id = id;
		this.collision = collision;
		BufferedImage tmpimg = null;
		try
		{
			tmpimg = ImageIO.read(new File(imagepath));
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
			System.exit(1);
		}
		this.image = tmpimg;
	}
	public TileType(InputStream stream) throws IOException
	{
		byte[] idba = new byte[4];
		if(stream.read(idba, 0, 4) != 4)
			throw new IOException("Failed to get id!");
		this.id = toInt(idba);
		collision = CollisionType.forByte((byte) stream.read());
		byte[] nbba = new byte[4];
		if(stream.read(nbba, 0, 4) != 4)
			throw new IOException("Failed to get image size!");
		final int numbytes = toInt(nbba);
		byte[] bytes = new byte[numbytes];
		int bytesread = stream.read(bytes);
		if(bytesread != numbytes)
			throw new IOException("Failed to read correct amount of bytes!");
		final String format = "PNG";//TODO 
		File tmp = File.createTempFile("Tile"+id+"-"+bytes.hashCode(), "."+format);
		RandomAccessFile raf = new RandomAccessFile(tmp, "rws");
		raf.write(bytes);
		raf.close();
		image = ImageIO.read(tmp);
		if(image==null)
			throw new NullPointerException("image == null!");
	}
	public static int toInt(final byte[] data) {
		if (data == null || data.length != 4) return 0x0;
		// ----------
		return  ((0xff & data[0]) << 24) |
				((0xff & data[1]) << 16) |
				((0xff & data[2]) << 8 ) |
				((0xff & data[3]) << 0 );
	}
	public String toString()
	{
		return "Tile("+id+", BufferedImage@"+Integer.toHexString(getImage().hashCode())+")";
	}
	public int getId()
	{
		return id;
	}
	public BufferedImage getImage()
	{
		return this.image;
	}
	public CollisionType getCollision()
	{
		return collision;
	}
}
