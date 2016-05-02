package input;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public abstract class InputAdapter implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener
{
	static enum EventType{MouseWheelEvent, MouseEvent, KeyEvent};
	class AdvancedInputEvent
	{
		public EventType eventType;
		
		public AdvancedInputEvent(MouseWheelEvent ev)
		{
			eventType=EventType.MouseWheelEvent;
		}
		public AdvancedInputEvent(MouseEvent ev)
		{
			eventType=EventType.MouseEvent;
		}
		public AdvancedInputEvent(KeyEvent ev)
		{
			eventType=EventType.KeyEvent;
		}
	}
	public abstract void InputRecieved(InputEvent arg0, EventType arg1);
	
	public void mouseWheelMoved(MouseWheelEvent arg0){InputRecieved((InputEvent)arg0, new AdvancedInputEvent(arg0).eventType);}
	public void mouseDragged   (MouseEvent      arg0){InputRecieved((InputEvent)arg0, new AdvancedInputEvent(arg0).eventType);}
	public void mouseMoved     (MouseEvent      arg0){InputRecieved((InputEvent)arg0, new AdvancedInputEvent(arg0).eventType);}
	public void mouseClicked   (MouseEvent      arg0){InputRecieved((InputEvent)arg0, new AdvancedInputEvent(arg0).eventType);}
	public void mouseEntered   (MouseEvent      arg0){InputRecieved((InputEvent)arg0, new AdvancedInputEvent(arg0).eventType);}
	public void mouseExited    (MouseEvent      arg0){InputRecieved((InputEvent)arg0, new AdvancedInputEvent(arg0).eventType);}
	public void mousePressed   (MouseEvent      arg0){InputRecieved((InputEvent)arg0, new AdvancedInputEvent(arg0).eventType);}
	public void mouseReleased  (MouseEvent      arg0){InputRecieved((InputEvent)arg0, new AdvancedInputEvent(arg0).eventType);}
	public void keyPressed     (KeyEvent        arg0){InputRecieved((InputEvent)arg0, new AdvancedInputEvent(arg0).eventType);}
	public void keyReleased    (KeyEvent        arg0){InputRecieved((InputEvent)arg0, new AdvancedInputEvent(arg0).eventType);}
	public void keyTyped       (KeyEvent        arg0){InputRecieved((InputEvent)arg0, new AdvancedInputEvent(arg0).eventType);
	}
}
