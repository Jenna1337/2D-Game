package rendering.shapes;

import java.awt.Component;

@SuppressWarnings("serial")
public class Point2D extends Component
{
	protected int x;
	protected int y;
	
	public Point2D(){}
	public Point2D(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	@Override
	public Object clone()
	{
		return new Point2D(this.x, this.y);
	}
	@Override
	public boolean equals(Object obj)
	{
		return obj.toString().equals(this.toString());
	}
	public double distance(Point2D point)
	{
		return Math.sqrt(
				Math.pow(this.getX()-point.getX(), 2)+
				Math.pow(this.getY()-point.getY(), 2)
				);
	}
	public int getX()
	{
		return this.x;
	}
	public int getY()
	{
		return this.y;
	}
	public void setLocation(int x, int y)
	{
		if(this.x!=x || this.y!=y)
			this.firePropertyChange("Location", null, this);
		if(this.x!=x)
			this.firePropertyChange("X", this.x, this.x = x);
		if(this.y!=y)
			this.firePropertyChange("Y", this.y, this.y = y);
	}
	public Point2D translate(int dx, int dy)
	{
		this.setLocation(this.x+dx, this.y+dy);
		return this;
	}
	public Point2D copyTranslate(int dx, int dy)
	{
		return ((Point2D)this.clone()).translate(dx, dy);
	}
	@Override
	public String toString()
	{
		return this.getClass().getName()+'@'+System.identityHashCode(this)+" X="+this.getX()+" Y="+this.getY();
	}
}
