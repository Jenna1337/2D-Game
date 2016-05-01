package rendering.shapes;

import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

@SuppressWarnings("serial")
public abstract class Shape2D extends Component implements PropertyChangeListener
{
	public ArrayList<Line> lines = new ArrayList<Line>();
	public Shape2D(Line... lines)
	{
		addLines(lines);
	}
	public void addLines(Line... lines)
	{
		for(Line l : lines)
		{
			this.lines.add(l);
			l.addPropertyChangeListener(this);
		}
	}
	@Override
	public void propertyChange(PropertyChangeEvent eve)
	{
		this.firePropertyChange("ShapeChange", null, this);
	}
	//	@Override
	//	public String toString()
	//	{
	//		return this.getClass().getName()+"{"+this.lines.toString()+"}";
	//	}
}
