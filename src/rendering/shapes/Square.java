package rendering.shapes;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

@SuppressWarnings({"serial", "unused"})
public class Square extends Shape2D implements PropertyChangeListener
{
	protected Point2D origin;
	private Point2D top_left, top_right, bottom_left, bottom_right;
	private Line top, left, right, bottom;
	
	public Square(Point2D location)
	{
		super();
		this.setLocation(location);
	}
	public int getX()
	{
		return this.origin.getX();
	}
	public int getY()
	{
		return this.origin.getY();
	}
	public void setLocation(Point2D location)
	{
		Point2D old = null;
		try
		{
			old = (Point2D) origin.clone();
		}
		catch(NullPointerException npe){}
		
		while(lines.size()>0)
			lines.remove(0);
		this.origin=location;
		
		top_left     = origin.copyTranslate(0, 1);
		top_right    = origin.copyTranslate(1, 1);
		bottom_left  = origin.copyTranslate(0, 0);
		bottom_right = origin.copyTranslate(1, 0);
		
		top    = new Line(top_left, top_right);
		left   = new Line(top_left, bottom_left);
		right  = new Line(top_right, bottom_right);
		bottom = new Line(bottom_left, bottom_right);
		
		Line[] ls = new Line[]{top, left, right, bottom};
		super.addLines(ls);
		
		this.firePropertyChange("Cube_origin", old, this.origin);
	}
	@Override
	public String toString()
	{
		return this.getClass().getName()+"{"+this.origin.getX()+", "+this.origin.getY()+"}";
	}
}
