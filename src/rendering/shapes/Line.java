package rendering.shapes;

import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

@SuppressWarnings("serial")
public class Line extends Component implements PropertyChangeListener
{
	protected Point2D p1, p2;
	public Line(Point2D p1, Point2D p2)
	{
		this.p1=p1;
		this.p2=p2;
		
		this.p1.addPropertyChangeListener("Location", this);
		this.p2.addPropertyChangeListener("Location", this);
	}
	@Override
	public void propertyChange(PropertyChangeEvent eve)
	{
		this.firePropertyChange("EndPointLocation", null, this);
	}
	@Override
	public String toString()
	{
		return this.getClass().getName()+"{"+this.p1.toString()+", "+this.p2.toString()+"}";
	}
}
