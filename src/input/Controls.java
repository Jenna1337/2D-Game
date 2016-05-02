package input;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class Controls extends InputAdapter
{
	private int triggerKey;
	private Thread thread;
	enum EVENT_TYPE{INPUT_MOUSE, INPUT_KEYS};
	public Controls(int onKey, Thread thread)
	{
		this.triggerKey = onKey;
		this.thread = thread;
	}
	public void InputRecieved(InputEvent arg0, EventType arg1)
	{
		switch(arg1)
		{
			case KeyEvent:
				if(((KeyEvent)arg0).equals(triggerKey))
					thread.run();
				break;
			case MouseEvent:
				if(((MouseEvent)arg0).equals(triggerKey))
					thread.run();
				break;
			case MouseWheelEvent:
				if(((MouseWheelEvent)arg0).equals(triggerKey))
					thread.run();
				break;
			default:
				break;
		}
	}
}