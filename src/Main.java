
import game.GameWindow;
import game.Tile;
import rendering.shapes.*;


/***************************
 * 
 * @author Jonah Sloan
 * @since v0
 **************************/
public class Main
{
	public static void main(String[] args)
	{
		Point2D p1=new Point2D(0,1),
				p2=new Point2D(5,4);
		Line line = new Line(p1,p2);
		p1.setLocation(7, 8);
		p2.setLocation(p2.getX(), p2.getY());
		p2.translate(7, 8);
		System.out.println(line);
		
		Tile t = new Tile(new Point2D(50, 50), "test.png");
		
		GameWindow game = new GameWindow();
		game.getRenderer().add(t);
		game.setVisible(true);
	}
}
