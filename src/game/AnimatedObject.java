package game;

import java.awt.Component;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

@SuppressWarnings("serial")
public abstract class AnimatedObject extends Component
{
	private double xpos;
	private double ypos;
	private double direction;
	private double speed;
	private Shape hitbox;
	public abstract void nextFrame();
	public abstract BufferedImage getImage();
	
	//public AnimatedObject(){}
	public AnimatedObject(double xcoord, double ycoord, double direction, double speed, Shape hitbox)
	{
		this.xpos=xcoord;
		this.ypos=ycoord;
		this.direction=direction;
		this.speed=speed;
		this.hitbox=hitbox;
	}
	
	public AffineTransform getTransform()
	{
		double scalex=1, scaley=1;
		AffineTransform form=new AffineTransform();
		form.scale(scalex, scaley);
		form.rotate(getDirection());
		form.translate(getXcoords(), getYcoords());
		return form;
	}
	public double getXcoords()
	{
		return xpos;
	}
	public void setXcoords(double xpos)
	{
		this.xpos = xpos;
	}
	public double getYcoords()
	{
		return ypos;
	}
	public void setYcoords(double ypos)
	{
		this.ypos = ypos;
	}
	public double getDirection()
	{
		return direction;
	}
	public void setDirection(double direction)
	{
		this.direction = direction;
	}
	public double getSpeed()
	{
		return speed;
	}
	public void setSpeed(double speed)
	{
		this.speed = speed;
	}
	public Shape getHitbox()
	{
		return hitbox;
	}
	public void setHitbox(Shape hitbox)
	{
		this.hitbox = hitbox;
	}
}
